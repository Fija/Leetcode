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
    ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {

        ArrayList<ArrayList<Integer>> collection =
            new ArrayList<ArrayList<Integer>>();
        int[] sorted_arr = Arrays.copyOf(candidates, candidates.length);
        int[] count = new int[candidates.length];

        Arrays.sort(sorted_arr);
        return recurFind(collection, count, sorted_arr, 0,
                          sorted_arr.length-1, target);
    }
    ArrayList<ArrayList<Integer>> recurFind(ArrayList<ArrayList<Integer>> 
            collection, int[] count, int[] sorted_arr, int current_sum,
             int idx, int target) {

        int[] new_count ;
/*
        if(count[3] == 0 && count[2] == 0 ) {
            System.out.println("Here's problem");
        }
        */
        count[idx] = (target-current_sum)/sorted_arr[idx];
        if((target - current_sum) % sorted_arr[idx] == 0) {
            collection.add(transform(count,sorted_arr));
            count[idx] -= 1;
        }
        if(idx == 0) {
            return collection;
        }
        current_sum += count[idx] * sorted_arr[idx];
        for(; count[idx] >= 0; count[idx]--) {
            new_count = Arrays.copyOf(count, count.length);
            recurFind(collection, new_count, sorted_arr, current_sum,
                      idx-1, target);
            current_sum -= sorted_arr[idx];
        }
        //System.out.println(collection.size());
        return collection;
    }
    ArrayList<Integer> transform(int[] count, int[] sorted_arr) {
        ArrayList<Integer> combination = new ArrayList<Integer>();
        for(int i = 0; i < count.length; i++) {
            if(count[i] != 0) {
                for(int j = 0; j < count[i]; j++) {
                    combination.add(sorted_arr[i]);
                }
            }
        }
        return combination;
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

public class CombinationSum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{2,3,6,7}};
        int[][] B = {{7,9,2,1}};

/*
        System.out.print();

        System.out.println();

        sol.printTree(sol.growTree(A[i]));
*/
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B[i].length; j++) {
                sol.printAL2(sol.combinationSum(A[i],B[i][j]));
            }
            System.out.println();
        }

    }
}
