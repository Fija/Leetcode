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
    double findMedianSortedArrays(int A[], int B[]) {
        if(A[0] > B[0]) {
            temp = A;A = B;B = temp;
            sA = sA^sB; sB = sA^sB; sA = sA^sB;
            eA = eA^eB; eB = eA^eB; eA = eA^eB;
        }
        lenA = eA-sA+1;
        lenB = eB-sB+1;
        idxA = (lenA-1)/2;
        idxB1 = Arrays.binarySearch(B, A[idxA]);
        idxB2 = Arrays.binarySearch(B, A[eA]);
        if(idxB2 < 0) {
            if (lenA-1 < rank) return B[rank-lenA];
            else return A[rank];
        }else if(idxB2 < 

        if(idxB + idxA + 1 == rank) {
            if(odd) return B[idxB];
            else {
                if(idxA < lenA-1 && idxB < lenB-1) {
                    return (A[idxA+1] < B[idxB+1]? (B[idxB]+A[idxA+1])/2 :
                            (B[idxB]+B[idxB+1])/2);
                }else if(idxA < lenA-1) {
                    return (B[idxB]+A[idxA+1])/2;
                }else if(idxB < lenB-1) {
                    return (B[idxB]+B[idxB+1])/2;
                }
            }
        }else if(idxB + idxA +1 < rank) {
            rank = rank - idxB - idxA - 2;
            sA = idxA+1;
            sB = idxB;
        }else {
            eA = idxA;
            eB = idxB-1;
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

public class  {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{}};
        int[][] B = {{}};



        for(int i = 0; i < A.length ; i++) {
            for(int j = 0; j < B[i].length; j++) {
            sol.print(sol.
            }
            System.out.println();
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
