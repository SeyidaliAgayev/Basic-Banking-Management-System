package service.impl;

import enums.Exceptions;
import exceptions.*;
import service.CardService;
import service.CustomerManagementService;
import service.OperationManagementService;

import static util.MenuUtil.operationsMenu;

public class OperationManagementServiceImpl implements OperationManagementService {
    @Override
    public void operationManagement() {
        CardService cardService = new CardServiceImpl();


        while (true) {
            int option = operationsMenu();
            try {

                switch (option) {
                    case 1:
                        cardService.showBalance();
                        break;
                    case 2:
                        cardService.cashingOut();
                        break;
                    case 3:
                        CustomerManagementService customerManagementService = new CustomerManagementServiceImpl();
                        customerManagementService.customerManagement();
                        break;
                    default:
                        throw new InvalidOption(Exceptions.INVALID_OPTION);
                }
            } catch (WrongFormat | InvalidOption | CustomerNotFound | EmptyList | LackOfFunds | LowSendingAmount exception) {
                System.out.println(exception.getMessage());
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
