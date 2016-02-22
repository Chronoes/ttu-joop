import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Chronoes on 11.11.2015.
 */
public class Main {
    public static List<Wine> wines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try(Stream<String> lines = Files.lines(Paths.get("wine.data"))) {
            lines.forEach(line -> wines.add(new Wine(line)));
        } catch (IOException e) {
            System.err.println("wine.data missing from root");
            throw e;
        }

        System.out.println("Min magnesium content: " + wines.stream()
                .mapToDouble(Wine::getMagnesiumContent)
                .min()
                .getAsDouble());

        System.out.println("Max magnesium content: " + wines.stream()
                .mapToDouble(Wine::getMagnesiumContent)
                .max()
                .getAsDouble());

        double magnesiumAverageContent = wines.stream()
                .mapToDouble(Wine::getMagnesiumContent)
                .average()
                .getAsDouble();

        System.out.println("Average magnesium content: " + magnesiumAverageContent + "\n");

        wines.stream()
                .filter(wine -> wine.getMagnesiumContent() > magnesiumAverageContent)
                .forEach(wine -> wine.setSlogan("Siin veinis on palju magneesiumit!"));

        wines.stream()
                .mapToDouble(Wine::getFlavonoidContent)
                .sorted()
                .limit(5)
                .forEach(System.out::println);

        double alcoholAverageContent = wines.stream()
                .mapToDouble(Wine::getAlcoholContent)
                .average()
                .getAsDouble();

        wines.stream()
                .filter(wine -> wine.getCategory() == 3 && wine.getAlcoholContent() > alcoholAverageContent)
                .forEach(wine -> wine.setSlogan( "Alkohol on hea sulane, aga halb peremees! " +
                        "Alkohol kahjustab tervist ja eriti teie aju!"));

        wines.stream().forEach(System.out::println);
    }
}
