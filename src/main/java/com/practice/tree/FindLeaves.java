package com.practice.tree;

import java.util.*;

public class FindLeaves {

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

    private Map<Integer, List<Integer>> leaveMap;

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(0, new ArrayList<>(root.val));



        leaveMap =  new HashMap<>();
        setHeight(root);
        return mapToList(leaveMap);
    }

    public List<List<Integer>> mapToList(Map<Integer, List<Integer>> map) {
        List<List<Integer>> nodeList = new ArrayList<>();
        for(int i = 0; i < map.size(); i++){
            nodeList.add(map.get(i));
        }
        return nodeList;
    }

    private int setHeight(TreeNode node){
        if(node==null)
            return -1;
        int height = Math.max(setHeight(node.left), setHeight(node.right))+1;
        List<Integer> currentList = this.leaveMap.getOrDefault(height, new ArrayList<>());
        currentList.add(node.val);
        this.leaveMap.put(height, currentList);
        return height;
    }


    public static void main(String[] arg){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        FindLeaves leaves = new FindLeaves();
        System.out.println(leaves.findLeaves(root));
    }
}
