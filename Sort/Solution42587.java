import java.util.*;

class Solution42587 {

    static Queue<Integer> q = new LinkedList<>();

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        for (int i : priorities) {
            q.add(i);
        }

        while (!q.isEmpty()) {
            int max = getMaxValue();
            int temp = q.poll();

            answer += 1;

            if (location == 0) {
                if (temp == max) {
                    return answer;
                } else {
                    // 그게 아니면 뒤로 간다.
                    q.add(temp);
                }
            } else {
                // location값은 아니지만
                // 가장 큰 값이면, q에서 빼고 끝.
                if (temp == max) {
                    continue;
                } else {
                    // 맨 뒤로 보낸다.
                    q.add(temp);
                }
            }

            System.out.println(q);
            location = location <= 0 ? q.size() - 1 : (location - 1);
        }

        return answer;
    }

    public static int getMaxValue() {
        int max = 0;
        for (Integer i : q) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] priorities = { 2, 1, 2, 1, 2 };
        int location = 4;
        solution(priorities, location);
        // [2, 1, 3, 2] 2 1
    }
}