class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}

class Solution {
    ListNode swapParis(ListNode head) {
        ListNode node = head;
        int tmp;
        while(true) {
            if(node != null && node.next != null) {
                tmp = node.val;
                node.val = node.next.val;
                node.next.val = tmp;
                node = node.next.next;
            }else break;
        }
        return head;
    }
    ListNode buildList(int[] A) {
        int i = 0, len = A.length; 
        ListNode head = new ListNode(0);
        ListNode node = head;
        while(i < len) {
            node.next = new ListNode(A[i]);
            node = node.next;
            i += 1;
        }
        return head.next;
    }
    void printList(ListNode head) {
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

public class SwapParis {
    public static void main(String[] args) {
        //int[] A = {1,2,3,4};
        int[] A = {1};
        Solution sol = new Solution();
        ListNode head = sol.buildList(A);
        sol.printList(sol.swapParis(head));
    }
}
