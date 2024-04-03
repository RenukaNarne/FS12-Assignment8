import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TestScoreAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> scores = new ArrayList<>();

        // Input test scores
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        System.out.println("Enter the test scores:");
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            int score = scanner.nextInt();
            scores.add(score);
        }

        // Calculate average score
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        double averageScore = sum / numStudent
