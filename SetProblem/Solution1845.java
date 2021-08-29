import java.util.*;
import java.lang.Math;

class Solution1845 {
    HashSet<Integer> set = new HashSet();

    public int solution(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        answer = Math.min(set.size(), nums.length / 2);
        return answer;
    }
}
/*
 * 
 * class Solution { public int[] solution(int[] prices) { int[] answer = new
 * int[prices.length];
 * 
 * for(int i = 0;i<prices.length;i++){ int count = 0; for(int j =
 * i+1;j<prices.length;j++){ count++; if(prices[i]>prices[j]){ break; } }
 * answer[i] = count; } return answer; } }
 */