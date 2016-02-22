package bank;

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
        card = new CreditCard();
    }

    @Test
    public void testTransferPayment() throws NoResourcesException {
        card.transferPayment(new BigDecimal("52"));
        assertEquals(card.getBalance(), new BigDecimal("98"));

        card.transferPayment(new BigDecimal("98"));
        assertEquals(card.getBalance(), BigDecimal.ZERO);

        card.transferPayment(new BigDecimal("300"));
        assertEquals(card.getBalance(), new BigDecimal("-300"));

        card.transferPayment(new BigDecimal("200"));
        assertEquals(card.getBalance(), new BigDecimal("-500"));
    }

    @Test(expected = NoResourcesException.class)
    public void testTransferPaymentFailure() throws NoResourcesException {
        card.transferPayment(new BigDecimal("1000"));
    }
}