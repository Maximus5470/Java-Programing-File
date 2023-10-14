import java.util.Scanner;

class Operators {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter numbers: ");
        String str = input.nextLine();
        String[] arr = str.split(" |,");
        double[] arr1 = new double[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arr1[i] = Double.parseDouble(arr[i]);
        }

        System.out.println("Enter operations:\n" +
                "1. Addition\n" +
                "2. Subtraction\n" +
                "3. Multiplication\n" +
                "4. Division");
        String n = input.nextLine();
        n = n.toLowerCase();
        switch (n) {
            case "1","add","addition"-> System.out.println(add(arr1));
            case "2","sub","subtraction"-> System.out.println(sub(arr1));
            case "3","multi","multiplication"-> System.out.println(mul(arr1));
            case "4","div","division"-> System.out.println(div(arr1));

            default-> System.out.println("Enter valid input.");
        }
    }

    static double add(double... values) {
        double sum = values[0];
        for (int i = 1; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }

    static double sub(double... values) {
        double sub = values[0];
        for (int i = 1; i < values.length; i++) {
            sub -= values[i];
        }
        return sub;
    }

    static double mul(double... values) {
        double prod = values[0];
        for (int i = 1; i < values.length; i++) {
            prod *= values[i];
        }
        return prod;
    }

    static double div(double... values) {
        if (values.length == 2) {
            return values[0] / values[1];
        } else {
            System.out.println("Digit entered is less or more than 2");
            return 0;
        }

    }
}