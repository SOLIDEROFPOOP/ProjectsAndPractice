public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {

    }
    public int height(TreeNode node){
        if (node == null) return 0;
        return 1 + Math.max(height(node.left),height(node.right));
        
    }
}
