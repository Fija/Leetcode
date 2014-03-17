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
    ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> collection = new ArrayList<>();
        List<List<Boolean>> dp = new ArrayList<>();
        int len = s.length();
        if(len == 0) {
            collection.add("");
            return collection;
        }
        for(int i = 0; i < len; i++) {
            dp.add(new ArrayList<Boolean>());
            for(int j = 1; i+j <= len; j++) {
                dp.get(i).add(dict.contains(s.substring(i, i+j)));
            }
        }
        List<List<Integer>> children = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            children.add(new ArrayList<Integer>());
        }
        if(dp.get(len-1).get(0)) {
            children.get(len-1).add(len-1);
        } 
        for(int i = len-2; i >= 0; i--) {
            for(int j = 0; i+j < len-1; j++) {
                if(dp.get(i).get(j) && children.get(i+j+1).size() > 0) {
                    children.get(i).add(i+j);
                }
            }
            if(dp.get(i).get(len-i-1)) {
                children.get(i).add(len-1);
            }
        }
        StringBuilder str = new StringBuilder();
        if(children.get(0).size() == 0) {
            return collection;
        }
        dfs(collection, s, dict, children, str, 0, 0);
        return collection;
    }
    void dfs(ArrayList<String> collection, String s, Set<String> dict,
             List<List<Integer>> children, StringBuilder str, int i, int j) {
        String word = s.substring(i, children.get(i).get(j)+1);
        int len = str.length();
        str.append(word);
        str.append(' ');
        if(i + word.length() == s.length()) {
            str.deleteCharAt(str.length()-1);
            collection.add(str.toString());
        }else {
            dfs(collection, s, dict, children, str, i+word.length(), 0);
        }
        str.setLength(len);
        if(j < children.get(i).size()-1) {
            dfs(collection, s, dict, children, str, i, j+1);
        }
    }

           





    ArrayList<String> slowwordBreak(String s, Set<String> dict) {
        ArrayList<String> collection = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        if(s.length() == 0) {
            collection.add("");
            return collection;
        }
        recurSolve(collection, s, dict, str, 0, 1);
        return collection;
    }
    void recurSolve(ArrayList<String> collection, String s, Set<String> dict,
                    StringBuilder str, int i, int k) {
        String word = s.substring(i, i+k);
        int len = str.length();
        if(dict.contains(word)) {
            str.append(word);
            str.append(' ');
            if(i+k == s.length()) {
                str.deleteCharAt(str.length()-1);
                collection.add(str.toString());
            }else {
                recurSolve(collection, s, dict, str, i+word.length(), 1);
            }
        }
        str.setLength(len);
        if(i + k < s.length()) {
            recurSolve(collection, s, dict, str, i, k+1);
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

    void printAL(ArrayList<String> A) {
        if(A == null) return;
        for(int i = 0; i < A.size(); i++) {
                System.out.println(A.get(i)+"$");
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

public class WordBreak {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                      "","a","","catsanddog"};
        String[][] B = {{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"},
                        {"a"},{},{},{"cat","cats","and","sand","dog"}};
        List<Set<String>> C = new ArrayList<>();
        for(String[] dict : B) {
            C.add(new HashSet<String>(Arrays.asList(dict)));
        }
        for(int i = 0; i < A.length ; i++) {
            sol.printAL(sol.wordBreak(A[i],C.get(i)));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
