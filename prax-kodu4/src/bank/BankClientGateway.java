package bank;

import bank.exceptions.NoResourcesException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by chronoes on 9/24/15.
 */
public class BankClientGateway {
    public static final BigDecimal BASE_BALANCE = BigDecimal.valueOf(1000);

    private static Map<Integer, Optional<Client>> clients = new HashMap<>();

    public static Optional<Client> of(int id, LocalDate birthYear) {
        if (clients.containsKey(id)) {
            return clients.get(id);
        }
        BigDecimal balance = BASE_BALANCE;
        if (size() % 3 == 2) {
            balance = balance.add(BigDecimal.valueOf(100));
        }
        Client client = new Client(id, balance, birthYear, (id < 100));
        Optional<Client> newClient;
        if (LocalDate.now().compareTo(birthYear) < 60) {
            newClient = Optional.of(client);
        } else {
            newClient = Optional.empty();
        }
        clients.put(id, newClient);
        return newClient;
    }

    public static int size() {
        return clients.size();
    }

    public static Stream<Integer> getIdStream() {
        return clients.keySet().stream();
    }

    public static void processPayments(BigDecimal payment) {
        for (Optional<Client> client: clients.values()) {
            client.ifPresent(
                c -> {
                    processCard(c.getDebitCard(), payment);
                    c.getOptCreditCard().ifPresent(card -> processCard(card, payment));
                });
        }
    }

    private static void processCard(BankCard card, BigDecimal payment) {
        try {
            card.transferPayment(payment);
        } catch (NoResourcesException e) {
            System.out.println(e.toString());
        }
    }
}
