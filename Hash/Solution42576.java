import java.util.*;

class Solution {
    public String solution42576(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            if (map.containsKey(p)) {
                map.replace(p, map.get(p), map.get(p) + 1);
            } else {
                map.put(p, 1);
            }
        }

        for (String c : completion) {
            if (map.containsKey(c)) {
                map.replace(c, map.get(c), map.get(c) - 1);
            }
        }

        String answer = "";
        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                answer = s;
                break;
            }
        }
        return answer;
    }
}