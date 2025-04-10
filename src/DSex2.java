import java.util.Arrays;
import java.util.Scanner;

public class DSex2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter array: ");
//        String[] arr_inp = sc.nextLine().split(" ");
//        int[] arr = new int[arr_inp.length];
//        for (int i = 0; i < arr_inp.length; i++) {
//            arr[i] = Integer.parseInt(arr_inp[i]);
//        }
//        int key = sc.nextInt();
//        System.out.print("Linear Search: ");
//        System.out.println(LinearSearch(arr, key, 0));
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        System.out.print("Binary Search: ");
//        System.out.println(BinarySearch(arr, key, 0, arr.length - 1));
        int[] arr = {4, 10, 16, 20, 30};
        createTable(arr.length);
        System.out.println(UniformBinarySearch(arr, 10));

//        System.out.println(interpolationSearch(new int[]{1, 3, 5, 6, 7, 8, 9}, 5));

    }

    private static int LinearSearch(int[] arr, int key, int index) {
        if (index == arr.length) {
            return -1;
        } else if (arr[index] == key) {
            return index;
        }
        return LinearSearch(arr, key, index + 1);
    }

    private static int BinarySearch(int[] arr, int key, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static int FibonacciSearch(int[] arr, int key) {
        int offset = -1, f1 = 0, f2 = 1, fm = f1 + f2;
        int n = arr.length;

        // Generating Fib numbers
        while (fm < n) {
            f1 = f2;
            f2 = fm;
            fm = f1 + f2;
        }

        // Searching
        while (fm > 1) {
            int i = Math.min(offset + f1, n - 1);
            if (arr[i] < key) {
                fm = f2;
                f2 = f1;
                f1 = fm - f2;
                offset = i;
            } else if (arr[i] > key) {
                fm = f1;
                f2 = f2 - f1;
                f1 = fm - f2;
                n = i;
            } else {
                return i;
            }
        }
        return -1;
    }

    // Uniform Binary Search
    static int[] lookup_table;
    private static void createTable(int n){
        int max = (int) Math.ceil(Math.log(n)/Math.log(2))+1;
        lookup_table = new int[max];

        for (int i = 0, power=2; i < max; i++, power*=2) {
            lookup_table[i] = n / power+1;
        }
        System.out.println(Arrays.toString(lookup_table));
    }

    private static int UniformBinarySearch(int[] arr, int key){
        int index = lookup_table[0];

        for (int i = 0; i < lookup_table.length-1; i++) {
            if(arr[index] == key) return index;
            if(arr[index] < key) index+=lookup_table[i+1];
            else index-=lookup_table[i+1];
        }
        return (arr[index]==key)? index:-1;
    }

    //interpolation search
    private static int interpolationSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high && key >= arr[low] && key <= arr[high]) {
            int pos = low + ((key - arr[low]) * (high - low) / (arr[high] - arr[low]));
            if (arr[pos] == key) {
                return pos;
            } else if (arr[pos] < key) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
        return -1;
    }
}
