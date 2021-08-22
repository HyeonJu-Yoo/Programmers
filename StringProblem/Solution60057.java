import java.util.*;
import java.lang.Math;

class Solution60057 {
    Stack<String> stack = new Stack<>();

    public int solution(String s) {
        int answer = s.length();
        String sub = "";
        for (int i = 1; i <= s.length(); i++) {
            String cur = s;
            int cnt = 1;
            StringBuffer sb = new StringBuffer();
            stack.clear();

            while (!cur.equals("")) {
                // 문자열 자르기
                if (cur.length() < i) {
                    sub = cur.substring(0, cur.length());
                } else {
                    sub = cur.substring(0, i);
                }
                cur = cur.substring(sub.length(), cur.length());
                // 기존 값과 비교
                if (!stack.isEmpty()) {
                    String temp = stack.peek();
                    // 문자열 같으면 +1
                    if (temp.equals(sub)) {
                        cnt += 1;
                    } else {
                        if (cnt != 1)
                            sb.append(cnt);
                        sb.append(temp);
                        stack.add(sub);
                        cnt = 1;
                    }
                } else {
                    stack.add(sub);
                }
            }
            if (cnt != 1)
                sb.append(cnt);
            sb.append(sub);
            answer = Math.min(sb.length(), answer);
        }
        return answer;
    }

}