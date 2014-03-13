import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x){val = x;}
}
    
        
class LRUCache {
    int size;
    Map<Integer, ListNode> map;
    Map<Integer, Integer> cache;
    class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int x) {val = x;}
    }
    ListNode head;
    ListNode tail;
    public LRUCache(int capacity) {
        size = capacity; 
        map = new HashMap<>();
        cache = new HashMap<>();
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }
    private ListNode poll() {
        if(head.next == tail) return null;
        ListNode first = head.next;
        head.next = first.next;
        first.next.prev = head;
        map.remove(first.val);
        return first;
    }
    private void moveToLast(int key) {
        ListNode node;
        if(!map.containsKey(key)) {
            node = new ListNode(key);
            map.put(key, node);
        }else {
            node = map.get(key);
            if(node == tail.prev) return;
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        ListNode last = tail.prev;
        tail.prev = node;
        node.prev = last;
        last.next = node;
        node.next = tail;
    }
    public int get(int key) {
        if(cache.containsKey(key)) {
            moveToLast(key);
            return cache.get(key);
        }else return -1;
    }

    public void set(int key, int value) {
        if(size == 0) return;
        if(cache.size() == size && !cache.containsKey(key)) {
            cache.remove(this.poll().val);
        }
        cache.put(key, value);
        this.moveToLast(key);
    }
}

class WrongLRUCache {
    TreeMap<Integer, Integer> count = new TreeMap<Integer, Integer>();
    Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
    int size;
    public WrongLRUCache(int capacity) {
       size = capacity; 
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        else {
            count.put(key, count.get(key)+1);
            return cache.get(key);
        }
    }

    public void set(int key, int value) {
        if(cache.size() == size) {
            cache.remove(count.pollFirstEntry().getKey());
        }
        cache.put(key, value);
        if(count.containsKey(key))
            count.put(key, count.get(key)+1);
        else
            count.put(key, 1);
    }
}
class Solution {


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

public class LruCache {
    public static void main(String[] args) {
        /*
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.set(2,6);
        System.out.println(cache.get(1));
        cache.set(1,5);
        cache.set(1,2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        */

        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.set(1,3);
        cache.set(2,4);
        cache.set(3,5);
        System.out.println(cache.get(2));
        cache.set(4,6); cache.set(1,2);
        cache.set(5,7);
        cache.set(6,8);
        cache.set(5,7);
        System.out.println(cache.get(3));
        System.out.println(cache.get(1));
        cache.set(7,9);
        System.out.println(cache.get(2));
        System.out.println(cache.get(5));
        System.out.println(cache.get(6));
        for(Map.Entry<Integer, Integer> entry : cache.cache.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        /*
           sol.printTree(sol.growTree(A[i]));
           System.out.print();
           System.out.println();
           */
    }
}
