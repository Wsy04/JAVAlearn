package Collection.Tree;

public class TreeTest {
    public static void main(String[] args) {
        /*
         *            20
         *     18            23
         * 16      19    22     24
         *
         *
         * */
        int[] preorder = {20, 18, 16, 19, 23, 22, 24};
        int[] inorder = {16, 18, 19, 20, 22, 23, 24};
        int[] postorder = {16, 19, 18, 22, 24, 23, 20};
//        TreeNode root = BuildTree.buildTree1(preorder,inorder);
        TreeNode root = BuildTree.buildTree2(inorder, postorder);
        TreeTravel.preOrderTraversal(root);
        System.out.println();
        TreeTravel.inOrderTraversal(root);
        System.out.println();
        TreeTravel.postOrderTraversal(root);
        System.out.println();
        TreeTravel.levelOrderTraversal(root);
    }
}
