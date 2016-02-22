package bank;

import java.math.BigDecimal;

/**
 * Created by chronoes on 9/17/15.
 */
public class NFCCard extends DebitCard {
    private BigDecimal paymentLimit;
    private BigDecimal totalLimit;
    private BigDecimal paymentsMade;

    public NFCCard() {
        super();
        paymentLimit = new BigDecimal("30");
        totalLimit = new BigDecimal("100");
        paymentsMade = BigDecimal.ZERO;
    }

    public BigDecimal getPaymentsMade() {
        return paymentsMade;
    }

    @Override
    public boolean haveFreeResources(BigDecimal sum) {
        if (balance.compareTo(sum) >= 0
                && paymentLimit.compareTo(sum) >= 0
                && totalLimit.compareTo(paymentsMade.add(sum)) >= 0) {
            paymentsMade = paymentsMade.add(sum);
            return true;
        }
        return false;
    }
}
