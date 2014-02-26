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
    int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int i, max = 0, min = Integer.MAX_VALUE,
            profit = 0, max_profit = 0,
            len = prices.length;
        int[] max_to_now = new int[len];
        int[] max_after_now = new int[len];
        for(i = len-1; i >= 2; i--) {
            if(prices[i] > max) {
                max = prices[i];
            }else if(max - prices[i] > max_profit) {
                max_profit = max - prices[i];
            }
            max_after_now[i] = max_profit;
        }
        max_profit = 0;
        for(i = 0; i< len; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }else if(prices[i] - min > max_profit) {
                max_profit = prices[i] - min;
            }
            max_to_now[i] = max_profit;
        }
        for(i = 1; i< len-1; i++) {
            profit = max_to_now[i] + max_after_now[i+1];
            if(profit > max_profit) {
                max_profit = profit;
            }
        }
        if(max_to_now[len-1] > max_profit) max_profit = max_to_now[len-1];
        return max_profit;
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

public class MaxProfit {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{},{3,2,1},{2,1},{1,2,3,4},{1,7,2,9,3,10,5,8,6,11,0}};
        //int[][] B = {{}};



        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.maxProfit(A[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
