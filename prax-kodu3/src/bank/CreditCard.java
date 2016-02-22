package bank;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by chronoes on 9/17/15.
 */
public class CreditCard extends DebitCard {
    private BigDecimal creditLimit;

    public CreditCard() {
        super();
        creditLimit = new BigDecimal("500");
    }

    public CreditCard(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance(Calendar date) {
        return balance;
    }

    @Override
    public boolean haveFreeResources(BigDecimal sum) {
        return balance.add(creditLimit).compareTo(sum) >= 0;
    }
}
