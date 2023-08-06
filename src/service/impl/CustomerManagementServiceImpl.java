package service.impl;

import enums.Exceptions;
import exceptions.*;
import service.CustomerManagementService;
import service.CustomerService;

import static util.MenuUtil.entryMenu;

public class CustomerManagementServiceImpl implements CustomerManagementService {
    @Override
    public void customerManagement() {
        CustomerService customerService = new CustomerServiceImpl();


        while (true) {
            try {
                int option = entryMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                        break;
                    case 1:
                        customerService.register();
                        break;
                    case 2:
                        customerService.logIn();
                        break;
                    case 3:
                        customerService.increaseBalance();
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
