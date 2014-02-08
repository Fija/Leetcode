import java.util.*;
class TreeNode {
    int val;
    TreeNode left,right;
    TreeNode(int x) {val = x;}
}

class Solution {
    boolean isSymmetric(TreeNode root) {
        int i = 0, j, head = 0, levelfull = 3, nextlevelempty = 0;
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        while(true) {
            if (list.get(head) != null) {
                if (list.get(head).right != null ||
                    list.get(head).left != null)
                nextlevelempty = 0;
                list.add(list.get(head).right);
                list.add(list.get(head).left);
            }else {
                list.add(null);
                list.add(null);
            }
            i += 2;
            if (i == levelfull-1) {
                if (nextlevelempty == 1) break;
                head = levelfull/2;
                for (j = head; j < head + (levelfull-head)/2; j++) {
                    if (list.get(j) == list.get(i-(j-head)) || 
                        list.get(j) != null && list.get(i-(j-head)) != null &&
                        list.get(j).val != list.get(i-(j-head)).val) {
                        return false;
                    }
                }
                levelfull = (levelfull+1)*2-1;
                nextlevelempty = 1;
            }
        }
        return true;
    }
}

public class IsSymmetric {
    public static TreeNode growTree(int[] A) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root, node;
        int i = 0, len;
        if (A == null || A.length == 0) return null;
        len = A.length;
        root = new TreeNode(A[0]);
        node = root;
        queue.offer(root);
        while (true) {
            i += 1;
            if (i >= len) break;
            if (A[i] != -1) {
                node = queue.poll(); 
                node.left = new TreeNode(A[i]);
                queue.offer(node.left);
            }
            i += 1;
            if (i >= len) break;
            if (A[i] != -1) {
                node.right = new TreeNode(A[i]);
                queue.offer(node.right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        //int[] A = {1,2,2,-1,3,-1,3};
        //int[] A = {1,2,2,3,4,4,3};
        int[] A = {1,2,2,3,3,3,3};
        TreeNode root = growTree(A);
        Solution sol = new Solution();
        if (sol.isSymmetric(root)) {
            System.out.println("It's symmetric!");
        }else {
            System.out.println("It's not symmetric!");
        }
    }
}
               

