import java.util.*;
class Solution {
    int n, k;
    ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();

    ArrayList<ArrayList<Integer>> combine(int x, int y) {
        if(y <= 0 || y > x) return null;
        int i;
        ArrayList<Integer> a;
        n = x; k = y;
        for(i = 1; i < n-k+2; i++) {
            a = new ArrayList<Integer>();
            a.add(i);
            makeCombination(a);
        }
        return A;
    }

    void makeCombination(ArrayList<Integer> a) {
        int len, i;
        len = a.size();
        if(len == k) {
            ArrayList<Integer> b = new ArrayList<Integer>(a);
            A.add(b);
            return;
        }else {
            for(i = a.get(len-1) + 1; i <= n-(k-len)+1; i++) {
                a.add(i);
                makeCombination(a);
                a.remove(len);
            }
        }
    }
    void print2(ArrayList<Integer> a) {
        for(int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i)+" ");
        }
        System.out.println();
    }


    void print(ArrayList<ArrayList<Integer>> A) {
        for(int i = 0; i < A.size(); i++) {
            for(int j = 0; j < A.get(i).size(); j++) {
                System.out.print(A.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
public class Combine {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.print(sol.combine(5,2));
    }
}

                
     
    
