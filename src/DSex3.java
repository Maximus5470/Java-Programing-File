import java.util.Arrays;

public class DSex3 {
    public static void main(String[] args) {
        int[] ar1 = {5, 3, 8, 4, 2};
        System.out.println(Arrays.toString(insertionSort(ar1)));
    }

    private static int[] bubbleSort(int[] ar1) {
        boolean swapped = false;
        for (int i = 0; i < ar1.length - 1; i++) {
            for (int j = 0; j < ar1.length - i - 1; j++) {
                if (ar1[j] > ar1[j + 1]) {
                    int temp = ar1[j];
                    ar1[j] = ar1[j + 1];
                    ar1[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) return ar1;
        }
        return ar1;
    }

    private static int[] selectionSort(int[] ar1) {
        for (int i = 0; i < ar1.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < ar1.length; j++) {
                if (ar1[smallest] > ar1[j]) smallest = j;
            }
            int temp = ar1[smallest];
            ar1[smallest] = ar1[i];
            ar1[i] = temp;
        }
        return ar1;
    }

    private static int[] insertionSort(int[] ar1) {
        for (int i = 1; i < ar1.length; i++) {
            int current = ar1[i];
            int j = i - 1;
            while (j >= 0 && current < ar1[j]) {
                ar1[j + 1] = ar1[j];
                j--;
            }
            ar1[j + 1] = current;
        }
        return ar1;
    }
}
