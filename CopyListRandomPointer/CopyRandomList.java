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
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};

class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode copy = new RandomListNode(head.label);
        RandomListNode pre_head = new RandomListNode(0);
        HashMap<RandomListNode, RandomListNode> map = 
            new HashMap<RandomListNode, RandomListNode>();
        pre_head.next = copy;
        map.put(head, copy);
        while(head != null) {
            if(head.next != null && !map.containsKey(head.next)) {
                copy.next = new RandomListNode(head.next.label);
                map.put(head.next, copy.next);
            }
            if(head.random != null && !map.containsKey(head.random)) {
                copy.random = new RandomListNode(head.random.label);
                map.put(head.random, copy.random);
            }
            copy.next = map.get(head.next);
            copy.random = map.get(head.random);
            head = head.next;
            copy = copy.next;
        }
        return pre_head.next;
    }
    RandomListNode genRandomList(int[] A) {
        RandomListNode head = new RandomListNode(0), node=head;
        ArrayList<RandomListNode> B = new ArrayList<RandomListNode>();
        for(int i = 0; i < A.length; i+=2) {
            node.next = new RandomListNode(A[i]);
            node = node.next;
            B.add(node);
        }
        node = head.next;
        for(int i = 1; i < A.length; i+=2) {
            if(A[i] != -1) {
                node.random = B.get(A[i]);
            }
            node = node.next;
        }
        return head.next;
    }
    ArrayList<Integer> flattenRandomList(RandomListNode head) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        RandomListNode node = head;
        HashMap<RandomListNode, Integer> map = 
            new HashMap<RandomListNode, Integer>();
        int i;
        i = 0;
        while(node != null) {
            A.add(i/2);
            A.add(0);
            map.put(node, i/2);
            node = node.next;
            i += 2;
        }
        node = head;
        i = 1;
        while(node != null) {
            if(node.random != null) {
                A.set(i, map.get(node.random));
            }else {
                A.set(i, -1);
            }
            node = node.next;
            i += 2;
        }
        return A;
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

public class  CopyRandomList{
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{0,-1},{0,1,1,1},{0,1,1,2,2,-1,3,1}};
        //int[][] B = {{}};
        RandomListNode head, copy;



        for(int i = 0; i < A.length ; i++) {
            head = sol.genRandomList(A[i]);
            sol.printAL(sol.flattenRandomList(head));
            copy = sol.copyRandomList(head);
            sol.printAL(sol.flattenRandomList(copy));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
