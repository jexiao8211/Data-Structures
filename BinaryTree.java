package Assignment_3;

import java.util.Stack;

public class BinaryTree {	
	public class Node {
		private int key;
		private Node left;
		private Node right;
		
		public Node( ) {
			setLeft(null);
			setRight(null);
			setKey(0);
		}
		
		public Node(int k) {
			setLeft(null);
			setRight(null);
			setKey(k);
		}
		
		public int getKey() {
			return key;
		}
		
		public void setKey(int key) {
			this.key = key;
		}
		
		public Node getLeft() {
			return left;
		}
		
		public void setLeft(Node left) {
			this.left = left;
		}
		
		public Node getRight() {
			return right;
		}
		
		public void setRight(Node right) {
			this.right = right;
		}
		
		public String toString() {			//toString method for when Node is returned in a method
			return "node" + getKey();
		}

	}
	private Node root;					//tree instance variable
	
	public BinaryTree() {				//tree constructor
		root = null;
	}
	
	
	public Node getRoot() {				//necessary for some recursive methods
		return root;
	}
	
	
	public void insert (int k) {			//traverse until the correct place to insert is found
		Node parent = null;						//have to keep track of parent of trav because trav goes to null
		Node trav = root;
		
		while (trav != null) {				
			parent = trav;
			if (k < trav.getKey())
				trav = trav.getLeft();
			else
				trav = trav.getRight();
		}
		Node newNode = new Node(k);			//create a new node and insert it according to size of key
		if (parent == null) {
			root = newNode;
		}
		else if (k < parent.getKey()) {
			parent.setLeft(newNode);
		}
		else {
			parent.setRight(newNode);
		}
	}
		
	
	public void inorder(Node r) {		//left, node, right:   needs to have node r passed as parameter because its recursive- this is where the getRoot method is hand
		if (r.getLeft() != null)			
			inorder(r.getLeft());
		System.out.print(r.getKey() + " ");
		if (r.getRight() != null)
			inorder(r.getRight());
	}
	
	
	public int sum(Node r) {		//start at root and add children to root recursively
		if (r == null) 
			return 0;
		return  r.getKey() + sum(r.getLeft()) + sum(r.getRight());
	}
	
	
	public Node search(int k) {			//traverse tree
		Node trav = root;
		while (trav != null) {
			if (k == trav.getKey()) 
				return trav;
			else if (k < trav.getKey())
				trav = trav.getLeft();
			else
				trav = trav.getRight();
		}
		return null;
	}
	
	
	public Node kthSmallest(int k) {					//stack implementation
		Stack<Node> nodeStack = new Stack<Node>();		
		Node trav = root;
		Node parent = null;
		int kCounter = 0;								//counts to k
		
		while((trav != null || nodeStack.size() > 0) && kCounter < k) {			//iterates until the counter is reached or if k is greater than the number of elements
			while(trav != null) {					//traverse as far left as possible, popping each node passed
				nodeStack.push(trav);
				trav = trav.getLeft();		
			}
			trav = nodeStack.pop();					//pop the leftmost element(the smallest)
			kCounter++;	
			parent = trav;
			trav = trav.getRight();					//get the next smallest element
		}												//if this next smallest element is not to the right, the next smallest is popped from the stack 
		return parent;
	}
		

	
	public Node delete(int k) {
		Node trav = root;
		Node parent = null;				//have to keep track of parent of trav
		
		while (trav != null && trav.getKey() != k) {	//traverses until trav reaches Node to be deleted
			parent = trav;
			if (k < trav.getKey())
				trav = trav.getLeft();
			else
				trav = trav.getRight();
		}
		
		if (trav == null)
			return null;
		else {
			deleteNode(trav, parent);
			return trav;
		}
	}
		public void deleteNode(Node t, Node p) {						//t is Node to be deleted, p is parent of that node
			if (t.getLeft() == null || t.getRight() == null) {			//takes care of cases where t has one or no children
				Node childOfT = null;								//store node that is the child of the Node to be deleted(t)		
				if (t.getRight() == null)				
					childOfT = t.getLeft();
				else 
					childOfT = t.getRight();
				
				if (t == root)									//makes sure to take care of root
					root = childOfT;
				else if (t.getKey() < p.getKey())				//sets child to null or the child of the deleted node
					p.setLeft(childOfT);
				else
					p.setRight(childOfT);
			}
			else {												//if t has two children
				Node replacement = t.getRight();				
				Node replacementParent = null;					
				while (replacement.getLeft() != null) {			//set replacement to the leftmost element of the right subtree of the Node to be deleted
					replacementParent = replacement;
					replacement = replacement.getLeft();
				}	
				t.setKey(replacement.getKey());					//swap replacement with node to be deleted
				deleteNode(replacement, replacementParent);		//delete the intended Node; it has one or no children so delete() terminates after this one recursive call
			}
		}
	
	
}
