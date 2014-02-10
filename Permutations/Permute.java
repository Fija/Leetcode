import java.util.*;
class Solution {
    ArrayList<ArrayList<Integer>> permute(int[] num) {
        if(num == null) return null;

        int i, j, k, l, idx, val, n = num.length;
        int[] FAC = {1,1,2,6,24,120,720,5040,40320,362880,3628800,39916800,
                     479001600};
        ArrayList<ArrayList<Integer>> A =
            new ArrayList<ArrayList<Integer>>(FAC[n]); 
        ArrayList<ArrayList<Integer>> remain =
            new ArrayList<ArrayList<Integer>>(FAC[n]); 

        if(n == 0) return A;
        for(i = 0; i < FAC[n]; i++) {
            A.add(new ArrayList<Integer>(n));
            remain.add(new ArrayList<Integer>(n));
            for(j = 0; j < n; j++) {
                remain.get(i).add(num[j]);
            }
        }
        for(i = 0;i < n;i++) {
            for(j = 0;j < FAC[n]/FAC[n-i]; j++) {
                for(k = 0; k < n-i; k++ ) {
                    for(l = 0; l < FAC[n-i-1]; l++) {
                        idx = j*FAC[n-i]+k*FAC[n-i-1]+l;
                        val = remain.get(idx).get(k);
                        A.get(idx).add(val);
                        remain.get(idx).remove(k);
                    }
                }
            }
        }
        return A;
    }
    void print(ArrayList<ArrayList<Integer>> A) {
        if (A == null || A.size() == 0) return;

        int i, j, row = A.size(), col = A.get(0).size();
        System.out.print(row+ "\n");
        
        for(i = 0; i < row; i++) {
            for(j = 0; j < col; j++) {
                System.out.print(A.get(i).get(j)+" ");
            }
            System.out.print('\n');
        }
        
    }
}

public class Permute {
    public static void main(String[] args) {
        //int[] A = {2,1,3,4,5,6,7,8,9,10};
        //int[] A = {2,4,3};
        int[] A = {15,51};
        Solution sol = new Solution();
        sol.print(sol.permute(A));
    }
}





           
