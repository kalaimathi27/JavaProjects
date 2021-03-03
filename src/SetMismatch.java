import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] arr = {};
        int repeatedNum = 0;
        int lostNum = 0;
        List<Integer> num = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(num);
        for(int i = 0;i < num.size(); i++){
            if(!num.contains(i+1)){
                lostNum = i+1;
            }
            if(i != num.size() -1 && (num.get(i+1).equals(num.get(i)))) {
                repeatedNum = num.get(i + 1);
            }
            else if(i == num.size() -1 && (num.get(i-1).equals(num.get(i)))){
                repeatedNum = num.get(i);
            }

            if((repeatedNum != 0) && (lostNum != 0)){
                arr = new int[]{repeatedNum, lostNum};
                break;
            }
        }
        return arr;
    }
}
