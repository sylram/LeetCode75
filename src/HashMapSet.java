import java.util.*;

public class HashMapSet {

    public static boolean uniqueOccurrences(int[] arr) {
        //Create hashmap key,value [int,int];
        //Iterate through map values to verify there is no duplicates

        Map<Integer,Integer> map = new HashMap<>();

        for(int n: arr){
            if(map.containsKey(n)){
                map.put(n, map.get(n)+1);
            } else {
                map.put(n,1);

            }
        }
        List<Integer> arrList = new ArrayList<>(map.values());
        Set<Integer> set = new HashSet<>(arrList);

        return arrList.size() == set.size();
    }
}
