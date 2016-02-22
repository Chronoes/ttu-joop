package bank;

import bank.exceptions.NoResourcesException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by Chronoes on 18.09.2015.
 */
public class NFCCardTest {
    private NFCCard card;

    @Before
    public void setUp() throws Exception {
        card = new NFCCard();
    }

    @Test
    public void testTransferPayment() throws NoResourcesException {
        card.transferPayment(BigDecimal.TEN);
        assertEquals(card.getBalance(), new BigDecimal("140"));
        assertEquals(card.getPaymentsMade(), BigDecimal.TEN);

        card.transferPayment(new BigDecimal("30"));
        assertEquals(card.getBalance(), new BigDecimal("110"));
        assertEquals(card.getPaymentsMade(), new BigDecimal("40"));

        card.transferPayment(new BigDecimal("30"));
        assertEquals(card.getBalance(), new BigDecimal("80"));
        assertEquals(card.getPaymentsMade(), new BigDecimal("70"));

        card.transferPayment(new BigDecimal("30"));
        assertEquals(card.getBalance(), new BigDecimal("50"));
        assertEquals(card.getPaymentsMade(), new BigDecimal("100"));

    }

    @Test(expected = NoResourcesException.class)
    public void testPaymentLimitFailure() throws NoResourcesException {
        card.transferPayment(new BigDecimal("100"));
    }

    @Test(expected = NoResourcesException.class)
    public void testTotalLimitFailure() throws NoResourcesException {
        card.transferPayment(new BigDecimal("30"));
        card.transferPayment(new BigDecimal("30"));
        card.transferPayment(new BigDecimal("30"));
        card.transferPayment(new BigDecimal("30"));
    }
}