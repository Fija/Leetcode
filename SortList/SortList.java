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
    /*
    ListNode sortList(ListNode head) {
        ListNode pre_head = new ListNode(0), head1 = pre_head,
                 head2 = pre_head, temp, node1, node2;
        int i, step = 1;
        pre_head.next = head;
        while(true) {
            head2 = move(head2, step);
            if(head2.next == null) break;
            while(true) {
                i = 0;
                node1 = head1;
                node2 = head2;
                while(true) {
                    if(node1.next.val > node2.next.val) {
                        temp = node2.next;
                        node2.next = temp.next;
                        temp.next = node1.next;
                        node1.next = temp;
                    }
                    node1 = node1.next;
                    i += 1;
                    if(i == step || node1.next == null ||
                       node2.next == null) break;
                }
                head1 = move(head1, step*2);
                head2 = move(head1, step);
                if(head2.next == null) break;
            }
            step *= 2;
            head1 = pre_head;
            head2 = pre_head; 
        }
        return pre_head.next; 
    }
    */
    ListNode sortList(ListNode head) {
        ListNode pre_head = new ListNode(0), head1 = pre_head,
                 head2 = pre_head, temp;
        int i,j, step = 1;
        pre_head.next = head;
        while(true) {
            head2 = move(head2, step);
            if(head2.next == null) break;
            while(true) {
                i = 0;
                j = 0;
                while(true) {
                    if(head1.next.val > head2.next.val) {
                        temp = head2.next;
                        head2.next = temp.next;
                        temp.next = head1.next;
                        head1.next = temp;
                        j += 1;
                    }else i += 1;
                    head1 = head1.next;
                    if(i == step || j == step || head2.next == null) 
                        break;
                }
                head1 = move(head1, 2*step-i-j);
                head2 = move(head2, 2*step-j);
                if(head2.next == null) break;
            }
            step *= 2;
            head1 = pre_head;
            head2 = pre_head; 
        }
        return pre_head.next; 
    }
    ListNode move(ListNode head, int step) {
        for(int i = 0; i< step && head.next != null; i++) {
            head = head.next;
        }
        return head;
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

public class SortList {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{5,6,7,8,1,2,3},{1,3,5,7,2,4,6,8},{1,2,3,4},{},{1},
                     {4,3,2,1},{7,4,3,1,33,88}};
        //int[][] B = {{}};



        for(int i = 0; i < A.length ; i++) {
            sol.printLN(sol.sortList(sol.genList(A[i])));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
