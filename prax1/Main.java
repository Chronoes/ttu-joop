
public class Main {
    public static void main (String[] args) {
        StudentOOP student1 = new StudentOOP("Rain");
        StudentOOP student2 = new StudentOOP("Marten");
        StudentOOP student3 = new StudentOOP("Uku");

        student1.addPoints(3);
        student2.addPoints(5);
        student3.addPoints(1);

        student1.setYear(2012);
        student2.setYear(2014);

        System.out.println(student1.getYear());
        System.out.println(student2.getYear());
        System.out.println(student3.getYear());
    }
}