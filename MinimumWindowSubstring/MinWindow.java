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
    String minWindow(String S, String T) {
        if(S == null || T == null ||S.length() == 0 ||T.length() == 0) return "";
        int i, j, k, min, min_l, min_r;
        char c,d;
        HashMap<Character, Integer> map_T = new HashMap<Character, Integer>();
        for(i = 0; i < T.length(); i++) {
            c = T.charAt(i);
            if(map_T.containsKey(c)) {
                map_T.put(c, map_T.get(c)+1);
            }else {
                map_T.put(c, 1);
            }
        }
        HashMap<Character,Integer> map_C = new HashMap<Character, Integer>(map_T);
        HashMap<Character,Integer> map_S = new HashMap<Character, Integer>();

        for(i = 0;i < S.length() && !map_C.isEmpty();i++) {
            c = S.charAt(i);
            if(map_T.containsKey(c)) {
                if(map_S.containsKey(c)) map_S.put(c, map_S.get(c)+1);
                else map_S.put(c, 1);
                if(map_C.containsKey(c)) { 
                    map_C.put(c, map_C.get(c)-1);
                    if(map_C.get(c) == 0) map_C.remove(c);
                }
            }
        }
        if(!map_C.isEmpty()) return "";
        min = i;
        min_l = 0;
        min_r = i-1; 
        for(j = 0, k = i-1;;) {
            c = S.charAt(j);
            if(map_S.containsKey(c)) {
                if(map_S.get(c) > map_T.get(c)) {
                    map_S.put(c, map_S.get(c)-1);
                }else {
                    k += 1;
                    while(k < S.length() && S.charAt(k) != c) {
                        d = S.charAt(k);
                        if(map_S.containsKey(d)) map_S.put(d, map_S.get(d)+1);
                        k += 1;
                    }
                    if(k == S.length()) break;
                }
            }
            j += 1;
            if(k-j+1 < min) {
                min = k-j+1; 
                min_l = j;
                min_r = k;
            }
        }
        return S.substring(min_l, min_r+1);
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

public class MinWindow {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {"","aa","ADOBECODEBANC"};
        String[][] B = {{"","a"},{"aa"},{"ABC","ED","NO","AEBC","BBBB","BK"}};



        for(int i = 0; i < A.length ; i++) {
            for(int j = 0; j < B[i].length; j++) {
            System.out.println(sol.minWindow(A[i],B[i][j]));
            }
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
