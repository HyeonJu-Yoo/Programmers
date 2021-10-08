public class Problem4 {
    
}
import java.util.*;
class Solution {
    List<Integer> list = new ArrayList<>();
    public int[] solution(int n) {
        int[] answer = new int[n];
        for(int i = 0;i<n;i++){
            // answer[i] = i+1;
            list.add(i+1);
        }
        answer = binarySplit(list,0,n);
        
        return answer;
    }
    public void binarySplit(List<Integer> list, int sIdx, int eIdx){
        int mIdx = eIdx + sIdx/2;//list.size()%2;
            
        if(mIdx == 1){
            return arr;
        }
        int[] temp = arr.clone();//new int[arr.length]
        arr = binarySplit(arr, sIdx, mIdx);
        for(int i = sIdx;i<eIdx/2;i++){
            if(i%2 == 0){
                arr[sIdx+i/2] = temp[i];
            }else{
                arr[mIdx+i/2] = temp[i];   
            }
        }
        arr = binarySplit(arr,mIdx,eIdx);
        return arr;
    }
}