package Assignment_2;

public class JerryLinkedList {
	private class Node {				//inner class
		private Node nextNode;			//node instance variables
		private int value;
		
		public Node(int v) {			//Node constructor
			setValue(v);
			setNextNode(null);
		}

		public Node getNextNode() {	
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}	
	}
	
	private Node head;					//linkedList instance variable
	
	public JerryLinkedList() {				//linkedList constructor
		head = null;
	}
	
	public void addNode(int v) {					
		if (head == null) 					//if head is null set head as node
			head = new Node(v);
		else {
			Node trav = head;						//traverse to end of linkedList
			while(trav != null) {
				if (trav.getNextNode() == null) {
					trav.setNextNode(new Node(v));	//add node to end of list
					return;
				}
				trav = trav.getNextNode();	
			}
		}	
	}
	
	public void reverse() {				//traverse through the list, reversing the pointers as trav goes 
			Node trav = null;				//create a traversal node
			Node temp = null;				//storage for node 
		while (head != null) {		
			trav = head.getNextNode();		//move trav ahead
			head.setNextNode(temp);			//reverse pointer
			temp = head;					//store previous node
			head = trav;					//move the head up in the list
		}
		head = temp;						//set head to last item in list, making it the new start of the list
	}
	
	public String toString() {					//toString method for my linkedList
		Node trav = head;
		String returnString = "[";					//traverse while adding each node's value to the returnString
		while (trav != null) {
			returnString += trav.getValue();
			if (trav.getNextNode() != null)
				returnString += ", ";
			trav = trav.getNextNode();
		}
		returnString += "]";
		return returnString;
	}
	
	
}
