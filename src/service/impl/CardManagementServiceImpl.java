package service.impl;

import exceptions.*;
import service.CardManagementService;
import service.CustomerManagementService;
import service.CustomerService;
import service.OperationManagementService;

import static util.MenuUtil.logInMenu;

public class CardManagementServiceImpl implements CardManagementService {
    @Override
    public void cardManagement() {
        CustomerService cardService = new CustomerServiceImpl();


        while (true) {
            try {

                int option = logInMenu();
                switch (option) {
                    case 1:
                        cardService.showMyDetails();
                        break;
                    case 2:
                        cardService.updateMyDetails();
                        break;
                    case 3:
                        OperationManagementService operationService = new OperationManagementServiceImpl();
                        operationService.operationManagement();
                        break;
                    case 4:
                        CustomerManagementService customerManagementService = new CustomerManagementServiceImpl();
                        customerManagementService.customerManagement();
                        break;
                }
            } catch (WrongFormat | InvalidOption | CustomerNotFound | EmptyList | LackOfFunds | LowSendingAmount exception) {
                System.out.println(exception.getMessage());
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
