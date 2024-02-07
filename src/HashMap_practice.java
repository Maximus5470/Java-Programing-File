import java.util.HashMap;
import java.util.Map;

public class HashMap_practice {
    public static void main(String[] args) {
        HashMap<Integer,String>map=new HashMap<>();
        map.put(1,"Harry"); // adds the data to the hashmap
        map.put(2,"Hermione");
        map.put(3,"Ron");
        map.put(4,"Draco");
        map.remove(4);  //removes value with key value 4 i.e. Draco
        System.out.println(map.size()); // size of the hashmap rn =3
        System.out.println(map);    // displays the hashmap   {1=Harry, 2=Hermione, 3=Ron}

        for (Map.Entry<Integer,String> e:map.entrySet()) {
            System.out.println(e.getKey()+", "+e.getValue());
        }
    }
}