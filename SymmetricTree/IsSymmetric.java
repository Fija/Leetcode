import java.util.*;
class TreeNode {
    int val;
    TreeNode left,right;
    TreeNode(int x) {val = x;}
}

class Solution {
    boolean isSymmetric(TreeNode root) {
        int i = 0, j, head = 0, levelfull = 3, nextlevelempty = 1;
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        TreeNode node1, node2;
        list.add(root);
        while(true) {
            node1 = list.get(head);
            if (node1 != null) {
                if (node1.right != null ||
                    node1.left != null)
                nextlevelempty = 0;
                list.add(node1.right);
                list.add(node1.left);
            }else {
                list.add(null);
                list.add(null);
            }
            i += 2;
            head +=1;
            if (i == levelfull-1) {
                if (nextlevelempty == 1) break;
                for (j = head; j < head + (levelfull-head)/2; j++) {
                    node1 = list.get(j);
                    node2 = list.get(i-(j-head));
                    if (node1 == null && node2 != null || 
                        node1 != null && node2 == null || 
                        node1 != null && node2 != null &&
                        node1.val != node2.val) {
                        return false;
                    }
                }
                levelfull = (levelfull+1)*2-1;
                nextlevelempty = 1;
            }
        }
        return true;
    }
    
    boolean isSymmetric2(TreeNode root) {


        while (true) {
            head1 = queue1.poll();
            head2 = queue2.poll();
            if (head1 != null && head2 == null ||
                head1 == null && head2 != null ||
                head1 != null && head2 != null &&
                head1.val != head2.val) {
                return false;
            }
            if (head1 != null && head2 != null) {
                queue1.offer(head1.left);
                queue1.offer(head1.right);
                queue2.offer(head2.right);
                queue2.offer(head2.left);
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
            node = queue.poll(); 
            i += 1;
            if (i >= len) break;
            if (A[i] != -999) {
                node.left = new TreeNode(A[i]);
                queue.offer(node.left);
            }
            i += 1;
            if (i >= len) break;
            if (A[i] != -999) {
                node.right = new TreeNode(A[i]);
                queue.offer(node.right);
            }
        }
        return root;
    }
    public static void printTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        while (root != null) {
            System.out.println(root.val);
            if (root.left != null)
            queue.offer(root.left);
            if (root.right != null)
            queue.offer(root.right);
            root = queue.poll();
        }
    }
    public static void main(String[] args) {
        //int[] A = {1,2,2,-1,3,-1,3};
        //int[] A = {1,2,2,3,4,4,3};
        //int[] A = {1,2,2,-1,-1,-1};
        //int[] A = {1,2,2,3,-1,-1,3};
        //int[] A = {};
        //int[] A = {-64,12,18,-4,-53,-999,76,-999,-51,-999,-999,-93,3,-999,-31,47,-999,3,53,-81,33,4,-999,-51,-44,-60,11,-999,-999,-999,-999,78,-999,-35,-64,26,-81,-31,27,60,74,-999,-999,8,-38,47,12,-24,-999,-59,-49,-11,-51,67,-999,-999,-999,-999,-999,-999,-999,-67,-999,-37,-19,10,-55,72,-999,-999,-999,-70,17,-4,-999,-999,-999,-999,-999,-999,-999,3,80,44,-88,-91,-999,48,-90,-30,-999,-999,90,-34,37,-999,-999,73,-38,-31,-85,-31,-96,-999,-999,-18,67,34,72,-999,-17,-77,-999,56,-65,-88,-53,-999,-999,-999,-33,86,-999,81,-42,-999,-999,98,-40,70,-26,24,-999,-999,-999,-999,92,72,-27,-999,-999,-999,-999,-999,-999,-67,-999,-999,-999,-999,-999,-999,-999,-54,-66,-36,-999,-72,-999,-999,43,-999,-999,-999,-92,-1,-98,-999,-999,-999,-999,-999,-999,-999,39,-84,-999,-999,-999,-999,-999,-999,-999,-999,-999,-999,-999,-999,-999,-93,-999,-999,-999,98};
        int[] A = {0};
        TreeNode root = growTree(A);
        //printTree(root);
        Solution sol = new Solution();
        if (sol.isSymmetric(root)) {
            System.out.println("It's symmetric!");
        }else {
            System.out.println("It's not symmetric!");
        }
    }
}
               

