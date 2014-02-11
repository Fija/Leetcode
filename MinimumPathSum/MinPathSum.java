import java.util.*;
class TreeNode {
    int row, col, val;
    TreeNode left, right;
    TreeNode(int x, int y, int z){
        val = x;
        row = y;
        col = z;
    }
}

class Solution {
    int StupidBFSminPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int i, min, len, m = grid.length, n = grid[0].length;
        ArrayList<Integer> path = new ArrayList<Integer>();
        TreeNode node = new TreeNode(grid[0][0],0,0);
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        System.out.println(m+" "+n);
        queue.offer(node);
        for(;;) {
            try {
                node = queue.removeFirst();
            }catch(Exception ex) {
                break;
            }
            if(node.row < m-1) {
                node.left = new TreeNode(node.val + 
                                grid[node.row+1][node.col],
                                node.row+1,node.col);
                queue.offer(node.left);
            }
            if(node.col < n-1) {
                node.right = new TreeNode(node.val + 
                                grid[node.row][node.col+1],
                                node.row,node.col+1);
                queue.offer(node.right);
            }
            if(node.row == m-1 && node.col == n-1) {
                path.add(node.val);
            }
        }
        min = 0x7FFFFFFF;
        len = path.size();
        for(i = 0; i < len; i++) {
            if(path.get(i) < min) {
                min = path.get(i);
            }
        }
        return min;
    }
    int LessStupidDFSminPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length, min = 0x7FFFFFFF;
        TreeNode node = new TreeNode(grid[0][0],0,0);
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(node);
        for(;;) {
            try{
                node = stack.pop();
            }catch(Exception ex) {
                break;
            }
            if(node.col < n - 1) {
                node.right = new TreeNode(node.val + 
                                 grid[node.row][node.col+1],
                                 node.row, node.col+1);
                stack.push(node.right);                                          
            }
            if(node.row < m - 1) {
                node.left = new TreeNode(node.val + 
                                grid[node.row+1][node.col],
                                node.row+1, node.col);
                stack.push(node.left);                                          
            }
            if(node.row == m - 1 && node.col == n - 1) {
                if((node.val) < min) min = node.val;
            }
        }
        return min;
    }
    int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int i, j, m = grid.length, n = grid[0].length; 
        int[][] min = new int[m][n];
        for(i = 0; i < m; i++) {
            for(j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    min[i][j] = grid[0][0];
                }else if(i == 0 && j > 0) {
                    min[i][j] = min[i][j-1]+grid[i][j];
                }else if(j == 0 && i > 0) {
                    min[i][j] = min[i-1][j]+grid[i][j];
                }else {
                    min[i][j] = Math.min(min[i-1][j], min[i][j-1])+grid[i][j];
                }
            }
        }
        return min[m-1][n-1];
    }
    void print(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.print('\n');
        }
    }
}

public class MinPathSum {
    public static void main(String[] args) {
        /*int[][] grid = {{1,2,3},
                        {3,1,5},
                        {4,2,1}};
        //int[][] grid = {{4}};
        */int[][] grid = {{7,1,3,5,8,9,9,2,1,9,0,8,3,1,6,6,9,5},{9,5,9,4,0,4,8,8,9,5,7,3,6,6,6,9,1,6},{8,2,9,1,3,1,9,7,2,5,3,1,2,4,8,2,8,8},{6,7,9,8,4,8,3,0,4,0,9,6,6,0,0,5,1,4},{7,1,3,1,8,8,3,1,2,1,5,0,2,1,9,1,1,4},{9,5,4,3,5,6,1,3,6,4,9,7,0,8,0,3,9,9},{1,4,2,5,8,7,7,0,0,7,1,2,1,2,7,7,7,4},{3,9,7,9,5,8,9,5,6,9,8,8,0,1,4,2,8,2},{1,5,2,2,2,5,6,3,9,3,1,7,9,6,8,6,8,3},{5,7,8,3,8,8,3,9,9,8,1,9,2,5,4,7,7,7},{2,3,2,4,8,5,1,7,2,9,5,2,4,2,9,2,8,7},{0,1,6,1,1,0,0,6,5,4,3,4,3,7,9,6,1,9}};
        Solution sol = new Solution();
        System.out.println(sol.minPathSum(grid));
    }
}



