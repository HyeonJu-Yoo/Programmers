import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        for(int i : numbers){
            list.add(i);
        }
         Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer s1, Integer s2) {
                int val1 = Integer.parseInt(Integer.toString(s1) + Integer.toString(s2));
                int val2 = Integer.parseInt(Integer.toString(s2) + Integer.toString(s1));
                int diff = val1 - val2;
                System.out.println(s1 + " " + s2 + " ");
                System.out.println(val1 + " " + val2 + " " + "diff : " + diff);
                if(diff >= 0){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        System.out.println("sort result : ");
        for(Integer i : numbers){
            System.out.print(i + " ");
        }
         System.out.println("-- sort result : ");
        for(Integer i : numbers){
            // System.out.print(i + " ");
            answer += Integer.toString(i);
            System.out.println("answer : " + answer);
        }
        //if()
        //answer = Long.toString(Long.parseLong(answer));
        return answer;
    }
}