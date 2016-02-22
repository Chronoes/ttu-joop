package travel;

/**
 * Created by chronoes on 11/18/15.
 */
public class Name {
    private String name;
    private String localName;
    private String country;
    private String continent;

    public Name(String name, String localName, String country, String continent) {
        this.name = name;
        this.localName = localName;
        this.country = country;
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public String getLocalName() {
        return localName;
    }

    public String getCountry() {
        return country;
    }

    public String getContinent() {
        return continent;
    }
}
