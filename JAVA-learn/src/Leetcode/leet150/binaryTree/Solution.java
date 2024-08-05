package Leetcode.leet150.binaryTree;

import java.util.*;

public class Solution {
    private static HashMap<Integer, Integer> map;
    private static LinkedList<TreeNode> queue;
    private static ArrayList<Integer> list;
    private static int max = Integer.MIN_VALUE;


    public static void main(String[] args) {
        int[] preorder = {4,9,5};
        int[] inorder = {2,1,3};
        int[] postorder = {2,3,1};
        TreeNode root = buildTree(preorder, inorder);
        TreeNode root2 = buildTree2(inorder, postorder);
        System.out.println(sumNumbers(root));
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

    public static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        public Node(int val) {
            this.val = val;
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

    public static Node connect(Node root) {
        if (root == null) return null;
        Node head = root;//每层的头结点
        while (head != null) {
            Node dummyHead = new Node(-1);//虚拟头结点
            Node temp = dummyHead;//用于连接下一层的变量
            for (Node cur = head; cur != null; cur = cur.next) {//遍历当前层
                if (cur.left != null) {
                    temp.next = cur.left;//进行连接
                    temp = temp.next;
                }
                if (cur.right != null) {
                    temp.next = cur.right;
                    temp = temp.next;
                }
            }
            head = dummyHead.next;//从下一层的头结点开始
        }
        return root;
    }

    public static void flatten(TreeNode root) {
        //本质上是把左子树插入到右子树之前
        while (root != null) {
            if (root.left == null) {
                root = root.right;//左子树为空,无需处理
            } else {
                TreeNode temp = root.left;
                while (temp.right != null) {
                    temp = temp.right;//左子树中最右端的结点
                }
                temp.right = root.right;//插入到右子树之前
                root.right = root.left;//左子树移动到右边
                root.left = null;
                root = root.right;
            }
        }
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == targetSum;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static int sumNumbers(TreeNode root) {
        return dfsSumNumbers(root,0);
    }

    public static int dfsSumNumbers(TreeNode root, int sum) {
        if (root == null) return 0;
        sum *= 10;
        sum += root.val;
        if(root.left == null&&root.right == null) return sum;
        return dfsSumNumbers(root.left, sum) + dfsSumNumbers(root.right, sum);
    }

    public static int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }

    public static int maxGain(TreeNode root) {
        if(root == null) return 0;
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        //只选取贡献值为正的结点
        int pathSum = root.val + leftGain + rightGain;
        max = Math.max(max, pathSum);
        return root.val+Math.max(leftGain,rightGain);
    }

    static class BSTIterator {
        private final List<Integer> list;
        private int index = 0;
        public BSTIterator(TreeNode root) {
            list = new ArrayList<>();
            inorder(root);
        }

        public int next() {
            return list.get(index++);
        }

        public boolean hasNext() {
            return index < list.size();
        }
        public void inorder(TreeNode root) {
            if (root == null) return;
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left)+countNodes(root.right)+1;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null||root == p||root == q) return root;//root已经不能再往下或者找到p,q
        TreeNode left = lowestCommonAncestor(root.left, p, q);//左子树中寻找p,q,都没找到会返回null
        TreeNode right = lowestCommonAncestor(root.right, p, q);//右子树中寻找p,q,都没找到会返回null
        if(left != null && right != null) return root;//p,q分别在左右子树中,返回当前结点
        return left != null ? left : right;//p,q在其中一个子树中,返回该子树中的遍历结果,题目给定p,q在树中,所以不会同时为空
    }


    //二叉树的层次遍历

    public static List<Integer> rightSideView1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (i == n - 1) list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return list;
    }

    public static List<Integer> rightSideView2(TreeNode root) {
        list = new ArrayList<>();
        if (root == null) return list;
        dfsRightSideView(root, 0);
        return list;
    }

    public static void dfsRightSideView(TreeNode root, int depth) {
        //第一个找到的符合当前深度的结点就是最右边的结点
        if (root == null) return;
        if (list.size() == depth) list.add(root.val);
        dfsRightSideView(root.right, depth + 1);
        dfsRightSideView(root.left, depth + 1);
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            double sum = 0.0;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            list.add(sum / n);
        }
        return list;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean right = true;
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            if(right){
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.pollFirst();
                    list.add(node.val);
                    if (node.left != null) queue.offerLast(node.left);
                    if (node.right != null) queue.offerLast(node.right);
                }
                right = false;
            }else {
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.pollLast();
                    list.add(node.val);
                    if (node.right != null) queue.offerFirst(node.right);
                    if (node.left != null) queue.offerFirst(node.left);
                }
                right = true;
            }
            res.add(list);
        }
        return res;
    }

}
