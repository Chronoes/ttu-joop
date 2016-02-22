package travel;

/**
 * Created by chronoes on 11/18/15.
 */
import java.util.function.DoubleBinaryOperator;

public interface DestinationModel {
    String getName();
    double getKelvin();
    double getAvgWeather(DoubleBinaryOperator tempHandler);
}
