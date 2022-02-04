package com.tsytem.code.binary.tree.mirror;

import java.util.ArrayList;
import java.util.List;

class Node {
	int data;
	Node left;
	Node right;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}

public class BinaryTree {

	Node root;

	List<Integer> mulList = new ArrayList<Integer>();

	void mirror() {
		root = mirror(root);
	}

	Node mirror(Node node) {
		if (node == null)
			return node;

		Node left = mirror(node.left);
		Node right = mirror(node.right);

		node.left = right;
		node.right = left;

		return node;
	}

	void inOrder() {
		inOrder(root);
	}

	void inOrder(Node node) {
		if (node == null)
			return;

		inOrder(node.left);
		System.out.print(node.data + " ");

		inOrder(node.right);
	}

	int sumOfChildNode() {
		return sumOfAllNodes(root) - root.data;
	}

	int sumOfAllNodes(Node node) {

		if (node == null)
			return 0;
		return node.data + sumOfAllNodes(node.left) + sumOfAllNodes(node.right);

	}

	int multiplicationOfOnlyOneChild() {
		int mul = 1;
		multiplicationOfOnlyOneChild(root);
		for (Integer data : mulList) {
			mul *= data;
		}
		return mul;

	}

	void multiplicationOfOnlyOneChild(Node node) {

		if (node == null)
			return;
		if (node.left == null && node.right == null) {
			mulList.add(node.data);
		}
		
		multiplicationOfOnlyOneChild(node.left);
		multiplicationOfOnlyOneChild(node.right);

	}

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new Node(9);
		tree.root.left = new Node(6);
		tree.root.right = new Node(3);
		tree.root.right.left = new Node(2);
		tree.root.right.right = new Node(7);
		tree.root.right.left.left = new Node(3);
		tree.root.right.left.right = new Node(5);

		System.out.println("Inorder traversal of  binary tree before mirroring  is :");
		tree.inOrder();
		System.out.println("");

		tree.mirror();

		System.out.println("Inorder traversal of binary tree after mirroring is : ");
		tree.inOrder();

		System.out.println("");

		int sum = tree.sumOfChildNode();
		System.out.println("sum of all child node is " + sum);
		
		int mul = tree.multiplicationOfOnlyOneChild();
		System.out.println("Multiplication of of only one child node " + mul);

	}

}
