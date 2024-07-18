package Leetcode.leet150.binaryTree;

import java.util.*;

public class Solution {
    private static HashMap<Integer, Integer> map;

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = buildTree(preorder, inorder);
        TreeNode root2 = buildTree2(inorder, postorder);
        System.out.println();
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;//p,q都为null则遍历结束，不同时为null则结构不同
        }
        if (q == null) {
            return false;//q单独为null
        }
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);//递归调用左右子树
    }

    public static TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        } else return null;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
            TreeNode t = temp.left;
            temp.left = temp.right;
            temp.right = t;
        }
        return root;
    }

    public static boolean isSymmetric_1(TreeNode root) {
        return check(root, root);
    }

    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    public static boolean isSymmetric_2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if (p == null && q == null) continue;
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;
            queue.add(p.left);
            queue.add(q.right);
            queue.add(p.right);
            queue.add(q.left);
        }
        return true;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder,0,n-1,0,n-1);
    }

    public static TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left,
                                       int preorder_right, int inorder_left, int inorder_right) {
        if(preorder_left > preorder_right) return null;
        TreeNode root = new TreeNode(preorder[preorder_left]);
        int pos = map.get(preorder[preorder_left]);
        int size_left = pos-inorder_left;
        root.left = myBuildTree(preorder,inorder,preorder_left+1,preorder_left+size_left,inorder_left,pos-1);
        root.right = myBuildTree(preorder,inorder,preorder_left+size_left+1,preorder_right,pos+1,inorder_right);
        return root;
    }

    public static TreeNode buildTree2(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        int n = postorder.length;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree2(inorder,postorder,0,n-1,0,n-1);
    }

    public static TreeNode myBuildTree2(int[] inorder, int[] postorder,int inorder_left,
                                        int inorder_right,int postorder_left,int postorder_right) {
        if(postorder_left > postorder_right) return null;
        TreeNode root = new TreeNode(postorder[postorder_right]);
        int pos = map.get(postorder[postorder_right]);
        int size_right = inorder_right-pos;
        root.left = myBuildTree2(inorder,postorder,inorder_left,pos-1,postorder_left,postorder_right-size_right-1);
        root.right = myBuildTree2(inorder,postorder,pos+1,inorder_right,postorder_right-size_right,postorder_right-1);
        return root;
    }
}
