package Assignment_3;

public class Main {

	public static void main(String[] args) {
		BinaryTree btTest = new BinaryTree();			//constructor
		btTest.insert(50);								//insert
		btTest.insert(25);
		btTest.insert(75);
		btTest.insert(12);
		btTest.insert(5);
		btTest.insert(14);
		btTest.insert(37);
		btTest.insert(30);
		btTest.insert(40);
		btTest.insert(62);
		btTest.insert(55);
		btTest.insert(65);
		btTest.insert(97);
		btTest.insert(90);
		btTest.insert(99);
		
		System.out.println("kthSmallest method test:");
		for(int i = 1; i < 18; i++) {						//also tests cases where k > number of Nodes in tree
			System.out.println(btTest.kthSmallest(i));
		}
		System.out.println();
		
		System.out.println("inorder method test:");
		btTest.inorder(btTest.getRoot());					
		System.out.println();
		System.out.println();
		
		System.out.println("seach method test:");
		System.out.println(btTest.search(2));				//search failure test
		System.out.println(btTest.search(99));				
		System.out.println(btTest.search(37));
		System.out.println();
		
		System.out.println("sum method test:");
		System.out.println(btTest.sum(btTest.getRoot()));	
		System.out.println();
		
		System.out.println("delete method test:");
		System.out.println(btTest.delete(40));			
		System.out.println(btTest.delete(999));			//delete failure test
		System.out.println(btTest.delete(14));
		System.out.println();
		
		System.out.println("another inorder test:");
		btTest.inorder(btTest.getRoot());
		System.out.println();
		System.out.println();
		
		System.out.println("another sum test:");
		System.out.println(btTest.sum(btTest.getRoot()));	//sum
		
		
		

	}

}
