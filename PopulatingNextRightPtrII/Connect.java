import java.util.*;
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) {val = x;}
}
class Solution {
    TreeLinkNode temp_node = null, next_first = null;
    void connect(TreeLinkNode root) {
        next_first = findNext(root);
        //System.out.println(next_first.val);
        for(;;) {
            /*if(root.val == 1) {
                System.out.println(root.right.val+" "+
                root.next.val);
            }*/
            if(root == null) {
                if(next_first != null) {
                    root = next_first;
                    next_first = findNext(root);
                    root = temp_node;
                    if(root == null) break;
                }else break;
            }
            System.out.println(root.val);
            if(root.left != null && root.right != null) {
                root.left.next = root.right;
                root.right.next = findNext(root.next);
            }else if(root.left != null) {
                root.left.next = findNext(root.next);
            }else if(root.right != null) {
                root.right.next = findNext(root.next);
            }
            root = temp_node;
        }
    }
    TreeLinkNode findNext(TreeLinkNode root) {
        temp_node = root;
        if(root == null) {
            return null;
        }else if(root.left != null) {
            return root.left;
        }else if(root.right != null) {
            return root.right;
        }else {
            return findNext(root.next);
        }
    }
    TreeLinkNode growTree(int[] A) {
        TreeLinkNode root = new TreeLinkNode(A[0]), node = root;
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(node);
        for(int i = 1; i < A.length; i++) {
            node = queue.poll();
            if(A[i] != -1) {
                node.left = new TreeLinkNode(A[i]);
                queue.offer(node.left);
            }
            i += 1;
            if(i == A.length) break;
            if(A[i] != -1) {
                node.right = new TreeLinkNode(A[i]);
                queue.offer(node.right);
            }
        }
        return root;
    }
    void printTree(TreeLinkNode node) {
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>(); 
        queue.offer(node);
        for(;;) {
            try {
                node = queue.pop();
            }catch(Exception ex) {
                break;
            }
            if(node == null) {
                System.out.print("# ");
            }else {
                if(node.next != null) {
                    System.out.print(node.val+"N"+node.next.val+" ");
                }else {
                    System.out.print(node.val+"N# ");
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        System.out.println();
    }
}
class StupidSolution {
    int i = 1, n_current = 1, n_next = 0;
    void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        /*if(root.val == 1) {
            System.out.println(root.right.val+" "+
            root.next.val);
        }*/
        System.out.println(root.val);
        if(root.left != null) {
            if(root.right != null) {
                root.left.next = root.right;
            }else {
                root.left.next = findNext(root.next);
            }
        }
        if(root.right != null) {
            root.right.next = findNext(root.next);
        }
        connect(root.next);
        connect(root.left);
        //connect(root.right);
    }
    TreeLinkNode findNext(TreeLinkNode root) {
        if(root == null) {
            return null;
        }else if(root.left != null) {
            return root.left;
        }else if(root.right != null) {
            return root.right;
        }else {
            return findNext(root.next);
        }
    }
    TreeLinkNode growTree(int[] A) {
        TreeLinkNode root = new TreeLinkNode(A[0]), node = root;
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(node);
        for(int i = 1; i < A.length; i++) {
            node = queue.poll();
            if(A[i] != -1) {
                node.left = new TreeLinkNode(A[i]);
                queue.offer(node.left);
            }
            i += 1;
            if(i == A.length) break;
            if(A[i] != -1) {
                node.right = new TreeLinkNode(A[i]);
                queue.offer(node.right);
            }
        }
        return root;
    }
    void printTree(TreeLinkNode node) {
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>(); 
        queue.offer(node);
        for(;;) {
            try {
                node = queue.pop();
            }catch(Exception ex) {
                break;
            }
            if(node == null) {
                System.out.print("# ");
            }else {
                if(node.next != null) {
                    System.out.print(node.val+"N"+node.next.val+" ");
                }else {
                    System.out.print(node.val+"N# ");
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        System.out.println();
    }
}

public class Connect {
    public static void main(String[] args) {
        //int[] A = {1,2,3,4,5,-1,7};
        //int[] A = {1,2,3,4,-1,-1,7};
        //int[] A = {0,2,4,1,-1,3,7,5,1,-1,6,-1,8};
        int[] A = {2,1,3,0,7,9,1,2,-1,1,0,-1,-1,8,8,-1,-1,-1,-1,7};
        //int[] A = {1};
        Solution sol = new Solution();
        TreeLinkNode root = sol.growTree(A);
        sol.printTree(root);
        sol.connect(root);
        sol.printTree(root);
    }
}



            
