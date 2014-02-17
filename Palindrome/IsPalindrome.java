import java.util.*;
class Solution {
    boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }else return (check(nDigit(x, 0),x,x));
    }
    boolean check(int n_digit,int x, int y) {
        if(y == 0) {
            return true;
        }else {
            if(x / (int)Math.pow(10, n_digit) != y % 10) {
                return false;
            }else {
                x = x - x / (int)Math.pow(10, n_digit)
                          * (int)Math.pow(10, n_digit);
                y = y / 10; 
                return check(n_digit - 1, x, y);
            }
        }
    }
    int nDigit(int x, int n) {
        x = x / 10;
        if(x == 0) {
            return n;
        }else {
            return nDigit(x, n+1);  
        }
    }

}
public class IsPalindrome {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {0,1,133,1331,1330, 2003333339,2033333302};
        for(int i = 0; i < A.length; i++) {
            if(sol.isPalindrome(A[i])) System.out.println("True");
            else System.out.println("False");
        }
    }
}

