package com.greatlearning.main;

import java.util.HashSet;

public class FindSumPair {
	static class Node {
		int nodeData;
		Node leftNode, rightNode;
	};
	
	static Node NewNode(int nodeData)
	{
		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;

		return temp;
	}
	
	public Node insert(Node root, int key)
	{
		if (root == null)
			return NewNode(key);
		if (key < root.nodeData) {
			root.leftNode = insert(root.leftNode, key);
			System.out.println(root);
		}
		else {
			root.rightNode = insert(root.rightNode, key);
			System.out.println(root);
		}
		return root;
	}
	public static void main(String[] args)
	{
		Node root = null;
		
		FindSumPair findSP = new FindSumPair();
		root = findSP.insert(root, 40);
		root = findSP.insert(root, 20);
		root = findSP.insert(root, 60);
		root = findSP.insert(root, 10);
		root = findSP.insert(root, 30);
		root = findSP.insert(root, 50);
		root = findSP.insert(root, 70);
		System.out.println(root);
		int sum = 40;
		findSP.findPairWithGivenSum(root, sum);
	}
	public boolean findPairUtil(Node root, int sum, HashSet<Integer> set) {
		if(root == null) {
			return false;
		}
		if(findPairUtil(root.leftNode, sum, set)) {
			return true;
		}
		if(set.contains(sum - root.nodeData)) {
			System.out.println("Pair Found" + (sum - root.nodeData) + root.nodeData);
			return true;
		}
		else {
			set.add(root.nodeData);
		}
		return findPairUtil(root.rightNode, sum, set);
	}
	public void findPairWithGivenSum(Node root, int sum) {
		HashSet<Integer> HSet = new HashSet<>();
		if(!findPairUtil(root, sum, HSet)) {
			System.out.println("Pair does not exist" + "\n");
		}
		findPairUtil(root, sum, HSet);
	}

}
