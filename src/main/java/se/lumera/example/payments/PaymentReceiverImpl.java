package main.java.se.lumera.example.payments;

import java.math.BigDecimal;
import java.util.Date;

/**
 * An implementation of the PaymentReceiver interface purely for visual aid.
 */
public class PaymentReceiverImpl implements PaymentReceiver {

    @Override
    public void startPaymentBundle(String accountNumber, Date paymentDate, String currency) {
        System.out.println("--- BUNDLE STARTED! ---");
        System.out.println("Account: " + accountNumber);
        System.out.println("Date: " + paymentDate);
        System.out.println("Currency: " + currency);
    }

    @Override
    public void payment(BigDecimal amount, String reference) {
        System.out.println("--- INCOMING PAYMENT! ---");
        System.out.println("Amount: " + amount);
        System.out.println("Reference: " + reference);
    }

    @Override
    public void endPaymentBundle() {
        System.out.println("--- BUNDLE FINISHED! ---");
    }
}