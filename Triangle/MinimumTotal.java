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
    int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int temp, pre_val =0, min;
        int[] path = new int[triangle.size()];
        path[0] = triangle.get(0).get(0); 
        for(int i = 1; i < triangle.size(); i++) {
            for(int j = 0; j <triangle.get(i).size(); j++) {
                temp = path[j];
                if(j == 0) {
                    path[j] = triangle.get(i).get(j) +path[j];
                }else if(j == triangle.get(i).size()-1) {
                    path[j] = triangle.get(i).get(j) + pre_val;
                }else {
                    path[j] = triangle.get(i).get(j) + Math.min(pre_val, path[j]);
                }
                pre_val = temp;
            }
        }

        min = path[0];
        for(int i = 0; i < triangle.size(); i++) {
            if(path[i] < min ) min = path[i];
        }

        return min;
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

public class MinimumTotal {
    public static void main(String[] args) {
        Solution sol = new Solution();
        //int[][] A = {{2},{3,4},{6,5,7},{4,1,8,3}};
        int[][] A = {{2},{3,4}};
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < A.length ; i++) {
            B.add(new ArrayList<Integer>());
            for(int j = 0; j < A[i].length; j++) {
                B.get(i).add(A[i][j]);
            }
        }

        sol.printAL2(B);
        System.out.println(sol.minimumTotal(B));
    }
}
