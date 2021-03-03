import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ScoreOfParantheses {
    public int scoreOfParentheses(String S) {
        int score = 0;
        Stack st = new Stack();
        for(int i = 0;i < S.length();i++){
            char c = S.charAt(i);
            switch (c){
                case '(':{
                    st.push(0);
                    break;
                }
                case ')':{
                    List<Integer> x = new ArrayList<>();
                    int top = 0;
                    if(!st.isEmpty()) {
                        top = (int) st.pop();
                        if(top == 0){
                            st.push(1);
                        }
                        else{
                            while (!st.isEmpty()) {
                                int n = (int) st.pop();
                                if (n != 0) {
                                    top = top + n;
                                } else {
                                    top = top * 2;
                                    st.push(top);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }

                default:{
                    break;
                }
            }
        }
        score = (int) st.pop();
        while(!st.isEmpty() && st.size() >= 1){
            score += (int) st.pop();
        }
        return score;
    }
}
