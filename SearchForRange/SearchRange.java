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
    int[] searchRange(int[] A, int target) {
        int[] range = {-1,-1};
        if(A == null || A.length == 0) return range;
        int len = A.length;
        if(target > A[len-1] || target < A[0]) {
            return range;
        }else if(target == A[len-1] && target == A[0]) {
            range[0] = 0; range[1] = len-1;
            return range;
        }else if(target == A[0] && target < A[len-1]) {
            range[0] = 0;
            findRight(A, range, 0, len-1, target);
        }else if(target == A[len-1] && target > A[0]) {
            range[1] = len-1;
            findLeft(A,range, 0, len-1, target);
        }else {
            findLeft(A,range, 0, len-1, target);
            findRight(A, range, 0, len-1, target);
        }
        return range;
    }
    void findLeft(int[] A, int[] range, int left, int right, int target) {
        int mid = (left+right)/2;
        if(mid == left) {
            if(target == A[left] || target == A[right]){
                range[0] =  A[left] == target? left:right;
            }
            return;
        }
        if(target > A[mid]) {
            findLeft(A, range, mid, right, target);
        }else {
            findLeft(A, range, left, mid, target);
        }
    }
    void findRight(int[] A, int[] range, int left, int right, int target) {
        int mid = (left+right)/2;
        if(mid == left) {
            if(target == A[right] || target == A[left]){
                range[1] =  A[right] == target? right:left;
            }
            return;
        }
        if(target >= A[mid]) {
            findRight(A, range, mid, right, target);
        }else {
            findRight(A, range, left, mid, target);
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

public class SearchRange {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] A = {{1,5},{5,7,7,8,8,10},{4,4,4,5,5}};
        int[][] B = {{4},{8,7,10,11},{4,5}};



        for(int i = 0; i < A.length ; i++) {
            for(int j = 0; j < B[i].length; j++) {
                sol.printAr(sol.searchRange(A[i], B[i][j]));
            }
            System.out.println();
        }
        /*
        System.out.print();

        System.out.println();
*/
    }
}
