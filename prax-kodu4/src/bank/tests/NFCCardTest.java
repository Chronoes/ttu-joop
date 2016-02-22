package bank.tests;

import bank.NFCCard;
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
        card = new NFCCard(BigDecimal.valueOf(150));
    }

    @Test
    public void testTransferPayment() throws NoResourcesException {
        card.transferPayment(BigDecimal.TEN);
        assertEquals(BigDecimal.valueOf(140), card.getBalance());
        assertEquals(BigDecimal.TEN, card.getPaymentsMade());

        card.transferPayment(BigDecimal.valueOf(30));
        assertEquals(BigDecimal.valueOf(110), card.getBalance());
        assertEquals(BigDecimal.valueOf(40), card.getPaymentsMade());

        card.transferPayment(BigDecimal.valueOf(30));
        assertEquals(BigDecimal.valueOf(80), card.getBalance());
        assertEquals(BigDecimal.valueOf(70), card.getPaymentsMade());

        card.transferPayment(BigDecimal.valueOf(30));
        assertEquals(BigDecimal.valueOf(50), card.getBalance());
        assertEquals(BigDecimal.valueOf(100), card.getPaymentsMade());

    }

    @Test(expected = NoResourcesException.class)
    public void testPaymentLimitFailure() throws NoResourcesException {
        card.transferPayment(BigDecimal.valueOf(100));
    }

    @Test(expected = NoResourcesException.class)
    public void testTotalLimitFailure() throws NoResourcesException {
        card.transferPayment(BigDecimal.valueOf(30));
        card.transferPayment(BigDecimal.valueOf(30));
        card.transferPayment(BigDecimal.valueOf(30));
        card.transferPayment(BigDecimal.valueOf(30));
    }
}