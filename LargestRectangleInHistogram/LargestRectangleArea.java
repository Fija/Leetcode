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
    public int largestRectangleArea(int[] height) {
        if(height == null) return 0;
        Integer len = height.length, idx, start, area, max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        idx = stack.peek();
        for(int i = 0; i <= len; i++) {
            //The key point is when height[i] == height[idx], we renew it to 
            //new place but do not calculate its area
            while(idx != null &&
                 (i == len || height[i] <= height[idx])) {
                idx = stack.pop();
                if(stack.isEmpty()) {
                    area = height[idx] * i;
                }else {
                    start = stack.peek();
                    area = height[idx] * (i-start-1);
                }
                if(area > max) {
                    max = area;
                }
                idx = stack.peek();
            }
            stack.push(i);
            idx = stack.peek();
        }
        return max;
    }
    int anotherVersionOflargestRectangleArea(int[] height) {
        if(height == null) return 0;
        Integer len = height.length, idx, start, area, max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i <= len; i++) {
            idx = stack.peek();
            //The key point is when height[i] == height[idx], we renew it to 
            //new place but do not calculate its area
            if(i == len || idx != null && height[i] <= height[idx]) {
                while(!stack.isEmpty()) {
                    idx = stack.peek();
                    if(i == len || height[i] < height[idx]) {
                        stack.pop();
                        if(stack.isEmpty()) {
                            area = height[idx] * i;
                        }else {
                            start = stack.peek();
                            area = height[idx] * (i-start-1);
                        }
                        if(area > max) {
                            max = area;
                        }
                    }else {
                        break;
                    }
                }
            }
            stack.push(i);
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

public class LargestRectangleArea {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{4,2,0,3,2,5},{3,3,2,3,3},{4,3,2,1,0,4,8,10,1,0,7,8},
                     {4},{0,1,2,3,4},{0},{},{4,3,2,1,0},{2,1,5,6,2,3}};

        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.largestRectangleArea(A[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
