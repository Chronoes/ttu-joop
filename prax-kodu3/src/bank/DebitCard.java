package bank;

import bank.exceptions.NoResourcesException;

import java.math.BigDecimal;
/**
 * Created by chronoes on 9/17/15.
 */
public class DebitCard implements BankCard {
    protected BigDecimal balance;

    public DebitCard() {
        balance = new BigDecimal("150");
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public void transferPayment(BigDecimal sum) throws NoResourcesException {
        System.out.printf("Class %s: %s\n", getClass().getCanonicalName(), sum.toString());
        if (haveFreeResources(sum)) {
            balance = balance.subtract(sum);
        } else {
            throw new NoResourcesException("Payment not allowed");
        }
    }

    @Override
    public boolean haveFreeResources(BigDecimal sum) {
        return balance.compareTo(sum) >= 0;
    }
}
