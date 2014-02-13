class Solution {
    int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return null;
        int i, len = digits.length; 
        int[] B = new int[len+1]; 
        System.arraycopy(digits,0,B,1,len);
        B[len] = B[len]+1; 
        for(i = len;i >= 1;i--) {
            if(B[i] == 10) {
                B[i] = 0;
                B[i-1] = B[i-1] + 1;
            }else break;
        }
        if(B[0] == 0) {
            int[] C = new int[len];
            System.arraycopy(B,1,C,0,len);
            return C;
        }else return B;
    }
    void print(int[] A) {
        for(int i = 0; i < A.length; i++) {
            System.out.print(A[i]+" ");
        }
        System.out.println();
    }
}
public class PlusOne {
    public static void main(String[] args) {
        //int[] A = {1,9,9,9};
        //int[] A = {9};
        //int[] A = {0,0,1};
        //int[] A = {1,9,8,9};
        int[] A = {9,9,9,9};
        Solution sol = new Solution();
        sol.print(sol.plusOne(A));
    }
}

        
