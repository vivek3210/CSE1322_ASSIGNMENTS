import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
public class GradeBook {
    LinkedList<Student> students = new LinkedList<Student>();

    public GradeBook(String fileName) {
        // open the file
        // read the file line by line
        // create a student object for each line
        // add the student object to the linked list
        try {
            FileInputStream file = new FileInputStream(fileName);
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Student student = new Student(line);
                students.add(student);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Student getStudent(String n) {
        for (Student student : students) {
            if (student.name().equals(n)) {
                return student;
            }
        }
        return null;
    }

    public void getStudentGrade(String n) {
        Student student = getStudent(n);
        if (student == null) {
            System.out.println("Student not found");
        } else {
            System.out.println(student.getGrade());
        }
    }
    public LinkedList getAllStudentsNames() {
        LinkedList<String> names = new LinkedList<String>();
        for (Student student : students) {
            names.add(student.name());
        }
        return names;
    }
}

