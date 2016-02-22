package bank;

import bank.exceptions.NoResourcesException;

import java.math.BigDecimal;

/**
 * Created by chronoes on 9/17/15.
 */
public interface BankCard {
    BigDecimal getBalance();
    void transferPayment(BigDecimal sum) throws NoResourcesException;
    boolean haveFreeResources(BigDecimal sum);
}