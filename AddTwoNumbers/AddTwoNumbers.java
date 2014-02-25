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
    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), node = head;
        String a = "",b = "", c= "";
        while(l1 != null) {
            a = l1.val+a;
            l1 = l1.next;
        }
//        System.out.println(a);
        while(l2 != null) {
            b = l2.val+b;
            l2 = l2.next;
        }
 //       System.out.println(b);
        int i, len_a = a.length(), len_b = b.length(), add =0, sum;
        for( i = 0; ; i++) {
            if(i < len_a && i < len_b) {
                sum = Character.getNumericValue(a.charAt(len_a-1-i)) +
                      Character.getNumericValue(b.charAt(len_b-1-i)) +
                      add;
            }else if(i < len_a) {
                sum = Character.getNumericValue(a.charAt(len_a-1-i)) + add;
            }else if(i < len_b) {
                sum = Character.getNumericValue(b.charAt(len_b-1-i)) + add;
            }else {
                if(add == 1) c = add+c;
                break;
            }
            add = sum/10;
            c = (sum % 10)+c;
        }
  //      System.out.println(c);
        for(i = c.length()-1; i >= 0; i--) {
            node.next = new ListNode(Character.getNumericValue(c.charAt(i)));
            node = node.next;
        }
        return head.next;
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

public class AddTwoNumbers  {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{0},{9,9,9},{2,4,3}};
        int[][] B = {{},{1},{5,6,4}};
        ListNode l1, l2;



        for(int i = 0; i < A.length ; i++) {
            l1 = sol.genList(A[i]);
            l2 = sol.genList(B[i]);
            sol.printLN(sol.addTwoNumbers(l1,l2));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
