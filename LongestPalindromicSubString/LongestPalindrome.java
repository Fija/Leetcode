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
    //Manacher's O(N) algorithm
    String longestPalindrome(String s) {
        int i, len = 2*s.length()+1, max = 1, max_right = 0,
               id_right = 0, id_max = 0;
        char[] S = expand(s);
        int[] L = new int[len];
        for(i = 0 ; i < len; i++) {
            L[i] = max_right > i?
                   Math.min(max_right-i+1, L[2*id_right-i]):1;
            while(i-L[i] >= 0 && i+L[i] < len &&
                  S[i+L[i]] == S[i-L[i]]) L[i] += 1;
            if(i + L[i] -1 > max_right) {
                max_right = i+L[i]-1;
                id_right = i;
            }
        }
        for(i = 0; i < len; i++) {
            if(L[i] > max) {
                max = L[i];
                id_max = i;
            }
        }
        return output(s, max, id_max);
    }
    char[] expand(String s) {
        char[] S = new char[s.length()*2+1];
        S[0] = '#';
        int i;
        for(i = 0; i < s.length(); i++) {
            S[i*2+1] = s.charAt(i);
            S[i*2+2] = '#';
        }
        return S;
    }
    String output(String s, int max, int id_max) {
        int start = (id_max - max+1)/2,
            end = (id_max + max-1)/2;
        return s.substring(start,end);
    }

        
        


    String naiveDPLongestPalindrome(String s) {
        int i, k, len= s.length();
        boolean is_pa , has_len = false;
        ArrayList<ArrayList<String>> dp =
            new ArrayList<ArrayList<String>>();
        String max_str = "";
        for(k = 0; k < len; k++) {
            dp.add(new ArrayList<String>());
            for(i = 0; k +i < len; i++) {
                has_len = false;
                if(k == 0) {
                    max_str = s.substring(i,i+1);
                    dp.get(k).add(s.substring(i,i+1));
                    has_len = true;
                }else if(k == 1) {
                    is_pa = s.charAt(i) == s.charAt(i+1);
                    if(is_pa) {
                        max_str = s.substring(i, i+2);
                        dp.get(k).add(max_str);
                        has_len = true;
                    }else dp.get(k).add(new String());
                }else {
                    is_pa = s.charAt(i) == s.charAt(i+k) &&
                            !dp.get(k-2).get(i+1).equals("");
                    if(is_pa) {
                        max_str = s.substring(i, i+k+1);
                        dp.get(k).add(max_str);
                        has_len = true;
                    }else {
                        dp.get(k).add(new String());
                    }
                }
            }
        }
        return max_str;
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

public class LongestPalindrome {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] A = {"bb","ab","", "a","abaca","abacabegc",
                      "ukxidnpsdfwieixhjnannbmtppviyppjgbsludrzdleeiydzawnfmiiztsjqqqnthwinsqnrhfjxtklvbozkaeetmblqbxbugxycrlzizthtuwxlmgfjokhqjyukrftvfwikxlptydybmmzdhworzlaeztwsjyqnshggxdsjrzazphugckgykzhqkdrleaueuajjdpgagwtueoyybzanrvrgevolwssvqimgzpkxehnunycmlnetfaflhusauopyizbcpntywntadciopanyjoamoyexaxulzrktneytynmheigspgyhkelxgwplizyszcwdixzgxzgxiawstbnpjezxinyowmqsysazgwxpthloegxvezsxcvorzquzdtfcvckjpewowazuaynfpxsxrihsfswrmuvluwbdazmcealapulnahgdxxycizeqelesvshkgpavihywwlhdfopmmbwegibxhluantulnccqieyrbjjqtlgkpfezpxmlwpyohdyftzgbeoioquxpnrwrgzlhtlgyfwxtqcgkzcuuwagmlvgiwrhnredtulxudrmepbunyamssrfwyvgabbcfzzjayccvvwxzbfgeglqmuogqmhkjebehtwnmxotjwjszvrvpfpafwomlyqsgnysydfdlbbltlwugtapwgfnsiqxcnmdlrxoodkhaaaiioqglgeyuxqefdxbqbgbltrxcnihfwnzevvtkkvtejtecqyhqwjnnwfrzptzhdnmvsjnnsnixovnotugpzuymkjplctzqbfkdbeinvtgdpcbvzrmxdqthgorpaimpsaenmnyuyoqjqqrtcwiejutafyqmfauufwripmpcoknzyphratopyuadgsfrsrqkfwkdlvuzyepsiolpxkbijqw"};
        //int[][] B = {{}};



        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.longestPalindrome(A[i]));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
