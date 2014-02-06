class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class List {
    int[] list;
    int len, start_idx, i=0;
    ListNode head;
    ListNode start;

    //n is the point where circle start
    List(ListNode node, int[] A, int n) {
        list = A;
        len = A.length;
        start_idx = n;
        head = node;
        if (len == 1) {
            start = node;
        }else {
            do {
                if (i == n) start = node;
                i += 1;
                node.next = new ListNode(A[i]);
                node = node.next;
            }while(i < len-1);
            if (n == len-1) start = node;
        }
        if (n > -1 && n < len) {
            node.next = start;
        } 
    }

    void printList() {
        int j;
        ListNode node = head;
        for (j = 0; j < len; j++) {
            System.out.println(node.val);
            node = node.next;
        }
        if (start_idx > -1 && start_idx < len) {
            System.out.println(node.val);
        }
    }
            

}

class Solution {
    boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
}

public class HasCycle {
    public static void main(String[] args) {
        //int[] A = {1,2,3,4,5};
        int[] A = {1,2};
        ListNode head = new ListNode(A[0]);
        List list = new List(head, A, 4);
        list.printList();
        Solution sol = new Solution();
        if (sol.hasCycle(head)) {
            System.out.println("It has cycle!");
        }else {
            System.out.println("It has no cycle!");
        }
    }
}
