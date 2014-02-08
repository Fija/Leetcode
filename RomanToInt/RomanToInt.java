import java.util.*;

class Solution {
    int romanToInt(String s) {
        int i=0,pre_val=0, cur_val, sum=0;
        char c;
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        dict.put('M',1000);
        dict.put('D',500);
        dict.put('C',100);
        dict.put('L',50);
        dict.put('X',10);
        dict.put('V',5);
        dict.put('I',1);
        while(i < s.length()) {
            c = s.charAt(i);
            cur_val = dict.get(c);
            if (cur_val > pre_val) {
                sum = sum + cur_val - 2*pre_val;
            }else {
                sum = sum + cur_val;
            }
            pre_val = cur_val;
            i += 1;
        }
        return sum;
    }
}

public class RomanToInt {
    public static void main(String[] args) {
        String[] s = {"MCMLIV","MCMXC","MMXIV","MDCCCCX"};
        int[] ans = {1954, 1990, 2014, 1910};
        int i,guess;
        Solution sol = new Solution();
        for (i = 0; i < ans.length; i++) {
            guess =sol.romanToInt(s[i]);
            if (guess != ans[i]) {
                System.out.println("Your guess:"+guess+"is not equal to"
                                    +ans[i]);
            }else {
                System.out.println("Your guess:"+guess+"is correct!");
            }
        }
    }
}

        


    
