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
    int threeSumClosest(int[] num, int target) {
        if(num == null || num.length == 0) return 0;
        if(num.length <= 2) {
            int s = 0;
            for(int i = 0; i < num.length; i++) s += num[i];
            return s;
        }

        Integer[] sorted_num = new Integer[num.length];
        for(int i = 0; i < num.length; i++) sorted_num[i] = num[i];
        Arrays.sort(sorted_num);

        int sum, i, j, k, closest_sum = sorted_num[0]+sorted_num[1]+sorted_num[2];
        if(closest_sum == target) return target;

        for(i =0 ; i < num.length-2 ; i++) {
            j = i + 1;
            k = num.length-1;
            for(;j < k;) {
                sum = sorted_num[i] + sorted_num[j] + sorted_num[k];
                if(Math.abs(sum-target) < Math.abs(closest_sum-target)) {
                    closest_sum = sum;
                    if(closest_sum == target) return target;
                }
                if(sum > target) {
                    k -= 1;
                }else {
                    j += 1;
                }
            }
        }
        return closest_sum;
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

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[][] A = {{},{3,4,1,2,5},{-1,2,1,-4}};
        int[][] B = {{1},{9,18,1},{1,0,4,-4}};
        Solution sol = new Solution();


        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B[i].length ; j++) {
                System.out.println(sol.threeSumClosest(A[i],B[i][j]));
            }
            
        }
    }
}
