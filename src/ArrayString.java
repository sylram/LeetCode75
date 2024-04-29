import java.util.*;

public class ArrayString {


    public static boolean canPlaceFlowers (int[] flowerbed, int n) {
        int previous = flowerbed[0];
        int[] result = new int[flowerbed.length];

        int count = 0;
        boolean plant = false;
        for (int i = 1; i < flowerbed.length; i++) {
            if (previous == 0 && flowerbed[i] == 0) {
                plant = true;
            }
            if (plant && (flowerbed[i + 1] == 0 || i == flowerbed.length - 1)) {
                count++;
                flowerbed[i] = 1;
                plant = false;
            }
            previous = flowerbed[i];
        }
        return count >= n;
    }

    public static int removeDuplicates1 (int[] nums) {

        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static int[] productExceptSelf (int[] nums) {
        int numsLength = nums.length;
        int prefixProduct = 1;
        int suffixProduct = 1;
        int[] result = new int[numsLength];
        for (int i = 0; i < numsLength; i++) {
            result[i] = prefixProduct;
            prefixProduct *= nums[i];
        }
        for (int i = numsLength - 1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }
        return result;

    }

    public static int[] productExceptSelf1 (int[] nums) {

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
        if (index > 1) {
            return result;
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                result[j] = product;
            } else if (index != 1) {
                result[j] = product / nums[j];

            }

        }
        return result;
    }

    /**
     * Given a string s, reverse only all the vowels in the string and return it.
     *
     * @param s String
     * @return String with reverse vowel order
     */
    public static String reverseVowels (String s) {
        StringBuilder foundvowels = new StringBuilder();
        StringBuilder result = new StringBuilder();
        String lcs = s.toLowerCase();


        for (int i = 0; i < s.length(); i++) {
            if (lcs.charAt(i) == 'a' || lcs.charAt(i) == 'e' || lcs.charAt(i) == 'i'
                    || lcs.charAt(i) == 'o' || lcs.charAt(i) == 'u') {
                foundvowels.append(s.charAt(i));
            }
        }
        foundvowels.reverse();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (lcs.charAt(i) == 'a' || lcs.charAt(i) == 'e' || lcs.charAt(i) == 'i'
                    || lcs.charAt(i) == 'o' || lcs.charAt(i) == 'u') {
                result.append(foundvowels.charAt(index));
                index++;
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    public static int compress (char[] chars) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < chars.length; ) {
            char c = chars[i];
            int count = 1;
            while (i + 1 < chars.length && c == chars[i + 1]) {
                i++;
                count++;
            }
            str.append(c);
            if (count > 1) {
                str.append(count);
            }
            i++;
        }
        char[] valuesChar = str.toString().toCharArray();
        int index = 0;
        for (char c : valuesChar) {
            chars[index] = c;
            index++;
        }
        return valuesChar.length;
    }

    public static boolean checkIfExist (int[] arr) {
        boolean result = false;
        for (int k : arr) {
            for (int j = 1; j < arr.length; j++) {
                if ((k * 2) == arr[j]) {
                    result = true;
                    break;
                } else if (k == arr[j] * 2) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public static int diffPossible (final List<Integer> A, int B) {

        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            int findNum = B + A.get(i);
            if (A.contains(findNum) && A.indexOf(findNum) != i) {
                count++;
                break;
            }
        }
        return count;
    }

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid. Open brackets must be closed by the same type of brackets.
     * @param s String
     * @return boolean
     */
    public static boolean isValid (String s) {
        Stack<Character> stack = new Stack<>();

        // Loop through every character in the string
        for (char c : s.toCharArray()) {
            // If the character is an opening bracket, push it onto the stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else { // If the character is a closing bracket
                // If the stack is empty, there is no matching opening bracket, so return false
                if (stack.isEmpty()) {
                    return false;
                }
                // Otherwise, get the top of the stack and check if it's the matching opening bracket
                char top = stack.peek();
                if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                    // If it is, pop the opening bracket from the stack
                    stack.pop();
                } else { // Otherwise, the brackets don't match, so return false
                    return false;
                }
            }
        }
        // If the stack is empty, all opening brackets have been closed, so return true
        // Otherwise, there are unmatched opening brackets, so return false
        return stack.isEmpty();
    }

    public int removeDuplicates(int[] nums) {
        ArrayList<Integer> arrList = new ArrayList();

        arrList.add(nums[0]);
        int count =1;
        for(int i=0; i< nums.length-1; i++){
            if(arrList.get(i) == nums[i+1] && count <=1 ){
                count++;
                arrList.add(nums[i+1]);
            } else {
                count =0;
                if(nums[i] != nums[i+1]){
                    arrList.add(nums[i+1]);

                }
            }
        }

        for(int i =0; i< arrList.size(); i++){
            nums[i] = arrList.get(i);
        }

        return arrList.size();
    }

