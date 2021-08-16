import java.util.*;
import java.util.stream.*;

class Solution42746 {
    public String solution(int[] numbers) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        for(int i : numbers){
            list.add(i);
        }
         Collections.sort(list, (a,b)->{
             String va = Integer.toString(a);
             String vb = Integer.toString(b);
             return -Integer.compare(Integer.parseInt(va+vb),Integer.parseInt(vb+va));
        });
        if(list.get(0) == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(Integer i : list){
            sb.append(i);
        }
        answer = sb.toString();                      
        return answer;
    }
}