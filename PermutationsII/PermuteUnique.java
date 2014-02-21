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
    ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        //remain_num can be improved by more complicated data structure
        //using linkedlist and hashmap to search and remove
        ArrayList<ArrayList<Integer>> collections = 
            new ArrayList<ArrayList<Integer>>();
        
        int[] s_num = Arrays.copyOf(num, num.length);
        Arrays.sort(s_num);
        Integer[] sorted_num = new Integer[num.length];
        for(int i = 0 ; i < num.length; i++) {
            sorted_num[i] = s_num[i];
        }

        ArrayList<Integer> remain_num = new ArrayList<Integer>(
                                        Arrays.asList(sorted_num));
        LinkedHashSet<Integer> set = 
            new LinkedHashSet<Integer>(remain_num);
        Integer[] unique_num = set.toArray(new Integer[0]);

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < unique_num.length; i++) {
            map.put(unique_num[i], i);
        }

        ArrayList<Integer> permutation = new ArrayList<Integer>();

        recurSolve(collections, unique_num, map, remain_num, permutation);
        return collections; 
    }
    void recurSolve(ArrayList<ArrayList<Integer>> collections,
               Integer[] unique_num, HashMap<Integer, Integer> map,
               ArrayList<Integer> remain_num,
               ArrayList<Integer> permutation) {
        ArrayList<Integer> new_permutation = 
            new ArrayList<Integer>(permutation);
        ArrayList<Integer> new_remain_num = 
            new ArrayList<Integer>(remain_num);
        Integer cur_val, i = 0, idx;

        if(remain_num.size() == 0) {
            collections.add(new_permutation);
            return;
        }else {
            cur_val = new_remain_num.remove(0);
            i = map.get(cur_val);
            new_permutation.add(cur_val);
            recurSolve(collections, unique_num, map, new_remain_num,
                    new_permutation);
        }
        if(i >= unique_num.length-1) {
            return;
        }else {
            new_permutation =  new ArrayList<Integer>(permutation);
            new_remain_num = new ArrayList<Integer>(remain_num);
            idx = findNext(remain_num, cur_val);
            if(idx == -1) {
                return;
            }else {
                cur_val = remain_num.get(idx+1);
                new_remain_num.remove(cur_val);
                new_permutation.add(cur_val);
                recurSolve(collections, unique_num, map, new_remain_num,
                           new_permutation);
            }
        }
    } 
    Integer findNext(ArrayList<Integer> remain_num, Integer val) {
        //Collections.binarySearch(remain_num, val) or
        //my solution of "Search Range" problem will be more efficient
        Integer i = remain_num.lastIndexOf(val);
        if(i < remain_num.size()-1) {
            return i;
        }else {
            return -1;
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

public class PermuteUnique{
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{1,1,2},{1,2,3},{3,3,5,5,5,4}};
        //int[][] B = {{}};



        for(int i = 0; i < A.length ; i++) {
                sol.printAL2(sol.permuteUnique(A[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
