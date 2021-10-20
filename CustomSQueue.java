package Assignment_2;
import java.util.*;


public class CustomSQueue {
	private Stack<Integer> stackList;
	private Stack<Integer> storageStack = new Stack<Integer>();
	
	public CustomSQueue (Stack<Integer> ql ) {
		stackList = new Stack<Integer>();			//take everything from the stack and put into a customQueue
		stackList.addAll(ql);
	}
	
	
	public boolean add(Integer i) {		//add Integer to the end
		if (stackList.push(i) == i)			
			return true;
		else
			return false;		
	}
	
	public Integer poll() {				//removes Integer from the front
		if (stackList.empty()) {					//if its empty return -1
			return -1;
		}
		int s = stackList.size();
		for(int i = 0; i < s-1; i++) {				//push everything but the last element from stackList into storageStack
			storageStack.push(stackList.pop());
		}
		Integer removed = stackList.pop();			//set the item in bottom of the stack to new Integer removed 
		for(int i = 0; i < s-1; i++) {				//pop everything but the removed element back into the stackList
			stackList.push(storageStack.pop());
		}
		return removed;								//return the item that was in the bottom of the stack
	}
	
			
	public String toString() {						//this is done just to have consistent looking toString
		int s = stackList.size();
		String returnString = "[";
		for (int i = 0; i < s; i++) {
			storageStack.push(stackList.pop());		//pop everything into storageStack
		}
		
		for (int i = 0; i < s; i++) {
			Integer removed = storageStack.pop();	//move everything back into stackList and add the element to the list to be printed
			returnString += removed;
			stackList.push(removed);
			if (i < s-1)
				returnString += ", ";
		}
		returnString += "]";
		return returnString;
		
	}
}
