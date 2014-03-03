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
    boolean isMatch(String s, String p) {
        return recurSolve(s, p, 0, 0);
    }
    boolean recurSolve(String s, String p, int i, int j) {
        if(i == s.length()) {
            if(j == p.length()) {
                return true;
            }else if(j < p.length()-1 && p.charAt(j+1) == '*') {
                return recurSolve(s, p, i, j+2);
            }else return false;
        }else {
            if(j == p.length()) {
                return false;
            }else if(j < p.length()-1 && p.charAt(j+1) == '*') {
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                    if(recurSolve(s, p, i+1, j)) return true;
                    else return recurSolve(s, p, i, j+2);
                }else return recurSolve(s, p, i, j+2);
            }else if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                return recurSolve(s, p, i+1, j+1);
            }else return false;
        }
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

public class IsMatch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {"baccbbcbcacacbbc","","aa","aaa","ab","aab"};
        String[][] B = {{"c*.*b*c*ba*b*b*.a*"},
                        {".*a","","a","a*",".",".*","..","*","a*.*a*","a*.*."},
                        {".*a","","a","aa","a*",".*"},{".*a","","aa"},
                        {".*a","",".*"},{".*a","","c*a*b"}};

        for(int i = 0; i < A.length ; i++) {
            for(int j = 0; j < B[i].length; j++) {
                System.out.println(A[i]+" "+B[i][j]);
                System.out.println(sol.isMatch(A[i],B[i][j]));
            }
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
