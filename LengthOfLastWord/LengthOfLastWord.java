import java.util.*;
class Solution {
    int lengthOfLastWord(String s) {
        int last_word_length = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i != 0 && i != s.length()-1 && s.charAt(i) == ' ' &&
               Character.isLetter(s.charAt(i+1))) {
                last_word_length = 0;
               }else if(Character.isLetter(s.charAt(i))) {
                   last_word_length += 1;
               }
        }
        return last_word_length;
    }
}

public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] s = {"Hello World", ""," ","  ab"," ab ","a b"," ab cd ",
                      "Hello","a"};
        for(int i = 0; i < s.length; i++) {
            System.out.print(sol.lengthOfLastWord(s[i])+" ");
        }
    }
}
