/*
Given an unsorted integer array nums, find the smallest missing positive integer.



Example 1:

Input: nums = [1,2,0]
Output: 3
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1


Constraints:

0 <= nums.length <= 300
-231 <= nums[i] <= 231 - 1


Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space?

 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        if(nums.length == 0)
            return 1;
        List<Integer> l = Arrays.stream(nums).boxed().collect(Collectors.toList());

        for(int i = 0;i < l.size();){
            if(l.get(i) <= 0){
                l.remove(i);
                continue;
            }
            i++;
        }

        if(l.isEmpty())
            return 1;

        int min = Collections.min(l);
        int max = Collections.max(l);

        if(min > 1 ) {
            return 1;
        }

        Collections.sort(l);
        for(int i = min; i < max; i++){
            if(!l.contains(i)){
                return i;
            }
        }

        return max+1;
    }

    public static void main(String[] args){
        int[] x = {-1,-2};
        int res = firstMissingPositive(x);
        System.out.println(res);
    }
}
