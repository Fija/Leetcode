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

class Coord {
    int i;
    int j;
    Coord(int x, int y) {
        i = x; j = y;
    }
    @Override
    public boolean equals(Object aThat) {
        if(this == aThat) return true;
        if(!(aThat instanceof Coord)) return false;
        Coord that = (Coord)aThat;
        return(i == that.i && j == that.j);
    }
    @Override
    public int hashCode() {
        return 31*31 + 31*i + j;
    }
}

class Area implements Iterable<Coord>{
    List<Coord> area;
    int len;
    Area(Coord coord) {
        area  = new ArrayList<Coord>();
        area.add(coord);
        len = area.size();
    }
    public void add(Coord coord) {
        area.add(coord);
        len = area.size();
    }
    public void addAll(Area new_area) {
        area.addAll(new_area.area);
        len = area.size();
    }
    public Iterator<Coord> iterator() {
        return area.iterator();
    }
}


class Solution {
    void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        Set<Area> open = new HashSet<Area>();
        Set<Area> closed = new HashSet<Area>();
        Map<Coord, Area> map = new HashMap<Coord, Area>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    Coord coord = new Coord(i, j);
                    Area area = map.get(coord);
                    if(area == null) {
                        area = new Area(coord);
                        map.put(coord, area);
                        closed.add(area);
                    }
                    if(i == 0||j == 0||i == m-1||j == n-1) {
                        open.add(area);
                    }
                    if(i != m-1 && board[i+1][j] == 'O') {
                        Coord new_coord = new Coord(i+1, j);
                        area.add(new_coord);
                        map.put(new_coord, area);
                    }
                    if(j != n-1 && board[i][j+1] == 'O') {
                        Coord new_coord = new Coord(i, j+1);
                        Area new_area = map.get(new_coord);
                        if(new_area == null) {
                            area.add(new_coord);
                            map.put(new_coord, area);
                        }else if(area != new_area) {
                            merge(area, new_area, map, open, closed);
                        }
                    }
                }
            }
        }
        for(Area area : closed) {
            if(!open.contains(area)) {
                for(Coord coord : area) 
                    board[coord.i][coord.j] = 'X';
            }
        }
    }
    void merge(Area area, Area new_area, Map<Coord, Area> map, Set<Area> open,
               Set<Area> closed) {
        Area temp;
        if(area.len > new_area.len) {
            temp = area; area = new_area; new_area = temp;
        }
        area.addAll(new_area);
        for(Coord coord : new_area) {
            //can be optimized for just coord.i >= i
            map.put(coord, area);
        }
        if(open.contains(new_area) && !open.contains(area)) 
            open.add(area);
        open.remove(new_area);
        closed.remove(new_area);
    }
        

    char[][] genBoard(String[] A) {
        int m = A.length, n = A[0].length();
        char[][] board = new char[m][n];
        for(int i = 0 ; i < m; i++) {
           for(int j = 0; j < n; j++) {
              board[i][j] = A[i].charAt(j);
           }
        }
        return board;
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

    void printAr2(char[][] A) {
        if(A == null) return;
        for(int i =0; i < A.length; i++ ) {
            for(int j= 0; j < A[0].length; j++ ) {
                System.out.print(A[i][j] +" ");
            }
            System.out.println();
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

public class NewSolve{
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] A = {{"XXXXX",
                         "OOXOX",
                         "XOOOX",
                         "XOXXX",
                         "XXXXX"},
                        {"XOOXXXOXXOOOOOOOOOOO","XOOXXOOXOOOXOXOXOOXO","OOOXXXXOXOXXOOOOXOXO","OOOXXOOXOOOXXXOOXOOX","OOOOOOOXXXOOOOOOOOOO","XOOOOXOXOXXOOOOOOXOX","OOOXOOOXOXOXOXOXOXOX","OOOXOXOOXXOXOXXOXXXO","OOOOXOOXXOOOOXOOOXOX","OOXOOXOOOOOXOOXOOOXO","XOOXOOOOOOOXOOXOXOXO","OXOOOXOXOXXOXXXOXXOO","XXOXOOOOXOOOOOOXOOOX","OXOOXXXOOOXXXXXOXOOO","OOXXXOOOXXOOOXOXOOOO","XOOXOXOOOOXOOOXOXOXX","XOXOOOOOOXOOOXOXOOOO","OXXOOOXXXOXOXOXXXXOO","OXOOOOXXOOXOXOOXOOXX","OOOOOOXXXXOXOOOXXOOO"},
                        {"XXXXOOXXO",
                         "OOOOXXOOX",
                         "XOXOOXXOX",
                         "OOXXXOOOO",
                         "XOOXXXXXO",
                         "OOXOXOXOX",
                         "OOOXXOXOX",
                         "OOOXOOOXO",
                         "OXOOOXOXO"},
                        {"XOXO",
                         "XOOO",
                         "XXXX",
                         "XXXX"},
                        {"XOXXXOX",
                         "XOOXXOX",
                         "XOXOXOX",
                         "XOXOXOX",
                         "XOXXOXO",
                         "XOOOOXX",
                         "XXXXXXX"},
                        {""},{"X"},{"O"},{"XOX"},{"OXO"},{"OOO"},
                        {"XXXX",
                         "XOOX",
                         "XXOX",
                         "XOXX"}}; 

        for(int i = 0; i < A.length ; i++) {
            char[][] B = sol.genBoard(A[i]);
            sol.printAr2(B);
            sol.solve(B);
            sol.printAr2(B);
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
