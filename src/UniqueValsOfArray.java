import java.util.*;

public class UniqueValsOfArray {
    public static void main(String[] args) {
        int[] array={1,1,1,2,2,3,3,3,3,3,4,4,4,5};
        ArrayList<Integer> l1=new ArrayList<Integer>();
        for (int i:array) {
            l1.add(i);  //appends all elements of array into ArrayList
        }
        Set<Integer> distinct=new HashSet<>(l1);    //convert unique elements into HashSet
        System.out.println(distinct);

        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i:distinct) {
            map.put(i,Collections.frequency(l1,i));     //adding unique number and count in HashMap
        }
        System.out.println(map.get(3));     //print HashMap value
    }
}