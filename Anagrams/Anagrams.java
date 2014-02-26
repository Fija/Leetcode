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
    class IntArray {
        protected int[] array;
        IntArray(int[] a) {
            array = Arrays.copyOf(a, a.length);
        }
        public void addOne(int idx) {
            array[idx] += 1;
        }

        @Override
        public boolean equals(Object aThat) {
            if(this == aThat) return true;
            if(!(aThat instanceof IntArray)) return false;
            IntArray that = (IntArray)aThat;
            return Arrays.equals(this.array, that.array);
        }
        @Override
        public int hashCode() {
            return (this != null) ? Arrays.hashCode(this.array) :0;
        }
    }
    ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> collection = new ArrayList<String>();
        ArrayList<Integer> shorten_strs = new ArrayList<Integer>();
        if(strs == null) return collection;
        int i, len, idx;
        HashMap<Integer, Integer> map_len = 
            new HashMap<Integer, Integer>();
        HashMap<IntArray, Integer> map_alpha_stats = 
            new HashMap<IntArray, Integer>();
        HashMap<Integer, IntArray> map_alpha = 
            new HashMap<Integer, IntArray>();
        IntArray alpha;

        for(i = 0; i < strs.length; i++) {
            len = strs[i].length();
            if(!map_len.containsKey(len)) {
                map_len.put(len,1);
            }else {
                map_len.put(len,2);
            }
        }
        for(i = 0; i < strs.length; i++) {
            if(map_len.get(strs[i].length()) > 1) {
                shorten_strs.add(i);
                alpha = toAlphaTable(strs[i]);
                map_alpha.put(i, alpha);
                if(!map_alpha_stats.containsKey(alpha)) {
                    map_alpha_stats.put(alpha, 1);
                }else {
                    map_alpha_stats.put(alpha, 2);
                }
            }
        }
        for(i = 0; i < shorten_strs.size(); i++) {
            idx = shorten_strs.get(i);
            if(map_len.get(strs[idx].length()) > 1 &&
               map_alpha_stats.get(map_alpha.get(idx)) > 1) {
                    collection.add(strs[idx]);
            }
        }
        return collection;
    }
    IntArray toAlphaTable(String s) {
        int i;
        IntArray alpha = new IntArray(new int[26]);
        for(i = 0; i < s.length(); i++) {
            alpha.addOne(s.charAt(i)-'a');
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

    void printAL(ArrayList<String> A) {
        if(A == null) return;
        for(int i = 0; i < A.size(); i++) {
                System.out.print(A.get(i)+" ");
            }
        System.out.println();
    }

    void printAr(String[] A) {
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

public class Anagrams {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] A = {{},{"a"},{"a","a","a"},{"a","b","c"},
            {"odg","abc","cba","dog","god","skdfnaadf", "a"}};
        //int[][] B = {{}};



        for(int i = 0; i < A.length ; i++) {
            sol.printAL(sol.anagrams(A[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
