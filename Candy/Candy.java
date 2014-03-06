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
    int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        if(ratings.length == 1) return 1;
        int i, j, r=0, l=0, peak=0, sum = 0, len = ratings.length;
        int[] c = new int[len];
        for(i = 0; i < len; i++) {
            if(i == len-1 && ratings[i]>ratings[i-1]||i<len-1 && i > 0 &&
               ratings[i] >ratings[i-1]&&ratings[i] == ratings[i+1]) {
                l++;
                peak = i;
                for(j = 0; j < l; j++) c[i-j] = l-j;
                l = 0;
            }else if(i == len-1 && ratings[i]<ratings[i-1]||i<len-1 && i > 0 &&
                    ratings[i] < ratings[i-1] && ratings[i] <= ratings[i+1]) {
                r += 1;
                if(r > l) {
                    for(j = 0; j < r; j++) c[i-j] = j+1;
                    for(j = 0; j < l-1; j++) c[peak-1-j] = l-1-j;
                }else {
                    for(j = 0; j < r-1; j++) c[i-j] = j+1;
                    for(j = 0; j < l; j++) c[peak-j] = l-j;
                }
                l = 0;
                r = 0;
                if(i<len-1 && i > 0 && 
                   ratings[i] < ratings[i-1] && ratings[i] < ratings[i+1]) 
                    l += 1;
            }else if(i == 0 && ratings[1] > ratings[0] ||i<len-1 && i > 0 &&
                    ratings[i] < ratings[i+1] && ratings[i] >= ratings[i-1]) {
                l += 1;
            }else if(i == 0 && ratings[1] < ratings[0] ||i <len-1 && i > 0 &&
                    ratings[i] > ratings[i+1] && ratings[i] >= ratings[i-1]) {
                peak = i;
                r = 1;
                if(i<len-1 && i > 0 &&
                   ratings[i] > ratings[i-1] && ratings[i] > ratings[i+1])l++;
            }else if(i < len-1 && i > 0 &&
                     ratings[i] < ratings[i-1] && ratings[i] > ratings[i+1]) {
                r += 1;
            }else {
                c[i] = 1;
            }
        }
        for(i = 0; i < len; i++) sum += c[i];
        return sum;
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

public class  Candy{
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{3},{1,1},{1,2},{2,1},{3,3,3},
                     {4,3,3,5,2,1,3,3,2},{1,6,4,2,3,5}};



        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.candy(A[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
