class Solution { 
    int trap(int[] A) {
        if(A == null || A.length < 3) return 0;
        int idx_current_max=0, current_max, i, tank, water, len = A.length; 
        current_max = 0;
        i = 0;
        tank = 0;
        water = 0;
        while(true) {
            if(A[i] >= current_max) {
        //        System.out.println(i+" "+A[i]+" "+current_max+" "+
        //                           tank+" "+water+" "+idx_current_max);
                tank += water;
                water = 0;
        //        if(isExtrema(A, i)) {
                    current_max = A[i];
                    idx_current_max = i;
        //        }
            }else {
                water += current_max-A[i];
            }
            i += 1;
            if(i == len) break;
        }
        i = len - 1;
        water = 0;
        current_max = 0;
        while(true) {
//            System.out.println(i+" "+A[i]+" "+current_max+" "+
//                               tank+" "+water+" "+idx_current_max);
            if(A[i] >= current_max) {
                tank += water;
                water = 0;
                //if(isExtrema(A, i)) {
                    current_max = A[i];
                //}
            }else {
                water += current_max-A[i];
            }
            i -= 1;
            if(i == idx_current_max-1) break;
        }
        return tank;
    }
    boolean isExtrema(int[] A, int i) {
        if(i == 0 && A[1] < A[0]) {
            return true;
        }else if(i == A.length-1 && A[A.length-2] < A[A.length-1]) {
            return true;
        }else if(i != 0 && i != A.length-1 &&
                 A[i] > A[i-1] && A[i] > A[i+1]) {
            return true;
        }else {
            return false;
        }
    }
}
public class Trap {
    public static void main(String[] args) {
        int[][] A = {{0,1,0,2,1,0,1,3,2,1,2,1},{0,0,0},{1,2,3},{3,2,1},
                     {0,1,0,3,0,1,0,3,0,0,0,1},{1,0,1,0,1,0},
                     {5,5,1,7,1,1,5,2,7,6}};
        Solution sol = new Solution();
        for(int k = 0; k < A.length; k++) {
            System.out.println(sol.trap(A[k]));
        }
    }
}






