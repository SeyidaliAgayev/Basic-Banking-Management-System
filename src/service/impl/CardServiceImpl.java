package service.impl;

import data.GlobalData;
import enums.Exceptions;
import exceptions.CustomerNotFound;
import exceptions.LackOfFunds;
import model.Customer;
import service.CardService;

import static helper.CardServiceHelper.cashReceiptMessage;
import static helper.CardServiceHelper.currencyCounter;
import static util.InputUtil.doubleInput;
import static util.InputUtil.intInput;

public class CardServiceImpl implements CardService {
    @Override
    public void showBalance() {
        int customerId = intInput("Which customer balance do you want to see: ");
        for (Customer customer: GlobalData.customers) {
            if (customer.getId() == customerId) {
                System.out.println(customer.getCard().getCurrentBalance() + "₼");
                return;
            }
        }
        throw new CustomerNotFound(Exceptions.CUSTOMER_NOT_FOUND);
    }

    @Override
    public void cashingOut() {
        double inputAmount = doubleInput("How much money do you want to cash out: ");
        boolean isCashOut = false;
        for (Customer customer: GlobalData.customers) {
            if (customer.getCard().getCurrentBalance() >= inputAmount) {
                customer.getCard().setCurrentBalance(customer.getCard().getCurrentBalance() - inputAmount);
                currencyCounter(inputAmount);
                isCashOut = true;
                break;
            }
        }
        if (isCashOut) {
            cashReceiptMessage(inputAmount);
        } else {
            throw new LackOfFunds(Exceptions.LACK_OF_FUNDS);
        }
    }
}
