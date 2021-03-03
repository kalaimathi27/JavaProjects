import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayFormation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        boolean canFormArray = false;
        int arrLength = arr.length;
        int trackLength = 0;
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        String arrString = arrList.stream().map(String::valueOf).collect(Collectors.joining(","));
        arrString = ",".concat(arrString);

        for(int i = 0; i < pieces.length;i++){
            trackLength += pieces[i].length;
            if(trackLength > arrLength){
                return false;
            }
            if(pieces[i].length > 1){
                List<Integer> piecesList = Arrays.stream(pieces[i]).boxed().collect(Collectors.toList());
                String pieceStr = piecesList.stream().map(String::valueOf).collect(Collectors.joining(","));
                if(i != 0){
                    pieceStr = ",".concat(pieceStr);
                }
                if(arrString.contains(pieceStr)){
                    canFormArray = true;
                    System.out.println(canFormArray + " " + pieceStr);
                }
                else{
                    return false;
                }
            }
            else
            {
                for(int j = 0;j<pieces[i].length;j++){
                    if(arrList.contains(pieces[i][j])){
                        canFormArray = true;
                    }
                    else
                        return false;
                }

            }
        }
        return canFormArray;
    }
}
