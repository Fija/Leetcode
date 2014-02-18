import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x){val = x;}
}

class Solution {
    ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> collection =
            new ArrayList<ArrayList<Integer>>();
        if(root == null) return collection;
        int path_sum = root.val;
        path.add(root.val);
        preOrderTraverse(collection, path,root,path_sum, sum);
        return collection;
    }
    void preOrderTraverse(ArrayList<ArrayList<Integer>> collection,
             ArrayList<Integer> path, TreeNode root, int path_sum, int sum) {
        ArrayList<Integer> new_path;
        /*
        System.out.println(root.val+" "+path_sum);
        for(int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
        */

        if(root.left == null && root.right == null) {
            if(path_sum == sum)
                collection.add(path);
        }else {
            if(root.left != null) {
                new_path = new ArrayList<Integer>(path);
                new_path.add(root.left.val);
                preOrderTraverse(collection,new_path,
                            root.left,path_sum+root.left.val,sum);
            }
            if(root.right != null) {
                new_path = new ArrayList<Integer>(path);
                new_path.add(root.right.val);
                preOrderTraverse(collection,new_path,
                            root.right,path_sum+root.right.val,sum);
            }
        }
    }
    void print(ArrayList<ArrayList<Integer>> A) {
        for(int i =0; i < A.size(); i++ ) {
            for(int j= 0; j < A.get(i).size(); j++ ) {
                System.out.print(A.get(i).get(j)+" ");
            }
            System.out.println();
        }
        System.out.println();
    }


    TreeNode growTree(int[] A) {
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
public class PathSum {
    public static void main(String[] args) {
        //int[][] A = {{1,2,3},{1},{1,2,3,-1,4},{1,2,-1,3},
        //             {1,-1,3,-1,4},{1,2,3,4,5,6}};
        int[][] A = {{5,4,8,11,-1,13,4,7,2,-1,-1,5,1},{1,2},{1}};
        int[][] B = {{22,26,5,18},{1,3},{1,2}};
        Solution sol = new Solution();
        for(int i = 0; i < A.length; i++) {
            sol.printTree(sol.growTree(A[i]));
            for(int j = 0; j < B[i].length; j++) {
                sol.print(sol.pathSum(sol.growTree(A[i]),B[i][j]));
            }
            System.out.println();
        }
    }
}



