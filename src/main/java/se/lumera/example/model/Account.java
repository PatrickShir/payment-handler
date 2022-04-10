package main.java.se.lumera.example.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Account {
    private String postType;
    private String accountNumber;
    private BigDecimal sum;
    private int quantity;
    private Date date;
    private String currency;
    private List<Payment> payments;

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
                "postType='" + postType + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", sum=" + sum +
                ", quantity=" + quantity +
                ", date=" + date +
                ", currency='" + currency + '\'' +
                ", payments=" + payments +
                '}';
    }
}
