package bank;

import java.math.BigDecimal;

/**
 * Created by chronoes on 9/17/15.
 */
public class NFCCard extends DebitCard {
    private static final BigDecimal TOTAL_LIMIT = BigDecimal.valueOf(100);
    private static final BigDecimal PAYMENT_LIMIT = BigDecimal.valueOf(30);

    private BigDecimal paymentsMade = BigDecimal.ZERO;

    public NFCCard() {}
    public NFCCard(BigDecimal newBalance) { balance = newBalance; }

    public BigDecimal getPaymentsMade() {
        return paymentsMade;
    }

    @Override
    public boolean haveFreeResources(BigDecimal sum) {
        if (balance.compareTo(sum) >= 0
                && PAYMENT_LIMIT.compareTo(sum) >= 0
                && TOTAL_LIMIT.compareTo(paymentsMade.add(sum)) >= 0) {
            paymentsMade = paymentsMade.add(sum);
            return true;
        }
        return false;
    }
}
