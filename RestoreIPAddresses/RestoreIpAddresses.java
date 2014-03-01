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
    ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> collection = new ArrayList<String>();
        String address = "";
        recurSolve(collection, s, address, 0, 1, 1);
        return collection;
    }
    void recurSolve(ArrayList<String> collection, String s,
                    String address, int i, int j, int k) {
        String new_address = address;
        if(s.length()-i >= 4-j + k && s.length()-i <= 3*(4-j) + k &&
           !(k == 3 && Integer.parseInt(s.substring(i, i+3)) > 255) &&
           !(k > 1 && s.charAt(i) == '0')) {
            new_address = address + s.substring(i, i+k) + ".";
            if(j == 4) {
                new_address = new_address.substring(
                        0, new_address.length()-1);
                collection.add(new_address);
            }else {
                recurSolve(collection, s, new_address, i+k, j+1, 1);
            }
        }
        if(k < 3) {
            recurSolve(collection, s, address, i, j, k+1);
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

    void printAL(ArrayList<String> A) {
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

public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {"010010","0000","","2552555552","777777777777",
                      "111","25525511135"};
        //int[][] B = {{}};



        for(int i = 0; i < A.length ; i++) {
            sol.printAL(sol.restoreIpAddresses(A[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
