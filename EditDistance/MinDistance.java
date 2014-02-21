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
    int minDistance(String word1, String word2) {
        int m = 0, n =0;
        if(word1 != null) m = word1.length(); 
        if(word2 != null) n = word2.length();
        int[][] dist = new int[m+1][n+1];
        for(int i = 0; i <= m ; i++) {
            for(int j= 0; j <= n; j++) {
                if(i == 0 || j== 0) {
                    dist[i][j] = i == 0? j: i;
                }else {
                    dist[i][j] = min(dist[i-1][j]+1, dist[i][j-1]+1,
                                     dist[i-1][j-1] + 
                                     (word1.charAt(i-1)==word2.charAt(j-1)?
                                          0:1));
                }
            }
        }
        printAr2(dist);
        return dist[m][n];
    }
    int min(int a, int b, int c) {
        if(a < b) {
            if(a < c) return a;
            else return c;
        }else {
            if(b < c) return b;
            else return c;
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

    void printAr2(int[][] A) {
        if(A == null) return;
        for(int i = 0; i < A.length; i++) {
            for(int j= 0; j < A[i].length; j++ ) {
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
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

public class MinDistance {
    public static void main(String[] args) {
        Solution sol = new Solution();
        //int[][] A = {{}};
        //int[][] B = {{}};
        String[] A = {"","","sitting","Sunday"};
        String[] B = {"","abc","kitten", "Saturday"};

        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.minDistance(A[i],B[i]));
        }

    }
}
