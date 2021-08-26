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