import java.util.LinkedList;
public class StatisticGradeBook extends GradeBook implements Runnable{

    public StatisticGradeBook(String fileName) {
        super(fileName);
    }

    @Override
    public void run() {
        // get all the students names and store them in a linked list
        LinkedList<String> names = getAllStudentsNames();
        // figure out how many students are in the class
        int numberOfStudents = names.size();
        // keep count of how many students have been processed
        int count = 0;
        // loop through all the students
        for (String name : names) {
            Student student = getStudent(name);
            student.calcQuizAverage();
            student.calcHWAverage();
            student.calcOverallAverage();
            count++;
            // print out every 100 students
            if (count % 100 == 0) {
                System.out.println("Calculating grades " + count + " out of 1000");
            }
            if (count == 1000) {
                System.out.println("All grades calculated");
            }

        }

    }

}
