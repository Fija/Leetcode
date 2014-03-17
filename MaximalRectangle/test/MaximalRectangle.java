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
    int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if(n == 0) {
            return 0;
        }
        int[][] height = getHeight(matrix);
        int[][] wrongHeight = wronggetHeight(matrix);
        for(int i = 0; i < n; i++) {
            if(!Arrays.equals(height[i], wrongHeight[i])) {
                System.out.print(i+" ");
            }
        }
        System.out.println();
        int max = 0;
        for(int j = 0; j < n; j++) {
            int area = maxArea(height[j]);
            if(area > max) {
                max = area;
            }
        }
        return max;
    }
    int[][] getHeight(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] height = new int[n][m];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int k = j;
                while(k < n && matrix[i][k] == '1') {
                    height[j][i]++;
                    k++;
                }
            }
        }
        return height;
    }


    int[][] wronggetHeight(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<List<Integer>> interval = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            interval.add(new ArrayList<Integer>());
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') {
                    if(j == 0 || matrix[i][j-1] == '0') {
                        interval.get(i).add(j);
                    }
                    if(j == n-1 || matrix[i][j+1] =='0') {
                        interval.get(i).add(j);
                    }
                }
            }
        }
        int[][] height = new int[n][m];
        for(int i = 0; i < m; i++) {
            List<Integer> intvl = interval.get(i);
            if(intvl.size() == 0) {
                continue;
            }
            int k = 0;
            for(int j = 0; j < n; j++) {
                if(j < intvl.get(k)) {
                    if(k % 2 == 0) {
                        height[j][i] = 0;
                    }else {
                        height[j][i] = intvl.get(k)-j+1;
                    }
                }else if(j == intvl.get(k)) {
                    if(k % 2 == 0) {
                        height[j][i] = intvl.get(k+1)-j+1;
                        if(intvl.get(k) == intvl.get(k+1)) {
                            k++;
                        }
                    }else {
                        height[j][i] = 1;
                    }
                    k++;
                    if(k >= intvl.size()) {
                        break;
                    }
                }
            }
        }
        return height;
    }

    int maxArea(int[] height) {
        int len = height.length;
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        Integer idx = stack.peek();
        for(int i = 1; i <= len; i++) {
            while(idx != null && (i == len || height[i] <= height[idx])) {
                Integer h = height[stack.pop()];
                if(i == len || height[i] < height[idx]) {
                    int area;
                    if(stack.size() == 0) {
                        area = h * i;
                    }else {
                        area = h * (i-1-stack.peek());
                    }
                    if(area > max) {
                        max = area;
                    }
                }
                idx = stack.peek();
            }
            if(i < len) {
                stack.push(i);
            }
            idx = stack.peek();
        }
        return max;
    }



                        
                        

    //List<List<Integer>> getInterval(

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
    char[][] genMatrix(String[] A) {
        int m = A.length;
        int n = A[0].length();
        char[][] matrix = new char[m][n];
        for(int i = 0; i < m; i++) {
            matrix[i] = A[i].toCharArray();
        }
        return matrix;
    }
        
}

public class  MaximalRectangle{
    public static void main(String[] args) {
        Solution sol = new Solution();
        Random random = new Random();
        while(true) {
            final int LEN = 8;
            char[][] grid = new char[LEN][LEN];
            for(int i = 0; i < LEN; i++) {
                for(int j = 0; j < LEN; j++) {
                    if(random.nextDouble() > 0.5) {
                        grid[i][j] = '1';
                    }else {
                        grid[i][j] = '0';
                    }
                }
            }
            int[][] height = sol.getHeight(grid);
            int[][] wrongHeight = sol.wronggetHeight(grid);
            boolean isDiff = false;
            for(int i = 0; i < LEN; i++) {
                if(!Arrays.equals(height[i], wrongHeight[i])) {
                    isDiff = true;
                    break;
                }
            }
            if(isDiff) {
                for(int i = 0; i < LEN; i++) {
                    for(int j = 0; j < LEN; j++) {
                        System.out.print(grid[i][j]+" ");
                    }
                    System.out.println();
                }
                break;
            }
        }

        String[][] A ={{"00010111",
                        "01100101",
                        "10111101",
                        "00010000",
                        "00100010",
                        "11100111",
                        "10011001",
                        "01001100",
                        "10010000"},
                       {""},{"0"},{"1"},{"10"},{"0","1"},
                       {"01110000",
                        "01111000",
                        "00110010",
                        "00111101",
                        "01111111",
                        "00110000",
                        "11111111",
                        "00000000"}};
        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.maximalRectangle(sol.genMatrix(A[i])));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
