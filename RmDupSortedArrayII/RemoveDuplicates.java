import java.util.*;
class Solution {
    int removeDuplicates(int[] A) {
        if(A == null || A.length == 0) return 0;
        int i, j, idx, len = A.length;
        ArrayList<Integer> B = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(i = 0; i < len; i ++) {
            if(!map.containsKey(A[i])) {
                map.put(A[i],1);
                B.add(A[i]);
            }else if(map.get(A[i]) == 1) {
                map.put(A[i],2);
            }
        }
        idx = 0;
        for(i = 0; i < B.size(); i++) {
            for(j = 0; j < map.get(B.get(i)); j++) {
                A[idx] = B.get(i);
                idx += 1;
            }
        }
        return idx;
    }
    void print(int[] A) {
        for(int i = 0; i < A.length; i++) {
            System.out.print(A[i]+" ");
        }
        System.out.println();
    }
}
public class RemoveDuplicates {
    public static void main(String[] args) {
        //int[] A = {1,1,1,2,2,3};
        //int[] A = {1};
        int[] A = {1,2,3,3,3,3,4};
        Solution sol = new Solution();
        sol.print(A);
        System.out.println(sol.removeDuplicates(A));
        sol.print(A);
    }
}

