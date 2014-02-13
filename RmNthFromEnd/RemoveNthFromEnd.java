class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}
class Solution {
    ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        int i;
        ListNode node, nth_node_prev = null; 
        node = head;
        for(i = 0;;) {
            node = node.next;
            i += 1;
            if(i > n) {
                nth_node_prev = nth_node_prev.next;
            }else if(i == n) {
                nth_node_prev = head;
            }
            if(node == null) return null;
            //if(nth_node_prev != null)
             //   System.out.println(node.val+" "+nth_node_prev.val+" "+i);
            if(node.next == null) {
                if(nth_node_prev != null) {
                    nth_node_prev.next = nth_node_prev.next.next;
                    return head;
                }else return head.next;
            }
        }
    }
    ListNode genList(int[] A) {
        if(A == null || A.length == 0) return null;
        ListNode head = new ListNode(A[0]), node = head;
        for(int i = 1; i < A.length; i++) {
            node.next = new ListNode(A[i]);
            node = node.next;
        }
        return head;
    }
    void print(ListNode head) {
        for(;;) {
            if(head == null) {
                System.out.println();
                return;
            }
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        //int[] A = {1,2,3,4,5};
        int[] A = {1};
        //int[] A = {};
        Solution sol = new Solution();
        sol.print(sol.genList(A));
        sol.print(sol.removeNthFromEnd(sol.genList(A),1));
    }
}


