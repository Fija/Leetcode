class Solution{
    public int singleNumber(int[] A){
        int val, i, len=A.length;
        for(val=0,i=0;i<len;i++) {
            val=val^A[i];
        }
        return val;
    }
}
public class Single{
    public static void main(String[] args){
        int[] A = {1,1,2,3,3};
        Solution sol=new Solution();
        System.out.println(sol.singleNumber(A));
    }
}

