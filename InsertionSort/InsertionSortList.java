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
     ListNode insertionSortList(ListNode head) {
        ListNode node = head;
        ArrayList<ListNode> array = new ArrayList<ListNode>();
        int i = 0, j;
        
        if(head == null) return null;
        while(node != null) {
            array.add(node);
            //printLT(head);
            //System.out.println(i);
            j = i;
            while(j >= 1) {
                if(node.val < array.get(j-1).val) {
                    array.set(j, array.get(j-1));
                    j -= 1;
                }else {
                    break;
                }
            }
            array.set(j, node);
            array.get(i).next = node.next;
            if(j > 0)
                array.get(j-1).next = array.get(j);
            if(j < array.size()-1)
                array.get(j).next = array.get(j+1);

            node = array.get(i).next;
            i += 1;
        }
        return array.get(0);
        
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

    void printLT(ListNode head) {
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

public class InsertionSortList {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{},{1},{1,3,3,2,4,2,7,-5},{3,7,4,9,5,2,6,1}};
        /*int[][] B = {{}};
        System.out.print();

        System.out.println();

        sol.printTree(sol.growTree(A[i]));
*/
        for(int i = 0; i < A.length ; i++) {
            //for(int j = 0; j < B[i].length; j++) {
            sol.printLT(sol.genList(A[i])); 
            sol.printLT(sol.insertionSortList(sol.genList(A[i])));
        }
    }
}
