import java.util.*;
import java.util.stream.*;
import java.util.Collections;

class Solution42577 {
    Map<String, String> map = new HashMap<>();

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        String v1, v2;
        for (int i = 0; i < phone_book.length; i++) {
            v1 = phone_book[i];
            for (int j = i + 1; j < phone_book.length; j++) {
                v2 = phone_book[j];

                if (v2.charAt(0) > v1.charAt(0)) {
                    break;
                }
                if (v1.length() >= v2.length()) {
                    if (v1.substring(0, v2.length()).equals(v2)) {
                        return false;
                    }
                } else {
                    if (v2.substring(0, v1.length()).equals(v1)) {
                        return false;
                    }
                }

            }
        }
        return answer;
    }
}

119 119543 119564 119119

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Boolean> map = new HashMap<>();
        for (String p : phone_book) {
            map.put(p, false);
        }

        for (String p : phone_book) {
            for (String m : map.keySet()) {
                if (m.equals(p)) {
                    continue;
                }
                String temp, shortString;
                if (p.length() > m.length()) {
                    temp = p.substring(0, m.length());
                    shortString = m;
                } else {
                    temp = m.substring(0, p.length());
                    shortString = p;
                }
                if (shortString.equals(temp)) {
                    answer = false;
                    return answer;
                }
            }
        }

        return answer;
    }
}