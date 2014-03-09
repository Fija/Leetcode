import java.util.*;
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
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
    protected int[] A = new int[2];
    Coord (Point p) {
        A[0] = p.x; A[1] = p.y;
    }
    int get(int i) {
        return A[i];
    }
    @Override
    public boolean equals(Object aThat) {
        if(aThat == this) return true;
        if(!(aThat instanceof Coord)) return false;
        Coord that = (Coord)aThat;
        return Arrays.equals(this.A,that.A);
    }
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.A);
    }
}
class Line {
    protected double[] A = new double[3];
    Line(double a, double b, double c) {
        A[0] = a; A[1] = b; A[2] = c;
    }
    @Override
    public boolean equals(Object aThat) {
        if(aThat == this) return true;
        if(!(aThat instanceof Line)) return false;
        Line that = (Line)aThat;
        return Arrays.equals(this.A, that.A);
    }
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.A);
    }
}
class Solution {
    public int maxPoints(Point[] points) {
        int i,j, len = points.length, max = 0;
        Line line;
        HashMap<Line,Integer> map = new HashMap<Line,Integer>();
        HashMap<Line,Integer> added = new HashMap<Line,Integer>();
        HashMap<Coord,Integer> dup = new HashMap<Coord,Integer>();

        for(i = 0; i < len; i++) {
            Coord point = new Coord(points[i]);
            if(dup.containsKey(point)) dup.put(point, dup.get(point)+1);
            else dup.put(point, 1);
        }

        Coord[] coords = dup.keySet().toArray(new Coord[0]);
        if(coords.length == 1) return dup.get(coords[0]);

        for(i = 0; i < coords.length; i++) {
            for(j = 0; j < i; j++) {
                line = getLine(coords[i], coords[j]);
                if(map.containsKey(line)) {
                    if(!added.containsKey(line)) {
                        map.put(line, map.get(line)+dup.get(coords[i]));
                        added.put(line,1);
                    }
                }else {
                    map.put(line, dup.get(coords[j])+dup.get(coords[i]));
                    added.put(line,1);
                }
            }
            added.clear();
        }
        for(Integer count : map.values()) {
            if(count > max) max = count;
        }
        return max;
    }
    Line getLine(Coord a, Coord b) {
        double x = a.get(0), y = a.get(1), w = b.get(0), v = b.get(1),
               A =0., B=0., C=0., det;
        det = x*v-w*y;
        if(det != 0) {
            A = (y-v)/det;
            B = (w-x)/det;
            C = 1.;
            if(A == 0.) A = 0.;
            if(B == 0.) B = 0.;
        }else {
            if(x == 0. && y == 0.) {
                if(w == 0.) {A = 1.; B = 0.;}
                else if(v == 0.) {A = 0.; B = 1.;}
                else {A = 1.; B = -w/v;}
            }else if(x == 0.) {
                A = 1.; B = 0.;
            }else if(y == 0.) {
                A = 0.; B = 1.;
            }else {A = 1.; B = -x/y;}
        }
        Line line = new Line(A, B, C);
        return line;
    }
    Point[] genPoints(int[] array) {
        int i;
        Point[] points = new Point[array.length/2];
        for(i = 0; i < array.length; i+=2) 
            points[i/2] = new Point(array[i],array[i+1]);
        return points;
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

public class MaxPoints {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] A = {{2,3,3,3,-5,3},
                     {0,9,138,429,115,359,115,359,-30,-102,230,709,-150,-686,-135,-613,-60,-248,-161,-481,207,639,23,79,-230,-691,-115,-341,92,289,60,336,-105,-467,135,701,-90,-394,-184,-551,150,774},
                     {3,10,0,2,0,2,3,10},{1,1,1,1,1,1},{},
                     {0,0,1,1,1,-1},{0,0,1,1,0,0},{1,2,3,4,2,4},
                     {29,87,145,227,400,84,800,179,60,950,560,122,-6,5,-87,-53,-64,-118,-204,-388,720,160,-232,-228,-72,-135,-102,-163,-68,-88,-116,-95,-34,-13,170,437,40,103,0,-38,-10,-7,-36,-114,238,587,-340,-140,-7,2,36,586,60,950,-42,-597,-4,-6,0,18,36,586,18,0,-720,-182,240,46,5,-6,261,367,-203,-193,240,46,400,84,72,114,0,62,-42,-597,-170,-76,-174,-158,68,212,-480,-125,5,-6,0,-38,174,262,34,137,-232,-187,-232,-228,232,332,-64,-118,-240,-68,272,662,-40,-67,203,158,-203,-164,272,662,56,137,4,-1,-18,-233,240,46,-3,2,640,141,-480,-125,-29,17,-64,-118,800,179,-56,-101,36,586,-64,-118,-87,-53,-29,17,320,65,7,5,40,103,136,362,-320,-87,-5,5,-340,-688,-232,-228,9,1,-27,-95,7,-5,58,122,48,120,8,35,-272,-538,34,137,-800,-201,-68,-88,29,87,160,27,72,171,261,367,-56,-101,-9,-2,0,52,-6,-7,170,437,-261,-210,-48,-84,-63,-171,-24,-33,-68,-88,-204,-388,40,103,34,137,-204,-388,-400,-106}};
        //int[][] B = {{}};



        for(int i = 0; i < A.length ; i++) {
            System.out.println(sol.maxPoints(sol.genPoints(A[i])));
        }
/*
        sol.printTree(sol.growTree(A[i]));
        System.out.print();
        System.out.println();
*/
    }
}
