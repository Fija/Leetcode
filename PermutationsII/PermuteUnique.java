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
    ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        //remain_num can be improved by more complicated data structure
        //using linkedlist and hashmap to search and remove
        ArrayList<ArrayList<Integer>> collections = 
            new ArrayList<ArrayList<Integer>>();
        
        int[] s_num = Arrays.copyOf(num, num.length);
        Arrays.sort(s_num);
        Integer[] sorted_num = new Integer[num.length];
        for(int i = 0 ; i < num.length; i++) {
            sorted_num[i] = s_num[i];
        }

        ArrayList<Integer> remain_num = new ArrayList<Integer>(
                                        Arrays.asList(sorted_num));
        ArrayList<Integer> permutation = new ArrayList<Integer>();

        recurSolve(collections, permutation, remain_num, 0);
        return collections; 
    }
    void recurSolve(ArrayList<ArrayList<Integer>> collections, 
                    ArrayList<Integer> permutation,
                    ArrayList<Integer> remain_num,
                    int i) {
        LinkedHashSet<Integer> set = 
            new LinkedHashSet<Integer>(remain_num);
        Integer[] unique_num = set.toArray(new Integer[set.size()]);
       
        if(remain_num.size() == 0) {
           collections.add(permutation); 
           return;
        }else {
            ArrayList<Integer> new_permutation = 
                new ArrayList<Integer>(permutation);
            ArrayList<Integer> new_remain_num = 
                new ArrayList<Integer>(remain_num);
            new_permutation.add(unique_num[i]);
            new_remain_num.remove(unique_num[i]);
            recurSolve(collections, new_permutation, new_remain_num, 0);
        }
        if(i == unique_num.length-1) {
            return;
        }else {
            recurSolve(collections, permutation, remain_num, i+1);
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

public class PermuteUnique{
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{},{1},{1,1,2},{3,3,5,5,5,4}};
        //int[][] B = {{}};



        for(int i = 0; i < A.length ; i++) {
                sol.printAL2(sol.permuteUnique(A[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
