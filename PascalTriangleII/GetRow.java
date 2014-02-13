import java.util.*;
class Solution {
    ArrayList<Integer> getRow(int rowIndex) {
        int i, j;
        ArrayList<Integer> A = new ArrayList<Integer>(); 
        for(i = 0; i <= rowIndex; i++) {
            A.add(0);
        }
        A.set(0,1);
        if(rowIndex == 0) {
            return A;
        }
        A.set(1,1);
        if(rowIndex == 1) {
            return A;
        }
        for(i = 2; i <= rowIndex; i++) {
            A.set(i, 1);
            for(j = i-1; j > 0; j--) {
                A.set(j, A.get(j)+A.get(j-1));
            }
        }
        return A;
    }
    void print(ArrayList<Integer> A) {
        for(int i = 0; i < A.size(); i++) {
            System.out.print(A.get(i)+" ");
        }
        System.out.println();
    }
}
public class GetRow {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.print(sol.getRow(5));
    }
}
    
