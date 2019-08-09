import java.io.*;
import java.util.Arrays;
import java.util.*;

class Toppers implements Comparator<StudentData> {

    public int compare(StudentData d1, StudentData d2) {
    	Integer I1 = (Integer)d1.marks;
    	Integer I2 = (Integer)d2.marks;

    	return I2 - I1;
    }

	public static void main(String[] args) throws IOException {

        Toppers t = new Toppers();

        BufferedReader br = new BufferedReader(new FileReader( new File("file1.txt")));

		String s = br.readLine();
        
        List<StudentData> student = new ArrayList<StudentData>();

        BufferedReader br1 = new BufferedReader(new FileReader( new File("file1.txt")));

        s = br1.readLine();
        int k = 0;

        while( s!=null ) {
        	String[] temp = s.split(",");
        	student.add(new StudentData( Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]), temp[3], temp[4]));
            s = br1.readLine();
        }
        br1.close();


        Collections.sort(student, t);
        
        System.out.println("List of top 5 toppers");
        int count = 0;

        for(StudentData std: student) {
        	if(count == 5) {
        		break;
        	} else {
        		System.out.println("Rollno:"+std.rollno+" Name:"+std.name+" Marks:"+std.marks+" Branch:"+std.branch+" Institute:"+std.institute);
        		count++;
        	}
        	
        }


	}
}

class StudentData {
	int marks;
	int rollno;
	String branch, name, institute;

	StudentData(int rollno, String name, int marks,  String branch, String institute) {
		this.marks = marks;
		this.rollno = rollno;
		this.name = name;
		this.branch = branch;
		this.institute = institute;
	}

	public String getname() {
		return name;
	}
}