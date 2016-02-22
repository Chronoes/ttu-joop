package bank.tests;

import bank.BankClientGateway;
import bank.Client;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by chronoes on 9/24/15.
 */
public class BankClientGatewayTest {
    private final List<Integer> ids = Arrays.asList(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024);
    private Map<Integer, LocalDate> clientMap = new HashMap<>();

    private LocalDate makeBirthYear(int id) {
        return LocalDate.now().minusYears(id);
    }

    @Before
    public void setUp() throws Exception {
        ids.stream().forEach(id -> clientMap.put(id, makeBirthYear(id)));
        clientMap.forEach(BankClientGateway::of);
    }

    @Test
    public void testOfNewInstance() {
        int id = 3;
        int prevSize = BankClientGateway.size();
        Optional<Client> client = BankClientGateway.of(id, makeBirthYear(id));
        assertEquals(id, client.get().getId());
        assertEquals(prevSize+1, BankClientGateway.size());
    }

    @Test
    public void testOfExistingInstance() {
        int id = ids.get(0);
        int prevSize = BankClientGateway.size();
        Optional<Client> client = BankClientGateway.of(id, makeBirthYear(id));
        assertEquals(id, client.get().getId());
        assertEquals(prevSize, BankClientGateway.size());
    }

    @Test
    public void testPaymentProcessing() {
        BigDecimal payment = BigDecimal.valueOf(53);
        Map<Integer, BigDecimal> prevBalances = new HashMap<>();
        BankClientGateway.getIdStream().forEach(
            id -> {
                Optional<Client> client = BankClientGateway.of(id, makeBirthYear(id));
                client.ifPresent(c -> prevBalances.put(id, c.getDebitCard().getBalance()));
            });

        BankClientGateway.processPayments(payment);
        BankClientGateway.getIdStream().forEach(
            id -> {
                Optional<Client> client = BankClientGateway.of(id, makeBirthYear(id));
                client.ifPresent(c -> {
                    assertTrue("Debit card balance should be reduced by " + payment.toString(),
                            c.getDebitCard().getBalance().equals(prevBalances.get(id).subtract(payment)));
                    c.getOptCreditCard().ifPresent(
                            card -> assertTrue("Credit card balance should be reduced by " + payment.toString(),
                                    card.getBalance().equals(prevBalances.get(id).subtract(payment))));
                });
            });
    }
}