package Assignment_4;

public class JHashTable {
	public class Sstring {
		private int freq;
		private String string;
		private Sstring next;
		
		
		public Sstring (String s){			//creates a Sstring node
			string = s;
			freq = 1;
			next = null;
		}
		
		
		public void incFreq(){				//increment frequency
			freq++;
		}
		
		
		public void setNext(Sstring s) {	
			next = s;
		}
		
		
		public String getString() {
			return string;
		}
		
		
		public String toString() {
			return string + ": " + String.valueOf(freq);
		}
	}
	
	
	private Sstring[] table;
	private int size;				//to keep track of load factor for rehashing
	private int num;				//number of Sstrings in table
	
	
	public JHashTable(int size) {		
		table = new Sstring[size];
		this.size = size;
		num = 0;
	}
	
	
	public void insert(Sstring s) {
		int h = Math.abs(s.getString().hashCode()) % size;		//hash function
		Sstring trav = table[h];				
		while(trav != null) {									//traverse the linkedList to see if the String is already there
			if(trav.getString().equals(s.getString())) {
				trav.incFreq();
				return;
			}
			trav = trav.next;
		}									//if not already in list,
		s.setNext(table[h]);					//set s as the first value in the linkedList
		table[h] = s;							//set the rest of the linkedList after s
		num++;	
		if(num > size) {					//if load factor gets to high,
			rehash();		
		}		
	}


	public void rehash() {
		int oldSize = size;					//keep track of old size
		Sstring[] oldTable = table;			//keep track of old table
		size *= 2;							//increase size of current table
		table = new Sstring[size];
			
		for(int i = 0; i < oldSize; i++) {		//rehash every element from old table into new one
			if(oldTable[i] != null) {				
				Sstring trav = oldTable[i];
				while(trav != null) {
					insert(trav);
					trav = trav.next;
				}
			}
		}
	}
	
	
	public void wordCount(String s) {
		String[] strArr = s.split("\\P{Alpha}+");	//split the input into words and add them to strArr
		for(int i= 0; i < strArr.length; i++) {
			insert(new Sstring(strArr[i]));			//insert every element in strArr into hashTable
		}
		print();									//print the hashTable contents
	}
	
	
	public void print() {
		for(int i = 0; i < size; i++) {				//traverse through each linkedList and print its contents side-by-side
			if(table[i] != null) {				
				Sstring trav = table[i];
				while(trav != null) {
					System.out.print(trav + " ");
					trav = trav.next;
				}
				System.out.println();
			}
		}
	}
	
}
