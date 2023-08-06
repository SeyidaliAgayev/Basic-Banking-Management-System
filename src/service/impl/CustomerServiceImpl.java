package service.impl;

import data.GlobalData;
import enums.Exceptions;
import enums.StatusEnum;
import exceptions.CustomerNotFound;
import exceptions.EmptyList;
import exceptions.LowSendingAmount;
import model.Card;
import model.Customer;
import service.CardManagementService;
import service.CustomerService;

import static helper.CardServiceHelper.cardNumberMasker;
import static helper.CardServiceHelper.incerementReceiptMessage;
import static helper.CustomerServiceHelper.fillCard;
import static helper.CustomerServiceHelper.registerHelper;
import static util.InputUtil.*;

public class CustomerServiceImpl implements CustomerService {
    private static int failedAttempts = 0;
    private CardManagementService cardManagementService;

    @Override
    public boolean register() {
        int customerCount = intInput("How many customer will be register: ");

        if (GlobalData.customers == null) {
            GlobalData.customers = new Customer[customerCount];
            for (int i = 0; i < GlobalData.customers.length; i++) {
                while (!registerHelper()) {

                }
            }
            System.out.println(StatusEnum.REGISTER_SUCCESSFULLY);
        } else {
            Customer[] tempCustomers = GlobalData.customers;
            GlobalData.customers = new Customer[GlobalData.customers.length + customerCount];
            for (int i = 0; i < GlobalData.customers.length; i++) {
                if (i < tempCustomers.length) {
                    GlobalData.customers[i] = tempCustomers[i];
                }
            }
            for (int i = tempCustomers.length; i <GlobalData.customers.length ; i++) {
                while (!registerHelper()) {

                }
            }
            System.out.println(StatusEnum.REGISTER_SUCCESSFULLY);

            int nullCustomerCount = 0;
            for (Customer customer: GlobalData.customers) {
                if (customer == null) {
                    nullCustomerCount++;
                }
            }
            Customer[] customers = GlobalData.customers;
            GlobalData.customers = new Customer[GlobalData.customers.length - nullCustomerCount];
            for (int i = 0; i < GlobalData.customers.length; i++) {
                GlobalData.customers[i] = customers[i];
            }
        }
        return true;
    }

    @Override
    public void showMyDetails() {
        int customerId = intInput("Enter your customer ID: ");
        boolean customerFound = false;
        for (Customer customer : GlobalData.customers) {
            if (customer.getId() == customerId) {
                Card card = customer.getCard();

                System.out.println("---------| Customer |---------");
                System.out.println("Name: " + customer.getName());
                System.out.println("Surname: " + customer.getSurname());
                System.out.println("Email: " + customer.geteMail());
                System.out.println("Password: " + customer.getPassword());
                System.out.println("CardNumber: " + cardNumberMasker(card.getCardNumber()));
                System.out.println("Current Balance: " + card.getCurrentBalance());
                System.out.println("------------------------------");

                customerFound = true;
                break;
            }
        }
        if (!customerFound) {
            throw new CustomerNotFound(Exceptions.CUSTOMER_NOT_FOUND);
        }
    }

    @Override
    public void updateMyDetails() {
        if (GlobalData.customers == null && GlobalData.customers.length == 0) {
            throw new EmptyList(Exceptions.EMPTY_LIST);
        }
        int customerId = intInput("Which customer do you want to update: ");
        boolean isUpdated = false;

        for (Customer customer : GlobalData.customers) {
            if (customer.getId() == customerId) {
                String parameter = stringInput("Enter the parameter(s) you want to update (comma-separated, e.g., name,surname,email,password): ");
                String[] parameterString = parameter.split(",");
                for (String str : parameterString) {
                    switch (str) {
                        case "name":
                            String newName = stringInput("Enter the new name: ");
                            customer.setName(newName);
                            isUpdated = true;
                            break;
                        case "surname":
                            String newSurname = stringInput("Enter the new surname: ");
                            customer.setSurname(newSurname);
                            isUpdated = true;
                            break;
                        case "email":
                            String newEmail = stringInput("Enter the new email: ");
                            customer.setEmail(newEmail);
                            isUpdated = true;
                            break;
                        case "password":
                            String oldPassword = stringInput("Enter the old password: ");
                            if (oldPassword.equals(customer.getPassword())) {
                                String newPassword = stringInput("Enter the new password: ");
                                customer.setPassword(newPassword);
                                isUpdated = true;
                            } else {
                                System.out.println("Incorrect old password!");
                            }
                            break;
                    }
                }
                if (isUpdated) {
                    System.out.println(StatusEnum.UPDATE_SUCCESSFULLY);
                }
                return;
            }
        }
        System.out.println("Customer not found!");
    }

    @Override
    public void logIn() {
        String eMail = stringInput("Enter the email: ");

        boolean customerExists = false;
        boolean passwordIsCorrect = false;

        for (Customer customer : GlobalData.customers) {
            if (customer.geteMail().equals(eMail)) {
                customerExists = true;

                while (failedAttempts < 3) {
                    String password = stringInput("Enter the password: ");
                    if (customer.getPassword().equals(password)) {
                        passwordIsCorrect = true;
                        failedAttempts = 0;

                        System.out.println("-----------------------------\n" +
                                           "Welcome, dear " + customer.getName() + "!\n" +
                                           "-----------------------------\n");

                        this.cardManagementService = new CardManagementServiceImpl();
                        this.cardManagementService.cardManagement();
                    }
                    if (!passwordIsCorrect) {
                        System.err.println("Password is not correct!");
                        failedAttempts++;
                    }
                    if (failedAttempts == 3) {
                        System.exit(-1);
                    }
                }
            }
        }
        if (!customerExists) {
            throw new CustomerNotFound(Exceptions.CUSTOMER_NOT_FOUND);
        }
    }
    @Override
    public void increaseBalance() {
        long increasingCardNumber = longInput("Enter the card number to increase: ");
        double sendingAmount = doubleInput("Enter the amount of sending money: ");
        boolean isIncreased = false;

        for (Customer customer: GlobalData.customers) {
            if (customer.getCard().getCardNumber() == increasingCardNumber && sendingAmount >= 1) {
                customer.getCard().setCurrentBalance(customer.getCard().getCurrentBalance() + sendingAmount);
                isIncreased = true;
                break;
            }
        }

        if (isIncreased) {
            incerementReceiptMessage(sendingAmount);
        } else {
            throw new LowSendingAmount(Exceptions.LOW_SENDING_AMOUNT);
        }
    }
}

