import travel.Destination;
import travel.Name;
import travel.Temperature;

/**
 * Created by chronoes on 11/18/15.
 */
public class Main {
    public static void main(String[] args) {
        Destination dest = new Destination(new Name("Milaano", "Milano", "Itaalia", "Euroopa"), new Temperature(273.15, 313.15));
        dest.processName((name) -> {
            System.out.format("%s (%s), %s, %s\n", name.getName(), name.getLocalName(), name.getCountry(), name.getContinent());
        });

        dest.processName((name) -> System.out.format("%s, %s\n", name.getName(), name.getCountry()));

        dest.processName((name) -> System.out.println(name.getName()));

        dest.processName((name) -> System.out.println(name.getName().toUpperCase()));

        dest.processName((name) -> System.out.format("%s, %s\n", name.getName(), name.getCountry().toUpperCase()));
    }
}
