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
    ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0) return null;
        int i= 0, idx = 1;
        while(i+idx <= lists.size()-1) {
            while(i+idx <= lists.size()-1) {
                lists.set(i, mergeSort(lists.get(i), lists.get(i+idx)));
                i += 2*idx;
            }
            i = 0;
            idx *= 2;
        }
        return lists.get(0);
    }
    ListNode mergeSort(ListNode node1, ListNode node2) {
        ListNode head1 = new ListNode(0), pre_node1 = head1;
        pre_node1.next = node1;
        while(node2 != null) {
            if(node1 != null) {
                if (node1.val < node2.val) {
                    node1 = node1.next;
                    pre_node1 = pre_node1.next;
                }else {
                    pre_node1.next = node2;
                    pre_node1 = pre_node1.next;
                    node2 = node2.next;
                    pre_node1.next = node1;
                }
            }else {
                pre_node1.next = node2;
                pre_node1 = pre_node1.next;
                node2 = node2.next;
            }
        }
        return head1.next;
    }

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

public class MergeKLists {
    public static void main(String[] args) {
        Solution sol = new Solution();

        //int[][] A = {{},{3,6,7},{1,4,13},{4,5,9}};
        int[][] A = {{1}};
        //int[][] B = {{}};
        ArrayList<ListNode> lists = new ArrayList<ListNode>();

        for(int i = 0; i < A.length ; i++) {
            lists.add(sol.genList(A[i]));
        }
        sol.printLN(sol.mergeKLists(lists));
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
