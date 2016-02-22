package bank;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by chronoes on 9/17/15.
 */
public class CreditCard extends DebitCard {
    private static final BigDecimal CREDIT_LIMIT = BigDecimal.valueOf(500);

    public CreditCard() {}

    public CreditCard(BigDecimal newBalance) { super(newBalance); }

    @Override
    public boolean haveFreeResources(BigDecimal sum) {
        return balance.add(CREDIT_LIMIT).compareTo(sum) >= 0;
    }
}
