import java.util.*;

class Solution42578 {
    Map<String, Integer> map = new HashMap();

    public int solution(String[][] clothes) {
        int answer = 1;

        for (int i = 0; i < clothes.length; i++) {
            if (map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            } else {
                map.put(clothes[i][1], 1);
            }
        }
        // 여사건 적용
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(answer);
            answer *= (map.get(key) + 1);
        }
        answer -= 1;

        System.out.println(answer);
        return answer;
    }
}