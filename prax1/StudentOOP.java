import java.time.Year;

public class StudentOOP {
    private String name;
    private int points = 0;
    private int year;

    public StudentOOP(String name) {
        this.name = name;
        this.year = Year.now().getValue();
    }

    public String getName() {
        return this.name;
    }

    public int getPoints() {
        return this.points;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void addPoints(int points) {
        this.points += points;
    }


}