class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {val = x;}
}

class Solution {
    ArrayList<Integer> preorderTraversal(TreeNode root) {
        return new ArraryList<Integer>(0);
    }
}

public class PreTrav {
    private int i = 0, len = A.length;
    private int[] A = {1,-1,2,3};

    public static void growTree(TreeNode root) {
        while (i < len) {
            if (i+2 < len && A[i+1] != -1 && A[i+2] != -1) {
                root.left = new TreeNode(A[i+1]);
                root.right = new TreeNode(A[i+2]);
                i += 3;
                growTree(root.left);
                growTree(root.right);
            }else if(
                





    }
    public static void printTree(TreeNode root) {
        while(root != null) {
            System.out.println(root.val);
            root = root.val;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(A[0]);
        growTree(root, A);
        println(root);
        Solution sol = new Solution();
        ArrayList<Integer> tree = sol.preorderTraversal(root);
        for (i = 0; i < tree.size(); i++) {
            System.out.println(tree[i]);
        }
    }
}



