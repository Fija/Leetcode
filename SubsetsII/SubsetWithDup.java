import java.util.*;
class Solution {
    ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> collection =
            new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subset = new ArrayList<Integer>();
        int[] sorted_num = Arrays.copyOf(num, num.length);
        Arrays.sort(sorted_num);
        ArrayList<ArrayList<Integer>> map = creatSet(sorted_num);

        //print(map);
        collection.add(subset);
        findSubsets(collection, subset, map, 0);
        return collection;
    }
    void findSubsets(ArrayList<ArrayList<Integer>> collection,
            ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> map, int idx) {

        if(idx == map.size()) return;

        for(int i = 0; i < map.get(idx).get(1); i++) {
            ArrayList<Integer> new_subset = new ArrayList<Integer>(subset);
            for(int j = 0; j <= i; j++) {
                new_subset.add(map.get(idx).get(0));
            }
            collection.add(new_subset);
            findSubsets(collection, new_subset, map, idx+1);
        }
        
        findSubsets(collection, subset, map, idx+1);
    }
    ArrayList<ArrayList<Integer>> creatSet(int[] sorted_num) {
        ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> stats = null;
        int j = -1;
        for(int i = 0; i < sorted_num.length; i++) {
            if(i == 0 || sorted_num[i] != map.get(j).get(0)) {
                stats = new ArrayList<Integer>(2);
                stats.add(sorted_num[i]);
                stats.add(1);
                map.add(stats);
                j += 1;
            }else {
                map.get(j).set(1,stats.get(1)+1);
            }
        }
        return map;
    }
    void print(ArrayList<ArrayList<Integer>> A) {
        for(int i = 0; i < A.size(); i++) {
            for(int j = 0; j < A.get(i).size(); j++) {
                System.out.print(A.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    void printArray(ArrayList<Integer> A) {
        for(int i = 0; i < A.size(); i++) {
                System.out.print(A.get(i)+" ");
            }
        System.out.println();
    }

}
public class SubsetWithDup {
    public static void main(String[] args) {
        Solution sol = new Solution();
        //int[] A = {1,2,2};
        int[] A = {7,7,2,2,2,4,4,4};
        sol.print(sol.subsetsWithDup(A));
    }
}

            




        

