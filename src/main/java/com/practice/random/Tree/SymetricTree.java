package com.practice.random.Tree;

public class SymetricTree {
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
     }

    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return true;
        if(root.left == null || root.right == null)
            return false;
        TreeNode left = root.left;
        TreeNode right = root.right;
        return isSymmetric(left, right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right){
          if(left == null && right == null)
              return true;
          if (left == null || right == null)
              return false;
          return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }



}
