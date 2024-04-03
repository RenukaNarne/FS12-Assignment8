import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StudentProject {
    private String studentName;
    private int completionTime;

    public StudentProject(String studentName, int completionTime) {
        this.studentName = studentName;
        this.completionTime = completionTime;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getCompletionTime() {
        return completionTime;
    }
}

public class ProjectCompletionAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<StudentProject> projects = new ArrayList<>();

        // Input project details
        System.out.print("Enter the number of projects: ");
        int numProjects = scanner.nextInt();

        for (int i = 0; i < numProjects; i++) {
            System.out.print("Enter student name for project " + (i + 1) + ": ");
            String studentName = scanner.next();
            System.out.print("Enter completion time for project " + (i + 1) + " (in days): ");
            int completionTime = scanner.nextInt();

            projects.add(new StudentProject(studentName, completionTime));
        }

        // Analyze project completion
        int onTime = 0, late = 0, early = 0;
        double totalCompletionTime = 0;

        for (StudentProject project : projects) {
            totalCompletionTime += project.getCompletionTime();
            if (project.getCompletionTime() <= 0) {
                early++;
            } else if (project.getCompletionTime() <= 7) {
                onTime++;
            } else {
                late++;
            }
        }

        // Output results
        System.out.println("\nProject Completion Analysis:");
        System.out.println("Projects completed on time: " + onTime);
        System.out.println("Projects completed late: " + late);
        System.out.println("Projects completed early: " + early);
        System.out.println("Average completion time: " + (totalCompletionTime / numProjects) + " days");

        scanner.close();
    }
}
