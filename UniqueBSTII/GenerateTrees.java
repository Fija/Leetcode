import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x){val = x;}
}

class Solution {
    ArrayList<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> set = new ArrayList<TreeNode>();
        ArrayList<ArrayList<TreeNode>> collection = 
            new ArrayList<ArrayList<TreeNode>>();
        //initialize
        set.add(null);
        if (n == 0) return set;
        collection.add(set);

        return recurGenTrees(collection,1, n);
    }
    ArrayList<TreeNode> recurGenTrees(ArrayList<ArrayList<TreeNode>> collection,
                       int level, int n) {

        TreeNode left, node;
        ArrayList<TreeNode> set = new ArrayList<TreeNode>();
        
        for(int i = 0; i < level; i++) {
            for(int j = 0; j < collection.get(i).size(); j++) {
                left = treeCopyAdd(new TreeNode(0), collection.get(i).get(j),0);
                for(int k = 0; k < collection.get(level-1-i).size();k++) {
                    node = new TreeNode(i+1);
                    node.left = left;
                    node.right = treeCopyAdd(new TreeNode(0), 
                                             collection.get(level-1-i).get(k),i+1);
                    set.add(node);
                }
            }
        }
        if(level == n) return set;

        collection.add(set); 
        return recurGenTrees(collection, level+1, n);
    }
    TreeNode treeCopyAdd(TreeNode dest,TreeNode src, int a) {
        if(src == null) {
            return null;
        }else {
            dest.val = src.val + a;
            if(src.left != null) {
                dest.left = new TreeNode(src.left.val+a);
                treeCopyAdd(dest.left, src.left,a);
            }
            if(src.right != null) {
                dest.right = new TreeNode(src.right.val+a);
                treeCopyAdd(dest.right, src.right,a);
            }
        }
        return dest;
    }

        //System.out.print();

        //System.out.println();

    void print(ArrayList<TreeNode> A) {
        if(A == null) return;
        for(int i = 0; i < A.size(); i++) {
            printTree(A.get(i));
        }
        System.out.println();
    }

    void printAL2(ArrayList<ArrayList<Integer>> A) {
        if(A == null) return;
        for(int i =0; i < A.size(); i++ ) {
            for(int j= 0; j < A.get(i).size(); j++ ) {
                System.out.print(A.get(i).get(j)+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void printAL(ArrayList<Integer> A) {
        if(A == null) return;
        for(int i = 0; i < A.size(); i++) {
            System.out.print(A.get(i)+" ");
        }
        System.out.println();
    }

    void printAr(int[] A) {
        if(A == null) return;
        for(int i = 0; i < A.length; i++) {
                System.out.print(A[i]+" ");
            }
        System.out.println();
    }


    TreeNode growTree(int[] A) {
        if(A == null || A.length == 0) return null;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(A[0]), node = root;
        queue.offer(node);
        for(int i = 1; i < A.length; i++ ) {
            node = queue.poll();
            if(A[i] != -1) {
                node.left = new TreeNode(A[i]);
                queue.offer(node.left);
            }
            i += 1;
            if(i == A.length) break;
            if(A[i] != -1) {
                node.right = new TreeNode(A[i]);
                queue.offer(node.right);
            }
        }
        return root;
    }
    void printTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(true) {
            try {
                root = queue.pop();
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
        System.out.println();
    }
}

public class GenerateTrees {
    public static void main(String[] args) {
        Solution sol = new Solution();

        //System.out.print();

        //System.out.println();

        sol.print(sol.generateTrees(1));
/*
        for(int i = 0; i < ; i++) {
            for(int j = 0; j < ; j++) {
            }
            System.out.println();
        }
        */
    }
}
