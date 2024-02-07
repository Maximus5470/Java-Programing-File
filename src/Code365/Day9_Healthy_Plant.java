package Code365;

import java.util.Scanner;

public class Day9_Healthy_Plant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        sc.nextLine();

        byte[][] state = new byte[m][n];
        for (int i = 0; i < m; i++) {
            String[] input = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                state[i][j] = switch (input[j]) {
                    case "NP" ->  0;
                    case "NH" -> -1;
                    case "H"  ->  1;
                    default   ->  0;
                };
            }
        }
        System.out.println(calculateRuntime(state, 0));
    }

    public static int calculateRuntime(byte[][] currentState, int runtime) {
        byte[][] newState = currentState.clone();
        int m = currentState.length, n = currentState[0].length;
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
            newState[i][j] = switch (currentState[i][j]) {
                case 0, -1 -> 0;
                case 1 -> {
                    if (i < m - 1 && currentState[i + 1][j] == -1) yield -1;
                    else if (i > 0 && currentState[i - 1][j] == -1) yield -1;
                    else if (j < n - 1 && currentState[i][j + 1] == -1) yield -1;
                    else if (j > 0 && currentState[i][j - 1] == -1) yield -1;
                    else yield 1;
                }
                default -> -2;
            };
        }
        return (allZeroes(newState))?runtime:calculateRuntime(newState, runtime+1);
    }

    public static boolean allZeroes(byte[][] state) {
        for (byte[] bytes : state)
            for (byte bite : bytes)
                if (bite != 0) return false;
        return true;
    }
}
