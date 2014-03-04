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
    boolean isInterleave(String s1, String s2, String s3) {
        int i = 0, j = 0, k = 1, len1, len2, len3;
        if(s1 == null) s1 = ""; len1 = s1.length();
        if(s2 == null) s2 = ""; len2 = s2.length();
        if(s3 == null) s3 = ""; len3 = s3.length();
        if(len1+len2 != len3) return false;
        boolean[][] path = new boolean[len1+1][len2+1];
        path[0][0] = true;
        for(i = 1; i <= len1; i++) {
            path[i][0] = s3.charAt(i-1) == s1.charAt(i-1);
        }
        for(j = 1; j <= len2; j++) {
            path[0][j] = s3.charAt(j-1) == s2.charAt(j-1);
        }
        
        for(i = 1; i <= len1; i++) {
            for(j = 1; j <= len2; j++) {
                path[i][j] = path[i-1][j] && s3.charAt(i+j-1) == s1.charAt(i-1)||
                             path[i][j-1] && s3.charAt(i+j-1) == s2.charAt(j-1); 
            }
        }
        return path[len1][len2];
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

public class IsInterleave {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {"a","","aabcc"};
        String[] B = {"","","dbbca"};
        String[][] C = {{"a","b"},{"","a"},{"aadbbcbcac","aadbbbaccc"}};



        for(int i = 0; i < A.length ; i++) {
            for(int j = 0; j < C[i].length; j++) {
            System.out.println(sol.isInterleave(A[i],B[i],C[i][j]));
            }
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
