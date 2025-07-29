import java.util.*;

class Tree {
    int val;
    Tree left, right;
    Tree(int v) { val = v; }
}

public class F12_TreeDiameter {
    static int maxDiameter = 0;

    public static int height(Tree root) {
        if (root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        maxDiameter = Math.max(maxDiameter, lh + rh);
        return Math.max(lh, rh) + 1;
    }

    public static Tree build(String[] vals) {
        if (vals.length == 0 || vals[0].equals("-1")) return null;
        Tree root = new Tree(Integer.parseInt(vals[0]));
        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < vals.length) {
            Tree node = q.poll();
            if (!vals[i].equals("-1")) {
                node.left = new Tree(Integer.parseInt(vals[i]));
                q.add(node.left);
            }
            i++;
            if (i < vals.length && !vals[i].equals("-1")) {
                node.right = new Tree(Integer.parseInt(vals[i]));
                q.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nodes = sc.nextLine().split(" ");
        Tree root = build(nodes);
        height(root);
        System.out.println("Diameter: " + maxDiameter);
    }
}