public class Student {
    int[] quizScores = new int[10];
    int[] homeworkScores = new int[10];
    int midtermGrade;
    int finalExamGrade;
    double quizAverage;
    double homeworkAverage;
    double overallAverage;
    String name;
    int studentID;

    // constructor that takes a line from the csv file and parses it
    public Student(String line) {
        String[] values = line.split(",");
        studentID = Integer.parseInt(values[1]);
        name = values[0];
        for (int i = 0; i < 10; i++) {
            quizScores[i] = Integer.parseInt(values[i + 2]);
        }
        for (int i = 0; i < 10; i++) {
            homeworkScores[i] = Integer.parseInt(values[i + 12]);
        }
        midtermGrade = Integer.parseInt(values[22]);
        finalExamGrade = Integer.parseInt(values[23]);
    }
    public int id() {
        return studentID;
    }
    public String name() {
        return name;
    }
    public void calcQuizAverage() {
        int sum = 0;
        int lowest = quizScores[0];
        for (int i = 0; i < 10; i++) {
            sum += quizScores[i];
            if(lowest > quizScores[i]) {
                lowest = quizScores[i];
            }
        }
        quizAverage = (sum - lowest) / 9.0;
    }
    public void calcHWAverage() {
        int sum = 0;
        int lowest = homeworkScores[0];
        for (int i = 0; i < 10; i++) {
            sum += homeworkScores[i];
            if(lowest > homeworkScores[i]) {
                lowest = homeworkScores[i];
            }
        }
        homeworkAverage = (sum - lowest) / 9.0;
    }
    public void calcOverallAverage() {
        // Calculate the overall average
        calcQuizAverage();
        calcHWAverage();
        overallAverage = (quizAverage * 0.4) + (homeworkAverage * 0.1) + (midtermGrade * 0.2) + (finalExamGrade * 0.3);
    }
    public String getGrade() {
        String result = "";
        for (int i = 0; i < 10; i++) {
            result += "Quiz " + i + ": " + quizScores[i] + "\n";
        }
        result += "Quiz Avg: " + quizAverage + "\n";
        for (int i = 0; i < 10; i++) {
            result += "Hw " + i + ": " + homeworkScores[i] + "\n";
        }
        result += "HW Avg: " + homeworkAverage + "Midterm: " + midtermGrade + "Final Exam: " + finalExamGrade + "Overall Average: " + overallAverage;
    return result;
    }
}
