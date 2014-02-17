import java.util.*;
class Solution {
    boolean isValid(String s) {
        if(s == null || s.length() == 0 ) return true;
        HashMap<Character, Character> map = 
            new HashMap<Character,Character>();
        LinkedList<Character> stack = new LinkedList<Character>();
        int i;
        Character token;
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        map.put(')','r');
        map.put(']','r');
        map.put('}','r');
        i = 0;
        while(true) {
            if(map.get(s.charAt(i)) != 'r') {
                stack.push(s.charAt(i));
                i += 1;
                if(i == s.length()) {
                    return false;
                }
            }else {
                try{
                    token = stack.pop();
                }catch(Exception ex) {
                    return false;
                }
                if(map.get(token) != s.charAt(i)) {
                    return false;
                }else {
                    i += 1;
                    if(i == s.length()) {
                        if(stack.size() == 0) return true;
                        else return false;
                    }
                }
            }
        }
    }
}
public class IsValid {
    public static void main(String[] args) {
        String[] s = {"(",")","","()",")(","()[]{}","(]","([)]","([{}])",
                      "(((())(","([]"};
        Solution sol = new Solution();
        for(int i = 0; i < s.length; i++) {
            if(sol.isValid(s[i])) {
                System.out.print("T ");
            }else {
                System.out.print("F ");
            }
            System.out.println();
        }
    }
}
