package bank;

import bank.exceptions.NoResourcesException;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by chronoes on 9/17/15.
 */
public class PaymentProcessor {
    public int makePayments(List<BankCard> clients) {
        int errors = 0;
        for (BankCard client: clients) {
            try {
                client.transferPayment(new BigDecimal("3.0454547"));
            } catch (NoResourcesException e) {
                System.out.printf("%s: %s\n", getClass().getCanonicalName(), e.getMessage());
                errors++;
            }
        }
        return errors;
    }
}
