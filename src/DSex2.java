import java.util.Arrays;
import java.util.Scanner;

public class DSex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array: ");
        String[] arr_inp = sc.nextLine().split(" ");
        int[] arr = new int[arr_inp.length];
        for (int i = 0; i < arr_inp.length; i++) {
            arr[i] = Integer.parseInt(arr_inp[i]);
        }
        int key = sc.nextInt();
        System.out.print("Linear Search: ");
        System.out.println(LinearSearch(arr, key,0));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.print("Binary Search: ");
        System.out.println(BinarySearch(arr, key, 0, arr.length-1));

    }

    public static int LinearSearch(int[] arr, int key, int index) {
        if(index == arr.length){
            return -1;
        }else if (arr[index] == key){
            return index;
        }
        return LinearSearch(arr, key, index+1);
    }

    public static int BinarySearch(int[] arr, int key, int left, int right) {
        int mid = (left+right)/2;
        if (left > right){
            return -1;
        }
        if(key>arr[mid]){
            return BinarySearch(arr, key, mid+1, right);
        }else if(key < arr[mid]){
            return BinarySearch(arr, key, left, mid-1);
        }
        return mid;
    }
}
