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

class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
class Solution {
    UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        UndirectedGraphNode src_node, new_node, new_neighbor,
                            root = new UndirectedGraphNode(node.label);
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        List<UndirectedGraphNode> new_neighbor_set = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        int label;
        map.put(node.label, root);
        queue.offer(node);
        visited.add(node.label);
        while(queue.size() > 0) {
            src_node = queue.poll();
            new_node = map.get(src_node.label);
            for(UndirectedGraphNode neighbor : src_node.neighbors) {
                label = neighbor.label;
                new_neighbor_set = new_node.neighbors;
                if(!map.containsKey(label)) { 
                    new_neighbor = new UndirectedGraphNode(label);
                    map.put(label, new_neighbor);
                }else 
                    new_neighbor = map.get(label);
                new_neighbor_set.add(new_neighbor);
                if(!visited.contains(label)) {
                    queue.offer(neighbor);
                    visited.add(label);
                }
            }
        }
        return root;
    }
    UndirectedGraphNode genGraph(int[] A) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode node, root = new UndirectedGraphNode(A[0]), cur = root;
        for(int i = 1, len = A.length, start = 0;
            i < len; i++) {
            if(A[i] == -1) {
                start = i+1;
            }else {
                if(!map.containsKey(A[i])) {
                    node = new UndirectedGraphNode(A[i]);
                    map.put(A[i], node);
                }else  
                    node = map.get(A[i]);
                if(i == start) 
                    cur = node;
                else
                    cur.neighbors.add(map.get(A[i]));
            }
        }
        return root;
    }
    void printGraph(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        UndirectedGraphNode cur;
        Set<Integer> visited = new HashSet<>();
        int label;
        queue.offer(node);
        visited.add(node.label);
        while(queue.size() > 0) {
            cur = queue.poll();
            System.out.print(cur.label+" ");
            for(UndirectedGraphNode neighbor : cur.neighbors) {
                label = neighbor.label;
                System.out.print(label+" ");
                if(!visited.contains(label))
                    queue.offer(neighbor);
                visited.add(label);
            }
            System.out.print('#');
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

public class CloneGraph  {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{0,0,0},{0,1,2,-1,1,0,-1,2,0}, {0}, {0,0},
                     {0,1,2,-1,1,0,2,-1,2,0,1},{0,1,2,-1,1,2,-1,2,2}};
        UndirectedGraphNode node;

        for(int i = 0; i < A.length ; i++) {
            node = sol.genGraph(A[i]);
            sol.printGraph(node);
            node = sol.cloneGraph(node);
            sol.printGraph(node);
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
