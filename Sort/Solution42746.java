import java.util.*;

class Solution42746 {

    class Node {
        private int num;
        private Node left;
        private Node right;

        Node(int num) {
            this.num = num;
            this.left = null;
            this.right = null;
        }

        Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }
    }

    Node root = null;
    List<Integer> answerList = new ArrayList<>();

    public String solution(int[] numbers) {

        String answer = "";

        for (int i : numbers) {

            if (root == null) {
                root = new Node(i);
                continue;
            }

            Node cur = root;
            while (true) {
                // 숫자i가 크면 왼쪽
                // 작으면 오른쪽
                boolean flag = isBigger(i, cur.num);
                if (flag) {
                    if (cur.left == null) {
                        cur.left = new Node(i);
                        break;
                    }
                    cur = cur.left;
                    // 왼쪽 비어있으면 추가
                    // 아니면 더 내려감.
                } else {
                    if (cur.right == null) {
                        cur.right = new Node(i);
                        break;
                    }
                    cur = cur.right;
                }
            }
        }

        // 트리 순회
        // answer = inorderTraverse(root, answer);
        inorderTraverse(root, answer);
        for (Integer i : answerList) {
            answer += Integer.toString(i);
        }

        return answer;
    }

    public void inorderTraverse(Node n, String answer) {
        if (n != null) {
            // answer += Integer.toString(n.num);
            inorderTraverse(n.left, answer);
            if (!answerList.isEmpty() && answerList.get(0) == 0) {
                return;
            }

            answerList.add(n.num);
            // System.out.println("num : " + n.num);
            // answer = answer + Integer.toString(n.num);
            // System.out.println(answer);

            inorderTraverse(n.right, answer);
            // return answer;
        }
        // return answer;
    }

    public boolean isBigger(int v1, int v2) {
        while (true) {
            int[] res1 = getFirstNum(v1);
            int[] res2 = getFirstNum(v2);
            if (res1[0] > res2[0]) {
                return true;
            } else if (res1[0] == res2[0]) {
                // i가 한자리수 일 때
                // 둘다 한자리수
                if (res1[1] == 1 && res2[1] == 1) {
                    return true;
                    // res1만 한자리수
                } else if (res1[1] == 1 && res2[1] != 1) {
                    v2 = v2 - res2[0] * res2[1];
                    // res2만 한자리수
                } else if (res1[1] != 1 && res2[1] == 1) {
                    v1 = v1 - res1[0] * res1[1];
                } else {
                    v1 = v1 - res1[0] * res1[1];
                    v2 = v2 - res2[0] * res2[1];
                }
            } else {
                return false;
            }

        }
    }

    public int[] getFirstNum(int i) {
        int[] res = new int[2]; // {앞자리수, 자리수*10}
        int cnt = 1;

        while (true) {
            if (i >= 0 && i < 10) {
                res[0] = i;
                res[1] = cnt;
                return res;
            }
            i /= 10;
            cnt *= 10;
        }
    }

}