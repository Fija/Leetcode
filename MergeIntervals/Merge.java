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

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval i1, Interval i2) {
        return i1.start-i2.start;
    }
}
class Solution {
    ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> new_intervals = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) return new_intervals;

        Collections.sort(intervals, new IntervalComparator());
        new_intervals.add(intervals.get(0));
        for(Interval interval : intervals) {
            insert(new_intervals, interval);
        }
        return new_intervals;
    }
    void insert(ArrayList<Interval> intervals, Interval new_interval) {
        Interval interval = intervals.get(intervals.size()-1), merged_interval;
        if(new_interval.start > interval.end) {
            intervals.add(new_interval);
        }else if(new_interval.end > interval.end) {
            merged_interval = new Interval(interval.start, new_interval.end);
            intervals.remove(intervals.size()-1);
            intervals.add(merged_interval);
        }
    }
    ArrayList<Interval> genInterval(int[] A) {
        ArrayList<Interval> intervals = new ArrayList<>();
        for(int i = 0, len = A.length; i < len; i+=2) {
            intervals.add(new Interval(A[i],A[i+1]));
        }
        return intervals;
    }
    void printIntervel(ArrayList<Interval> intervals) {
        for(Interval interval : intervals) {
            System.out.print(interval.start+","+interval.end+" ");
        }
        System.out.println();
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

public class Merge  {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{15,18,8,10,2,6,1,3},
                     {},{1,1},{1,7,2,3,4,5},{1,3,2,6,8,10,15,18}};
        ArrayList<Interval> intervals;
        //int[][] B = {{}};

        for(int i = 0; i < A.length ; i++) {
            intervals = sol.genInterval(A[i]);
            sol.printIntervel(intervals);
            intervals = sol.merge(intervals);
            sol.printIntervel(intervals);
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
