import java.util.Arrays;

public class PancakeSort {
    // Function to flip the array from 0 to i
    static void flip(int[] arr, int i) {
        int start = 0;
        while (start < i) {
            int temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
        }
    }

    // Function to find the index of the maximum element in arr[0..n-1]
    static int findMax(int[] arr, int n) {
        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    // Function to sort the array using pancake sort
    static void pancakeSort(int[] arr) {
        for (int currSize = arr.length; currSize > 1; currSize--) {
            int maxIdx = findMax(arr, currSize);
            if (maxIdx != currSize - 1) {
                flip(arr, maxIdx);
                flip(arr, currSize - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {23, 10, 20, 11, 12, 6, 7};
        pancakeSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}