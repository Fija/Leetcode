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
    String convert(String s, int nRows) {
        ArrayList<ArrayList<Character>> zigzag = 
            new ArrayList<ArrayList<Character>>();
        String str = "";
        if(s == null || s.length() == 0 || nRows == 0) return str;
        if(nRows == 1) return s;
        int i, j, line, mod;
        for(i = 0; i < nRows; i++) {
            zigzag.add(new ArrayList<Character>());
        }
        for(i = 0; i < s.length(); i++) {
            mod = i % (2*(nRows-1));
            line = Math.min(mod,2*(nRows-1)-mod);
            zigzag.get(line).add(s.charAt(i));
        }
        for(i = 0; i < nRows; i++) {
            for(j = 0; j < zigzag.get(i).size(); j++) {
                str = str + zigzag.get(i).get(j);
            }
        }
        return str;
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

public class Convert {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {"PAYPALISHIRING"};
        int[][] B = {{0,1,2,3,4}};



        for(int i = 0; i < A.length ; i++) {
            for(int j = 0; j < B[i].length; j++) {
            System.out.println(sol.convert(A[i],B[i][j]));
            }
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
