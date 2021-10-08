import java.util.*;

class Solution43162 {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        int parent[] = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    // 그들의 부모를 찾아서 부모를 통일시킨다.
                    connect(i, j, parent);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(parent[i]);
        }
        answer = set.size();
        return answer;
    }

    public void connect(int x, int y, int[] parent) {
        if (parent[x] == parent[y]) {
            return;
        }
        int min = Math.min(parent[x], parent[y]);
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == parent[x] || parent[i] == parent[y]) {
                parent[i] = min;
            }
        }
    }
}