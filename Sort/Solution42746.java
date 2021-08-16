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
        if(answerList.get(0) == 0){
            return "0";
        }
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
        int val1 = Integer.parseInt(Integer.toString(v1) + Integer.toString(v2));
        int val2 = Integer.parseInt(Integer.toString(v2) + Integer.toString(v1));
        if(val1 >= val2){
            return true;
        } else{
            return false;
        }
    }

}