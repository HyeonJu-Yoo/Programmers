import java.util.*;
import java.util.stream.*;

class Solution83201 {
    public String solution(int[][] scores) {
        String answer = "";
        
        int myself = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0;i<scores.length;i++){
            list.clear();
            for(int j = 0;j<scores.length;j++){
                myself = scores[i][i];
                list.add(scores[j][i]);
            }
            Collections.sort(list);
            if(myself == list.get(0) || myself == list.get(list.size() -1)){
                int idx = myself==list.get(0) ? 0:list.size()-1;
                int cnt = 0;
                for(Integer num : list){
                    cnt = num == myself ? cnt+=1:cnt;
                }
                if(cnt == 1) list.remove(idx);
                // long cnt = list.stream().filter(e -> e.equals(myself)).count();
                // if(cnt != 1)list.remove(i);
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