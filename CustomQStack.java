package Assignment_2;
import java.util.*;


public class CustomQStack {
	private Queue<Integer> queueList; 
	
	
	public CustomQStack(Queue<Integer> sl) {					//create a stack from a queue
		queueList = new LinkedList<Integer>();
		while(!sl.isEmpty()) {
			queueList.add((Integer)sl.poll());
		}
	}
	
	
	public boolean empty() {				
		return queueList.isEmpty();
	}
	
	
	public Integer pop() {									//de-queue and immediately re-queue each item, for every element except for last in the list
		if (queueList.isEmpty())								//if its empty return -1
			return -1;
		Integer temp = 0;										
		for (int i = 0; i < queueList.size() - 1; i++) {
			temp = queueList.poll();							//dequeue and requeue each item but the last
			queueList.add(temp);
		}
		temp = queueList.poll();								//remove the last item in the list and return it
		return temp;
	}
		
	
	public Integer push(Integer i) {			
		if (queueList.add(i) == true)
			return i;
		else
			return -1;
	}
	
	public String toString() {						//this is done to make the toString consistent
		int s = queueList.size();
		String returnString = "[";
		for (int i = 0; i < s; i++) {				//iterate through list
			Integer removed = queueList.poll();		//store the Integer in removed in order to add back
			returnString += removed;				//add to list
			queueList.add(removed);					//add the polled Integer back
			if (i < s-1)
				returnString += ", ";
		}
		returnString += "]";
		return returnString;		
	}
	
	
	
	
}
