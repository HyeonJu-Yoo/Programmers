
import java.util.*;
import java.lang.Math;

public class Solution60057 {
    public static int solution(String s) {
        // 1.문자 길이 만큼 잘라서 압축해보고 가장 짧은 것을 기억한다.
        // 2.처음 글자가 시작되는 위치를 먼저 확인해봄.
        // -> 근데 처음글자만 짧을수도 있음.
        int answer = 0;
        int l = s.length();
        int min = l, cnt = 0;
        String sub = "";
        // version 1
        // 길이만큼.
        for (int i = 1; i <= l; i++) {
            StringBuffer sb = new StringBuffer(); // 압축 결과
            String cur = s;
            cnt = 0;
            while (!cur.equals("")) {
                // 문자열을 잘라서 비교
                if (cur.length() < i) {
                    sub = cur.substring(0, cur.length());
                } else {
                    sub = cur.substring(0, i);
                }
                // cur = cur.substring(sub.length(), cur.length());
                while (!cur.equals("")) {
                    System.out.println("sub : " + sub);
                    System.out.println("cur : " + cur);

                    // sub와 같으면 cnt+=1;
                    if (cur.substring(0, sub.length()).equals(sub)) {
                        cur = cur.substring(sub.length(), cur.length());
                        cnt += 1;
                        if (cur.equals("")) {
                            if (cnt != 1)
                                sb.append(cnt);
                            sb.append(sub);
                            System.out.println("sb : " + sb);
                        }
                    } else {
                        // 다르면 break;
                        if (cnt != 1)
                            sb.append(cnt);
                        sb.append(sub);
                        cnt = 0;
                        System.out.println("sb : " + sb);
                        break;
                    }

                }
            }
            min = Math.min(sb.length(), min);
        }

        return answer;
    }

    public static void main(String[] args) {

        Solution60057.solution("aabbaccc");
    }
}

// 2a2ba3c
