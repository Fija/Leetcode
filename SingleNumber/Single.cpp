#include <iostream>
using namespace std;
int main (int argc, char * const argv[]) {
    // insert code here...
    class Solution{
        public:
            int singleNumber(int A[], int n) {
                int val,i;
                for (val=0,i=0;i<n;i++) {
                    val = val ^ A[i];
                }   
                return val;
            }   
    };  
    Solution sol;
    int A[5] = {1,1,2,3,3};
    cout<<sol.singleNumber(A,5);
    return 0;
}

