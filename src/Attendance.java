import java.util.HashMap;

class Student {
    private String name;
    private int[] attendance;

    public Student(String name, int[] attendance) {
        this.name = name;
        this.attendance = attendance;
    }

    public String getName() {
        return name;
    }

    public int[] getAttendance() {
        return attendance;
    }

    public void setAttendance(int[] attendance) {
        this.attendance = attendance;
    }
}

public class Attendance {
    HashMap<Integer, Student> students;
    int id = 0;

    Attendance() {
        students = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.put(id, student);
        id++;
    }

    public void Condition() {
        for (Student student : students.values()) {
            int total = 0;
            for (int i : student.getAttendance()) {
                total += i;
            }
            int val = (total / student.getAttendance().length);

            System.out.println(val >= 65 ? val >= 75 ? student.getName() + " Passed" : student.getName() + " Condonation" : student.getName() + " Failed");
        }
    }

    public static void main(String[] args) {
        Attendance attendance = new Attendance();
        attendance.addStudent(new Student("James", new int[]{79, 69, 75, 84, 83}));
        attendance.addStudent(new Student("Bob", new int[]{32, 61, 75, 82, 82}));
        attendance.addStudent(new Student("John", new int[]{12, 1, 1, 5, 99}));

        attendance.Condition();
    }
}
