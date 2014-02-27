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
    boolean isScramble(String s1, String s2) {
        if(s1 == null && s2 == null || s1 != null && s1.length() == 0 && s2 == null
           ||s2 != null && s2.length() == 0 && s1 == null || s1.length() == 0 &&
           s2.length() == 0) return true;
        if(s1.length() != s2.length()) return false;
        int i,j,k,m,flag,len = s1.length();
        ArrayList<ArrayList<ArrayList<Integer>>> dp = new 
            ArrayList<ArrayList<ArrayList<Integer>>>();
        for(k = 1; k <= len; k++) {
            dp.add(new ArrayList<ArrayList<Integer>>());
            for(i = 0; i <= len-k; i++) {
                dp.get(k-1).add(new ArrayList<Integer>());
                for(j = 0; j <= len-k; j++) {
                    if(k == 1) {
                        dp.get(k-1).get(i).add(s1.charAt(i) == s2.charAt(j)? 1:0);
                    }else {
                        flag = 0;
                        dp.get(k-1).get(i).add(0); 
                        for(m = 1; m <= k-1; m++) {
                            flag = flag + dp.get(m-1).get(i).get(j)*
                                   dp.get(k-m-1).get(i+m).get(j+m) +
                                   dp.get(m-1).get(i).get(j+k-m)*
                                   dp.get(k-m-1).get(i+m).get(j);
                            if(flag > 0) {
                                dp.get(k-1).get(i).set(j,1); 
                                break;
                            }
                        }
                    }
                }
            }
        }
        return (dp.get(len-1).get(0).get(0) == 1? true:false);
    }
                            



// This method use BFS, but it's wrong, it can be made right using recursive
// search algorithm, it's still slow compared to the DP algorithm above.
    boolean wrongAndSlowIsScramble(String s1, String s2) {
        if(s1 == null && s2 == null || s1 != null && s1.length() == 0 && s2 == null
           ||s2 != null && s2.length() == 0 && s1 == null || s1.length() == 0 &&
           s2.length() == 0) return true;
        if(s1.length() != s2.length()) return false;
        if(s1.length() == 1 && s2.length() == 1) return s1.equals(s2);
        LinkedList<int[]> queue = new LinkedList<int[]>();
        int[] end_point = new int[4], new_end_point, left1, right1,
              left2, right2, s_left2, s_right2;
        end_point[1] = s1.length()-1;
        end_point[3] = s2.length()-1;
        int i;
        queue.offer(end_point);
        while(!(queue.peek() == null)) {
            end_point = queue.poll();
            for(i = 0; i < end_point[1]-end_point[0]; i++) {
                left1 = toAlpha(s1, end_point[0], end_point[0]+i);
                right1 = toAlpha(s1, end_point[0]+i+1, end_point[1]);
                left2 = toAlpha(s2, end_point[2], end_point[2]+i);
                right2 = toAlpha(s2, end_point[2]+i+1, end_point[3]);
                s_left2 = toAlpha(s2, end_point[2], end_point[3]-i-1);
                s_right2 = toAlpha(s2, end_point[3]-i, end_point[3]);
                if(Arrays.equals(left1, left2) && Arrays.equals(right1,right2)) {
                    if(i != 0) {
                        new_end_point = Arrays.copyOf(end_point, end_point.length);
                        new_end_point[1] = end_point[0]+i;
                        new_end_point[3] = end_point[2]+i;
                        queue.offer(new_end_point);
                    }
                    if(end_point[0]+i+1 != end_point[1]) {
                        new_end_point = Arrays.copyOf(end_point, end_point.length);
                        new_end_point[0] = end_point[0]+i+1;
                        new_end_point[2] = end_point[2]+i+1;
                        queue.offer(new_end_point);
                    }
                    break;
                }else if(Arrays.equals(left1, s_right2) &&
                        Arrays.equals(right1,s_left2)) {
                    if(i != 0) {
                        new_end_point = Arrays.copyOf(end_point, end_point.length);
                        new_end_point[1] = end_point[0]+i;
                        new_end_point[2] = end_point[3]-i;
                        queue.offer(new_end_point);
                    }
                    if(end_point[0]+i+1 != end_point[1]) {
                        new_end_point = Arrays.copyOf(end_point, end_point.length);
                        new_end_point[0] = end_point[0]+i+1;
                        new_end_point[3] = end_point[3]-i-1;
                        queue.offer(new_end_point);
                    }
                    break;
                }
                if(i == end_point[1]-end_point[0]-1) return false;
            }
        }
        return true;
    }
    int[] toAlpha(String s, int start, int end) {
        int[] alpha = new int[26];
        int i;
        for(i = start; i <= end; i++) {
            alpha[s.charAt(i)-'a'] += 1;
        }
        return alpha;
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

    void printLN(ListNode head) {
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

public class IsScramble {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {"hobobyrqd","ab","a","a","abcd","acaaaccabcabcbcb",
                      "bab","abcd","great"};
        String[] B = {"hbyorqdbo","bb","b","a","dbac","abbbcbaaccacaacc",
                      "abb","bdac","rgtae"};
        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.isScramble(A[i],B[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
