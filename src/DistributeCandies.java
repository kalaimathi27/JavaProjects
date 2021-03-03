import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Map.Entry;

public class DistributeCandies{
    public int distributeCandies(int[] candyType) {
        int max = 0;
        int possibleCandies = candyType.length/2;
        List<Integer> candyList = Arrays.stream(candyType).boxed().collect(Collectors.toList());
        Set<Entry<Integer, Long>> candySet = candyList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet();
        int availableCandies = candySet.size();
        max = availableCandies > possibleCandies ? possibleCandies : availableCandies;
        return max;
    }
}
