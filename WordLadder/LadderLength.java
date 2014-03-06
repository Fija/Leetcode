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
    int ladderLength(String start, String end, HashSet<String> dict) {
        if(start == null||start.length() == 0||end == null||end.length() ==0||
           (dict == null || dict.size() == 0) && !start.equals(end))
            return 0;
        if(start.equals(end)) return 1;
        int cur, next,step, i, j, lenW = end.length();
        LinkedList<String> queue = new LinkedList<String>();
        HashMap<String, Integer> map = new HashMap<String,Integer>();
        String word, new_word;
        queue.offer(start);
        map.put(start,1);
        step = 2;
        cur = 1;
        next = 0;
        while(queue.size() != 0) {
            word = queue.poll();
            for(i = 0; i < lenW; i++) {
                for(j = 0; j < 26; j++) {
                    new_word = word.substring(0, i)+
                              (char)('a'+j)+word.substring(i+1);
                    if(new_word.equals(end)) return step;
                    if(dict.contains(new_word) && !map.containsKey(new_word)) {
                        queue.offer(new_word);
                        map.put(new_word,1);
                        next += 1;
                    }
                }
            }
            cur -= 1;
            if(cur == 0) {
                cur = next;
                next = 0;
                step += 1;
            }
        }
        return 0; 
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

public class LadderLength {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {"e","hit","hit","hit"};
        String[] B = {"f","cog","lop","hit"};
        String[][] C = {{"a","b","c"},
                        {"hot","dot","dog","lot","log"},
                        {"hot","dot","dog","lot","log"},
                        {"hot","dot","dog","lot","log"}};
        ArrayList<HashSet<String>> D = 
            new ArrayList<HashSet<String>>();
        for(int i = 0; i < C.length; i++) D.add(
                new HashSet<String>(Arrays.asList(C[i])));
        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.ladderLength(A[i],B[i],D.get(i)));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
