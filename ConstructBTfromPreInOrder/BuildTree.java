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
    TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 ||
           inorder.length == 0) return null;
        int len = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        recurBuild(root, map, inorder, preorder, 0, len-1, 0, len-1);
        return root;
    }
    void recurBuild(TreeNode root, HashMap<Integer, Integer> map, int[] inorder,
                    int[] preorder, int in_left, int in_right, int pre_left,
                    int pre_right) {
        int idx, left_num, right_num;
        idx = map.get(preorder[pre_left]);
        left_num = idx - in_left;
        right_num = in_right - idx;
        if(left_num != 0) {
            root.left = new TreeNode(preorder[pre_left+1]);
            recurBuild(root.left, map, inorder, preorder, in_left,
                       idx-1, pre_left+1, pre_left+left_num);
        }
        if(right_num != 0) {
            root.right = new TreeNode(preorder[pre_left+left_num+1]);
            recurBuild(root.right, map, inorder, preorder, idx+1,
                       in_right, pre_left+left_num+1, pre_right);
        }
    }


//        System.out.print();

//        System.out.println();

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

public class BuildTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{1},{},{4,2,5,8,1,6,3,9,7},{3,2,1},{1,2,3}};
        int[][] B = {{1},{},{1,2,4,5,8,3,6,7,9},{1,2,3},{1,2,3}};
        int[][] C = {{1},{},{1,2,3,4,5,6,7,-1,-1,-1,8,-1,-1,9},{1,2,-1,3},
                        {1,-1,2,-1,3}};

        //System.out.print();

        //System.out.println();


        for(int i = 0; i < A.length ; i++) {
            sol.printTree(sol.growTree(C[i]));
            sol.printTree(sol.buildTree(B[i],A[i]));
        }
        System.out.println();
    }
}
