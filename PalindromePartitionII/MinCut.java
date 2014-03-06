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
    int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        int i, j, len = s.length();
        int[] mC = new int[len];
        boolean[][] isPa = new boolean[len][len];
        for(i = 0; i < len; i++) {
            isPa[i][0] = true;
        }
        for(i = 0; i < len-1; i++) {
            isPa[i][1] = s.charAt(i) == s.charAt(i+1);
        }
        for(j =2; j < len; j++) {
            for(i = 0; i+j < len; i++) {
                isPa[i][j] = isPa[i+1][j-2] && 
                             s.charAt(i) == s.charAt(i+j);
            }
        }
        if(isPa[0][len-1]) return 0;

        for(i = 0; i < len; i++) {
            mC[i] = isPa[0][i]? 0:min(isPa, mC, i)+1;
        }
        return mC[len-1];
    }
    int min(boolean[][] isPa, int[] mC, int i) {
        int k, min = i;
        for(k = 0; k < i; k++) {
            if(isPa[k+1][i-k-1]) {
                if(mC[k] < min) min = mC[k];  
            }
        }
        return min;
    }
    
    int StupidN3minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        int i, j, len = s.length();
        int[][] mC = new int[len][len];
        boolean[][] isPa = new boolean[len][len];
        for(i = 0; i < len; i++) {
            isPa[i][0] = true;
        }
        for(i = 0; i < len-1; i++) {
            isPa[i][1] = s.charAt(i) == s.charAt(i+1);
        }
        for(j =2; j < len; j++) {
            for(i = 0; i+j < len; i++) {
                isPa[i][j] = isPa[i+1][j-2] && 
                             s.charAt(i) == s.charAt(i+j);
            }
        }
        if(isPa[0][len-1]) return 0;
        for(i = 0; i < len; i++) {
            mC[i][0] = 0;
        }
        for(j = 0; j < len; j++) {
            for(i = 0; i+j < len; i++) {
                mC[i][j] = isPa[i][j]? 0:Stupidmin(mC, i, j)+1;
            }
        }
        return mC[0][len-1];
    }
    int Stupidmin(int[][] mC, int i, int j) {
        int k, min = j, sum = 0;
        for(k = 0; k < j; k++) {
            sum = mC[i][k] + mC[i+k+1][j-k-1];
            if(sum < min) min = sum;  
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

public class MinCut {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {"","a","abaca","abbcdedggdex","aab"};
        //int[][] B = {{}};



        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.minCut(A[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
