import java.util.*;
class Solution {
    ArrayList<Integer> grayCode(int n) {
        //121312141213121
        int i, j, max = (int)Math.pow(2,n);
        int[] A = new int[max];
        int[] B = new int[max];
        ArrayList<Integer> C = new ArrayList<Integer>();
        for(j = 0; j < n; j++) {
            i = (int)Math.pow(2,j);
            A[i] = j;
            System.arraycopy(A,1,A,i+1,i-1);
        }
        for(i = 1; i < max; i++) {
            B[i] = B[i-1];
            B[i] = B[i] ^ (int)Math.pow(2,A[i]);
        }
        for(i = 0; i < max; i++) {
            C.add(B[i]);
        }
        return C;
    }
    void print(ArrayList<Integer> B) {
        for(int i = 0; i < B.size(); i++) {
            System.out.print(B.get(i)+" ");
        }
        System.out.print('\n');
    }
}

public class GrayCode {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.print(sol.grayCode(3));
    }
}





