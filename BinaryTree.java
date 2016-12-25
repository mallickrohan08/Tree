import java.util.*;
class BTNode {
	int data;
	BTNode left;
	BTNode right;
	BTNode(int data) {
		this.data = data;
	}
}

class BinaryTree {
	BTNode root;
	BinaryTree() {
		root = null;
	}
	
	public BTNode insert (int data) {
		//If Tree in Empty
		if(root == null) {
			root = new BTNode(data);
			return root;
		}
		Queue<BTNode> q = new LinkedList<BTNode>();
		//Add root in Queue;
		q.add(root);
		//Now traverse down the tree and wherever we found left or right child null add the new Node;
		while(!q.isEmpty()) {
			BTNode curr = q.poll();
			if(curr != null) {
				if(curr.left != null) {
					q.add(curr.left);
				}
				else {
					curr.left = new BTNode(data);
					return root;
				}
				
				if(curr.right != null) {
					q.add(curr.right);
				}
				else {
					curr.right = new BTNode(data);
					return root;
				}
			}
		}
		return root;
	}
	
	//Insert using recursion;
	
	public void insertUsingRecc(BTNode root, int data) {
		if(root == null) {
			root = new BTNode(data);
			return;
		}
		
		if(root.left != null) {
			insertUsingRecc(root.left, data);
		}
		else if(root.left == null){
			root.left = new BTNode(data);
			return;
		}
		else if(root.right != null) {
			insertUsingRecc(root.right, data);
		}
		else if(root.right == null) {
			root.right = new BTNode(data);
			return;
		}
	}
	
	public void preOrder(BTNode root) {
		
		if(root != null) {
			System.out.println(root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	//Level Order Traversal
	public void levelOrder(BTNode root) {
		if(root == null) {
			System.out.println("Tree is empty.");
			return;
		}
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.add(root);
		while(!q.isEmpty()) {
			BTNode curr = q.poll();
			System.out.println(curr.data);
			if(curr.left != null) {
				q.add(curr.left);
			}
			if(curr.right != null) {
				q.add(curr.right);
			}
		}
	}
	
	public int maxElement(BTNode root) {
		int maxEle = Integer.MIN_VALUE;
		if(root != null) {
			int leftMax = maxElement(root.left);
			int rightMax = maxElement(root.right);
			
			if(leftMax > rightMax) {
				maxEle = leftMax;
			}
			else {
				maxEle = rightMax;
			}
			
			if(root.data > maxEle) {
				maxEle = root.data;
			}
		}
		return maxEle;
	}
	
	public int maxElementWithoutRecc(BTNode root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		
		int maxEle = Integer.MIN_VALUE;
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.add(root);
		
		while(!q.isEmpty()) {
			BTNode curr = q.poll();
			if(curr.data > maxEle) {
				maxEle = curr.data;
			}
			if(curr.left != null) {
				q.add(curr.left);
			}
			if(curr.right != null) {
				q.add(curr.right);
			}
		}
		return maxEle;
	}
	
	//Search Element;
	public boolean search(BTNode root, int data) {
		if(root == null) {
			return false;
		}
		if(root.data == data) {
			return true;
		}
		else {
			return search(root.left, data) || search(root.right, data);
		}
	}
	
	//Search without recursion
	public boolean searchWithoutRecc(BTNode root, int key) {
		if(root == null) {
			System.out.println("Tree is empty.");
			return false;
		}
		
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.add(root);
		while(!q.isEmpty()) {
			BTNode curr = q.poll();
			if(curr.data == key) {
				return true;
			}
			if(curr.left != null) {
				q.add(curr.left);
			}
			if(curr.right != null) {
				q.add(curr.right);
			}
		}
		return false;
		
	}
	
	//No of Node in Tree
	public int numberOfNode(BTNode root) {
		if(root == null) {
			return 0;
		}
		return numberOfNode(root.left) + 1 + numberOfNode(root.right);
	}
	
	//No of Node without recursion
	public int numberOfNodeWithoutRecc(BTNode root) {
		if(root == null) {
			return 0;
		}
		int count = 0;
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.add(root);
		while(!q.isEmpty()) {
			BTNode curr = q.poll();
			if(curr != null) {
				count++;
				if(curr.left != null) {
					q.add(curr.left);
				}
				if(curr.right != null) {
					q.add(curr.right);
				}
			}
		}
		return count;
	}
	
	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree();
		BTNode root;
		root = bt.insert(10);
		root = bt.insert(20);
		root = bt.insert(30);
		root = bt.insert(40);
		bt.insertUsingRecc(root,50);
		bt.preOrder(bt.root);
		System.out.println("------------------");
		bt.levelOrder(bt.root);
		System.out.println("-------------");
		System.out.println(bt.maxElement(bt.root));
		System.out.println(bt.maxElementWithoutRecc(bt.root));
		System.out.println(bt.search(bt.root, 60) + "Found");
		System.out.println(bt.searchWithoutRecc(bt.root, 60) + "Found");
		System.out.println(bt.searchWithoutRecc(bt.root, 40) + "Found");
		System.out.println(bt.numberOfNode(bt.root));
		System.out.println(bt.numberOfNodeWithoutRecc(bt.root));
	}	
}