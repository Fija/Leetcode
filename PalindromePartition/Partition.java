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
    ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> collection = 
            new ArrayList<ArrayList<String>>();
        if(s == null || s.length() == 0) return collection;
        ArrayList<String> partition = new ArrayList<String>();
        //using ArrayList may reduce the memory
        int len = s.length();
        int[][] isPa = new int[len][len];
        for(int k = 0; k < len; k ++) {
            for(int i= 0; i < len-k ; i++) {
                if(k == 0) {
                    isPa[k][i] = 1;
                }else if(k == 1) {
                    isPa[k][i] = s.charAt(i) == s.charAt(i+k)? 1:0;
                }else {
                    isPa[k][i] = (s.charAt(i) == s.charAt(i+k)? 1:0)*
                                 isPa[k-2][i+1];
                }
            }
        }
        recurSol(collection,partition,s,isPa,0,0);
        return collection; 
    }
    void recurSol(ArrayList<ArrayList<String>> collection,
                  ArrayList<String> partition, String s,
                  int[][] isPa, int k, int i) {
        ArrayList<String> new_partition = new ArrayList<String>(partition);
        if(isPa[k][i] == 1) {
            new_partition.add(s.substring(i, i+k+1));
            if(i+k == s.length()-1) {
                collection.add(new_partition);
                return;
            }else {
                recurSol(collection, new_partition, s, isPa, 0, i+k+1);
            }
        }
        if(i+k == s.length()-1) {
            return;
        }else {
            recurSol(collection, partition, s, isPa, k+1, i);
        }
    }



//        System.out.print();

//        System.out.println();

    void printAL2(ArrayList<ArrayList<String>> A) {
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

public class Partition {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {"","a","ab","aaa"};
        //int[][] B = {{}};



        for(int i = 0; i < A.length ; i++) {
            sol.printAL2(sol.partition(A[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
