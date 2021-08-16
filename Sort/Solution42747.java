import java.util.*;

class Solution42747 {
    public int solution(int[] citations) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        
        for(int i :citations)
        {
            list.add(i);
        }
        Collections.sort(list,Collections.reverseOrder());
        
        for(int i=0; i<list.size(); i++){
            int smaller = Math.min(list.get(i), i+1);
            answer = Math.max(answer, smaller);
            
        }
        
        return answer;
    }
}