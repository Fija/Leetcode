class Solution {
    boolean search(int[] A, int target) {
        int idx;
        int pivot = newSearchPivot(A);
        //int pivot = A[0] < A[A.length-1]?
        //            A.length-1 : searchPivot(A,0,A.length-1);
        if(target >= A[0]) {
            idx = binarySearch(A,0,pivot,target);
        }else {
            if(pivot == A.length-1) {
                return false;
            }else
            idx = binarySearch(A,pivot+1,A.length-1,target);
        }
        if(idx == -1) return false;
        else return true;
    }
    int searchPivot(int[] A, int left, int right) {
        int mid = (left + right)/2;
        if(mid == left || A[mid] > A[mid-1] && A[mid] > A[mid+1]) {
            return mid;
        }else if(A[mid] >= A[0]) {
            return searchPivot(A, mid, right);
        }else {
            return searchPivot(A, left, mid);
        }
    }
    int newSearchPivot(int[] A) {
        int i = 0, len = A.length, pivot = len-1;
        for(;i < len-1; i++) {
            if (A[i+1] < A[i]) {
                pivot = i;
            }
        }
        return pivot;
    }
    int binarySearch(int[] A, int left, int right, int target) {
        if(target > A[right] && target < A[left] ) {
            return -1;
        }else if(target == A[right]){
            return right;
        }else if( target == A[left]) {
            return left;
        }else {
            return recurBinary(A, left, right, target);
        }
    }
    int recurBinary(int[] A, int left, int right, int target) {
        int mid = (left + right)/2;
        if(mid == left) {
            return -1;
        }else if (A[mid] == target) {
            return mid;
        }else if (A[mid] < target) {
            return recurBinary(A, mid, right,target);
        }else{
            return recurBinary(A, left, mid,target);
        }
    }
}

public class SearchII {
    public static void main (String[] args) {
        int[][] A = {{0,5,5,5,5,5,5},{4,5,6,0,0,4,4},{0},{10,20,10},{20,0,20},
                     {6,7,8,0,1,3,5},{7,8,8,2,3,4,5,6},{8,1,2,3,4,8,8,8},
                     {1,1,1,1,1,3,1,1,1,1},{1,1,3,1},{1,1,1,1},{1,3},{2,2,2,0,1}};
        int[][] target = {{-1,0,4,5},{3,4,6,7,0,2},{-1,0,1},{-10,10,20,30},
                        {-10,20,0,10,30},{-1,6,7,8,0,1,5,9},{7,8,1,2,6,9},
                        {0,1,2,3,7,8,9},{0,1,2,3,4},{0,1,2,3,4},{0,1,2},{0,1,2,3,4},
                        {-1,0,1,2,3}};
        Solution sol = new Solution();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < target[i].length; j++) {
                //if(i == 11 && j == 3)
                //System.out.println(sol.newSearchPivot(A[i]));
                if(sol.search(A[i],target[i][j])) {
                    System.out.print("T ");
                }else {
                    System.out.print("F ");
                }
            }
            System.out.println();
        }
    }
}



        
