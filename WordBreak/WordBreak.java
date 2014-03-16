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
/*This is AC automata version
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
*/

class TrieNode {
    char val;
    boolean isEnd;
    TrieNode[] children;
    TrieNode(char c, boolean end) {
       val = c;
       isEnd = end;
       children = new TrieNode[26];
    }
}
class Solution {
    boolean wordBreak(String s, Set<String> dict) {
        if(s == null || dict == null) return false;
        int len = s.length();
        if(len == 0) {
            return dict.contains("");
        }
        List<List<Boolean>> dpOne = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            dpOne.add(new ArrayList<Boolean>());
            for(int j = 0; i+j < len; j++) {
                dpOne.get(i).add(dict.contains(s.substring(i, i+j+1)));
            }
        }
        List<Boolean> dpTwo = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            dpTwo.add(dpOne.get(0).get(i));
            if(!dpTwo.get(i)) {
                for(int j = 0; j < i; j++) {
                    if(dpTwo.get(j) && dpOne.get(j+1).get(i-j-1)) {
                        dpTwo.set(i, true);
                    }
                }
            }
        }
        return dpTwo.get(len-1);
    }
            

                

    boolean stupidwordBreak(String s, Set<String> dict) {
        if(s == null || dict == null) return false;
        TrieNode root = growTrie(dict);
        if(s.length() == 0) {
            return root.isEnd;
        }
        return recurSolve(s, root, 0, root);
    }
    boolean recurSolve(String s, TrieNode root, int i,
                       TrieNode node) {
        int idx = s.charAt(i)-'a';
        TrieNode children = node.children[idx];
        if(children == null) {
            return false;
        }else {
            if(!children.isEnd) {
                if(i == s.length()-1) {
                    return false;
                }else {
                    return recurSolve(s, root, i+1, children);
                }
            }else {
                if(i == s.length()-1) {
                    return true;
                }else {
                    return recurSolve(s, root, i+1, children) ||
                           recurSolve(s, root, i+1, root);
                }
            }
        }
    }
    TrieNode growTrie(Set<String> dict) {
        TrieNode root = new TrieNode(' ', false);
        for(String word : dict) {
            TrieNode node = root;
            int len = word.length();
            if(len == 0) {
                root.isEnd = true;
            }
            for(int i = 0; i < len; i++) {
                char c = word.charAt(i);
                int idx = c - 'a';
                boolean isEnd = (i == len-1);
                if(node.children[idx] == null) {
                    node.children[idx] = new TrieNode(c, isEnd);
                }else if(isEnd) {
                    node.children[idx].isEnd = true;
                }
                node = node.children[idx];
            }
        }
        return root;
    }





//        System.out.print();

//        System.out.println();
/* This is complicated AC automata version
    TrieNode growTrie(Set<String> dict) {
        TrieNode root = new TrieNode(' ', false, null);
        for(String word : dict) {
            node = root;
            for(int i = 0, len = word.length(); i < len; i++) {
                c = word.charAt(i);
                idx = c - 'a';
                isEnd = (i == len-1);
                if(node.children[idx] == null) {
                    tempNode = node;
                    while(tempNode != null || tempNode.children[idx] == null) {
                        tempNode = tempNode.fail;
                    }
                    fail = tempNode == null? root : tempNode.children[idx];
                    node.children[idx] = new TrieNode(c, isEnd, fail);
                }
                node = node.children[idx]
            }
        }
        return root;
    }
    */
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

public class WordBreak  {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                      "","","","a","catsanddog","leecode","leetcode"};
        String[][] B = {{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"},
                        {},{"a",""},{"a","b"},{"b","a"},
                        {"cats","and","dog"},{"lee","cod"},{"leet","code"}};
        List<Set<String>> C = new ArrayList<>();
        for(String[] dict : B) {
            C.add(new HashSet<>(Arrays.asList(dict)));
        }
        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.wordBreak(A[i],C.get(i)));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
