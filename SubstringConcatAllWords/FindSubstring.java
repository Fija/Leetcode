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
    ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> idx = new ArrayList<Integer>();
        if(S == null || L == null || L.length == 0) return idx;
        int i, j, k, lenS = S.length(), lenL = L.length, lenW = L[0].length();
        String w, v;
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        HashMap<String,Integer> map_T = new HashMap<String, Integer>();
        for(i = 0; i < lenL; i++) {
            w = L[i];
            if(map.containsKey(w)) map.put(w, map.get(w)+1);
            else map.put(w, 1);
        }
        for(i = 0; i < lenW;i++) {
            map_T.clear();
            for(j = i, k = i; j<= lenS-lenW; j += lenW ) {
                w = S.substring(j, j+lenW);
                if(!map.containsKey(w)) { 
                    k = j+lenW;
                    map_T.clear();
                }else {
                    if(!map_T.containsKey(w)) map_T.put(w, 1);
                    else {
                        if(map_T.get(w) < map.get(w)) {
                            map_T.put(w, map_T.get(w)+1);
                        }else {
                            while(!S.substring(k, k+lenW).equals(w)){
                                map_T.remove(S.substring(k,k+lenW));
                                k+= lenW;
                            }
                            k += lenW;
                        }
                    }
                    if(j-k == lenW*(lenL-1)) idx.add(k);
                }
            }
        }



/* This is another version of this problem, also correct, but it uses a different counting technique with hashmap, leads to a big change to time complexity, more specifically, it needs to creat new instances of map every loop, so try to start counting with empty hashmap*/

        for(i = 0; i < lenW;i++) {
            map_T = new HashMap<String, Integer>(map);
            for(j = i, k = i; j<= lenS-lenW; j += lenW ) {
                w = S.substring(j, j+lenW);
                v = S.substring(k, k+lenW);
                if(!map.containsKey(w)) { 
                    k = j+lenW;
                    map_T = new HashMap<String, Integer>(map);
                }else {
                    if(j - k < lenW*lenL) {
                        if(map_T.containsKey(w)) map_T.put(w, map_T.get(w)-1);
                        else map_T.put(w, -1);
                        if(map_T.get(w) == 0) map_T.remove(w);
                        if(map_T.size() == 0) idx.add(j-lenW*(lenL-1));
                    }else {
                        if(map_T.containsKey(w)) map_T.put(w, map_T.get(w)-1);
                        else map_T.put(w, -1);
                        if(map_T.get(w) == 0) map_T.remove(w);
                        if(map_T.containsKey(v)) map_T.put(v, map_T.get(v)+1);
                        else map_T.put(v, +1);
                        if(map_T.get(v) == 0) map_T.remove(v);
                        if(map_T.size() == 0) idx.add(j-lenW*(lenL-1));
                        k += lenW;
                    }
                }
            }
        }
        */

        return idx;
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

public class FindSubstring {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {"sheateateseatea","abababab","",
                      "barfoothefoobarfoo","aaaaaa"};
        String[][][] B = {{{"sea","tea","ate"}},{{"a","b","a"}},{{""},{"a"}},
                          {{"o","o"},{"foo","bar"}},
                          {{"a"},{"aa"},{"aa","aa"},{"aaaaaa"}}};



        for(int i = 0; i < A.length ; i++) {
            for(int j = 0; j < B[i].length; j++) {
            sol.printAL(sol.findSubstring(A[i], B[i][j]));
            }
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
