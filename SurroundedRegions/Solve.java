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
/*
class Area implements Iterable<Coord>{
    List<Coord> area;
    Area() {
        area  = new ArrayList<Coord>();
    }
    void add(Coord coord) {
        area.add(coord);
    }
    public Iterator<Coord> iterator() {
        return area.iterator();
    }
}
*/

class Area implements Iterable<Integer[]>{
    List<Integer[]> area;
    Area() {
        area  = new ArrayList<Integer[]>();
    }
    void add(Integer[] coord) {
        area.add(coord);
    }
    public Iterator<Integer[]> iterator() {
        return area.iterator();
    }
}


class Solution {
    void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        Set<Area> open = new HashSet<Area>();
        Set<Area> closed = new HashSet<Area>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    Area area = new Area();
                    closed.add(area);
                    expand(area, board, open, i, j, 0);
                }
            }
        }
        for(Area area : closed) {
            if(open.contains(area)) {
                for(Integer[] coord : area) 
                    board[coord[0]][coord[1]] = 'O';
            }else {
                for(Integer[] coord : area) 
                    board[coord[0]][coord[1]] = 'X';
            }
            /*
            if(open.contains(area)) {
                for(Coord coord : area) 
                    board[coord.i][coord.j] = 'O';
            }else {
                for(Coord coord : area) 
                    board[coord.i][coord.j] = 'X';
            }
            */
        }
    }
    void expand(Area area, char[][] board, Set<Area> open, int i, int j, int k) {
        int m = board.length, n = board[0].length, new_i, new_j;
        int[] newij = new int[2];
        board[i][j] = 'V';
        //Coord coord = new Coord(i, j);
        Integer[] coord = new Integer[2];
        coord[0] = i; coord[1] = j;
        area.add(coord);
        if(i == 0 || j == 0 || i == m-1 || j == n-1) {
            open.add(area);
        }
        if(move(board, newij, i, j, m, n, k)) {
            expand(area, board, open, newij[0], newij[1], 0);
        }
        if(k != 3) {
            expand(area, board, open, i, j, k+1);
        }
    }
    boolean move(char[][] board, int[] newij, int i, int j, int m, int n, int k) {
        if(k == 0 && i != 0 && board[i-1][j] == 'O') {
            newij[0] = i-1; newij[1] = j; return true;
        }
        if(k == 1 && j != n-1 && board[i][j+1] == 'O') {
            newij[0] = i; newij[1] = j+1; return true;
        }
        if(k == 2 && i != m-1 && board[i+1][j] == 'O') {
            newij[0] = i+1; newij[1] = j; return true;
        }
        if(k == 3 && j != 0 && board[i][j-1] == 'O') {
            newij[0] = i; newij[1] = j-1; return true;
        }
        return false;
    }
            




/*
    void wrongagiansolve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        Map<Coord, Area> map = new HashMap<Coord, Area>();
        Set<Set<Area>> open = new HashSet<Set<Area>>();
        Set<Set<Area>> closed = new HashSet<Set<Area>>();
        Map<Area, Set<Area>> connected = new HashMap<Area, Set<Area>>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    Coord coord = new Coord(i, j);
                    if(!(map.containsKey(coord))) {
                        Area area = new Area();
                        area.add(coord);
                        map.put(coord,area);
                        Set<Area> area_set = new HashSet<Area>();
                        area_set.add(area);
                        connected.put(area, area_set);
                        closed.add(area_set);
                    }
                    if(i == 0 || j == 0 || i == m-1 || j == n-1) {
                        Set<Area> area_set = connected.get(map.get(coord));
                        if(!open.contains(area_set)) {
                            open.add(area_set);
                        }
                    }
                    if(j != n-1 && board[i][j+1] == 'O') {
                        Coord new_coord = new Coord(i, j+1);
                        Area area = map.get(coord);
                        Area new_area = map.get(new_coord);
                        if(new_area == null) {
                            area.add(new_coord);
                            map.put(new_coord, area);
                        }else if (!connected.get(area).contains(new_area)){
                           //can be optimized a little 
                            Set<Area> area_set = connected.get(area);
                            Set<Area> new_area_set = connected.get(new_area);
                            area_set.addAll(new_area_set);
                            new_area_set.addAll(area_set);
                        }
                    }
                    if(i != m-1 && board[i+1][j] == 'O') {
                        Coord new_coord = new Coord(i+1, j);
                        Area area = map.get(coord);
                        area.add(new_coord);
                        map.put(new_coord, area);
                    }
                }
            }
        }
        for(Set<Area> area_set : closed) {
            if(!(open.contains(area_set))) {
                for(Area area : area_set) {
                    for(Coord coord : area) {
                        board[coord.i][coord.j] = 'X';
                    }
                }
            }
        }
    }
    /*
    void wrongsolve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        Map<Coord, Area> map = new HashMap<Coord, Area>();
        Set<Area> open = new HashSet<Area>();
        Set<Area> closed = new HashSet<Area>();
        Map<Area, Set<Area>> connected = new HashMap<Area, Set<Area>>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    Coord coord = new Coord(i, j);
                    if(!(map.containsKey(coord))) {
                        Area area = new Area();
                        area.add(coord);
                        map.put(coord,area);
                        closed.add(area);
                        Set<Area> area_set = new HashSet<Area>();
                        area_set.add(area);
                        connected.put(area, area_set);
                    }
                    if(i == 0 || j == 0 || i == m-1 || j == n-1) {
                        for(Area area : connected.get(map.get(coord))) {
                            open.add(area);
                        }
                    }
                    if(j != n-1 && board[i][j+1] == 'O') {
                        Coord new_coord = new Coord(i, j+1);
                        Area area = map.get(coord);
                        Area new_area = map.get(new_coord);
                        if(new_area == null) {
                            area.add(new_coord);
                            map.put(new_coord, area);
                        }else if (!connected.get(area).contains(new_area)){
                           //can be optimized a little 
                            Set<Area> area_set = connected.get(area);
                            Set<Area> new_area_set = connected.get(new_area);
                            /*
                            if(open.contains(new_area) &&
                                    !open.contains(area)) {
                                for(Area t_area : area_set) open.add(t_area);
                            else if(!open.contains(new_area) &&
                                    open.contains(area)) {
                                for(Area t_area : new_area_set) open.add(t_area);
                                */
/*
                            area_set.addAll(new_area_set);
                            new_area_set.addAll(area_set);
                        }
                    }
                                    /*
                        }else if(new_area != area) {

                            if(open.contains(new_area) &&
                               !(open.contains(area))) {
                                open.add(area);
                            }else if(!(open.contains(new_area)) &&
                                     open.contains(area)) {
                                open.add(new_area);
                            }else if(!(open.contains(new_area)) &&
                                    !open.contains(area)) {
                                connected.add(new_area);
                            }
                        }
                    }else if(j != n-1) {
                        connected.clear();
                    }
                            */
/*
                    if(i != m-1 && board[i+1][j] == 'O') {
                        Coord new_coord = new Coord(i+1, j);
                        Area area = map.get(coord);
                        area.add(new_coord);
                        map.put(new_coord, area);
                    }
                }
            }
        }
        for(Area area : closed) {
            if(!(open.contains(area))) {
                for(Coord coord : area) {
                    board[coord.i][coord.j] = 'X';
                }
            }
        }
    }
    */
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

public class Solve{
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
