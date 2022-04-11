package main.java.se.lumera.example.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Account {
    private UUID id = UUID.randomUUID();
    private String accountNumber;
    private BigDecimal totalCash;
    private int amountOfTransactions;
    private Date date;
    private String currency;
    private List<Payment> payments;

    public UUID getId() {
        return id;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setTotalCash(BigDecimal totalCash) {
        this.totalCash = totalCash;
    }

    public void setAmountOfTransactions(int amountOfTransactions) {
        this.amountOfTransactions = amountOfTransactions;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Date getDate() {
        return date;
    }

    public String getCurrency() {
        return currency;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", sum=" + totalCash +
                ", quantity=" + amountOfTransactions +
                ", date=" + date +
                ", currency='" + currency + '\'' +
                ", payments=" + payments +
                '}';
    }
}
