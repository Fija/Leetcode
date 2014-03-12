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
    String strStr(String haystack, String needle) {
        if(haystack == null ||needle == null) return null;
        int i = 0, j = 0, m = haystack.length(), n = needle.length();
        if(n == 0) return haystack;
        if(m == 0) return null;
        int[] lps = genLps(needle);
        while(true) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
                if(j == n) return haystack.substring(i-n);
                if(i == m) return null;
            }else {
                if(j == 0) {
                    i++;
                    if(i == m) return null;
                }else {
                    j = lps[j-1];
                }
            }
        }
    }
    int[] genLps(String needle) {
        int n = needle.length();
        int[] lps = new int[n];
        lps[0] = 0;
        int i = 1;
        int len = 0;
        while(i < n) {
            if(needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }else {
                if(len == 0) {
                    lps[i] = 0;
                    i++;
                }else {
                    len = lps[len-1];
                }
            }
        }
        return lps;
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

public class StrStr {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {"","a","a","a","","abaabaaab"};
        String[] B = {"a","aa","a","b","","abaaa"};



        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.strStr(A[i],B[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
