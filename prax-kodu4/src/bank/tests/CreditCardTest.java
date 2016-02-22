package bank.tests;

import bank.CreditCard;
import bank.exceptions.NoResourcesException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by Chronoes on 18.09.2015.
 */
public class CreditCardTest {
    private CreditCard card;

    @Before
    public void setUp() throws Exception {
        card = new CreditCard(BigDecimal.valueOf(150));
    }

    @Test
    public void testTransferPayment() throws NoResourcesException {
        card.transferPayment(BigDecimal.valueOf(52));
        assertEquals(BigDecimal.valueOf(98), card.getBalance());

        card.transferPayment(BigDecimal.valueOf(98));
        assertEquals(BigDecimal.ZERO, card.getBalance());

        card.transferPayment(BigDecimal.valueOf(300));
        assertEquals(BigDecimal.valueOf(-300), card.getBalance());

        card.transferPayment(BigDecimal.valueOf(200));
        assertEquals(BigDecimal.valueOf(-500), card.getBalance());
    }

    @Test(expected = NoResourcesException.class)
    public void testTransferPaymentFailure() throws NoResourcesException {
        card.transferPayment(BigDecimal.valueOf(1000));
    }
}