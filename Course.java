package Assignment_1;


public class Course {
	private String courseID;
	private String courseName;
	private int capacity;
	
	public Course (String id, String name, int cap) {			//creates a course with id, name, and capacity
		courseID = id;										
		courseName = name;
		capacity = cap;
	}
	
	
	public String toString() {				
		return "courseID; " + courseID + ", courseName; " + courseName + ", capacity; " + capacity;			//returns a String representation of a course
	}
	
	public String getCourseID ( ) {			
		return courseID;
	}
	
	
	public String getCourseName() {
		return courseName;
	}
	
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity (int c) {
		capacity = c;
	}
}
