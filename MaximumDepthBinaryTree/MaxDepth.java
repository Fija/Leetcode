class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;}
}
class Solution {
    int maxDepth(TreeNode root) {
        //int left, right, max;
        if (root == null) {
            return 0;
        }else {
            //left = maxDepth(root.left);
            //right = maxDepth(root.right);
            //max = Math.max(left, right);
            //System.out.format("value is: %d, left is: %d,"+
            //                  " right is: %d, max is: %d, return is %d\n",
            //                  root.val,left,right,max,max+1);
            //return 1+max;
            return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
        }
    }
}
class GrowTree {
    int[] arr;
    int len;
    int i;

    GrowTree(int[] x) {
        arr = x;
        len = x.length;
        i = 0;
    }

    void growTree(TreeNode node) {
        i += 1;
        if (i >= len) {
            return;
        }else {
            if(arr[i]!=-1) {
                node.left = new TreeNode(arr[i]);
                growTree(node.left);
            }else i += 1;
            
            if(arr[i]!=-1) {
                node.right = new TreeNode(arr[i]);
                growTree(node.right);
            }else i += 1;
            
        }
    }

}


public class MaxDepth {
    public static void printTree(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            printTree(node.left);
            printTree(node.right);
        }
    }

    public static void main(String[] arg) {
        int[] A={2,7,2,-1,-1,6,5,-1,-1,11,-1,-1,5,-1,9,4,-1,-1,-1};
        //int[] A={1,1,1,1,1,1,-1,-1,-1,-1,-1,-1,-1};
        GrowTree tree = new GrowTree(A);
        TreeNode root = new TreeNode(A[0]);
        Solution sol = new Solution();

        tree.growTree(root);
        printTree(root);
        System.out.format("depth is: %d\n",sol.maxDepth(root));
    }
}



