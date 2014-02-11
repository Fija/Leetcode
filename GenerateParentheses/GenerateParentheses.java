import java.util.*;
class Solution {
    ArrayList<String> generateParentheses(int n) {
        int l, i, j, k; 
        int[] m = new int[n+1];
        ArrayList<String> A = new ArrayList<String>();
        ArrayList<String> case0 = new ArrayList<String>();
        ArrayList<String> case1 = new ArrayList<String>();
        ArrayList<ArrayList<String>> C = new ArrayList<ArrayList<String>>();
        
        if (n == 0) return A;
        case0.add("");
        case1.add("()");
        C.add(case0);
        C.add(case1);
        m[0] = 1;
        m[1] = 1;
        for(l = 2; l <= n; l++) {
            for(i = 0; i < l; i++) {
                for(j = 0; j < m[i]; j++) {
                    for(k = 0; k < m[l-1-i]; k++) {
                        A.add("("+C.get(i).get(j)+")"+C.get(l-1-i).get(k));
                    }
                }
            }
            C.add(A);
            m[l] = A.size();
            A = new ArrayList<String>();
        }
        return C.get(n);
    }
    void print(ArrayList<String> A) {
        int i, len = A.size();
        for(i = 0; i < len; i++) {
            System.out.println(A.get(i)+" ");
        }
        System.out.println('\n');
    }
}

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.print(sol.generateParentheses(0));
    }
}
