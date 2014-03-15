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

class TrieNode {
    char val;
    int[] endCount;
    TrieNode fail;
    TrieNode[] children;
    TrieNode(char c, boolean isEnd, TrieNode failNode) {
       val = c;
       endCount = new int[1];
       endCount[0] = isEnd? 1 : 0;
       fail = failNode;
       children = new TrieNode[26];
    }
}






class Solution {
    boolean wordBreak(String s, Set<String> dict) {

        
    }

//        System.out.print();

//        System.out.println();

    TrieNode genTrie(Set<String> dict) {
        TrieNode root = new TrieNode(' ', false, null);
        for(String word : dict) {
            node = root;
            for(int i = 0, len = word.length(); i < len; i++) {
                c = word.charAt(i);
                idx = c - 'a';
                isEnd = (i == len-1);
                tempNode = node;
                while(tempNode != null || tempNode.children[idx] == null) {
                    tempNode = tempNode.fail;
                }
                fail = tempNode == null? root : tempNode.children[idx];
                node.children[idx] = new TrieNode(c, isEnd, fail);
            }
        }
        return root;
    }
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

public class  {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{}};
        int[][] B = {{}};



        for(int i = 0; i < A.length ; i++) {
            for(int j = 0; j < B[i].length; j++) {
            sol.print(sol.
            }
            System.out.println();
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
