import java.util.Arrays;

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

    }
}