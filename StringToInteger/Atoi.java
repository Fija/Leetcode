import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x){val = x;}
}

class Solution {
    int atoi(String str) {
        if(str == null) return 0;
        String s = str.trim();
        int len = s.length();
        if(len == 0) return 0;
        char c = s.charAt(0);
        int sign = 0;
        if(c == '+') {
            sign = 1;
        }else if(c == '-') {
            sign = -1;
        }
        int start = (sign == 0? 0 : 1);
        int sum = 0;
        final int MIN_VALUE = Integer.MIN_VALUE;
        final int MAX_VALUE = Integer.MAX_VALUE;
        for(int i = start; i < len; i++ ) {
            c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                if(MIN_VALUE / 10 > sum ||
                        MIN_VALUE / 10 == sum && sum*10-MIN_VALUE <= c-'0') {
                    if(sign == -1) {
                        return MIN_VALUE;
                    }else {
                        return MAX_VALUE;
                    }
                }else {
                    sum = sum * 10 - (c-'0');
                }
            }else {
                return sign == -1? sum : -sum;
            }
        }
        return sign == -1? sum : -sum;
    }
                    

            




//        System.out.print();

//        System.out.println();

    void printAL2(ArrayList<ArrayList<Integer>> A) {
        if(A == null) return;
        for(int i =0; i < A.size(); i++ ) {
            for(int j= 0; j < A.get(i).size(); j++ ) {
                System.out.print(A.get(i).get(j)+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void printAL(ArrayList<Integer> A) {
        if(A == null) return;
        for(int i = 0; i < A.size(); i++) {
                System.out.print(A.get(i)+" ");
            }
        System.out.println();
    }

    void printAr(int[] A) {
        if(A == null) return;
        for(int i = 0; i < A.length; i++) {
                System.out.print(A[i]+" ");
            }
        System.out.println();
    }

    void printLN(ListNode head) {
        while(head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }

    ListNode genList(int[] A) {
        if(A == null) return null;
        ListNode head = new ListNode(0), node = head;
        for(int i = 0 ; i < A.length; i++) {
            node.next = new ListNode(A[i]);
            node = node.next;
        }
        return head.next;
    }

    TreeNode growTree(int[] A) {
        if(A == null || A.length == 0) return null;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(A[0]), node = root;
        queue.offer(node);
        for(int i = 1; i < A.length; i++ ) {
            node = queue.poll();
            if(A[i] != -1) {
                node.left = new TreeNode(A[i]);
                queue.offer(node.left);
            }
            i += 1;
            if(i == A.length) break;
            if(A[i] != -1) {
                node.right = new TreeNode(A[i]);
                queue.offer(node.right);
            }
        }
        return root;
    }
    void printTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(true) {
            try {
                root = queue.pop();
            }catch(Exception ex) {
                break;
            }
            if(root == null) {
                System.out.print("# ");
            }else {
                System.out.print(root.val+" ");
                queue.offer(root.left);
                queue.offer(root.right);
            }
        }
        System.out.println();
    }
}

public class Atoi {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {"","+","+-12","+12ab12","12a","2-1","23333333333",
                      "-23333333333","-0","+0","000","+0001",
                      "-2147483648","+2147483647","2147483648","+2147483648",
                      "-2147483649"};
        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.atoi(A[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
