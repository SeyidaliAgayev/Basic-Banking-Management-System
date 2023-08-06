package exceptions;

import enums.Exceptions;

import java.time.LocalDateTime;

public class LackOfFunds extends RuntimeException{
    private String message;
    private LocalDateTime localDateTime;

    public LackOfFunds(Exceptions exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.message = exceptionEnum.getMessage();
        this.localDateTime = exceptionEnum.getLocalDateTime();
    }

    @Override
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
}
