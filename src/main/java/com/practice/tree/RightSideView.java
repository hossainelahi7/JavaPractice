package com.practice.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RightSideView {

    Stack<NodeMap> options = new Stack<>();

    private static class NodeMap{
        int height;
        TreeNode node;

        public NodeMap(){}
        public NodeMap(TreeNode node, int height){
            this.height = height;
            this.node = node;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        if(root == null)
            return nodes;
        options.push(new NodeMap(root, 1));
        int maxDepth = 0;
        NodeMap node;
        while(!options.empty()){
            node = options.pop();
            if(node.node!=null && node.height > maxDepth){
                nodes.add(node.node.val);
                maxDepth = node.height;
            }
            if(node.node.left!=null)
                options.push(new NodeMap(node.node.left,node.height+1));
            if(node.node.right!=null)
                options.push(new NodeMap(node.node.right,node.height+1));
        }
        return nodes;
    }
}
