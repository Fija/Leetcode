import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {val = x;}
}
    

class Solution {
    TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        int i = 1,len = num.length; 
        TreeNode root = new TreeNode(num[0]); 
        TreeNode node, tmp_node;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        node = root;
        list.offer(root);
        while (true) {
            try {
                node = list.removeFirst();
            }catch(Exception ex) {
                break;
            }
            if (i < len) {
                node.left = new TreeNode(i+1);
                list.offer(node.left);
                i += 1;
            }
            if (i < len) {
                node.right = new TreeNode(i+1);
                list.offer(node.right);
                i += 1;
            }
        }
        //printTree2(root);
        i = 0;
        list.push(root);
        node = root;
        while (true) {
            if (node.left != null) {
                node = node.left;
                list.push(node);
            }else {
                try {
                    tmp_node = list.pop();
                }catch(Exception ex) {
                    break;
                }
                tmp_node.val = num[i];
                i += 1;
                if(tmp_node.right != null) {
                    node = tmp_node.right;
                    list.push(node);
                }
            }
        }
        return root;
    }

    void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.println(root.val);
            printTree(root.right);
        }
    }
    void printTree2(TreeNode root) {
        if (root == null) return;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();    
        queue.offer(root);
        //System.out.println(root.val);
        while (true) {
            try {
                root = queue.removeFirst();
            }catch(Exception ex) {
                break;
            }
            if (root != null) {
                System.out.println(root.val);
                queue.offer(root.left);
                queue.offer(root.right);
            }else {
                System.out.println('#');
            }

            /*
            if (root.left != null) {
                System.out.println(root.left.val);
                queue.offer(root.left);
            }else {
                System.out.println('#');
            }
            if (root.right != null) {
                System.out.println(root.right.val);
                queue.offer(root.right);
            }else {
                System.out.println('#');
            }
            */
        }
    }
}
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        Solution sol = new Solution();
        TreeNode root = sol.sortedArrayToBST(A);
        sol.printTree2(root);
    }
        
}




