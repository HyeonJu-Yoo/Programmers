import java.util.*;

class Solution64061 {

    Stack<Integer> bucket = new Stack();// new LinkedList<>();

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        // moves 순서대로 담아서 같으면 없앤다.
        // 없애면 cnt+=1;
        for (int m : moves) {
            // m번째 열 값.
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < board.length; j++) {
                // 가장 위에 있는 값을 식별한다.
                if (board[j][m - 1] == 0)
                    continue;
                row.add(board[j][m - 1]);
            }

            if (row.size() == 0)
                continue;
            // 앞에있는 값과 같은지 확인
            board[board.length - row.size()][m - 1] = 0;
            if (bucket.isEmpty()) {
                bucket.add(row.get(0));
            } else {
                int temp = bucket.peek();
                if (temp == row.get(0)) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.add(row.get(0));
                }
            }

        }
        return answer;
    }
}