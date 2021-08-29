class Solution12899 {
    public String solution(int n) {
        String answer = "";
        int[] num = { 4, 1, 2 };
        int val = n;
        StringBuffer str = new StringBuffer();
        while (val != 0) {
            str.insert(0, num[val % 3]);
            if (val % 3 == 0) {
                val = val - 3;
            }
            val = val / 3;
        }
        answer = str.toString();
        return answer;
    }
}