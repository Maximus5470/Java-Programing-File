import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AttendanceSheet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Boolean> map = new HashMap<>();
        int inp;

        do {
            System.out.println("""
                    1. Take Attendance
                    2. Print Attendance
                    3. Count Present
                    4. Count Absent
                    5. Add Student
                    6. Remove Student
                    7. Print Present List
                    8. Print Absent List
                    9. Exit
                    """);
            inp = sc.nextInt();
            switch (inp) {
                case 1 -> takeAttendance(map);
                case 2 -> printAttendance(map);
                case 3 -> System.out.println(countPresent(map) + "/" + map.size() + " Present");
                case 4 -> System.out.println(countAbsent(map, map.size()) + "/" + map.size() + " Absent");
                case 5 -> {
                    sc.nextLine();
                    String rollNo;
                    do {
                        System.out.print("Enter Roll No (q to quit): ");
                        rollNo = sc.next().toUpperCase();
                        if (!map.containsKey(rollNo) && !rollNo.equals("Q")) {
                            addStudent(map, rollNo);
                        }
                    } while (!rollNo.equals("Q"));
                }
                case 6 -> {
                    String rollNo;
                    do {
                        System.out.print("Enter Roll No (q to quit): ");
                        rollNo = sc.next().toUpperCase();
                        if (map.containsKey(rollNo) && !rollNo.equals("Q")) {
                            removeStudent(map, rollNo);
                        }
                    } while (!rollNo.equals("Q"));
                }
                case 7 -> printPresent(map);
                case 8 -> printAbsent(map);
                case 9 -> System.exit(0);
                default -> System.out.println("Invalid Input");
            }
            System.out.println();
        } while (true);
    }


    public static void takeAttendance(HashMap<String, Boolean> map) {
        Scanner sc = new Scanner(System.in);
        String inp;
        do {
            System.out.print("Enter Roll No: ");
            inp = sc.nextLine().toUpperCase();
            if (!inp.equals("Q") && map.containsKey(inp)) {
                map.put(inp, true);
            }
        } while (!inp.equals("Q"));
    }

    public static void printAttendance(HashMap<String, Boolean> map) {
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "\t" + (entry.getValue() ? "Present" : "Absent"));
        }
    }

    public static int countPresent(HashMap<String, Boolean> map) {
        if (map.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                count++;
            }
        }
        return count;
    }

    public static int countAbsent(HashMap<String, Boolean> map, int n) {
        if (map.isEmpty()) {
            return 0;
        }
        return n - countPresent(map);
    }

    public static void addStudent(HashMap<String, Boolean> map, String rollNo) {
        map.put(rollNo, false);
    }

    public static void removeStudent(HashMap<String, Boolean> map, String rollNo) {
        map.remove(rollNo);
    }

    public static void printPresent(HashMap<String, Boolean> map) {
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                System.out.println(entry.getKey() + "\t" + "Present");
            }
        }
    }

    public static void printAbsent(HashMap<String, Boolean> map) {
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            if (!entry.getValue()) {
                System.out.println(entry.getKey() + "\t" + "Absent");
            }
        }
    }
}