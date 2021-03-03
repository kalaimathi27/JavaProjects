import java.util.ArrayList;
import java.util.List;

class ArithmeticSlices {
    public static int numberOfArithmeticSlices(int[] A) {
        int times = 0;
        int diff = 0;
        for(int i=0;i < A.length;i++){
            List<Integer> sliceList = new ArrayList<Integer>();
            for(int j = i;j < A.length-1; j++){
                int temp = A[j+1] - A[j];
                if(j == 0 || diff == temp){
                    diff = temp;
                    sliceList.add(A[j]);
                    if(j+1 == A.length-1){
                        sliceList.add(A[j+1]);
                    }
                }
                else if((diff != temp && sliceList.size() >= 3) || (j+1 == A.length-1)){
                    times = times + 1;
                    diff = temp;
                }


            }
            System.out.println("size : " + sliceList.size());
            for(int k = 0; k < sliceList.size(); k++){
                System.out.print(sliceList.get(k));
            }
            System.out.println();
        }
        return times;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        int times = numberOfArithmeticSlices(arr);
        System.out.println(times);
    }
}