import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Solution {
    ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ListNode start = head;
        if (head == null) { 
            return start;
        }else {
            map.put(new Integer(head.val), 1);
            while (head.next != null) {
                if (map.get(new Integer(head.next.val))== null) {
                    map.put(new Integer(head.next.val), 1);
                    head = head.next;
                }else {
                    head.next = head.next.next;
                }
            }
            return start;
        }
    }
}

public class DeleteDuplicates {
    public static void buildList(ListNode node, int[] A) {
        int len = A.length;
        int i;
        node.val = A[0];
        for (i = 1; i < len; i++) {
            node.next = new ListNode(A[i]);
            node = node.next;
        }
    }
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
    public static void main(String[] args) {
        //int[] A = {1,2,3,1,3};
        int[] A = {1,2,2,2,2,1,3,3,3};
        ListNode head = new ListNode(A[0]);
        buildList(head, A);
        printList(head);
        Solution sol = new Solution();
        head = sol.deleteDuplicates(head);
        //head = sol.deleteDuplicates(null);

        printList(head);
    }
}


