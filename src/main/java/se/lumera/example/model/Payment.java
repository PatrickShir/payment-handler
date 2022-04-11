package main.java.se.lumera.example.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Payment {
    private UUID id = UUID.randomUUID();
    private BigDecimal amount;
    private String reference;

    public UUID getId() {
        return id;
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
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", reference='" + reference + '\'' +
                '}';
    }
}