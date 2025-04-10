import java.util.*;

public class DSex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar1 = new int[n];

        for (int i = 0; i < n; i++) {
            ar1[i] = sc.nextInt();
        }
        quickSort(ar1, 0, ar1.length - 1);
//        mergeSort(ar1, 0, ar1.length - 1);
//        shellSort(ar1);
//        radixsort(ar1, n);
        System.out.println(Arrays.toString(ar1));
    }
//5
//3 5 1 2 4

    // Quick Sort
    private static void quickSort(int[] ar1, int low, int high) {
        if (low < high) {
            int pi = partition(ar1, low, high);
            quickSort(ar1, low, pi - 1);
            quickSort(ar1, pi + 1, high);
        }
    }

    private static int partition(int[] ar1, int low, int high) {
        int pivot = ar1[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (ar1[j] < pivot) {
                i++;
                int temp = ar1[i];      // swap ar1[i] and ar1[j]
                ar1[i] = ar1[j];
                ar1[j] = temp;
            }
        }
        int temp = ar1[i + 1];
        ar1[i + 1] = ar1[high];     // swap ar1[i+1] and ar1[high]
        ar1[high] = temp;
        return i + 1;
    }

    // Merge Sort
    private static void mergeSort(int[] ar1, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(ar1, low, mid);
            mergeSort(ar1, mid + 1, high);
            merge(ar1, low, mid, high);
        }
    }

    private static void merge(int[] ar1, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(ar1, low, L, 0, n1);
        System.arraycopy(ar1, mid + 1, R, 0, n2);
        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {         // merging 2 sorted arrays
                ar1[k] = L[i];
                i++;
            } else {
                ar1[k] = R[j];
                j++;
            }
            k++;
        }
        // remaining elements
        while (i < n1) {
            ar1[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            ar1[k] = R[j];
            j++;
            k++;
        }
    }

    // Heap Sort
//    private static void heapSort(int[] ar1) {
//        int n = ar1.length;
//        for (int i = n / 2 - 1; i >= 0; i--) {
//            heapify(ar1, n, i);
//        }
//        for (int i = n - 1; i > 0; i--) {
//            int temp = ar1[0];
//            ar1[0] = ar1[i];
//            ar1[i] = temp;
//            heapify(ar1, i, 0);
//        }
//    }
//
//    private static void heapify(int[] ar1, int n, int i) {
//        int largest = i;
//        int l = 2 * i + 1;
//        int r = 2 * i + 2;
//        if (l < n && ar1[l] > ar1[largest]) {
//            largest = l;
//        }
//        if (r < n && ar1[r] > ar1[largest]) {
//            largest = r;
//        }
//        if (largest != i) {
//            int swap = ar1[i];
//            ar1[i] = ar1[largest];
//            ar1[largest] = swap;
//            heapify(ar1, n, largest);
//        }
//    }
    
    // Radix Sort
    private static void radixsort(int[] arr, int n) {
        int m = getMax(arr, n);
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    private static int getMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    private static void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n];
        int i;
        int[] count = new int[10];
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // Shell Sort
    private static void shellSort(int[] ar1) {
        int n = ar1.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = ar1[i];
                int j;
                for (j = i; j >= gap && temp < ar1[j - gap]; j -= gap) {
                    ar1[j] = ar1[j - gap];
                }
                ar1[j] = temp;
            }
        }
    }
}
