import bank.BankCard;
import bank.CreditCard;
import bank.DebitCard;
import bank.PaymentProcessor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chronoes on 9/17/15.
 */

public class Test {
    public static void main(String[] args) {
        DebitCard debit = new DebitCard();
        CreditCard credit = new CreditCard();
        DebitCard debitCredit = new CreditCard();

        try {
            debit.transferPayment(new BigDecimal("100.05"));
            credit.transferPayment(new BigDecimal("50.02"));
            debitCredit.transferPayment(new BigDecimal("13.74"));
        } catch (bank.exceptions.NoResourcesException e) {
            System.out.printf("Transfer failed: %s", e.getMessage());
        }

        System.out.println(debit.getBalance());
        System.out.println(credit.getBalance());
        System.out.println(debitCredit.getBalance());

        PaymentProcessor processor = new PaymentProcessor();
        List<BankCard> bankCardList = new ArrayList<>();
        bankCardList.add(debit);
        bankCardList.add(credit);
        bankCardList.add(debitCredit);
        int errors = processor.makePayments(bankCardList);
        if (errors > 0) {
            System.out.printf("Payment processing failed with %d errors", errors);
        } else {
            System.out.println("Payment processing succeeded.");
        }
    }
}
