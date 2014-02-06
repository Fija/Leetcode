class TreeListNode {
    int val;
    TreeListNode left, right, next;
    TreeListNode(int x) {val = x;}
}

class Solution {
    void connect(TreeListNode root) {
        if (root == null || root.left == null || root.right == null) {
            return;
        }else {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
    }
}

public class Connect {
    public static void main(String[] args) {
        TreeListNode root = new TreeListNode(1);
        Solution sol = new Solution();
        sol.connect(root);
    }
}
