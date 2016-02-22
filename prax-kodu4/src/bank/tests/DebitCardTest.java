package bank.tests;

import bank.DebitCard;
import bank.exceptions.NoResourcesException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by Chronoes on 17.09.2015.
 */
public class DebitCardTest {
    private DebitCard card;

    @Before
    public void setUp() throws Exception {
        card = new DebitCard(BigDecimal.valueOf(150));
    }

    @Test
    public void testTransferPayment() throws NoResourcesException {
        card.transferPayment(BigDecimal.valueOf(52));
        assertEquals(BigDecimal.valueOf(98), card.getBalance());

        card.transferPayment(BigDecimal.valueOf(98));
        assertEquals(BigDecimal.ZERO, card.getBalance());
    }

    @Test(expected = NoResourcesException.class)
    public void testTransferPaymentFailure() throws NoResourcesException {
        card.transferPayment(BigDecimal.valueOf(1000));
    }
}