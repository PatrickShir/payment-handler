package main.java.se.lumera.example.service;

import main.java.se.lumera.example.model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Unit test class for the extraction service logic (with >90 percent line coverage).
 * The test txt files are just copies of the real ones but normally they would obviously not contain any sensitive data.
 */
class PaymentServiceTest {
    private static final String folderPath = "src/test/resources";
    private static final String fileBetalning = "Test_Exempelfil_betalningsservice.txt";
    private static final String fileInbetalning = "Test_Exempelfil_inbetalningstjansten.txt";

    @Test
    void shouldSuccessfullyExtractFromBetalningsservice() throws IOException, ParseException {
        PaymentService paymentService = new PaymentService();
        List<String> data = Files.readAllLines(Paths.get(folderPath + "/" + fileBetalning), StandardCharsets.ISO_8859_1);
        Account account = paymentService.extractData(data);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date expectedDate = formatter.parse("2011-03-15");

        Assertions.assertNotNull(account.getId());
        Assertions.assertNotNull(account.getPayments().get(0));
        Assertions.assertEquals(account.getPayments().size(), 4);
        Assertions.assertEquals(account.getPayments().get(0).getReference(), "1234567890");
        Assertions.assertEquals(account.getAccountNumber(), "55555555555555");
        Assertions.assertEquals(account.getDate(), expectedDate);
        Assertions.assertEquals(account.getCurrency(), "SEK");
    }

    @Test
    void shouldSuccessfullyExtractFromInbetalningstjansten() throws IOException {
        PaymentService paymentService = new PaymentService();
        List<String> data = Files.readAllLines(Paths.get(folderPath + "/" + fileInbetalning), StandardCharsets.ISO_8859_1);
        Account account = paymentService.extractData(data);

        Assertions.assertNotNull(account.getId());
        Assertions.assertNotNull(account.getPayments().get(0));
        Assertions.assertEquals(account.getPayments().size(), 3);
        Assertions.assertEquals(account.getPayments().get(0).getReference(), "9876543210");
        Assertions.assertEquals(account.getAccountNumber(), "12341234567897");
        Assertions.assertEquals(account.getDate(), null);
        Assertions.assertEquals(account.getCurrency(), "SEK");
    }
}