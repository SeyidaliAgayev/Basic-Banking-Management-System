package helper;

import data.GlobalData;

import java.time.LocalDateTime;

public class CardServiceHelper {
    public static void currencyCounter(double inputAmount){
        double firstCurrency = inputAmount/500;
        double remainingAmountAfterFirstCurrency = inputAmount % 500;

        double secondCurrency = remainingAmountAfterFirstCurrency / 200;
        double remainingAmountAfterSecondCurrency = remainingAmountAfterFirstCurrency % 200;

        double thirdCurrency = remainingAmountAfterSecondCurrency / 100;
        double remainingAmountAfterThirdCurrency = remainingAmountAfterSecondCurrency % 100;

        double forthCurrency = remainingAmountAfterThirdCurrency / 50;
        double remainingAfterForthCurrency = remainingAmountAfterThirdCurrency % 50;

        double fifthCurrency = remainingAfterForthCurrency / 1;

        System.out.println((int) firstCurrency + "- 500₼\n" +
                (int) secondCurrency + "- 200₼\n" +
                (int) thirdCurrency + "- 100₼\n" +
                (int) forthCurrency + "- 50₼\n" +
                (int) fifthCurrency + "- 1₼");
    }
    public static LocalDateTime cashDateTime(){
        return LocalDateTime.now().withNano(0);
    }
    public static Long cardNumberMasker(Long card) {
        String cardNumberString = String.valueOf(card);
        String maskedCardNumber = cardNumberString.substring(0,4) + "********" + cardNumberString.substring(12);
        return Long.parseLong(maskedCardNumber);
    }
    public static void cashReceiptMessage(double inputAmount) {
        for (int i = 0; i < GlobalData.customers.length; i++) {
            System.out.println("------Cash Receipt------\n" +
                    "Date&Time: " + cashDateTime() + "\n" +
                    "Card Number: " + cardNumberMasker(GlobalData.customers[i].getCard().getCardNumber()) + "\n" +
                    "Cash: " + inputAmount + "\n" +
                    "Total remain balance: " + GlobalData.customers[i].getCard().getCurrentBalance() + "\n" +
                    "-----------------------------\n");
        }
    }
    public static void incerementReceiptMessage(double sendingAmount) {
        for (int i = 0; i < GlobalData.customers.length; i++) {
            System.out.println( "------Cash Receipt------\n" +
                    "Date&Time: " + cashDateTime() + "\n" +
                    "Card Number: " + cardNumberMasker(GlobalData.customers[i].getCard().getCardNumber()) + "\n" +
                    "Cash: +" + sendingAmount + "\n" +
                    "Total remain balance: " + GlobalData.customers[i].getCard().getCurrentBalance() + "\n" +
                    "-----------------------------\n");
        }
    }
}
