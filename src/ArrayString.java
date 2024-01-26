import java.util.*;

public class ArrayString {


    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int previous = flowerbed[0];
        int count = 0;
        boolean plant = false;
        for(int i=1; i < flowerbed.length; i++){
            if(previous == 0 && flowerbed[i] ==0){
                plant = true;
            } if(plant && (flowerbed[i+1] ==0 || i == flowerbed.length -1)){
                count++;
                flowerbed[i] = 1;
                plant = false;
            }
            previous = flowerbed[i];
        }
        return count >= n;
    }

    public static int removeDuplicates(int[] nums) {

        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] != nums[i]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static int[] productExceptSelf(int[] nums) {
        int numsLength = nums.length;
        int prefixProduct = 1;
        int suffixProduct = 1;
        int[] result = new int[numsLength];
        for(int i = 0; i < numsLength; i++) {
            result[i] = prefixProduct;
            prefixProduct *= nums[i];
        }
        for(int i = numsLength-1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }
        return result;

    }

    public static int[] productExceptSelf1(int[] nums) {

        int numsLength = nums.length;
        int product = 1;
        int index = 0;

        int[] result = new int[numsLength];
        for (int num : nums) {
            if (num != 0) {
                product *= num;
            } else
                index++;
        }
        if(index > 1){
            return result;
        }
        for(int j=0; j< nums.length; j++) {
            if(nums[j]==0){
                result[j] = product;
            } else if(index !=1){
                result[j] = product/nums[j];

            }

        }
        return result;
    }

    /**
     * Given a string s, reverse only all the vowels in the string and return it.
     * @param s String
     * @return String with reverse vowel order
     */
    public static String reverseVowels(String s) {
        StringBuilder foundvowels = new StringBuilder();
        StringBuilder result = new StringBuilder();
        String lcs = s.toLowerCase();
        for(int i =0; i< s.length(); i++){
            if(lcs.charAt(i) == 'a' || lcs.charAt(i) == 'e' || lcs.charAt(i) == 'i'
                    || lcs.charAt(i) == 'o' || lcs.charAt(i) == 'u' ){
                foundvowels.append(s.charAt(i));
            }
        }
        foundvowels.reverse();
        int index =0;
        for(int i =0; i< s.length(); i++){
            if(lcs.charAt(i) == 'a' || lcs.charAt(i) == 'e' || lcs.charAt(i) == 'i'
                    || lcs.charAt(i) == 'o' || lcs.charAt(i) == 'u' ){
                result.append(foundvowels.charAt(index));
                index++;
            } else{
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }


}
