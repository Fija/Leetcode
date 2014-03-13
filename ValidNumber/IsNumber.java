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
    boolean isNumber(String s) {
        if(s == null) return false;
        s = s.trim();
        int i = 0, len = s.length();
        if(len == 0) return false;
        char c = s.charAt(i);
        if(c == '+' || c == '-') i++;
        boolean has_digit = false, has_decimal_point = false,
                has_exponent_part = false;
        while(i < len) {
            c = s.charAt(i);
            if(c > '9' || c < '0') {
                if(c == 'E' || c == 'e') {
                    has_exponent_part = true;
                    i++;
                    if(i == len) return false;
                    c = s.charAt(i);
                    break;
                }else if(c == '.') {
                    if(has_decimal_point) return false;
                    else has_decimal_point = true;
                }else return false;
            }else has_digit = true;
            i++;
        }
        if(!has_digit) return false;
        if(has_exponent_part) {
            if(c == '+' || c == '-') i++;
            has_digit = false;
            while(i < len) {
                c = s.charAt(i);
                if(c > '9' || c < '0') {
                    return false;
                }else has_digit = true;
                i++;
            }
        }
        return(has_digit);
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

public class IsNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {" ", " 1 ", "1 1", "abc", "1 a", " 1e1 ",
                      "","+","-","+-","+.","+.E","+.E+",".","..",".+","e1",
                      "1E+1.1","+1.1E-0","1","12","-1","-1.e+2"};
        boolean[] B = {false, true, false, false, false, true,
                      false,false,false,false,false,false,false,false,
                      false,false,false,false,true,true,true,true,true};
        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.isNumber(A[i]) == B[i]);
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
