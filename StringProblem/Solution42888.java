import java.util.*;

class Solution42888 {
    Map<String, String> map = new HashMap<>();

    public String[] solution(String[] record) {
        for (int i = 0; i < record.length; i++) {
            String[] split = record[i].split(" ");
            if (split[0].equals("Leave")) {
                continue;
            }
            map.put(split[1], split[2]);
        }

        ArrayList<String> arrlist = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String[] split = record[i].split(" ");
            StringBuffer sb = new StringBuffer();
            sb.append(map.get(split[1]));
            switch (split[0]) {
                case "Enter":
                    sb.append("님이 들어왔습니다.");
                    arrlist.add(sb.toString());
                    break;
                case "Leave":
                    sb.append("님이 나갔습니다.");
                    arrlist.add(sb.toString());
                    break;
                case "Change":
                    break;
            }
        }
        String[] answer = arrlist.toArray(new String[arrlist.size()]);

        return answer;
    }
}