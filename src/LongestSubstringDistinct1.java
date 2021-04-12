import java.util.*;

public class LongestSubstringDistinct1 {
    public int lengthOfLongestSubstringKDistinct(String s, int k){
        int len = 0;
        Map<Character, Integer> distMap = new HashMap<Character, Integer>();
        int window = 0;
        for(int i = 0;i < s.length(); i++){
            char c = s.charAt(i);
            if(distMap.containsKey(c)){
                distMap.put(c, distMap.get(c)+1);
            }
            else{
                distMap.put(c, 1);
            }

            while(distMap.size() > k){
                char c1 = s.charAt(window++);
                distMap.put(c1, distMap.get(c1)-1);
                if(distMap.get(c1) == 0){
                    distMap.remove(c1);
                }
            }
            len = Math.max(len, i - window + 1);
        }
        return len;
    }

    public static void main(String[] args){
        LongestSubstringDistinct1 l = new LongestSubstringDistinct1();
        int x = l.lengthOfLongestSubstringKDistinct("eceba", 2);
        System.out.println(x);
    }
}
