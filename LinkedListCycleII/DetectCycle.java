import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}
class Solution {
    ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode node1 = head, node2 = head;        
        int met = 0;
        for(;;) {
            if(met == 0) {
                if(node2.next == null) return null; 
                if(node2.next.next == null) return null; 
                node2 = node2.next.next;
                node1 = node1.next;
                if(node1 == node2) {
                    node1 = head;
                    met = 1;
                }
            }else {
                if(node1 == node2) {
                    return node1;
                }
                node1 = node1.next;
                node2 = node2.next;
            }
        }
    }
    ListNode genList(int[] A, int n) {
        int i, len = A.length;
        ListNode cycle = null, head, node; 
        head = new ListNode(0);
        node = head;
        for(i = 0; i < len; i++) {
            node.next = new ListNode(A[i]);
            node = node.next;
            if(i == n-1) cycle = node;
        }
        node.next = cycle;
        return head.next;
    }

    void print(ListNode node) {
        for(int i = 0; i < 4; i++) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

public class DetectCycle {
    public static void main(String[] args) {
        //int[] A = {1,2,3,4,5,6};
        //int[] A = {3,2,0,-4};
        //int[] A = {1,2};
        //int[] A = {};
        int[] A = {-4};
        Solution sol = new Solution();
        //sol.print(sol.genList(A,2));
        System.out.println(sol.detectCycle(sol.genList(A,1)).val);
    }
}
    

            



