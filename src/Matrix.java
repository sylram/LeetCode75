import java.util.Arrays;

public class Matrix {

    static boolean isToeplitz (int[][] arr) {
        // your code goes here
        boolean result = true;
        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            while ((j + 1 < arr[i].length) && (i + 1 < arr.length) && result) {
                if (arr[i][j] != arr[i + 1][j + 1]) {
                    result = false;
                    break;
                }
                j++;
            }

        }
        return result;
    }
    static boolean isToeplitz2(int[][] arr) {
        int rowLen = arr.length, colLen = arr[0].length;
        int[] map = new int[colLen+rowLen+1];
        Arrays.fill(map,-1);
        for(int i =0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                if(map[i-j+colLen]==-1){
                    map[i-j+colLen]=arr[i][j];
                }else if(map[i-j+colLen]!=-1 && map[i-j+colLen]!=arr[i][j])return false;
            }
        }
        return false;
    }
}


