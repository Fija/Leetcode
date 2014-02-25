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
     //This is a unfinished better N^2(log(N)) solution
     /*

    ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> collection = 
            new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> solution;
        if(num == null || num.length <= 3) return collection;
        int i,j,k,l,sum = 0,len = num.length;

        Integer[] sorted = new Integer[len];
        for(i = 0; i < len; i++) sorted[i] = num[i];
        Arrays.sort(sorted);

        ArrayList<Integer[]> indices;

        for(i = 0; i < len-1; i++) {
            for(j = i+1; j < len; j++) {
                sum = sorted[i]+sorted[j];
                Integer[] idx = {i, j};
                if(!map.containsKey(sum)) {
                    indices = new ArrayList<Integer[]>();
                }else {
                    indices = map.get(sum);
                }
                idices.add(idx);
                map.put(sum, indices);
            }
        }
        for(i = 0; i < len-1; i++) {
            for(j = i+1; j < len; j++) {
                sum = sorted[i]+sorted[j];
                Integer[] idx = {i, j};
                if(map.containsKey(target - sum)) {
                    indices = map.get(target- sum);
                    for(k = 0; k = 
                    */
                    

    ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> collection = 
            new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> solution;
        if(num == null || num.length <= 3) return collection;
        int i,j,k,l,sum = 0,len = num.length;

        Integer[] sorted = new Integer[len];
        for(i = 0; i < len; i++) sorted[i] = num[i];
        Arrays.sort(sorted);

        for(i = 0 ;i < len-3;i++) {
            if(i > 0 && sorted[i].equals(sorted[i-1])) continue;
            for(j = i+1 ;j < len-2;j++) {
                if(j > i+1 && sorted[j].equals(sorted[j-1])) continue;
                k = j+1;
                l = len-1;
                for(;k < l;) {
                    if(k > j+1 && sorted[k].equals(sorted[k-1])) {
                        k += 1;
                        continue;
                    }
                    sum = sorted[i]+sorted[j]+sorted[k]+sorted[l];
                    if(sum == target) {
                        solution = new ArrayList<Integer>();
                        solution.add(sorted[i]);
                        solution.add(sorted[j]);
                        solution.add(sorted[k]);
                        solution.add(sorted[l]);
                        collection.add(solution);
                    }
                    if(sum > target) {
                        l -= 1;
                    }else {
                        k += 1;
                    }
                }
            }
        }
        return collection;
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

public class FourSum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{-3,-1,0,2,4,5},{0,0,0,0,0,0},{1,0,-1,0,-2,2}};
        int[][] B = {{2},{0},{0,3,-1}};



        for(int i = 0; i < A.length ; i++) {
            for(int j= 0; j < B[i].length; j++) {
                sol.printAL2(sol.fourSum(A[i],B[i][j]));
            }
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
