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
    int idx=0;
    TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> list = toList(head);
        printAL(list);
        TreeNode root = getTree(list.size());
        printTree(root);
        toBST(root,list);
        return root;
    }
    ArrayList<Integer> toList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }
    TreeNode getTree(int len) {
        if(len == 0) return null;
        TreeNode root = new TreeNode(0), node = root;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int i = 1;
        while(true) {
            node = queue.pop();
            if(i == len) break;
            node.left = new TreeNode(0);
            queue.offer(node.left);
            i+= 1;
            if(i == len) break;
            node.right = new TreeNode(0);
            queue.offer(node.right);
            i+= 1;
        }
        return root;
    }
    void toBST(TreeNode root, ArrayList<Integer> list) {
        if(root == null) {
            return;
        }else {
            toBST(root.left, list);
            root.val = list.get(idx);
            idx+=1;
            toBST(root.right,list);
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

    void printLN(ListNode head) {
        while(head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }

    ListNode genList(int[] A) {
        if(A == null) return null;
        ListNode head = new ListNode(0), node = head;
        for(int i = 0 ; i < A.length; i++) {
            node.next = new ListNode(A[i]);
            node = node.next;
        }
        return head.next;
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

public class SortedListToBST  {
    public static void main(String[] args) {
        Solution sol;
        int[][] A = {{},{1},{1,2,3},{1,2,3,4,5,6,7,8,9}};
        //int[][] B = {{}};



        for(int i = 0; i < A.length ; i++) {
            sol = new Solution();
            sol.printLN(sol.genList(A[i]));
            sol.printTree(sol.sortedListToBST(sol.genList(A[i])));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
