package bank.tests;

import bank.Client;
import bank.CreditCard;
import bank.DebitCard;
import bank.exceptions.NoResourcesException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by chronoes on 9/24/15.
 */
public class ClientTest {
    private final BigDecimal BASE_BALANCE = BigDecimal.valueOf(1000);

    private Client client_3;
    private Client client_103;

    @Before
    public void setUp() throws Exception {
        client_3 = new Client(3, BASE_BALANCE, LocalDate.ofYearDay(1990, 3), true);
        client_103 = new Client(103, BASE_BALANCE, LocalDate.ofYearDay(1990, 3), false);
    }

    @Test
    public void testClientId() {
        assertEquals(3, client_3.getId());
        assertEquals(103, client_103.getId());
    }

    @Test
    public void testGetDebitCard() {
        assertTrue("Debit card should exist for all clients", client_3.getDebitCard() != null);
        assertTrue("Debit card should exist for all clients", client_103.getDebitCard() != null);
    }

    @Test
    public void testGetCreditCard() {
        assertTrue("Credit card should exist for client ID " + client_3.getId(), client_3.getCreditCard() != null);
        assertTrue("Credit card should NOT exist for client ID " + client_103.getId(), client_103.getCreditCard() == null);
    }

    @Test
    public void testOptGetCreditCard() {
        assertTrue("Credit card should exist for client ID " + client_3.getId(), client_3.getOptCreditCard().isPresent());
        assertFalse("Credit card should NOT exist for client ID " + client_103.getId(), client_103.getOptCreditCard().isPresent());
    }

    @Test
    public void testPayments() throws NoResourcesException {
        DebitCard debit_3 = client_3.getDebitCard();
        CreditCard credit_3 = client_3.getCreditCard();

        BigDecimal payment = BigDecimal.valueOf(100);

        debit_3.transferPayment(payment);
        assertEquals(debit_3.getBalance(), BASE_BALANCE.subtract(payment));

        credit_3.transferPayment(payment);
        assertEquals(credit_3.getBalance(), BASE_BALANCE.subtract(payment));
    }

    @Test
    public void testOptionalCreditPayments() throws NoResourcesException {
        Optional<CreditCard> credit_3 = client_3.getOptCreditCard();
        Optional<CreditCard> credit_103 = client_103.getOptCreditCard();

        BigDecimal payment = BigDecimal.valueOf(150);

        if (credit_3.isPresent()) {
            credit_3.get().transferPayment(payment);
        }
        assertTrue("Optional credit card should exist for client ID " + client_3.getId(), credit_3.isPresent());
        assertEquals(credit_3.get().getBalance(), BASE_BALANCE.subtract(payment));

        assertFalse("Optional credit card should NOT exist for client ID " + client_103.getId(), credit_103.isPresent());
    }
}