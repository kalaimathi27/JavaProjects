import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length];
        int lisLen = 0;
        for(int i = 0; i < nums.length; i++){
            int pos = Arrays.binarySearch(arr, 0, lisLen, nums[i]);
            if(pos < 0){
                pos = -(pos + 1);
            }
            arr[pos] = nums[i];
            if(pos == lisLen){
                lisLen++;
            }
        }
        return lisLen;
    }

    public static void main(String[] args){
        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        int x = l.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        System.out.println("length : " + x);
    }
}
