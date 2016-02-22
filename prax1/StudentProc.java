import java.util.HashMap;

public class StudentProc {
    private static HashMap students = new HashMap();

    public static void addStudent(String name) {
        students.put(name, 0);
    }

    public static void addPoints(String studentName, int pointsToAdd) {
        students.put(studentName, getPoints(studentName) + pointsToAdd);
    }

    public static int getPoints(String studentName) {
        return (Integer) students.get(studentName);
    }
}