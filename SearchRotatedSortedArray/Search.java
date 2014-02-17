class Solution {
    int search(int[] A, int target) {
        int idx;
        int pivot = A[0] < A[A.length-1]?
                    A.length-1 : searchPivot(A,0,A.length-1);
        //System.out.println(pivot);
        if(target >= A[0]) {
            idx = binarySearch(A,0,pivot,target);
        }else {
            if(pivot == A.length-1) {
                return -1;
            }else
            idx = binarySearch(A,pivot+1,A.length-1,target);
        }
        return idx;
    }
    int searchPivot(int[] A, int left, int right) {
        int mid = (left + right)/2;
        if(mid == left || A[mid] > A[mid-1] && A[mid] > A[mid+1]) {
            return mid;
        }else if(A[mid] > A[0]) {
            return searchPivot(A, mid, right);
        }else {
            return searchPivot(A, left, mid);
        }
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

public class Search {
    public static void main (String[] args) {
        int[][] A = {{0,1,2,4,5,6,7},{4,5,6,7,0,1,2},{0},{10,20,0},{20,0,10},
                     {6,7,8,0,1,3,5},{7,8,1,2,3,4,5,6},{8,1,2,3,4,5,6,7}};
        int[][] target = {{-1,0,4,7,8},{3,4,6,7,0,2,8},{-1,0,1},{-10,10,20,0,1},
                        {-10,20,0,10,30},{-1,6,7,8,0,1,5,9},{0,7,8,1,2,6,9},
                        {0,1,2,3,7,8,9}};
        Solution sol = new Solution();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < target[i].length; j++) {
                //if(i == 7 && j == 3)
                //System.out.print(sol.search(A[i],target[i][j])+" i: "+i+" ");
                System.out.print(sol.search(A[i],target[i][j])+" ");
            }
            System.out.println();
        }
    }
}



        
