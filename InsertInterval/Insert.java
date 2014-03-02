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
class Solution {
    ArrayList<Interval> insert(ArrayList<Interval> intervals,
                               Interval newInterval) {
        ArrayList<Interval> new_intervals =
            new ArrayList<Interval>(intervals);
        if(intervals == null||intervals.size() ==0) {
            new_intervals.add(newInterval);
            return new_intervals;
        }
        if(newInterval == null) return new_intervals;

        int i, len = intervals.size(), start, end, start_idx, end_idx,
            remove_start, remove_end;
        int[] A = new int[len*2];
        for(i = 0; i < len*2; i+=2) {
            A[i] = (intervals.get(i/2).start);
            A[i+1] = (intervals.get(i/2).end);
        }
        start_idx = Arrays.binarySearch(A, newInterval.start);
        if(start_idx >= 0) {
            if(start_idx % 2 == 1) start = A[start_idx-1];
            else start = A[start_idx];
            remove_start = start_idx/2;
        }else {
            if((-start_idx-1) % 2 == 1) start = A[-start_idx-2];
            else start = newInterval.start;
            remove_start = (-start_idx-1)/2;
        }
        end_idx = Arrays.binarySearch(A, newInterval.end);
        if(end_idx >= 0) {
            if(end_idx % 2 == 1) end = A[end_idx];
            else end = A[end_idx+1];
            remove_end = end_idx/2;
        }else {
            if((-end_idx-1) % 2 == 1){
                end = A[-end_idx-1];
                remove_end = (-end_idx-1)/2;
            }else {
                end = newInterval.end;
                remove_end = (-end_idx-2)/2;
            }
        }
        if(!(start_idx == -1 && end_idx == -1)) remove_end += 1;
        new_intervals.subList(remove_start, remove_end).clear();
        newInterval.start = start;
        newInterval.end = end;
        new_intervals.add(remove_start, newInterval);
        return new_intervals;
    }
    ArrayList<Interval> genIntervals(int[] A) {
        ArrayList<Interval> B = new ArrayList<Interval>();
        for(int i = 0 ; i < A.length; i+=2) {
            B.add(new Interval(A[i], A[i+1]));
        }
        return B;
    }
    void printItv(ArrayList<Interval> A) {
        for(int i = 0; i < A.size(); i++) {
            System.out.println(A.get(i).start+","+A.get(i).end+" ");
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

public class  Insert{
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{2,2},{},{1,3,6,9},{1,2,3,5,6,7,8,10,12,16}};
        int[][][] B = {{{1,1},{2,2},{2,3}},
                       {{2,5}},
                       {{-1,0},{0,4},{4,5},{9,11},{0,10},{10,11},{2,5}},
                       {{4,9}}};



        for(int i = 0; i < A.length ; i++) {
            sol.printItv(sol.genIntervals(A[i]));
            for(int j = 0; j < B[i].length; j++) {
                sol.printItv(sol.insert(sol.genIntervals(A[i]),
                            new Interval(B[i][j][0],B[i][j][1])));
            }
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
