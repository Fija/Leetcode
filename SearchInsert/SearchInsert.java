class Solution {
    int searchInsert(int[] A, int target) {
        if (A == null) return 0;
        int middle, end = A.length-1, start = 0;
        if (target > A[end]) return end+1;
        if (target < A[start]) return 0;
        if (target == A[start]) return start;
        if (target == A[end]) return end;
        while (true) {
            middle = start + (end - start)/2;
            if (middle == start) {
                return start+1;
            }else {
                if (target == A[middle]) return middle;
                if(target < A[middle]) {
                    end = middle;
                }else {
                    start = middle;
                }
            }
        }
    }
}

public class SearchInsert {
    public static void main(String[] args) {
        //int[] A = {1,3,5,6};
        int[] A = {1};
        int[] target={5,2,7,0};
        int i;
        Solution sol = new Solution();
        for (i = 0; i < target.length; i++) {
            System.out.println(sol.searchInsert(A,target[i]));
        }
        System.out.println(sol.searchInsert(null,target[1]));
    }
}

