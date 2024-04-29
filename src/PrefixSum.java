import java.util.*;

public class PrefixSum {

    /**
     * There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes.
     * The biker starts his trip on point 0 with altitude equal 0.
     * @param gain array where gain[i] is the net gain in altitude between points i and i + 1
     * @return int highest altitude point
     */
    public static int largestAltitude(int[] gain) {
        int altitude = 0;
        int maxAltitude = 0;
        for (int j : gain) {
            altitude = altitude + j;
            maxAltitude = Math.max(maxAltitude, altitude);
        }
        return maxAltitude;
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> lista = new ArrayList<>(Arrays.stream(nums1).boxed().toList());
        List<Integer> listb = new ArrayList<>(Arrays.stream(nums2).boxed().toList());
        Set<Integer> seta = new HashSet<>();
        Set<Integer> setb = new HashSet<>();

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i < nums1.length; i++){
            for(int j=0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    int value = nums1[i];
                    lista.removeIf(n -> n == value);
                    listb.removeIf(n -> n == value);

                }
            }
        }

        for (int i = 0; i < lista.size() ; i++) {
            seta.add(lista.get(i));

        }
        for (int i = 0; i < listb.size() ; i++) {
            setb.add(listb.get(i));
        }
        result.add(new ArrayList<>(seta));
        result.add(new ArrayList<>(setb));
        return result;
    }

    public List<List<Integer>> findDifference2(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> ans1 = new ArrayList<Integer>();
        List<Integer> ans2 = new ArrayList<Integer>();
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();

        for(int n : nums1) set1.add(n);
        for(int n : nums2) set2.add(n);
        for (int n : set1){
            if(set2.contains(n) == false){
                ans1.add(n);
            }
        }
        for (int n : set2){
            if(set1.contains(n) == false){
                ans2.add(n);
            }
        }
        ans.add(ans1);
        ans.add(ans2);
        return ans;
    }
}
