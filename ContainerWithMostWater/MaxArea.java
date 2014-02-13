class Solution {
    int maxArea(int[] height) {
        if(height == null || height.length < 2) return 0;
        int i = 0, len = height.length, k = len-1, max_left = height[0],
        max_right = height[len-1],idx_max_right = len-1, idx_max_left = 0,
        area = 0, max = Math.min(max_left, max_right)*(len-1); 
        for(;;) {
            if(max_left <= max_right) {
                if(height[i] > max_left) {
                    max_left = height[i];
                    idx_max_left = i;
                    area = Math.min(height[i], max_right)*(idx_max_right-i); 
                    if(area > max) {
                        max = area;
                    }
                }
                i += 1;
                if (i > k) break;
            }else {
                if(height[k] > max_right) {
                    max_right = height[k];
                    idx_max_right = k;
                    area = Math.min(height[k], max_left)*(k-idx_max_left); 
                    if(area > max) {
                        max = area;
                    }
                }
                k -= 1;
                if (i > k) break;
            }
        }
        return max;
    }
}

public class MaxArea {
    public static void main(String[] args) {
        //int[] height = {3,2,1,5,7,4,6};
        //int[] height = {3,2,1,50,70,4,6};
        //int[] height = {1,0,0,5,7,0,3,0,6,5};
        int[] height = {1,1};
        
        Solution sol = new Solution();
        System.out.println(sol.maxArea(height));
    }
}
            
            

            


                    
                
