import java.util.*;
class TreeNode {
    int val;
    TreeNode left,right;
    TreeNode(int x) {val = x;}
}
class Solution {
    ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        int i, level, n_in_this_level, n_in_next_level, len; 
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        queue.offer(root); 
        A.add(new ArrayList<Integer>());
        if(root == null) return A;
        for(i = 1,level = 0,n_in_this_level = 1,
                n_in_next_level = 0;;i++) {
            try {
                root = queue.removeFirst();
            }catch(Exception ex) {
                break;
            }
            A.get(level).add(root.val);
            if(root.left != null) {
                n_in_next_level += 1;
                queue.offer(root.left);
            }
            if(root.right != null) {
                n_in_next_level += 1;
                queue.offer(root.right);
            }
            if(i == n_in_this_level) {
                n_in_this_level = n_in_next_level;
                n_in_next_level = 0;
                i = 0;
                level += 1;
                A.add(new ArrayList<Integer>());
            }
        }
        len = A.size();
        for(i = 1; i < len; i++) {
            B.add(A.get(len-1-i));
        }
        return B;
    }
    TreeNode genTree(int[] A) {
        if(A == null || A.length == 0) return null;
        int i, len = A.length;
        TreeNode root = new TreeNode(A[0]), node = root;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(node); 
        for(i = 1; i < len;) {
            node = queue.poll();
            if(A[i] != -1) {
                node.left = new TreeNode(A[i]);
                queue.offer(node.left);
            }
            i += 1;
            if(i < len && A[i] != -1) {
                node.right = new TreeNode(A[i]);
                queue.offer(node.right);
            }
            i += 1;
        }
        return root;
    }
    void printTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        for(queue.offer(root);;) {
            try {
                root = queue.removeFirst();
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
        System.out.print('\n');
    }
    void printAL(ArrayList<ArrayList<Integer>> A) {
        int i, j; 
        for(i = 0; i < A.size(); i++) {
            for(j = 0; j < A.get(i).size(); j++) {
                System.out.print(A.get(i).get(j)+" ");
            }
            System.out.print('\n');
        }
    }
            

}

public class LevelOrderBottom {
    public static void main(String[] args) {
        Solution sol = new Solution(); 
        //int[] A = {3,9,20,-1,-1,15,7}; 
        int[] A = {3,9,20,1,-1,-1,7,2,-1,4,6}; 
        //int[] A = {0};
        TreeNode root = sol.genTree(A);
        sol.printTree(root);
        sol.printAL(sol.levelOrderBottom(root));
    }
}


