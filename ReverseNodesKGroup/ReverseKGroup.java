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
    ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ArrayList<ListNode> A = new ArrayList<ListNode>();
        A.add(new ListNode(0));
        A.get(0).next = head;
        while(true) {
            if(!extendK(A, k)) {
                break;
            }
            reverse(A, k);
        }
        return A.get(1);
    }
    boolean extendK(ArrayList<ListNode> A, int k) {
        int i = 0;
        ListNode node = A.get(A.size()-1).next; 
        while(i < k) {
            if(node == null) return false;
            A.add(node);
            node = node.next;
            i += 1;
        }
        return true;
    }
    void reverse(ArrayList<ListNode> A, int k) {
        ArrayList<ListNode> B = new ArrayList<ListNode>();
        ListNode end, head;
        int len = A.size();
        head = A.get(len-1-k);
        end = A.get(len-1).next;
        for(int i = len-1; i > len-1-k; i--) {
            B.add(A.get(i));
            head.next = A.get(i);
            head = head.next;
        }
        for(int i = 0; i < k; i++) {
            A.set(len-k+i, B.get(i));
        }
        head.next = end;
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

    void printLT(ListNode head) {
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

public class ReverseKGroup {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{1,2},{1,2,3,4,5}};
        int[][] B = {{0,1,2},{0,1,2,3,4,5}};
        for(int i = 0; i < A.length ; i++) {
            for(int j = 0; j < B[i].length; j++) {
                sol.printLT(sol.genList(A[i]));
                sol.printLT(sol.reverseKGroup(sol.genList(A[i]),B[i][j]));
            }
            System.out.println();
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
