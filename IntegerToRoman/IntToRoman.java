class Solution {
    String intToRoman(int num) {
        int i;
        int[] A = new int[4];
        String s = ""; 
        String[] B = {"M","D","C","L","X","V","I"}; 
        for(i = 3;i >= 0;i--) {
            A[i] = num % 10;
            num = num / 10;
        }
        for(i = 0;i < 4; i++) {
            switch(A[i]-5) {
                case -4: s = s+B[2*i];break;
                case -3: s = s+B[2*i]+B[2*i];break;
                case -2: s = s+B[2*i]+B[2*i]+B[2*i];break;
                case -1: s = s+B[2*i]+B[2*i-1];break;
                case 0: s = s+B[2*i-1];break;
                case 1: s = s+B[2*i-1]+B[2*i];break;
                case 2: s = s+B[2*i-1]+B[2*i]+B[2*i];break;
                case 3: s = s+B[2*i-1]+B[2*i]+B[2*i]+B[2*i];break;
                case 4: s = s+B[2*i]+B[2*i-2];break;
                default: break;
            }
        }
        return s;
    }
}

public class IntToRoman {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {1954,1990,2014,1910,1,3999};
        String[] ans = {"MCMLIV","MCMXC","MMXIV","MCMX","I","MMMCMXCIX"};
        String guess;
        for(int i = 0;i < A.length; i++) {
            guess = sol.intToRoman(A[i]);
            if(guess.equals(ans[i])) {
                System.out.println("Your guess:"+guess+" is euqal to "
                                    +ans[i]);
            }else {
                System.out.println("Your guess:"+guess+" is not euqal to "
                                    +ans[i]);
            }
        }
    }
}
        



