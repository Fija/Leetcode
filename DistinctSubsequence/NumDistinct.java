import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x){val = x;}
}

class Solution {
    int sum =0;
    int numDistinct(String S, String T) {
        if(S == null || T == null || T.length() > S.length()) return 0;
        int len_T = T.length(), len_S = S.length(), cur_val=0, pre_val =0, temp;
        int[] line = new int[len_S+1];
        for(int i = 0; i <= len_T; i ++) {
            for(int j=i; j <= len_S; j++) {
                if(i == 0) {
                   line[j] = 1;
                }else {
                    if(T.charAt(len_T-i) == S.charAt(len_S-j)) {
                        temp = line[j];
                        line[j] = cur_val+pre_val;
                        cur_val = line[j];
                        pre_val = temp;
                    }else {
                        pre_val = line[j];
                        line[j] = cur_val;
                        cur_val = line[j];
                    }
                }
            }
            if(i == len_T) break;
            pre_val = line[i];
            cur_val = 0;
            line[i] = 0;
        }
        return line[len_S];
    }
    int lessSpaceEfficientNumDistinct(String S, String T) {
        if(S == null || T == null || T.length() > S.length()) return 0;
        if(T.length() == 0) return 1;
        int len_T = T.length(), len_S = S.length();
        int[] line = new int[len_S+1];
        int[] new_line = new int[len_S+1];
        int[] temp_line;
        for(int i = 1; i <= len_T; i ++) {
            for(int j=i; j <= len_S; j++) {
                if(T.charAt(len_T-i) == S.charAt(len_S-j)) {
                    if(i == 1) new_line[j] = new_line[j-1] +1;
                    else new_line[j] = new_line[j-1] + line[j-1];
                }else {
                    new_line[j] = new_line[j-1];
                }
            }
            temp_line = line;
            line = new_line;
            new_line = temp_line;
            new_line[i] = 0;
        }
        return line[len_S];
    }
                
    int recurNumDistinct(String S, String T) {
        if(S == null || T == null || T.length() > S.length()) return 0;
        if(T.length() == 0) return 1;
        int k;
        HashMap<Character,ArrayList<Integer>> map_S = 
            new HashMap<Character,ArrayList<Integer>>();
        HashMap<Character,Integer> map_T = 
            new HashMap<Character,Integer>();
        ArrayList<Integer> bucket;

        for(int i = 0; i < T.length(); i ++) {
            if(!map_T.containsKey(T.charAt(i))) {
                map_T.put(T.charAt(i), 1);
            }
        }
        for(int i = 0; i < S.length(); i++) {
            if(map_T.containsKey(S.charAt(i))) {
                if(!map_S.containsKey(S.charAt(i))) {
                    bucket = new ArrayList<Integer>();
                }else {
                    bucket = map_S.get(S.charAt(i));
                }
                bucket.add(i);
                map_S.put(S.charAt(i),bucket);
            }
        }

        bucket = map_S.get(T.charAt(0));
        if(bucket == null) return 0;

        k = -(Collections.binarySearch(bucket,-1))-1;
        recurSolve(S, T, map_S, 0, k);
        return sum; 
    }
    void recurSolve(String S, String T,
            HashMap<Character,ArrayList<Integer>> map_S,int i,int k) {
        for(int j = k; j < map_S.get(T.charAt(i)).size(); j++) {
            if(i == T.length()-1) {
                sum += 1;
            }else {
                ArrayList<Integer> bucket = map_S.get(T.charAt(i));
                ArrayList<Integer> new_bucket = map_S.get(T.charAt(i+1));
                int idx = Collections.binarySearch(new_bucket,bucket.get(j));
                int new_k;
                if(idx >= 0) {
                    new_k = idx+1;
                }else {
                    new_k = -idx-1;
                }
                if(new_k < map_S.get(T.charAt(i+1)).size()) {
                    recurSolve(S, T, map_S, i+1, new_k);
                }else {
                    return;
                }
            }
        }
    }
    void slowRecurSolve(String S, String T, 
                        HashMap<Character,ArrayList<Integer>> map_S, int i,int k) {
        if(i == T.length()-1) {
            sum += 1;
        }else {
            ArrayList<Integer> bucket = map_S.get(T.charAt(i));
            ArrayList<Integer> new_bucket = map_S.get(T.charAt(i+1));
            int idx = Collections.binarySearch(new_bucket,bucket.get(k));
            int new_k;
            if(idx >= 0) {
                new_k = idx+1;
            }else {
                new_k = -idx-1;
            }
            if(new_k < map_S.get(T.charAt(i+1)).size()) {
                recurSolve(S, T, map_S, i+1, new_k);
            }else {
                return;
            }
        }
       if(k == map_S.get(T.charAt(i)).size()-1) {
          return;
       }else {
          recurSolve(S, T, map_S, i, k+1) ;
       }
    }



//        System.out.print();

//        System.out.println();

    void printAL2(ArrayList<ArrayList<Integer>> A) {
        if(A == null) return;
        for(int i =0; i < A.size(); i++ ) {
            for(int j= 0; j < A.get(i).size(); j++ ) {
                System.out.print(A.get(i).get(j)+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void printAL(ArrayList<Integer> A) {
        if(A == null) return;
        for(int i = 0; i < A.size(); i++) {
                System.out.print(A.get(i)+" ");
            }
        System.out.println();
    }

    void printAr(int[] A) {
        if(A == null) return;
        for(int i = 0; i < A.length; i++) {
                System.out.print(A[i]+" ");
            }
        System.out.println();
    }

    void printLT(ListNode head) {
        while(head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }

    ListNode genList(int[] A) {
        if(A == null) return null;
        ListNode head = new ListNode(0), node = head;
        for(int i = 0 ; i < A.length; i++) {
            node.next = new ListNode(A[i]);
            node = node.next;
        }
        return head.next;
    }

    TreeNode growTree(int[] A) {
        if(A == null || A.length == 0) return null;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(A[0]), node = root;
        queue.offer(node);
        for(int i = 1; i < A.length; i++ ) {
            node = queue.poll();
            if(A[i] != -1) {
                node.left = new TreeNode(A[i]);
                queue.offer(node.left);
            }
            i += 1;
            if(i == A.length) break;
            if(A[i] != -1) {
                node.right = new TreeNode(A[i]);
                queue.offer(node.right);
            }
        }
        return root;
    }
    void printTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(true) {
            try {
                root = queue.pop();
            }catch(Exception ex) {
                break;
            }
            if(root == null) {
                System.out.print("# ");
            }else {
                System.out.print(root.val+" ");
                queue.offer(root.left);
                queue.offer(root.right);
            }
        }
        System.out.println();
    }
}

public class NumDistinct {
    public static void main(String[] args) {

        String[] A = {"ab","ba","rabbbit","aacceaec","abc","aaaa","","","a",
        "aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe"};
        String[] B = {"ba","baa","rabbit","acec","abc","aa","","a","b","bddabdcae"};



        for(int i = 0; i < A.length ; i++) {
            //if(i == A.length -1) {
            Solution sol = new Solution();
            System.out.println(sol.numDistinct(A[i],B[i]));
            //}
        }
    }
}
/*(
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/

