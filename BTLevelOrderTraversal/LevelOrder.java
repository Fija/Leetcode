import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {val = x;}
}

class Solution {
    ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        int level = 0,n_this = 1,n_next = 0,i = 0;
        if(root == null) return A;
        A.add(new ArrayList<Integer>());
        queue.offer(root);
        for(;;) {
            try{
                root = queue.pop();
            }catch(Exception ex) {
                break;
            }
            if(root.left != null) {
                queue.offer(root.left);
                n_next += 1;
            }
            if(root.right != null) {
                queue.offer(root.right);
                n_next += 1;
            }
            i += 1;
            A.get(level).add(root.val);
            if(i == n_this) {
                level += 1;
                i = 0;
                n_this = n_next;
                n_next = 0;
                if(queue.peek() != null) {
                    A.add(new ArrayList<Integer>());
                }
            }
        }
        return A;
    }
    TreeNode growTree(int[] A) {
        if(A == null || A.length == 0) return null;
        int i, len = A.length;
        TreeNode head = new TreeNode(A[0]), node = head;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(node);
        for(i = 1; i < len; i++) {
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
        }
        return head;
    }
    void printTree(TreeNode node) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(node);
        for(;;) {
            try{
                node = queue.pop();
            }catch(Exception ex) {
                break;
            }
            if(node == null) {
                System.out.print("# ");
            }else {
                System.out.print(node.val+" ");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        System.out.println();
    }
    void printAns(ArrayList<ArrayList<Integer>> A) {
        for(int i = 0; i < A.size(); i++) {
            for(int j = 0; j < A.get(i).size(); j++) {
                System.out.print(A.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}

public class LevelOrder {
    public static void main(String[] args) {
        //int[] A = {3,9,20,-1,-1,15,7};
        //int[] A = {1};
        int[] A = {1,2,-1,3,-1,4,-1,5};
        Solution sol = new Solution();
        sol.printTree(sol.growTree(A));
        sol.printAns(sol.levelOrder(sol.growTree(A)));
        }
}



            

