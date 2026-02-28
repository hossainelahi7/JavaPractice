package com.practice.tree;

import org.junit.Assert;

import java.util.Stack;

public class MathTransform {
    // given a math sequence converted to that  1 + 2 converted to 1 2 +. revert it back to right sequence

    private static class TreeNode{
        String sign;
        TreeNode left;
        TreeNode right;
        int leftDistance;
        int rightDistance;

        public TreeNode(){}
        public TreeNode(String sign, TreeNode left, TreeNode right, int leftDistance, int rightDistance){
            this.sign = sign;
            this.left = left;
            this.right = right;
            this.leftDistance = leftDistance;
            this.rightDistance = rightDistance;
        }
    }

    public String convertToSequence(String[] sequence){
        if(sequence== null || sequence.length<=0 )
            return "";
        //convert into treeNode
//        Stack<S>

        // convert into String sequence


        // return string sequence
        return "";
    }

    public static void main(String[] arg){
        String[] sequence = {"2","3","+","5","*"};
        MathTransform mathTransform = new MathTransform();
        String equation = mathTransform.convertToSequence(sequence);
        System.out.println(equation);
        Assert.assertEquals(equation, "(2+3)*5");
    }

}
