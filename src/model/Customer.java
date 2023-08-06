package model;

import java.time.LocalDate;

public class Customer {
    private long id;
    private String name;
    private String surname;
    private String eMail;
    private String password;
    private boolean status;
    private boolean blockStatus;
    private LocalDate registerDate;
    private LocalDate updateDate;
    private Card card;
    public Customer() {

    }

    public Customer(long id, String name, String surname, String eMail, String password, boolean status, boolean blockStatus, LocalDate registerDate, LocalDate updateDate, Card card) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.eMail = eMail;
        this.password = password;
        this.status = status;
        this.blockStatus = blockStatus;
        this.registerDate = registerDate;
        this.updateDate = updateDate;
        this.card = card;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String geteMail() {
        return eMail;
    }

    public void setEmail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(boolean blockStatus) {
        this.blockStatus = blockStatus;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", blockStatus=" + blockStatus +
                ", registerDate=" + registerDate +
                ", updateDate=" + updateDate +
                ", card=" + card +
                '}';
    }
}
