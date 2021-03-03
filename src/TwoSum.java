public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = {};
        for(int i = 0;i < nums.length;i++){
            int firstNum = nums[i];
            for(int j = i+1;j < nums.length;j++){
                if((firstNum + nums[j]) == target){
                    arr = new int[]{i, j};
                    break;
                }
            }
        }
        return arr;
    }
}
