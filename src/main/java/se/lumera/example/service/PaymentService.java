package main.java.se.lumera.example.service;

import main.java.se.lumera.example.enums.PostType;
import main.java.se.lumera.example.payments.PaymentReceiverImpl;
import main.java.se.lumera.example.model.Account;
import main.java.se.lumera.example.model.Payment;
import main.java.se.lumera.example.payments.PaymentReceiver;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * PaymentService contains all the service based logic for extracting incoming data.
 */
public class PaymentService {
    private static final Logger logger = Logger.getLogger(PaymentService.class.getName());
    private final PaymentReceiver paymentReceiver = new PaymentReceiverImpl();
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

    /**
     * Goes over each entry of the extracted data and sets it to the appropriate instance variables of an account object.
     *
     * @param data - The extracted file data
     * @return Account - The created account object
     */
    protected Account extractData(List<String> data) throws IndexOutOfBoundsException {
        Account account = new Account();
        List<Payment> payments = new ArrayList<>();

        data.stream()
                .map(row -> {
                    try {
                        String postType = Character.toString(row.charAt(0));
                        switch (PostType.getByType(postType)) {
                            case POST_TYPE_O:
                                setOpeningPaymentFromBetalningsservice(row, account);
                                paymentReceiver.startPaymentBundle(account.getAccountNumber(),
                                        account.getDate(), account.getCurrency());
                                break;
                            case POST_TYPE_B:
                                payments.add(setPaymentRowFromBetalningsservice(row));
                                break;
                            case POST_TYPE_ZERO:
                                setOpeningPaymentFromInbetalningstjansten(row, account);
                                paymentReceiver.startPaymentBundle(account.getAccountNumber(), account.getDate(), account.getCurrency());
                                break;
                            case POST_TYPE_THREE:
                                payments.add(setPaymentRowFromInbetalningstjansten(row));
                                break;
                            case POST_TYPE_NINE:
                                setClosingPaymentFromInbetalningstjansten(row, account);
                                break;
                            default:
                                logger.info("Unknown post type " + postType);
                        }
                    } catch (ParseException e) {
                        logger.warning("WARNING MESSAGE " + e);
                    }
                    account.setPayments(payments);
                    return account;
                }).collect(Collectors.toList());

        paymentReceiver.endPaymentBundle();
        System.out.println("Account created: " + account);
        return account;
    }

    private Account setOpeningPaymentFromBetalningsservice(String row, Account account) throws ParseException {
        account.setAccountNumber(row.substring(1, 16).replace(" ", ""));
        account.setSum(new BigDecimal(row.substring(16, 30).replace(",", ".").replace(" ", "")));
        account.setQuantity(Integer.parseInt(row.substring(30, 40).replace(" ", "")));
        account.setCurrency(row.substring(48, 51));
        account.setDate(formatter.parse(row.substring(40, 48)));
        return account;
    }

    private Payment setPaymentRowFromBetalningsservice(String row) {
        Payment payment = new Payment();
        payment.setAmount(new BigDecimal(row.substring(1, 15).replace(",", ".").replace(" ", "")));
        payment.setReference(row.substring(15, 50).replace(" ", ""));
        paymentReceiver.payment(payment.getAmount(), payment.getReference());
        return payment;
    }

    private Account setOpeningPaymentFromInbetalningstjansten(String row, Account account) {
        account.setAccountNumber(row.substring(10, 24));
        account.setCurrency("SEK"); //I'm making a wild assumption here and I purposefully also left date as null
        return account;
    }

    private Payment setPaymentRowFromInbetalningstjansten(String row) {
        Payment payment = new Payment();
        payment.setAmount(new BigDecimal(row.substring(2, 22).replace(",", ".")));
        payment.setReference(row.substring(40, 65).replace(" ", ""));
        paymentReceiver.payment(payment.getAmount(), payment.getReference());
        return payment;
    }

    private Account setClosingPaymentFromInbetalningstjansten(String row, Account account) {
        account.setSum(new BigDecimal(row.substring(2, 22).replace(",", ".")));
        account.setQuantity(Integer.parseInt(row.substring(30, 38)));
        return account;
    }
}