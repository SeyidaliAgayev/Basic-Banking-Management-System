package helper;

import data.GlobalData;
import enums.Exceptions;
import exceptions.EmailAlreadyExist;
import exceptions.InvalidOption;
import model.Card;
import model.Customer;

import java.time.LocalDate;
import java.util.Random;

import static util.InputUtil.stringInput;

public class CustomerServiceHelper {
    static int customerCount = 0;
    public static long id = 0;

    public static Customer fillCustomer() {
        try {
            String name = stringInput("Enter the name: ");
            String surname = stringInput("Enter the surname: ");
            String eMail = stringInput("Enter the email: ");

            for (Customer existingCustomer : GlobalData.customers) {
                if (existingCustomer != null && existingCustomer.geteMail().equals(eMail)) {
                    throw new EmailAlreadyExist(Exceptions.EMAIL_ALREADY_EXIST);
                }
            }

            String password = stringInput("Enter the password: ");
            Card card = fillCard();
            return new Customer(id++, name, surname, eMail, password, true, false, LocalDate.now(), null, card);
        } catch (InvalidOption | EmailAlreadyExist e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Card fillCard() {
        Random random = new Random();
        try {
            Long cardNumber = random.nextLong(8999999999999999L, 10000000000000000L);
            double currentBalance = 0.0;
            LocalDate updateDate = null;
            return new Card(++id, cardNumber, currentBalance, updateDate);
        } catch (InvalidOption e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static boolean registerHelper() {
        try {
            Customer customer = fillCustomer();
            if (customer != null) {
                for (Customer existingCustomer : GlobalData.customers) {
                    if (existingCustomer != null && existingCustomer.geteMail().equals(customer.geteMail())) {
                        System.out.println("Email already exist, try new email to register!");
                    }
                }
                customer.setCard(fillCard());
                GlobalData.customers[customerCount] = customer;
                customerCount++;
                return true;
            }
        } catch (EmailAlreadyExist exception) {
            System.out.println(exception.getMessage());
        }
            return false;
    }
}
