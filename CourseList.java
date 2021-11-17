package Assignment_1;


public class CourseList {
	private Course[] listOfCourses;
	
	
	public CourseList() {					
		listOfCourses = new Course[10];				//creates new empty courseList object of size 10
	}
	
	
	public int size(Course[] cList) {			//returns the index of the last course in the courseList
		int c = 0;
		while (cList[c] != null) {					//iterate through until reaching null point, adding 1 each time
			c++;
		}
		return c - 1;
	}

	
	public void print() {															//prints out a numbered courseList
		for (int i = 0; i <= size(listOfCourses); i++) {								//iterate through and print each item
			System.out.println(i + ". " + listOfCourses[i].toString());
		}
		System.out.println();
	}

	
	public void addCourse(int i, Course course) {						//adds course to courseList
		System.out.println("Operation - add course:");  					//prints out the operation to be done
		System.out.println(course.toString());
		System.out.println("To index: " + i);
		System.out.println();											
		System.out.println("List before operation:");						//print list before operation
		print();
		
		if (i <= size(listOfCourses) && i >= 0) {							//if i is an index occupied by a course,
			for(int a = size(listOfCourses)+1; a > i; a--) {				//shifts courses on or above index i up by one index
				listOfCourses[a] = listOfCourses[a - 1];
			}
			listOfCourses[i] = course;										//set i as intended course
		}		
		else if (i < 0 || i > 9) {											//doesn't let user add to an out of bounds index
			System.out.println("Operation failed- index out of bounds");	//out of bounds error message
			print();
			System.out.println();
			return;
		}
		else {
			listOfCourses[size(listOfCourses) + 1] = course;				//if i is not occupied, adds to the first empty spot
		}
		
		System.out.println("List after the operation:");					//prints list after operation
		print();	
		System.out.println();
	}
	
	
	public boolean removeCourse(int i) {							//removes course from courseList
		System.out.println("Operation - remove course:");  				//prints out the operation to be done
		System.out.println("At index: " + i);
		System.out.println();											//print list before operation
		System.out.println("List before operation:");
		print();
		
		if (i <= size(listOfCourses)) {											//check if index i is occupied by a course, and return true if it is
			for(int a = i; a <= size(listOfCourses); a++) {							//shift courses down from the end of the course list to i;
				listOfCourses[a] = listOfCourses[a + 1];							//gets rid of course at index i in the process
			}
			System.out.println("List after the operation:");						//prints list after operation
			print();
			System.out.println();
			return true;
		}
		
		else																				//return false and error message if no course in i
			System.out.println("Operation failed- no course found with index " + i);			//failure message and reprint list
			System.out.println("List after the operation:");
			print();
			System.out.println();
			return false;
	}
	
	
	public boolean changeCapacity(String courseID, int capacity) {			//change capacity of a course in courseList
		System.out.println("Operation - change capacity of a course");  		//prints out the operation to be done
		System.out.println("Course ID: " + courseID);
		System.out.println("To capacity: " + capacity);
		System.out.println();													//print list before operation
		System.out.println("List before operation:");
		print();
		
		for (int i = 0; i <= size(listOfCourses); i++) {					//searches for course
			if (courseID == listOfCourses[i].getCourseID() ){					//if course is found, set capacity
				listOfCourses[i].setCapacity(capacity);
				
				System.out.println("List after the operation:");				//prints list after operation
				print();
				System.out.println();
				return true;													//return true after course is found and capacity is set
			}
				
		}
		System.out.println("Operation failed- invalid course");				//if course is not found: error message and return false
		System.out.println("List after operation:");
		print();															//reprint course list
		System.out.println();
		return false;										
	}
	

	public Course getCourseWithIndex(int i) {					//retrieve course with index i
		System.out.println("Operation - retreive course");			//print operation and list before operation
		System.out.println("With index: " + i);						
		System.out.println();
		System.out.println("List:");
		print();								
		
		if (i <= size(listOfCourses)) {								//check that i is an index occupied by a course
			System.out.print("Course found: ");						//print the course found at i, and returns index of course found
			System.out.println(listOfCourses[i].toString());
			System.out.println();
			System.out.println();
			return listOfCourses[i];
		}
		else {														//if i is not an index occupied by a course;
			System.out.println("Course not found");					//print failure message and return null
			System.out.println();
			System.out.println();
			return null;
		}
	}
	

	public int searchCourseID(String courseID) {										//search for course with given courseID
		System.out.println("Operation - search for course and return its index");			//print operation and list
		System.out.println("With ID: " + courseID);
		System.out.println();
		System.out.println("List:");
		print();			
		
		for (int i = 0; i <= size(listOfCourses); i++) {								//iterates through the courseList
			if (listOfCourses[i].getCourseID().equals(courseID)) {							//if matching courseID is found,
				System.out.print("Course found with index " + i + ": ");					//print success message and return index that the ID is located in
				System.out.println(listOfCourses[i].toString());
				System.out.println();
				System.out.println();
				return i;																	
			}
		}
		System.out.println("Course not found");												//failure message
		System.out.println();
		System.out.println();
		return -1;																			//return -1 if not found
	}


	public int searchCourseName(String courseName) {									//search for course with give courseName
		System.out.println("Operation - search for course and return its index");			//print operation and list
		System.out.println("With name: " + courseName);	
		System.out.println();
		System.out.println("List:");
		print();			
		
		for (int i = 0; i <= size(listOfCourses); i++) {								//iterates through courselist
			if (listOfCourses[i].getCourseName().equals(courseName)) {						//if matching coursename is found,
				System.out.print("Course found with index " + i + ": ");					//print success message and return index that the name is located in
				System.out.println(listOfCourses[i].toString());		
				System.out.println();
				System.out.println();
				return i;																	//return index of course if found
			}
		}
		System.out.println("Course not found");												//failure message
		System.out.println();
		System.out.println();
		return -1;																			//return -1 if not found
	}

}
