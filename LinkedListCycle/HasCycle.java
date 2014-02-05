class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    boolean hasCycle(ListNode head) {
        return false;
    }
}

public class HasCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        Solution sol = new Solution();
        if (sol.hasCycle(head)) {
            System.out.println("It has cycle!");
        }else {
            System.out.println("It has no cycle!");
        }
    }
}
