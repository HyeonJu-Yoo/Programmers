import java.util.*;

class Solution42586 {
    Stack<Integer> stack = new Stack();

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        // 93 -> 7(1*7)
        // 30 -> 70(30*3)
        // 55 -> 45(5*9)

        // 1. 각 작업을 100에서 빼서 남은 작업과 작업 날짜를 구한다.(days)
        // 2. days를 idx 순으로 해서 자기보다 작은 값 -> cnt+=1
        // 3. 큰 값이 나타나면 cnt를 array에 추가하고, cnt = 0으로 만들어준다.
        // array 끝인지도 확인이 필요함.
        int q = 0, r = 0, max = 100;
        int cnt = 0, current = 0;

        for (int i = 0; i < progresses.length; i++) {
            q = (100 - progresses[i]) / speeds[i];
            r = (100 - progresses[i]) % speeds[i];
            current = r != 0 ? q + 1 : q;
            // 처음일때(current 선언)
            if (i == 0) {
                max = current;
            }

            // 반복구문
            if (max >= current) {
                cnt += 1;
            } else {
                stack.add(cnt);
                cnt = 1;
                max = current;
            }

            // 마지막일때
            if (i == progresses.length - 1) {
                stack.add(cnt);
            }
        }
        answer = stack.stream().mapToInt(e -> e).toArray();
        return answer;
    }
}