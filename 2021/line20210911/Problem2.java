public class Problem2 {
    
}
import java.util.*;
class Solution {
    // Map<Integer,Map<Character,Integer>> map = new HashMap();
    Set<Integer> set = new HashSet<>();
    public String solution(String[] research, int n, int k) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        // issue = 2*n(days)*k(times)
        // 하루마다 검색된 횟수
        // 연속일 횟수
        int[][] keyCnt = new int[research.length][26];
        
        for(int i = 0;i<research.length;i++){
            for(int j = 0;j<research[i].length();j++){
                keyCnt[research[i].charAt() - 'a']+=1;
                set.add(research[i].charAt() - 'a');
                // list.get(research[i].charAt() - 'a');
            }
        }
        int cntSum = 0;
        for(int i : set.keySet()){
            for(int j = 0;j<keyCnt;j++){
                if(keyCnt[j][i] == 0)
                cntSum += keyCnt[j][i];
                // for(int k = 0;k)
            }
            if(cnt)
        }
        
//         for(int i = 0;i<research.length;i++){
//             for(int j = 0;j<research[i].length();j++){
//                 if(map.get(i).containsKey(research[i].charAt(j))){
//                     map.put(i,research[i].charAt(j),map.get(i).get(research[i].charAt(j))+1);
//                     // map.put(i,
//                     //         map.put(research[i].charAt(j), 
//                     //                 map.get(i).get(research[i].charAt(j))+1));
//                 }else{
//                     map.put(i,map.put(research[i].charAt(j), 1));           
//                 }
//             }
            
//         }
//         for(String key:map.keySet()){
//             for(String subKey:map.get(key).keySet()){
//                 System.out.println(key + ":" + subKey + ":" + map.get(key).get(subKey));
//             }
            
//         }
        
        return answer;
    }
}