import java.util.*;
import java.util.stream.*;

class Solution83201 {
    public String solution(int[][] scores) {
        String answer = "";
        
        int myself = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0;i<scores.length;i++){
            list.clear();
            int cnt = 0;
            for(int j = 0;j<scores.length;j++){
                myself = scores[i][i];
                if(scores[j][i] == myself){
                     cnt +=1 ;
                }
                list.add(scores[j][i]);
            }
            Collections.sort(list);
            if(myself == list.get(0) || myself == list.get(list.size() -1)){
                int idx = myself==list.get(0) ? 0:list.size()-1;
                if(cnt == 1) list.remove(idx);
            }

            double avg = list.stream().mapToInt(e -> e).average().getAsDouble();
            if(avg >= 90)
                answer += "A";
            else if(avg >= 80)
                answer += "B";
            else if(avg >= 70)
                answer += "C";
            else if(avg >= 50)
                answer += "D";
            else 
                answer += "F";
        }
        
        return answer;
    }
}