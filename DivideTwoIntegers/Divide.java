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
    int divide(int dividend, int divisor) {
        boolean positive = false;
        if(dividend > 0) {
            dividend = -dividend;
            if(divisor > 0) {
                positive = true;
                divisor = -divisor; 
            }
        }else {
            if(divisor < 0) {
                positive = true;
            }else {
                divisor = -divisor;
            }
        }
        if(dividend > divisor) {
            return 0;
        }
        int sum = divisor;
        List<Integer> products = new ArrayList<Integer>();
        products.add(0);
        products.add(divisor);
        while(sum >= dividend - sum) {
            sum += sum;
            products.add(sum);
        }
        int k = products.size()-1;
        int quotient = 0;
        while(k >= 1) {
            if(dividend <= products.get(k)) {
                quotient += (1 << (k-1));
                dividend -= products.get(k);
            }
            k--;
        }
        return positive? quotient : -quotient;
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

public class Divide {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {1,4375,-0,-2147483648,2147483647,3,3,3,-2147483648};
        int[] B = {-1,28,1,2147483647,-2147483648,2,4,3,1};
        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.divide(A[i],B[i])==A[i]/B[i]);
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
