class Solution43165 {
    static int[] visited;
    static int count;

    public int solution(int[] numbers, int target) {
        int answer = 0;
        visited = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            reset(numbers);
            dfs(i, target);
        }
        answer = count;
        System.out.println("answer : " + answer);
        return answer;
    }

    public void reset(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            visited[i] = numbers[i];
        }
    }

    public void dfs(int x, int target) {
        if (visited[x] < 0)
            return;
        visited[x] = -visited[x];
        if (sum() == target) {
            count += 1;
        }
        for (int i = x + 1; i < visited.length; i++) {
            dfs(i, target);
        }
        visited[x] = -visited[x];
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < visited.length; i++) {
            sum += visited[i];
        }
        return sum;
    }
}