    public static void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        int start = (nums.length >= k) ? (nums.length - k) : k%nums.length;
        int numRotation = (nums.length >= k) ? (nums.length - k) : k%nums.length;
        int index =0;
        // length 7 - k 3 -- start 4 0-5 1-6 2-7 3
        //0-4,1-5,2-6
        if(start < nums.length){
            for(int i=0; i< nums.length; i++){
                if(numRotation > i && start < nums.length){
                    arr[i] = nums[nums.length -1 -i];
                    start++;
                } else {
                    arr[i] = nums[index];
                    index++;
                }
            }


            for(int j=0; j<nums.length; j++){
                nums[j] = arr[j];
            }
        }
    }

    public static boolean isSubsequence(String s, String t) {

        char[] chars = s.toCharArray();
        int index = 0;
        for(int i=0; i< chars.length; i++){
            if((t.indexOf(chars[i], index)) >= 0){
                index = t.indexOf(chars[i], index) +1;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
     * starting with word1. If a string is longer than the other, append the additional letters onto the end
     * of the merged string.
     * @param word1 String
     * @param word2 String
     * @return String
     */
    public String mergeAlternately(String word1, String word2) {
        int lenWord1 = word1.length();
        int lenWord2 = word2.length();
        int len = Math.max(lenWord1, lenWord2);
        StringBuilder result = new StringBuilder();

        for(int i=0; i < len; i++){
            if(lenWord1 > i){
                result.append(word1.charAt(i));
            } if(lenWord2 > i) {
                result.append(word2.charAt(i));
            }
        }
        return result.toString();
    }

    public static boolean exist(char[][] board, String word) {
        int index = 0;
        int lastFound =0;
        for(int i=0; i < board.length; i++){
            for(int j=0; j< board[i].length; j++){
                if( word.charAt(index) == board[i][j]) {
                    index++;
                    lastFound = j;
                    board[i][j] = 0;
                } else if (index >0 && j>0 && lastFound > 0 && word.charAt(index) == board[i][lastFound-1] ) {
                    index++;
                    board[i][j] = 0;
                    lastFound = j;
                }
            }
        }
        if(index == word.length()){
            return true;
        } else {
            return false;
        }
    }

    public static boolean magicNumber(int num){
        int sum = 0;
        boolean result = false;
        while (num > 0 || sum > 9){
            if(num == 0){
                num = sum;
                sum = 0;
            }
                sum += num % 10;
                num = num/10;

        }
        return sum == 1;

    }

    public int[] twoSum(int[] nums, int target)  {

        ArrayList<Integer> arrList = new ArrayList();
        int[] result = new int[2];

        for(int i : nums){
            arrList.add(i);
        }

        for(int i =0; i< arrList.size(); i++){
            int numToFind = target - arrList.get(i);
            if(arrList.contains(numToFind) && arrList.indexOf(numToFind) != i){
                result[0] = i;
                result[1] = arrList.indexOf(numToFind);

                break;

            }

        }
        return result;
    }


    public boolean checkValidString(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int left = 0;
        int right = 0;
        for (int i = 0; i < chars.length ; i++) {
            if(chars[i]== '(' || chars[i]== '*'){
                left++;
            }
            if(chars[len-i] == ')' || chars[len-i] == '*' ){
                right++;
                left --;
            }
            if(left <0 && right <0){
                return false;
            }
        }

     return false;
    }

    public static String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack();
        int left = 0;
        for(int i=0; i< sb.length(); i++){
            if(sb.charAt(i) == '('){
                stack.push(i);
            } else {
                if(sb.charAt(i) == ')' && stack.isEmpty()){
                    sb.deleteCharAt(i);
                    i--;
                }else if(sb.charAt(i) == ')'){
                    stack.pop();

                }
            }
        }
        if(!stack.isEmpty()){
            Iterator value = stack.iterator();
            while(value.hasNext()){
                sb.deleteCharAt(stack.pop());
            }
        }
        return sb.toString();
    }

    public int minSwaps(String s) {

        Stack<Integer> opening = new Stack();
        int counter=0;
        int len = s.length() -1;

        for(int i=0; i< s.length(); i++){
            if(s.charAt(i) == '['){
                opening.push(i);
            } else {
                if(!opening.isEmpty()){
                    opening.pop();
                }
            }


        }
        return (opening.size()+1)/2;

    }

    public static int removeDuplicates2(int[] nums) {
        int num = nums[0];
        int counter =1;
        int index=1;
        for(int i=1; i<nums.length; i++){
            if(num == nums[i] && counter <2){
                counter++;
                index++;
                if(i == nums.length-1){
                    nums[index] = nums[i];
                }
            }else {

                if(num != nums[i] || i == nums.length-1){
                    nums[index] = nums[i];
                    index++;
                    counter =1;
                }
            }
            num = nums[i];
        }
        return index;

    }

    public static boolean isPalindrome(String s) {
        String[] chars = s.split(" ");

        String alpha = s.toLowerCase().replaceAll("[^a-zA-Z]+", "");
        StringBuilder sb = new StringBuilder(alpha);
        String reverse = sb.reverse().toString();
        return reverse.equals(alpha);
    }

}