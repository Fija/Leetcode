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
    ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> collection = 
            new ArrayList<ArrayList<Integer>>();

        int[] s_num = Arrays.copyOf(num, num.length);
        Arrays.sort(s_num);
        Integer[] sorted_num = new Integer[num.length];
        for(int i = 0; i < num.length; i++) sorted_num[i] = s_num[i];

        ArrayList<Integer> remain = 
            new ArrayList<Integer>(Arrays.asList(sorted_num));
        ArrayList<Integer> combination = new ArrayList<Integer>(); 

        int idx = Collections.binarySearch(remain, target);
        if(idx < 0) idx = -idx-2;
        if(idx < 0) {
            return collection;
        }else {
            remain.subList(idx+1, remain.size()).clear();
            recurSolve(collection, target, 0, combination, remain);
        }
        return collection;
    }
    void recurSolve(ArrayList<ArrayList<Integer>> collection, int target,
               int k, ArrayList<Integer> combination, ArrayList<Integer> remain) {

        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>(remain);
        Integer[] unique = set.toArray(new Integer[set.size()]);
        ArrayList<Integer> new_remain = new ArrayList<Integer>(remain);
        ArrayList<Integer> new_combination =new ArrayList<Integer>(combination);

        new_combination.add(unique[k]);
        if(unique[k] == target) {
            collection.add(new_combination);
        }else {
            new_remain.subList(0, new_remain.indexOf(unique[k])+1).clear();
            if(new_remain.size() > 0){
                int idx = Collections.binarySearch(new_remain, target-unique[k]);
                if(idx < 0) idx = -idx-2;
                if(idx >= 0) {
                    new_remain.subList(idx+1, new_remain.size()).clear();
                    recurSolve(collection, target-unique[k], 0,
                            new_combination, new_remain);
                }
            }
        }
        if(k == unique.length-1) {
            return;
        }else {
            recurSolve(collection, target, k+1, combination, remain);
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

public class CombinationSum2 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] A = {{},{},{2},{2,2,2},{10,1,2,7,6,1,5}};
        int[][] B = {{},{1},{},{4},{8,10,12,32}};



        for(int i = 0; i < A.length ; i++) {
            for(int j = 0; j < B[i].length; j++) {
            sol.printAL2(sol.combinationSum2(A[i], B[i][j]));
            }
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
