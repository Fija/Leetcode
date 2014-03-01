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
    String multiply(String num1, String num2) {
        String temp, product,cur_val = "",pre_val = "";
        if(num1.length() < num2.length())
            {temp = num1;num1 = num2;num2 = temp;}
        int len1 = num1.length(), len2 = num2.length(), i, j;
        for(i = 0; i < len2; i++) {
            product = multiplyOne(num1, num2, i);
            for(j = 0 ; j < i; j++) product = product + '0';
            cur_val = add(product, pre_val);
            pre_val = cur_val;
        }
        return cur_val;
    }
    String multiplyOne(String num1, String num2, int j) {
        int i, num, shift = 0, summand=0,len1 = num1.length(),
            len2 = num2.length();
        String digits = "";
        num = num2.charAt(len2-1-j)-'0';
        for(i = 0; i< len1; i++) {
            summand = shift + (num1.charAt(len1-1-i)-'0') * num;
            shift = summand / 10;
            digits = summand % 10 + digits;
        }
        if (shift > 0) {
            digits = shift + digits;
        }else if(summand % 10 == 0) {
            digits = "0";
        }
        return digits;
    }
    String add(String num1, String num2) {
        String temp, digits ="";
        if(num1.length() < num2.length())
            {temp = num1;num1 = num2; num2 = temp;}
        int len1 = num1.length(), len2 = num2.length(),i,sum =0,shift =0;
        for(i = 0; i < len1; i++) {
            if(i < len1 && i < len2) {
                sum = shift + (num1.charAt(len1-1-i)-'0') + 
                      (num2.charAt(len2-1-i)-'0');
            }else {
                sum = shift + (num1.charAt(len1-1-i)-'0');
            }
                shift = sum / 10;
                digits = sum % 10 + digits;
        }
        if (shift > 0) {
            digits = shift + digits;
        }else if(sum % 10 == 0) {
            digits = "0";
        }
        return digits;
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

public class Multiply {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {"2795820576851","23958233","9133","","0","78"};
        String[][] B = {{"95369034579"},{"5830"},{"0","1",""},
                        {"","1"},{"10","188"},{"1","9","36"}};



        for(int i = 0; i < A.length ; i++) {
            for(int j = 0; j < B[i].length; j++) {
            System.out.println(sol.multiply(A[i], B[i][j]));
            }
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
