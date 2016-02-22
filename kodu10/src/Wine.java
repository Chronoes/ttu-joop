/**
 * Created by Chronoes on 11.11.2015.
 */
public class Wine {
    private int category;
    private double alcoholContent;
    private double magnesiumContent;
    private double flavonoidContent;
    private String slogan;
    private String description;

    public Wine(String csv) {
        String[] parsedData = csv.split(",");
        category = Integer.parseInt(parsedData[0]);
        alcoholContent = Double.parseDouble(parsedData[1]);
        magnesiumContent = Double.parseDouble(parsedData[4]);
        flavonoidContent = Double.parseDouble(parsedData[6]);
    }

    @Override
    public String toString() {
        return String.format("Wine category: %d, %.2f%% alcohol, %.2f%% magnesium, %.2f%% flavonoids\nSlogan: %s\n",
                category, alcoholContent, magnesiumContent, flavonoidContent, slogan);
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(double alcoholContent) {
        this.alcoholContent = alcoholContent;
    }

    public double getMagnesiumContent() {
        return magnesiumContent;
    }

    public void setMagnesiumContent(double magnesiumContent) {
        this.magnesiumContent = magnesiumContent;
    }

    public double getFlavonoidContent() {
        return flavonoidContent;
    }

    public void setFlavonoidContent(double flavonoidContent) {
        this.flavonoidContent = flavonoidContent;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
