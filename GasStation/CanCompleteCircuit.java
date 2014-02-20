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

class Solution {
    int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null || gas.length == 0 ||cost.length == 0)
            return -1;

        int idx = -1, sum = 0;
        ArrayList<ArrayList<Integer>> extra_gas =
            new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> station;
        
        //initialize 
        for(int i = 0; i < gas.length; i++) {
            station = new ArrayList<Integer>();
            station. add(gas[i]-cost[i]);
            station. add(i);
            station. add(i);
            extra_gas.add(station);
        }

        //check if it has solution
        for(int i = 0; i < gas.length; i++) {
            sum += extra_gas.get(i).get(0);
        }
        if(sum < 0) return idx;

        //recursive solve
        extra_gas = recurSolve(extra_gas);

        return extra_gas.get(0).get(1);
    }
    ArrayList<ArrayList<Integer>> recurSolve(ArrayList<ArrayList<Integer>>
                                             extra_gas) {
        int start, i = 0,j =0, cur_val, pre_val, right_idx;
        ArrayList<ArrayList<Integer>> new_extra_gas =
            new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> merged_extra_gas =
            new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> station;

        if(extra_gas.size() == 1) return extra_gas;

        //guarantee output start with positive extra
        while(true) {
            if(extra_gas.get(i).get(0) >= 0) {
                start = i;
                station = new ArrayList<Integer>(extra_gas.get(i));
                merged_extra_gas.add(station);
                i+= 1;
                break;
            }
            i+= 1;
        }
        //merge same sign extras
        while(i != start) {
            if(i == extra_gas.size()) {
                i = 0;
                if(i == start) break;
            }
            cur_val = extra_gas.get(i).get(0);
            pre_val = i == 0? extra_gas.get(extra_gas.size()-1).get(0)
                            : extra_gas.get(i-1).get(0);
            if(cur_val >= 0 && pre_val < 0 || cur_val < 0 && pre_val >= 0) {
                station = new ArrayList<Integer>(extra_gas.get(i));
                merged_extra_gas.add(station);
                j += 1;
            }else {
                right_idx = extra_gas.get(i).get(2);
                merged_extra_gas.get(j).set(2, right_idx);
                merged_extra_gas.get(j).set(0, cur_val+
                                            merged_extra_gas.get(j).get(0));
            }
            i += 1;
        }
        //combine merged extras to new extras
        i = 0;
        while(i < merged_extra_gas.size()) {
            if(i != merged_extra_gas.size()-1) {
                station = new ArrayList<Integer>();
                station.add(merged_extra_gas.get(i).get(0) + 
                            merged_extra_gas.get(i+1).get(0));
                station.add(merged_extra_gas.get(i).get(1));
                station.add(merged_extra_gas.get(i+1).get(2));
                new_extra_gas.add(station);
                i += 2;
            }else {
                station = new ArrayList<Integer>(merged_extra_gas.get(i));
                new_extra_gas.add(station);
                i += 1;
            }
        }
        return recurSolve(new_extra_gas);
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

public class CanCompleteCircuit {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] A = {{},{70},{20,20,50,20,70,20}};
        int[][] B = {{},{80},{10,90,20,30,20,30}};

        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.canCompleteCircuit(A[i],B[i]));
        }
        /*
        System.out.print();

        System.out.println();
*/
    }
}
