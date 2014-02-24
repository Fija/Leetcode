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
    int jump(int[] A) {
        if(A == null || A.length == 0) return -1;
        if(A.length == 1) return 0;
        int right = 0, new_right = 0, step = 0;
        for(int i = 0;;i++) {
           if(i+A[i] > new_right) {
              new_right = i+A[i];
              if (new_right >= A.length-1) {
                 return step +1;
              }
           }
           if(i == right) {
               if(right == new_right) {
                   return -1;
               }else {
                   step += 1;
                   right = new_right;
               }
           }
        }
    }
    int stupidJump(int[] A) {
        if(A == null || A.length == 0) return -1;
        int len = A.length, temp;
        if(!hasSolution(A)) {
           return -1;
        }else { 
            final int INF = 0x7FFFFFFF; 
            int[][] min = new int[len][len];
            for(int i = 0; i < len ; i++) {
                for(int j = 0; j < len-i ; j++) {
                    if(i == 0) {
                        min[i][j] = 0;
                    }else {
                        if(A[j] >= i) {
                            min[i][j] = 1;
                        }else {
                            min[i][j] = INF;
                            for(int k = 1; k <= A[j]; k++) {
                                if(min[k][j] < INF && min[j+k][i-k] < INF) {
                                    temp = min[k][j]+min[i-k][j+k];
                                    if(temp < min[i][j]) min[i][j] = temp;
                                }
                            }
                        }
                    }
                    if(i == len-1) break;
                }
            }
            if(min[len-1][0] == INF) return -1;
            else return min[len-1][0];
        }
    }
    boolean hasSolution(int[] A) {
        int max = 0; 
        for(int i = 0;i <= max;i++) {
            if(max >= A.length-1 ) {
                return true;
            }else if(A[i] + i > max) {
                max = A[i] + i;
            }
        }
        return false;
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

public class Jump {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{0,1},{1},{0},{},{2,3,1,1,4},{2,0,0,0,4},{4,1,1,1}};
        //int[][] B = {{}};



        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.jump(A[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
