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
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> index = new ArrayList<Integer>();
        int i;
        int[] ans = new int[2];
        for(i = 0; i < numbers.length; i++) {
            map.put(numbers[i], 1);
        }
        for(i = 0; i < numbers.length; i++) {
            if(map.containsKey(target-numbers[i])) {
                index.add(i);
            }
        }
        if(index.size() == 3) {
            for(i =0 ; i< 3; i++) {
                if(numbers[index.get(i)] == target/2) {
                    index.remove(i);
                    break;
                }
            }
        }
        ans[0] = Math.min(index.get(0),index.get(1))+1;
        ans[1] = Math.max(index.get(0),index.get(1))+1;
        return ans;
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

public class TwoSum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{1,1},{3,2,4},{7,11,2,15},{9,3,7,8,2,4,7,1}};
        int[][] B = {{2},{6},{9,17},{4}};
/*
        System.out.print();

        System.out.println();

        sol.printTree(sol.growTree(A[i]));
*/
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B[i].length; j++) {
                sol.printAr(sol.twoSum(A[i],B[i][j]));
            }
            System.out.println();
        }
    }
}
