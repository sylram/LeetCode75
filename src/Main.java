import java.util.Arrays;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int [] flowerbed ={1,0,0,0,1};
        System.out.println(ArrayString.canPlaceFlowers(flowerbed,1));
        System.out.println(TwoPointers.isSubsequence("aaaaaa", "bbaaaa"));

        int[] nums = {1,1,2};
        System.out.println(Arrays.toString(TwoPointers.moveZeroes(nums)));
        System.out.println(ArrayString.removeDuplicates(nums));
        int [] prices = {7,1,5,3,6,4};
        System.out.println(TwoPointers.maxProfit2(prices));
        int[] numbers = {-1,0,0,-3,3};
        System.out.println(Arrays.toString(ArrayString.productExceptSelf1(numbers)));
        int[] values = {1,12,-5,-6,50,3};
        System.out.println(SlideWindow.findMaxAverage(values,4));
        int[] nums1 = {1,2,3,3};
        int[] nums2 = {1,1,2,2};
        PrefixSum.findDifference(nums1, nums2);

        int[] arr = {1,2,2,1,1,3};
        HashMapSet.uniqueOccurrences(arr);
        char[] input ={'a','b','c'};
        ArrayString.compress(input);
        int[][] matrix = new int[][] {
                new int[] {1,2,3,4},
                new int[] {5,1,9,3},
                new int[] {6,5,1,2}
        };
        int[] ar = {-2,0,10,-19,4,6,-8};
        ArrayString.checkIfExist(ar);
        List<Integer> arrayList = Arrays.asList(70, 48, 90);
//        List<Integer> arrayList = Arrays.asList( 66, 37, 46, 56, 49, 65, 62, 21, 7, 70, 13, 71, 93, 26, 18, 84, 96, 65, 92, 69, 97, 47, 6, 18, 17, 47, 28, 71, 70, 24, 46, 58, 71, 21, 30, 44, 78, 31, 45, 65, 16, 3, 22, 54, 51, 68, 19, 86, 44, 99, 53, 24, 40, 92, 38, 81, 4, 96, 1, 13, 45, 76, 77, 8, 88, 50, 89, 38, 60, 61, 49, 25, 10, 80, 49, 63, 95, 74, 29, 27, 52, 27, 40, 66, 38, 22, 85, 22, 91, 98, 19, 20, 78, 77, 48, 63, 27);
        ArrayString.diffPossible(arrayList,70);
        ArrayString.isValid("([])");
        StringBuilder sb = new StringBuilder();
        sb.append(1215);
        System.out.println(sb.reverse().equals(String.valueOf(121)));

    }
}