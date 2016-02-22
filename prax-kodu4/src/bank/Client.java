package bank;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

/**
 * Created by chronoes on 9/24/15.
 */
public class Client {
    private int id;
    private LocalDate birthYear;
    private DebitCard debitCard;
    private CreditCard creditCard;

    public Client(int id, BigDecimal balance, LocalDate birthYear, boolean eligibleForCredit) {
        this.id = id;
        this.birthYear = birthYear;
        debitCard = new DebitCard(balance);
        if (eligibleForCredit) {
            creditCard = new CreditCard(balance);
        }
    }

    public int getId() {
        return id;
    }

    public LocalDate getBirthYear() {
        return birthYear;
    }

    public DebitCard getDebitCard() {
        return debitCard;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public Optional<CreditCard> getOptCreditCard() {
        return Optional.ofNullable(creditCard);
    }
}
