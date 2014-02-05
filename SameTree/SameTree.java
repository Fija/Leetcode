class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}

class Tree {
    TreeNode root;
    int[] tree;
    int len;
    int i = 0;

    Tree(TreeNode node, int[] A) {
        root = node;
        tree = A;
        len = A.length;
        growTree(root);
    }

    void growTree(TreeNode node) {
        i += 1;
        if (i >= len) {
            return;
        }else {
            if (tree[i] != -1) {
                node.left = new TreeNode(tree[i]);
                growTree(node.left);
            }else i += 1;
            if (tree[i] != -1) {
                node.right = new TreeNode(tree[i]);
                growTree(node.right);
            }else i += 1;
        }
    }

    //in-order printing
    void printTree(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            printTree(node.left);
            printTree(node.right);
        }
    }
}



class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }else if ((p != null && q != null) && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);
        }else {
            return false;
        }
    }
}

public class SameTree {
    public static void main(String[] args) {
        int[] A={2,7,2,-1,-1,6,5,-1,-1,11,-1,-1,5,-1,9,4,-1,-1,-1};
        //int[] B={1,1,1,1,1,1,-1,-1,-1,-1,-1,-1,-1};
        int[] B=A;
        TreeNode root1 = new TreeNode(A[0]);
        TreeNode root2 = new TreeNode(B[0]);
        Tree tree1 = new Tree(root1, A);
        Tree tree2 = new Tree(root2, B);
        tree1.printTree(root1);
        tree2.printTree(root2);
        Solution sol = new Solution();
        if(sol.isSameTree(root1,root2)) {
            System.out.println("They are the same!");
        }else {
            System.out.println("They are not the same!");
        }
    }
}
