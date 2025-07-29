import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int v) { val = v; }
}

public class F09_BinaryTreeLeftView {
    public static TreeNode buildTree(String[] values) {
        if (values.length == 0 || values[0].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode curr = queue.poll();
            if (!values[i].equals("-1")) {
                curr.left = new TreeNode(Integer.parseInt(values[i]));
                queue.add(curr.left);
            }
            i++;
            if (i < values.length && !values[i].equals("-1")) {
                curr.right = new TreeNode(Integer.parseInt(values[i]));
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static void printLeftView(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0) System.out.print(node.val + " ");
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        TreeNode root = buildTree(input);
        System.out.print("LeftView: ");
        printLeftView(root);
    }
}