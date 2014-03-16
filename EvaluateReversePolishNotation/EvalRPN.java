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
    int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token : tokens) {
            try {
                Integer num = Integer.parseInt(token);
                stack.push(num);
            }catch(Exception e) {
                Integer operandTwo = stack.pop();
                Integer operandOne = stack.pop();
                Integer num;
                if(token.equals("+")) {
                    num = operandOne + operandTwo;
                }else if(token.equals("-")) {
                    num = operandOne - operandTwo;
                }else if(token.equals("*")) {
                    num = operandOne * operandTwo;
                }else {
                    num = operandOne / operandTwo;
                }
                stack.push(num);
            }
        }
        return stack.pop();
    }
    /*why it doesn't work?
    int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for(String token : tokens) {
            try {
                Integer num = Integer.parseInt(token);
                stack.push(num);
            }catch(Exception e) {
                try {
                    Integer operandOne = stack.pop();
                    Integer operandTwo = stack.pop();
                    Integer num;
                    if(token.equals("+")) {
                        num = operandOne + operandTwo;
                    }else if(token.equals("-")) {
                        num = operandOne - operandOne;
                    }else if(token.equals("*")) {
                        num = operandOne * operandOne;
                    }else {
                        num = operandOne / operandOne;
                    }
                    stack.push(num);
                }catch(Exception f){
                    throw new Exception("Invalid Expression");
                }
            }
        }
        return stack.pop();
    }
    */

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

public class EvalRPN {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] A = {{"4","13","5","/","+"},{"2","1","+","3","*"}};
        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.evalRPN(A[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
