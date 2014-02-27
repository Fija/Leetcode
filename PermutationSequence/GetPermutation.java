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
    String getPermutation(int n, int k) {
        int i, num, rank;
        ArrayList<Integer> remain = new ArrayList<Integer>();
        for(i = 0; i < n; i++) remain.add(i+1);
        int[] fac = {1,1,2,6,24,120,720,5040,40320,362880,3628800};
        String s ="";
        if(k > fac[n]) return s;
        for(i = 0; i < n; i++) {
            rank = (k-1) / fac[n-i-1];
            num = remain.get(rank);
            s = s+num;
            remain.remove((Integer)num);
            k = k - rank * fac[n-i-1];
        }
        return s;
    }

    String StupidGetPermutation(int n, int k) {
        ArrayList<Integer> remain = new ArrayList<Integer>();
        String s = "";
        String[] ans = new String[1];
        ans[0] = "";
        int[] count = new int[1];
        int i;
        for(i = 0; i < n; i++) {
            remain.add(i+1);
        }
        recurSolve(ans,count, s, remain, k, n, 0);
        return ans[0];
    }
    void recurSolve(String[] ans, int[] count, String s,
                    ArrayList<Integer> remain, int k, int n, int i) {
        String new_s = new String(s);
        ArrayList<Integer> new_remain = new ArrayList<Integer>(remain); 

        new_s = s + remain.get(i);
        if(new_s.length() == n) {
            count[0]+= 1;
            if(count[0] == k) {
                ans[0] = new_s;
                return;
            }
        }else {
            new_remain.remove(remain.get(i));
            recurSolve(ans, count, new_s, new_remain, k, n, 0);
        }
        if(i != remain.size()-1) {
            recurSolve(ans, count, s, remain, k, n, i+1);
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

public class GetPermutation  {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] A = {3,1};
        int[][] B = {{2,6,7},{1,2}};



        for(int i = 0; i < A.length ; i++) {
            for(int j = 0; j < B[i].length; j++) {
            System.out.println(sol.getPermutation(A[i],B[i][j]));
        }
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
