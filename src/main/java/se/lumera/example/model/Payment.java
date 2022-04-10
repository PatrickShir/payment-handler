package main.java.se.lumera.example.model;

import java.math.BigDecimal;

public class Payment {
    private String postType;
    private BigDecimal amount;
    private String reference;

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getReference() {
        return reference;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "postType='" + postType + '\'' +
                ", amount=" + amount +
                ", reference='" + reference + '\'' +
                '}';
    }
}