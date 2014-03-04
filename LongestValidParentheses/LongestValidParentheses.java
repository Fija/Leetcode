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
    int longestValidParentheses(String s) {
        if(s == null) return 0;
        int  max=0, i=0;
        Integer[] cur, pre;
        Stack<Integer[]> stack = new Stack<Integer[]>();
        while(i < s.length()) {
            if(s.charAt(i) == ')' && !stack.empty()) {
                cur = stack.peek();
                if(cur[0] == 0) {
                    stack.pop();
                }else {
                    cur[0] -= 1;
                    cur[1] += 2;
                    if(cur[1] > max) max = cur[1];
                    if(cur[0] == 0) {
                        stack.pop();
                        if(!stack.empty()) {
                            pre = stack.peek();
                            pre[1] = pre[1] + cur[1];
                            if(pre[1] > max) max = pre[1];
                        }else {
                            stack.push(cur);
                        }
                    }
                }
            }else if(s.charAt(i) == '(') {
                if(!stack.empty() && stack.peek()[1] == 0){
                    cur = stack.peek();
                    cur[0] += 1;
                }else {
                    cur = new Integer[]{1,0};
                    stack.push(cur);
                }
            }
            i += 1;
        }
        return max;
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

public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {"(()(((()",")()(","))))","(",")",
                      "","()))()(((())()((","(()",")()())"};
        //int[][] B = {{}};



        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.longestValidParentheses(A[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
