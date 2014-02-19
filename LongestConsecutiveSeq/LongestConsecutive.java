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
    int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int left_end, right_end, max_range = 0, range;
        for(int i = 0; i < num.length; i++) {
            if(map.get(num[i]) == null) {
                left_end = map.containsKey(num[i]-1)? map.get(num[i]-1):0;
                right_end = map.containsKey(num[i]+1)? map.get(num[i]+1):0;
                range = left_end + right_end + 1;
                map.put(num[i] - left_end, range);
                map.put(num[i] + right_end, range);
                map.put(num[i], range);
                if(range > max_range) max_range = range;
            }
        }
        return max_range;
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

public class LongestConsecutive {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {100,4,200,1,3,2};
        //int[] A = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        //int[] A = {1};
        System.out.println(sol.longestConsecutive(A));

/*
        System.out.print();

        System.out.println();

        sol.printTree(sol.growTree(A[i]));

        for(int i = 0; i < ; i++) {
            for(int j = 0; j < ; j++) {
            }
            System.out.println();
        }
*/
    }
}
