package com.practice.random.visitorPattern;

class ProductOfRedNodesVisitor extends TreeVis {
    private static long MODULO_FACTOR = ((long) Math.pow(10, 9) + 7);
    private int result = 1;
    
	public int getResult() {
		// implement this
		return result;
	}

	public void visitNode(TreeNode node) {
		visit(node);
	}

	public void visitLeaf(TreeLeaf leaf) {
		visitLeaf(leaf);
	}
	
	public void visit(Tree tree) {
		// implement this
		if(tree.getColor()== Color.RED) {
            long temp = result;
            temp = (temp * tree.getValue());
            result = (int) (temp % MODULO_FACTOR);
		}
	}
}