package com.practice.random.visitorPattern;

import java.util.ArrayList;
import java.util.List;

class TreeNode extends Tree {

	private List<Tree> children = new ArrayList<Tree>();

	public TreeNode(int value, Color color, int depth) {
		super(value, color, depth);
	}

	public void accept(TreeVis visitor) {
		visitor.visitNode(this);

		for (Tree child : children) {
			child.accept(visitor);
		}
	}

	public void addChild(Tree child) {
		children.add(child);
	}
}
