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
    boolean isMatch(String s, String p) {
        p = compressAsterisk(p);

        int i = 0, j = 0, lens = s.length(), lenp = p.length(),
            prev_s = 0, prev_p = 0;
        boolean has_star = false;
        int[] p_min_remain = new int[lenp];
        int[] no_star = new int[1];

        preprocess(p, p_min_remain, no_star);

        while(true) {
            if(i == lens && j == lenp) return true;
            if(j == lenp) {
                if(!has_star) return false;
                else {
                    prev_s++;
                    i = prev_s;
                    j = prev_p;
                }
            }
            if(p_min_remain[j] > lens-i ||
               !has_star && j >= no_star[0] && lenp-j != lens-i)
                return false;
            if(i == lens) {
                if(p.charAt(j) != '*') return false;
                else return j == lenp-1;
                /*
                else {
                    while(j < lenp && p.charAt(j) == '*') j++;
                    return j == lenp;
                }
                */
            }
            if(s.charAt(i) == p.charAt(j) && p.charAt(j) != '*' ||
               p.charAt(j) == '?') {
                i++;
                j++;
            }else {
                if(p.charAt(j) == '*') {
                    has_star = true;
                    //while(j < lenp && p.charAt(j) == '*') j++;
                    j++;
                    if(j == lenp) return true;
                    prev_s = i;
                    prev_p = j;
                }else {
                    if(!has_star) return false;
                    else {
                        prev_s++;
                        i = prev_s;
                        j = prev_p;
                    }
                }
            }
        }
    }
    void preprocess(String p, int[] p_min_remain, int[] no_star) {
        int len = p.length(), count = 0;
        if(len == 0) return;
        boolean star = p.charAt(len-1) == '*';
        no_star[0] = len;
        for(int i = len-1; i >= 0; i--) {
            if(!star) no_star[0]--;
            if(p.charAt(i) == '*') {
                p_min_remain[i] = count;
                star = true;
                no_star[0]++;
                continue;
            }
            p_min_remain[i] = ++count;
        }
    }

    boolean slowisMatch(String s, String p) {
        p = compressAsterisk(p);
        return recurMatch(s, p, 0, 0);
    }
    String compressAsterisk(String p) {
        StringBuilder new_p = new StringBuilder();
        char c;
        int len = p.length();
        for(int i = 0; i < len; i++) {
            c = p.charAt(i);
            if(c == '*' && i < len-1 && p.charAt(i+1) == '*')
                continue;
            new_p.append(c);
        }
        return new_p.toString();
    }
    boolean recurMatch(String s, String p, int i, int j) {
        int lens = s.length(), lenp = p.length();
        if(i == lens && j == lenp) 
            return true;
        if(i == lens) 
            return j == lenp-1 && p.charAt(j) == '*';
        if(j == lenp) 
            return false;
        char c1 = s.charAt(i), c2 = p.charAt(j);
        if(c1 == c2 && c2 != '*' || c2 == '?') 
            return recurMatch(s, p, i+1, j+1);
        if(c2 == '*') 
            return recurMatch(s, p, i, j+1) || recurMatch(s, p, i+1, j);
        return false;
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

public class IsMatch{
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {"abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbaba",
                      "abcdebcdde","hi",
                      "","","a","***?",
                      "geeks","geeksforgeeks","gee","pqrst","abcdhghgbcd",
                      "abcd","abcd","abcd",
                      "aa","aa","aaa","aa","aa","ab","aab"};
        String[] B = {"**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb",
                      "*abcd?e*","*?",
                      "","a","","*",
                      "g*ks","ge?ks*","g*k","*pqrs","abc*bcd","abc*c?d","*c*d",
                      "*?c*d",
                      "a","aa","aa","*","a*","?*","c*a*b"};
        boolean[] C = {false,
                       false, true,
                       true, false, false, true,
                       true, true, false, false, true, false, true, true,
                       false, true, false, true, true, true, false};
        StringBuilder s = new StringBuilder();
        StringBuilder p = new StringBuilder();
        p.append('*');
        for(int i = 0; i < 32320; i++) {
            s.append('a');
            p.append('a');
        }
        p.append('*');
        A[0] = s.toString();
        B[0] = p.toString();
        C[0] = true;



        for(int i = 0; i < A.length ; i++) {
            System.out.println(C[i] == sol.isMatch(A[i], B[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
