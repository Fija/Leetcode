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
    ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> text = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        int start = 0;
        int count = 0;
        int currentSpace = 0;
        int len = words.length;
        int k = 0;
        while(k <= len) {
            int extraSpace = L - currentSpace;
            if(k == len) {
                for(int i = start; i < len; i++) {
                    line.append(words[i]);
                    if(line.length() < L) {
                        line.append(' ');
                    }
                }
                for(int i = line.length(); i < L; i++) {
                    line.append(' ');
                }
                text.add(line.toString());
                break;
            }else if(words[k].length() <= extraSpace) {
                count += 1;
                currentSpace += words[k].length() + 1; 
                k++;
            }else {
                int totalSpace = extraSpace + count;
                if(count == 1) {
                    line.append(words[start]);
                    for(int i = 0; i < totalSpace; i++) {
                        line.append(' ');
                    }
                }else {
                    int gap = totalSpace / (count-1);
                    int adjust = totalSpace % (count-1);
                    for(int i = start; i < start + count; i++) {
                        line.append(words[i]);
                        if(i < start + adjust) {
                            for(int j = 0; j < gap+1; j++) {
                                line.append(' ');
                            }
                        }else if(i < start + count - 1){
                            for(int j = 0; j < gap; j++) {
                                line.append(' ');
                            }
                        }
                    }
                }
                text.add(line.toString());
                line = new StringBuilder();
                start += count;
                count = 0;
                currentSpace = 0;
            }
        }
        return text;
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

    void printAL(ArrayList<String> A) {
        if(A == null) return;
        for(int i = 0; i < A.size(); i++) {
            System.out.println(A.get(i)+'#');
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

public class FullJustify {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] A = {{""},
                        {"a","bc",""},{"This", "is","an","example","of","text",
                         "justification"}};
        int[][] B = {{0},{4,3},{21,16}};
        for(int i = 0; i < A.length ; i++) {
            for(int j = 0; j < B[i].length ; j++) {
                sol.printAL(sol.fullJustify(A[i], B[i][j]));
            }
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
