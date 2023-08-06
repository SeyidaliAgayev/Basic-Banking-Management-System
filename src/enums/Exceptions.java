package enums;

import java.time.LocalDateTime;


public enum Exceptions {
    CUSTOMER_NOT_FOUND("Customer not Found", LocalDateTime.now()),
    LACK_OF_FUNDS("Lack of Funds", LocalDateTime.now()),
    LOW_SENDING_AMOUNT("Low Sending Amount", LocalDateTime.now()),
    INVALID_OPTION("Invalid Option", LocalDateTime.now()),
    EMAIL_ALREADY_EXIST("Email already exist!", LocalDateTime.now()),
    WRONG_FORMAT("Wrong format!", LocalDateTime.now()),
    EMPTY_LIST("Empty list ", LocalDateTime.now());


    Exceptions(String message, LocalDateTime localDateTime) {
        this.message = message;
        this.localDateTime = localDateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
    String message;
    LocalDateTime localDateTime;
}
