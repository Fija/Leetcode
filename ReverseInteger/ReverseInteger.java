class Solution {
    int stupidreverse(int x) {
        int[] A = new int[10];
        int i = 0;
        int j = 1;
        int y;
        do {
            A[i] = x-(x/10)*10;
            x = x/10;
            i += 1;
        }while(x != 0);
        y = A[0];
        while(j < i) {
            y = y*10+A[j];
            j += 1;
        }
        return y;
    }
    int reverse(int x) {
        int y = 0;
        do {
            y = y*10 + x%10;
            x = x/10;
        }while (x != 0);
        return y;
    }
}

public class ReverseInteger {
    public static void main(String[] args) {
        int x = -9;
        Solution sol = new Solution();
        System.out.println(sol.reverse(x));
    }
}
