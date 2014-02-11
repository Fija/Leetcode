class Solution {
    void sortColors(int[] A) {
        int i, len = A.length, red_idx, white_idx;
        for(i = 0, red_idx = 0, white_idx = 0; i < len; i++) {
            if(A[i] == 0) {
                if (i > 0) A[i] = A[i-1];
                if(white_idx > red_idx) {
                    A[white_idx] = 1;
                }
                A[red_idx] = 0;
                red_idx += 1;
                white_idx += 1;
            }else if(A[i] == 1) {
                if (i > 0) A[i] = A[i-1];
                A[white_idx] = 1;
                white_idx += 1;
            }
        }
    }

    void print(int[] A) {
        int i, len = A.length;
        for(i = 0; i < len; i++) {
            System.out.print(A[i]+" ");
        }
    }

}

public class SortColors {
    public static void main(String[] args) {
        //int[] A = {2,2,2,0,0,0};
        //int[] A = {0,1,2,2,2,1,0};
        //int[] A = {2,2,1,0,0,1,1,1};
        int[] A = {0,0,2,1,1};
        //int[] A = {2};
        Solution sol = new Solution();
        sol.sortColors(A);
        sol.print(A);
    }
}
       


        
        
