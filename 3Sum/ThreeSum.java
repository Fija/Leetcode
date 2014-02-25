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
    ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> collection = 
            new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> solution;
        if(num == null || num.length <= 2) return collection;
        int i, j, k, sum, len = num.length;
        Integer[] sorted_sum = new Integer[len];
        for(i = 0; i < len; i++) sorted_sum[i] = num[i];
        Arrays.sort(sorted_sum);

        for(i = 0; i < len-2; i++) {
            if(i > 0 && sorted_sum[i] == sorted_sum[i-1]) continue;
            j = i +1;
            k = len-1;
            for(;j < k;) {
                if(j > i+1 && sorted_sum[j] == sorted_sum[j-1]) {
                    j+= 1;
                    continue;
                }
                sum = sorted_sum[i]+sorted_sum[j]+sorted_sum[k];
                if(sum == 0) {
                    solution = new ArrayList<Integer>();
                    solution.add(sorted_sum[i]);
                    solution.add(sorted_sum[j]);
                    solution.add(sorted_sum[k]);
                    collection.add(solution);
                }
                if(sum > 0) {
                    k -= 1;
                }else {
                    j += 1;
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

public class ThreeSum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{0,0,0,0,0},{3,1,-4},{-1,-1,-1,-1,0,1},{-1,0,1,2,-1,-4}};
        //int[][] B = {{}};



        for(int i = 0; i < A.length ; i++) {
            sol.printAL2(sol.threeSum(A[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}

