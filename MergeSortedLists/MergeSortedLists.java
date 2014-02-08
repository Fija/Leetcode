class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}
class Solution {
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //the only smart thing is to add an extra head node to avoid discussion
        ListNode merge = new ListNode(0);
        ListNode head = merge;
        while (l1 !=null || l2 != null) {
            if (l1 == null) {
                while (l2 != null) {
                    merge.next = new ListNode(l2.val);
                    merge = merge.next;
                    l2 = l2.next;
                }
            }else if (l2 == null) {
                while (l1 != null) {
                    merge.next = new ListNode(l1.val);
                    merge = merge.next;
                    l1 = l1.next;
                }
            }else {
                if (l1.val <= l2.val) {
                    merge.next = new ListNode(l1.val);
                    merge = merge.next;
                    l1 = l1.next;
                }else {
                    merge.next = new ListNode(l2.val);
                    merge = merge.next;
                    l2 = l2.next;
                }
            }
        }
        return head.next;
    }
}

public class MergeSortedLists {
    public static ListNode genList(int[] A) {
        int i = 0, len = A.length;
        ListNode list = new ListNode(0);
        ListNode head = list;
        while(i < len) {
            list.next = new ListNode(A[i]);
            list = list.next;
            i += 1;
        }
        return head.next;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static void main(String[] args) {
        int[] A = {1,3,4,7,8,8,9};
        int[] B = {1,2,5,6,10};
        ListNode l1,l2,merge;
        l1 = genList(A);
        l2 = genList(B);
        Solution sol = new Solution();
        merge = sol.mergeTwoLists(l1,l2);
        printList(merge);
    }
}

        


