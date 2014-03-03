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
    String simplifyPath(String path) {
    	if(path == null || path.length() == 0) return "";
        int i =1, start = 0;
        String s = "", folder;
        Stack<String> stack = new Stack<String>();
        while(true) {
            if(i >= path.length() || path.charAt(i) == '/') {
                folder = path.substring(start+1, i);
                if(folder.equals("..") && !stack.empty()) {
                    stack.pop(); 
                }else if(!folder.equals("") && !folder.equals(".") &&
                        !folder.equals("..")) {
                    stack.push(folder);
                }
                start = i;
                if(start >= path.length()-1) break;
            }
            i += 1;
        }
        if(stack.empty()) s = "/"; 
        else {
        	while(true) {
                if(!stack.empty()) s = "/"+stack.pop()+s;
                else break;
        	}
        }
        return s;
    }
    /*
    String simplifyPath(String path) {
        int i =0, pre_dir = 0;
        String s;
        while(true) {
            if(i == path.length()) {
                return path;
            }else {
                if(path.charAt(i) == '.') {
                    if(i+1 < path.length()) {
                        if(path.charAt(i+1) == '.') {
                            if(i+2 < path.length()) {
                                if(path.charAt(i+2) == '/') {
                                    path = path.substring(0, pre_dir+1, i+3);
                                    i = pre_dir; 
                                }else {
                                    path = path.substring(pre_dir+1, i+2);
                                    i = pre_dir;
                                }
                            }else {
                                path = path.substring(pre_dir+1, i+2);
                                i = pre_dir;
                            }
                        }else if(path.charAt(i+1) == '/') {
                            path = path.substring(i, i+2);
                        }else path = path.substring(i, i+1);
                    }else path = path.substring(i, i+1);
                }else if(path.charAt(i) == '/') {
                    if(i == pre_dir+1) path = path.substring(i, i+1);
                    else pre_dir = i;
                }
                i += 1;
            }
        }
    }
    */

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

public class SimplifyPath  {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {"","/.","/..","/home.aaa/../d/","/../",
                      "/home//foo/","/...","/a/./b/../../c/","/home/"};
        //int[][] B = {{}};



        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.simplifyPath(A[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
