import java.util.List;
import java.util.Stack;

public class ArrayString {


    public static boolean canPlaceFlowers (int[] flowerbed, int n) {
        int previous = flowerbed[0];
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

    public static int removeDuplicates (int[] nums) {

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

}