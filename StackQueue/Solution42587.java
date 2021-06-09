import java.util.*;

class Solution42587 {
    Queue<Integer> q = new LinkedList<>();

    public int solution(int[] priorities, int location) {
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            q.add(i);
        }

        while (!q.isEmpty()) {
            boolean changed = true;
            int key = q.poll();

            for (Integer temp : q) {
                if (priorities[temp] > priorities[key]) {
                    q.add(key);
                    changed = false;
                    break;
                }
            }
            System.out.println(q);
            if (changed) {
                answer += 1;
                if (key == location) {
                    return answer;
                }
            }
        }

        return answer;
    }
}