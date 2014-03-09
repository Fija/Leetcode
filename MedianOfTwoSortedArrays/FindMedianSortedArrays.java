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
        int sA = 0, eA = A.length-1, sB = 0, eB = B.length-1,
            rank = (eA+eB+1)/2;
        if(eA+eB % 2 == 1) return findMedian(A,sA,eA,B,sB,eB,rank);
        else return (findMedian(A,sA,eA,B,sB,eB,rank)+
                     findMedian(A,sA,eA,B,sB,eB,eA+eB+1-rank))/2.0;
    }
    double findMedian(int[] A, int sA, int eA, int[] B,
                      int sB, int eB, int rank) {
        int del;
        int[] temp; 
        while(true) {
            if(eA-sA+1 > eB-sB+1) {
                temp = A; A = B; B= temp;
                sA = sA^sB; sB = sA^sB; sA = sA^sB;
                eA = eA^eB; eB = eA^eB; eA = eA^eB;
            }
            if(eA-sA+1 == 0) return B[rank];
            if(rank == 0) return Math.min(A[sA],B[sB]);
            del = Math.min(eA-sA, rank/2);
            if(A[sA+del] == B[sB+rank-del-1]) {
                return A[sA+del];
            }else if(A[sA+del] < B[sB+rank-del-1]) {
                sA = sA+del+1;
                rank -= del+1;
            }else if(A[sA+del] > B[sB+rank-del-1]) {
                sB = sB+rank-del;
                rank -= rank-del;
            }
        }
    }




        
        
    double hopelessFindMedianSortedArrays(int A[], int B[]) {
        int sA = 0, sB = 0, eA = A.length-1, eB = B.length-1,midA,
            midB,lenA = A.length, lenB = B.length, rank = (eA+eB+1)/2;
        boolean odd = (A.length+B.length)%2 == 1;
        int[] temp;
        if(B.length == 0) {
            if(odd) return A[rank];
            else return (A[rank]+A[rank+1])/2.0;
        }else if(A.length == 0) {
            if(odd) return B[rank];
            else return (B[rank]+B[rank+1])/2.0;
        }
        while(true) {
            if(A[sA] > B[sB]) {
                temp = A;A = B;B = temp;
                sA = sA^sB; sB = sA^sB; sA = sA^sB;
                eA = eA^eB; eB = eA^eB; eA = eA^eB;
                lenA = lenA^lenB; lenB = lenA^lenB; lenA = lenA^lenB;
            }
            midA = (sA+eA)/2;
            midB = (sB+eB)/2;
            if(rank >= eA+1 && A[eA] <= B[sB]) {
                if(odd) return B[rank-eA-1];
                else return (B[rank-eA-1]+B[rank-eA])/2.0;
            }else if(rank < eA+1 && A[rank] <= B[sB]) {
                if(odd) return A[rank];
                else {
                    if(rank == lenA-1) return (A[rank]+B[sB])/2.0;
                    else return ((A[rank] + 
                                 (A[rank+1] < B[sB]?A[rank+1]:B[sB]))/2.0);
                }
            }else if(rank > eB+1 && A[rank-eB-1] >= B[eB]) {
                if(odd) return A[rank-eB-1];
                else return (A[rank-eB-1]+A[rank-eB])/2.0;
            }else {
                if(midA == sA && midB == sB) {
                    if(B[eB] <= A[eA]) {
                        if(midA+eB+1 == rank) {
                            if(odd) return B[eB];
                            else {
                                if(eA < lenA-1 && eB < lenB-1)
                                    return ((B[eB]+(A[eA+1]<B[eB+1]?
                                                    A[eA+1]:B[eB+1]))/2.0);
                                else if(eA < lenA-1)
                                    return ((B[eB] + A[eA])/2.0);
                                else if(eB < lenB-1)
                                    return ((B[eB] + B[eB+1])/2.0);
                            }
                        }else{
                            if(odd) return A[eA];
                            else {
                                if(eA < lenA-1 && eB < lenB-1)
                                    return ((A[eA]+(A[eA+1]<B[eB+1]?
                                                    A[eA+1]:B[eB+1]))/2.0);
                                else if(eA < lenA-1)
                                    return ((A[eA] + A[eA+1])/2.0);
                                else if(eB < lenA-1)
                                    return ((A[eA] + B[eB+1])/2.0);
                            }
                        }
                    }else {
                        if(midB+eA+1 == rank) {
                            if(odd) return A[eA];
                            else {
                                if(eA < lenA-1)
                                    return ((A[eA]+(A[eA+1]<B[eB]?
                                                    A[eA+1]:B[eB]))/2.0);
                                else return ((A[eA] + B[eB])/2.0);
                            }
                        }else{
                            if(odd) return B[eB];
                            else {
                                if(eA < lenA-1 && eB < lenB-1)
                                    return ((B[eB]+(A[eA+1]<B[eB+1]?
                                                    A[eA+1]:B[eB+1]))/2.0);
                                else if(eA < lenA-1)
                                    return ((B[eB] + A[eA+1])/2.0);
                                else if(eB < lenB-1)
                                    return ((B[eB] + B[eB+1])/2.0);
                            }
                        }
                    }
                }
                if(midA+midB+1 == rank) {
                    if(A[midA] == B[midB]) {
                        if(odd) return A[midA];
                        else {
                            if(midA < lenA-1 && midB < lenB-1)
                                return ((A[midA]+(A[midA+1]<B[midB+1]?
                                                A[midA+1]:B[midB+1]))/2.0);
                            else if(midA < lenA-1)
                                return ((A[midA] + A[midA+1])/2.0);
                            else if(midB < lenB-1)
                                return ((A[midA] + B[midB+1])/2.0);
                        }
                    }else if(A[midA] < B[midB]) {
                        sA = midA;
                        eB = midB;
                    }else{
                        sB = midB;
                        eA = midA;
                    }
                }else if(midA+midB+1 < rank) {
                    if(A[midA] < B[midB]) {
                        if(midA == sA) {
                            if(eA+midB+1 > rank) {
                                if(B[midB] > A[midA])
                                    eB = midB;
                            }
                        }
                        else sA = midA;
                    }else sB = midB;
                }else {
                    if(A[midA] > B[midB]) eA = midA;
                    else eB = midB;
                }
            }
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

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{1,3},{3},{1,2},{1,2},{3,3,7,9},{1,3,7,9},{1,3,4,5,6},
                     {1,1},{4,5,6,8,9},{}};
        int[][] B = {{2,4,5,6,7},{1,2,4,5,6},
                     {1,2},{1,2,3},{2,4,7},{2,4,5,8},
                     {2},{1,2},{},{2,3}};



        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.findMedianSortedArrays(A[i],B[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
