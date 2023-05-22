import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        StatisticGradeBook gradeBook = new StatisticGradeBook("Assignment7-Spreadsheet.csv");
        Thread thread = new Thread(gradeBook);
        thread.start();
        try {
            thread.join();
            System.out.println("What student would you like to see grades for");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            gradeBook.getStudentGrade(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}