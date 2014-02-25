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
    String addBinary(String a, String b) {
        int i, sum, add=0, len_a = a.length(), len_b = b.length();
        String c = "";
        for(i = 0; ;i++) {
            if(i < len_a && i < len_b) {
                sum = Character.getNumericValue(a.charAt(len_a-1-i)) +
                      Character.getNumericValue(b.charAt(len_b-1-i)) +
                      add;
            }else if(i < len_a ) {
                sum = Character.getNumericValue(a.charAt(len_a-1-i)) + add;
            }else if(i < len_b ) {
                sum = Character.getNumericValue(b.charAt(len_b-1-i)) + add;
            }else {
                if(add == 1) c = add+c;
                break;
            }
            if(sum == 2) {
                c = "0"+c;
                add = 1;
            }else if(sum == 3) {
                c = "1"+c;
                add = 1;
            }else {
                c = sum + c;
                add = 0;
            }
        }
        return c; 
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

public class AddBinary {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {"","1","0","1","111","11"};
        String[] B = {"","","0","1","1111","1"};



        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.addBinary(A[i],B[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
