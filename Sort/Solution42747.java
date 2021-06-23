import java.util.*;

class Solution42747 {
    public int solution(int[] citations) {
        int answer = 0;

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < citations.length; i++) {
            arr.add(citations[i]);
        }
        Collections.sort(arr, Collections.reverseOrder());
        for (Integer num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 총 논문 개수
        for (int i = citations.length; i >= 0; i--) {
            for (int j = 0; j < citations.length; j++) {
                // 정렬된 마지막 값이 기준보다 클 때
                if (i < arr.get(j)) {
                    // 마지막 index
                    if (j == citations.length - 1) {
                        return i;
                    }
                    // 기준과 같음.
                } else if (i == arr.get(j)) {
                    // index 와 i
                    if (j >= i) {
                        System.out.println("j : " + j);
                        System.out.println("answer : " + i);
                        return answer = i;
                    } else {
                        continue;
                    }
                } else {
                    // 기준보다 작음.
                    if (j >= i) {
                        System.out.println("j : " + j);
                        System.out.println("answer : " + i);
                        return answer = i;
                    } else {
                        break;
                    }
                }
            }
        }

        return answer;
    }
}