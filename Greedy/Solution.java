
// import java.util.*;

// class Solution {

//     public String solution(String number, int k) {
//         String answer = number;
//         char[] arr = new char[number.length()];
//         for (int i = 0; i < number.length(); i++) {
//             arr[i] = number.charAt(i);
//         }
//         Arrays.sort(arr);

//         int len = 0;
//         for (int i = 0; i < k; i++) {
//             len = answer.length();
//             System.out.println("before : " + answer);
//             for (int j = 0; j < len; j++) {
//                 if (answer.charAt(j) == arr[i]) {
//                     System.out.println(arr[i]);
//                     answer = answer.substring(0, j) + answer.substring(j + 1, answer.length());
//                     System.out.println(answer);
//                     // j = 0;
//                     break;
//                 }
//             }
//         }

//         return answer;
//     }
// }

// import java.util.*;

// class Solution {

//     public String solution(String number, int k) {
//         String answer = "";

//         List<String> list = new ArrayList<>();
//         String temp = number;
//         for (int i = 0; i < k; i++) {
//             list.clear();
//             for (int j = 0; j < temp.length(); j++) {
//                 list.add(temp.substring(0, j) + temp.substring(j + 1, temp.length()));
//             }
//             list.sort(Comparator.reverseOrder());
//             temp = list.get(0);
//         }

//         answer = temp;
//         return answer;
//     }
// }

import java.util.*;

class Solution {

    public String solution(String number, int k) {
        String answer = number;

        String temp = number;
        String cur = "";
        for (int i = 0; i < k; i++) {
            temp = answer.substring(1, answer.length());
            for (int j = 1; j < answer.length(); j++) {
                cur = answer.substring(0, j) + answer.substring(j + 1, answer.length());
                if (temp.compareTo(cur) < 0) {
                    temp = cur.toString();
                }
            }
            answer = temp;
        }

        return answer;
    }
}
