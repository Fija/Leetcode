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
    void nextPermutation(int[] num) {
        if(num == null || num.length <= 1) return;
        int temp, idx, len = num.length;
        for(int i = len-1; i >= 1; i--) {
            if(num[i] > num[i-1]) {
                idx = binarySearch(num, i, len-1, num[i-1]);
                temp = num[i-1];
                num[i-1] = num[idx];
                num[idx] = temp;
                reverse(num, i, len-1);
                return;
            }
        }
        reverse(num, 0, len-1);
    }
    int binarySearch(int[] num, int left, int right, int target) {
        while(true) {
            int mid = (left+right)/2;
            if(mid == left) {
                if(target < num[right]) return right;
                else return left;
            }else {
                if(target >= num[mid]) {
                    right = mid;
                }else {
                    left = mid;
                }
            }
        }
    }
    void reverse(int[] num, int left, int right) {
        int temp;
        int mid = (left + right)/2;
        for(int j = left; j <= mid; j++) {
            temp = num[j];
            num[j] = num[left+right-j];
            num[left+right-j] = temp;
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

public class NextPermutation {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{},{1},{1,2},{2,1},{3,5,4,4,2,1},{1,5,3,3,2,2},{3,5,3,3,2,1},
                     {1,2,3},{3,2,1},{1,1,5}};
        //int[][] B = {{}};



        for(int i = 0; i < A.length ; i++) {
            sol.nextPermutation(A[i]);
            sol.printAr(A[i]);
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
