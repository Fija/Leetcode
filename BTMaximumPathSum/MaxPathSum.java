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
    int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        if(root != null) recurMaximum(root, max);
        return max[0];
    }
    int recurMaximum(TreeNode root, int[] max) {
        int left_in = 0, right_in = 0, sum;
        if(root.left == null && root.right == null) {
            if(root.val > max[0]) max[0] = root.val;
            return root.val;
        }else {
            if(root.left != null) left_in = recurMaximum(root.left, max);
            if(root.right != null) right_in = recurMaximum(root.right, max);
            if(left_in > 0 && right_in > 0) {
                sum = left_in + right_in + root.val;
                if( sum > max[0]) max[0] = sum;
            }
            sum = getMax(left_in, right_in, 0) + root.val;
            if( sum > max[0]) max[0] = sum;
            return sum;
        }
    }
    int getMax(int a, int b, int c) {
        if(a > b) {
            if(c > a) return c;
            else return a;
        }else {
            if(c > b) return c;
            else return b;
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
            if(A[i] != -8) {
                node.left = new TreeNode(A[i]);
                queue.offer(node.left);
            }
            i += 1;
            if(i == A.length) break;
            if(A[i] != -8) {
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

public class MaxPathSum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{},{-1},{5,4,8,11,-8,13,4,7,2,-8,-8,-8,1},
                     {1,-2,-3,1,3,-2,-8,-1},{1,2,3}};
        //int[][] B = {{}};



        for(int i = 0; i < A.length ; i++) {
            sol.printTree(sol.growTree(A[i]));
            System.out.println(sol.maxPathSum(sol.growTree(A[i])));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
