package Collection.Tree;


import Leetcode.leet150.binaryTree.Solution;

import java.util.HashMap;

public class BuildTree {
    private static HashMap<Integer, Integer> map;

    public static TreeNode buildTree1(int[] preorder, int[] inorder) {
        int n = preorder.length;
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public static TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left,
                                       int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) return null;
        TreeNode root = new TreeNode(preorder[preorder_left]);
        int pos = map.get(preorder[preorder_left]);
        int size_left = pos - inorder_left;
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left, inorder_left, pos - 1);
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left + 1, preorder_right, pos + 1, inorder_right);
        return root;
    }

    public static TreeNode buildTree2(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        int n = postorder.length;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree2(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    public static TreeNode myBuildTree2(int[] inorder, int[] postorder, int inorder_left,
                                        int inorder_right, int postorder_left, int postorder_right) {
        if (postorder_left > postorder_right) return null;
        TreeNode root = new TreeNode(postorder[postorder_right]);
        int pos = map.get(postorder[postorder_right]);
        int size_right = inorder_right - pos;
        root.left = myBuildTree2(inorder, postorder, inorder_left, pos - 1, postorder_left, postorder_right - size_right - 1);
        root.right = myBuildTree2(inorder, postorder, pos + 1, inorder_right, postorder_right - size_right, postorder_right - 1);
        return root;
    }
}
