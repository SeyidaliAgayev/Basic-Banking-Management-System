package model;

import java.time.LocalDate;

public class Card {
    private long cardId;
    private Long cardNumber;
    private double currentBalance;
    private LocalDate updateDate;

    public Card() {
    }

    public Card(long cardId, Long cardNumber, double currentBalance, LocalDate updateDate) {
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.currentBalance = currentBalance;
        this.updateDate = updateDate;
    }

    public long getCardId() {
        return cardId;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }


}
