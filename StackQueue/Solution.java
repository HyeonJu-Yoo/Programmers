
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        int[] progresses = { 95, 90, 99, 99, 80, 99 };
        int[] speeds = { 1, 1, 1, 1, 1, 1 };

        solution(progresses, speeds);
    }

    public static Stack<Integer> stack = new Stack<Integer>();

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();

        int workLeft = 0;
        int[] days = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            workLeft = 100 - progresses[i];

            days[i] = (workLeft % speeds[i] == 0) ? workLeft / speeds[i] : workLeft / speeds[i] + 1;

            if (i == 0) {
                stack.push(i);
            } else {
                if (stack.isEmpty() || (i != 0 && days[i - 1] > days[i])) {
                    days[i] = days[i - 1];
                    stack.push(i);
                } else {
                    list.add(stack.size());
                    stack.clear();
                    stack.push(i);
                }
            }
        }
        if (!stack.isEmpty()) {
            list.add(stack.size());
        }

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
            System.out.println(answer[i]);
        }

        return answer;
    }

}