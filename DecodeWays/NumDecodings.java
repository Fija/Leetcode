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
    int numDecodings(String s) {
        int len = s.length();
        if(len == 0) return 0;
        int[] dp = new int[len];
        if(s.charAt(0) == '0') {
            return 0;
        }else {
            dp[0] = 1;
        }
        if(len == 1) {
            return 1;
        }
        int num = Integer.parseInt(s.substring(0,2));
        if(num > 26) {
            if(s.charAt(1) == '0') {
                return 0;
            }else {
                dp[1] = 1;
            }
        }else {
            if(num == 20 || num == 10) {
                dp[1] = 1;
            }else {
                dp[1] = 2;
            }
        }
        for(int i = 2; i < len; i++ ) {
            num = Integer.parseInt(s.substring(i-1,i+1));
            if(num % 10 == 0) {
                if(num == 20 || num == 10) {
                    dp[i] = dp[i-2];
                }else {
                    return 0;
                }
            }else if(num > 26 || num < 10) {
                dp[i] = dp[i-1];
            }else {
                dp[i] = dp[i-2] + dp[i-1];
            }
        }
        return dp[len-1];
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

public class NumDecodings {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {"111","200",
                      "0","20","09","2307","1","27","12","2222","2202"};
        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.numDecodings(A[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
