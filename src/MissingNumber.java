import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MissingNumber {

    public static int missingNumber(int[] nums) {
        if(nums.length == 0)
            return 1;
        List<Integer> l = Arrays.stream(nums).boxed().collect(Collectors.toList());
        if(l.isEmpty())
            return 1;

        int min = Collections.min(l);
        int max = Collections.max(l);

        if(min == 0 && l.size() == 1){
            return 1;
        }
        if(min > 0){
            return 0;
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
        int[] x = {3,0,1};
        int res = missingNumber(x);
        System.out.println(res);
    }

}
