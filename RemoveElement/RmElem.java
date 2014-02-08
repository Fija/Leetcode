class Solution {
    int removeElement(int[] A, int elem) {
        if (A == null) return 0;
        int i, j = 0, len = A.length, newlen = len;
        for(i = 0; i < len; i++) {
            if (A[i] == elem ) {
                newlen = newlen - 1;
            }else {
                A[j] = A[i];
                j += 1;
            }
        }
        return newlen;
    }
}
public class RmElem {
    public static void main(String[] args) {
        //int[] A = {1,2,3,3,3,2,2,4,5};
        int[] A = {3};
        int i,elem = 3;
        Solution sol = new Solution();
        System.out.println(sol.removeElement(A, elem)+"\n");
        for (i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}
   
