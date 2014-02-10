import java.util.*;
class Solution {
    int singleNumber(int[] A) {
        if (A == null || A.length <1) return 0;
        int i, len;
        Integer val;
        HashMap<Integer, Integer> dict = new HashMap<Integer,Integer>();
        for (i = 0, len = A.length; i < len; i++) {
            val = dict.get(A[i]);
            if(val == null) {
                dict.put(A[i], 1);
            }else if(val.equals(2)) {
                dict.remove(A[i]);
            }else {
                dict.put(A[i], 2);
            }
        }
        return dict.keySet().iterator().next();
    }
}

public class SingleNumberII {
    public static void main(String[] args) {
        //int[] A = {1,1,1,2,3,3,4,4,4,3};
        int[] A = {1,1};
        Solution sol = new Solution();
        System.out.println(sol.singleNumber(A));
        }
}
