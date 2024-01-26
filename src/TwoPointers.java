public class TwoPointers {


    /**
     * / A subsequence of a string is a new string that is formed from the original string by deleting some
     * (can be none) of the characters without disturbing the relative positions of the remaining characters.
     * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
     * @param s String subsequence
     * @param t String original
     * @return true if s is a subsequence of t
     */
    public static boolean isSubsequence(String s, String t) {
        int previousIndex = 0;
        boolean result = false;
        int character = 0;
        for (int i = 0; i <s.length() ; i++) {
            int index = t.indexOf(String.valueOf(s.charAt(i)), previousIndex);
            if(index >= previousIndex){
                previousIndex = index + 1;
                character++;
            }
        }
        if(character == s.length()){
            result = true;
        }

        return result;
    }

    public static int[] moveZeroes(int[] nums) {
        int index =0;
        for(int i=0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }
        for(int j=index; j < nums.length; j++){
            nums[j] = 0;
        }
        return nums;
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        if(prices.length >=2 && prices.length <= Math.pow(10,5)) {
            for(int i = 1; i < prices.length; i++ ){
                int profit = prices[i] - minPrice;
                if(prices[i] < minPrice){
                    minPrice = prices[i];
                } else if( profit > maxProfit){
                    maxProfit = profit;
                }

            }
        }
        return maxProfit;
    }
    public int maxProfit1(int[] prices) {
    int min_price = prices[0];
    int maxprof = 0;

        for(int i=1; i<prices.length; i++){
        maxprof = Math.max(maxprof, prices[i]-min_price);
        min_price = Math.min(prices[i],min_price);
    }

        return maxprof;
    }

    public static int maxProfit2(int[] prices) {
        int profit = 0;
        int minValue = prices[0];
        int gains = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < minValue){
                minValue = prices[i];
            } else if((prices[i]- minValue) > 0) {
                profit = Math.max(profit, (prices[i]- minValue));
                minValue = prices[i];
                gains += profit;
            }

        }
        return gains;
    }
}
