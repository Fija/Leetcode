import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> triangle =
            new ArrayList<ArrayList<Integer>>();
        if (numRows == 0) return triangle;
        ArrayList<Integer> top = new ArrayList<Integer>(); 
        ArrayList<Integer> level;
        int i, j;
        top.add(1);
        triangle.add(top);
        for(j = 1; j < numRows; j++) {
            level = new ArrayList<Integer>(j+1);
            level.add(1);
            for(i = 1; i < j; i++) {
                level.add(triangle.get(j-1).get(i-1) + 
                          triangle.get(j-1).get(i));
            }
            level.add(1);
            triangle.add(level);
        }
        return triangle;
    }

    void printTriangle(ArrayList<ArrayList<Integer>> triangle) {
        int i, j, n = triangle.size();
        for(i = 0; i < n; i++) {
            for(j = 0; j <= i; j++) {
                System.out.print(triangle.get(i).get(j));
            }
            System.out.print('\n');
        }
    }
}
public class Generate {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 0;
        ArrayList<ArrayList<Integer>> triangle;
        triangle = sol.generate(n);
        sol.printTriangle(triangle);
    }
}
