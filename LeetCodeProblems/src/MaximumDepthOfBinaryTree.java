import com.sun.source.tree.Tree;

public class MaximumDepthOfBinaryTree {
    public static int maxDepth(TreeNode root){
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth , rightDepth) + 1;
    }
    public static void main(String[] args) {
        // Construct the binary tree (example)
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();
        int depth = solution.maxDepth(root);
        System.out.println("Maximum depth: " + depth); // Output: 3
    }
}
