/*
 * Find the standard deviation of grades of all students in the records.
 */
import java.io.*;
import java.util.*;
public class findstd {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
	
		ArrayList<Student> students = new ArrayList<Student>();
		
		int N = in.nextInt();
		for(int k=0; k<N; k++) {
			String name1 = in.next();
			String name2 = in.next();
			int score = in.nextInt();

			int loc = 0;
			while(loc<students.size()) {
				if(students.get(loc).fname.equals(name1) && 
						students.get(loc).lname.equals(name2))
					break;
				loc++;
			}

			if(loc<students.size())
				students.get(loc).grades.add(score);
			
			else {
				Student s = new Student(name1, name2);
				s.grades.add(score);
				students.add(s);
			}
		}
		
		Collections.sort(students, (s1, s2) -> s1.lname.compareTo(s2.lname));
		
		//compute the standard deviation for all students
		for(Student s : students)
			System.out.println(s.computeSTD());
		in.close();
	}

    static class Student {
    	String fname, lname; //first and last names
    	ArrayList<Integer> grades;
	
    	Student(String a, String b) {
    		fname = a;
    		lname = b;
    		grades = new ArrayList<Integer>();
    	}
	
    	public void addGrade(int g) {
    		grades.add(g);
    	}
	
    	//compute the standard deviation of grades
    	public int computeSTD() {
    		if(grades.size()>=2) {
    			int sum = 0;
    			for(int g : grades)
    				sum += g;
 
    			double avg = (double) sum / grades.size();
				  
    			double sum2 = 0;
    			for(int g : grades)
    				sum2 += (g-avg)*(g-avg);
				  
    			double std =  Math.sqrt(sum2 / (grades.size()-1));
    			return (int)(std+0.5);
    		}
    		else 
    			return -1;
    	}
    }
}