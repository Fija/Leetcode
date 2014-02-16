import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {val = x;}
}

class State {
    TreeNode node;
    LinkedList<Integer> list_command;
    State(TreeNode tmp_node, LinkedList<Integer> list) {
        node = tmp_node;
        list_command = list;
    }
}

class Solution {
    ArrayList<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> array = new ArrayList<Integer>();
        queue.offerLast(root);
        while(true) {
            root = queue.pollLast();
            if (root == null) break;
            array.add(root.val);
            if (root.right != null)
            queue.offerLast(root.right);
            if (root.left != null)
            queue.offerLast(root.left);
        }
        return array;
    }

    ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node;
        node = root;
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }else if(!stack.empty()) {
                node = stack.pop();
                array.add(node.val);
                node = node.right;
            }else break;
        }
        return array;
    }

    ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode previsited = null;
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }else {
                if (stack.empty()) break;
                root = stack.peek();
                if (root.right == previsited || root.right == null) {
                    root = stack.pop();
                    previsited = root;
                    array.add(root.val);
                    root = null;
                }else {
                    root = root.right;
                }
            }
        }
        return array;
    }

    ArrayList<Integer> stackSim(TreeNode root) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        LinkedList<Integer> full_list_command = new LinkedList<Integer>();
        LinkedList<State> stack = new LinkedList<State>();
        State state;
        Integer command;
        int i;
        for(i = 0; i < 4; i++) {
            full_list_command.offer(i);
        }
        stack.push(new State(root, new LinkedList<Integer>(full_list_command)));
        for(;;) {
            try {
                state = stack.pop();
            }catch(Exception ex) {
                break;
            }
            for(;;) {
                try {
                    command = state.list_command.pop();
                }catch(Exception ex) {
                    break;
                }
                if(command == 0) {
                    if(state.node == null) break;
                }else if(command == 1) {
                    stack.push(state);
                    stack.push(new State(state.node.left,
                               new LinkedList<Integer>(full_list_command)));
                    break;
                }else if(command == 2) {
                    stack.push(state);
                    stack.push(new State(state.node.right,
                               new LinkedList<Integer>(full_list_command)));
                    break;
                }else {
                    array.add(state.node.val);
                }
            }
        }
        return array;
    }
}


            

public class PreTrav {
    //static int[] A = {1,-1,2,3};
    static int[] A = {1,2,3,-1,-1,4,-1,-1,5};
    static int len = A.length;

    public static void growTree(TreeNode root) {
        int i = 0; 
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (i < len-1) {
            root = queue.poll();
            if (i+1 < len && A[i+1] != -1) {
                root.left = new TreeNode(A[i+1]);
                queue.offer(root.left);
            }
            i += 1;
            if (i+1 < len && A[i+1] != -1) {
                root.right = new TreeNode(A[i+1]);
                queue.offer(root.right);
            }
            i += 1;
        }
    }

    public static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.println(root.val);
            printTree(root.right);
        }
    }

    public static void printSol(ArrayList<Integer> tree) {
        int i;
        for (i = 0; i < tree.size(); i++) {
            System.out.println(tree.get(i));
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int i;
        TreeNode root = new TreeNode(A[0]);
        growTree(root);
        printTree(root);
        System.out.println("\n");
        Solution sol = new Solution();
        //root = null;
        ArrayList<Integer> pretree = sol.preorderTraversal(root);
        printSol(pretree);
        ArrayList<Integer> intree = sol.inorderTraversal(root);
        printSol(intree);
        ArrayList<Integer> posttree = sol.postorderTraversal(root);
        printSol(posttree);
        ArrayList<Integer> stacksimtree = sol.stackSim(root);
        printSol(stacksimtree);
    }
}



