import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MovieRatingAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> movieCount = new HashMap<>();
        Map<String, Double> movieRatingTotal = new HashMap<>();

        // Input movie details
        System.out.print("Enter the number of movies: ");
        int numMovies = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        for (int i = 0; i < numMovies; i++) {
            System.out.print("Enter the name of movie " + (i + 1) + ": ");
            String movieName = scanner.nextLine();
            System.out.print("Enter the rating of movie " + (i + 1) + " (e.g., PG, PG-13, R): ");
            String rating = scanner.nextLine();
            System.out.print("Enter the rating of movie " + (i + 1) + " (out of 10): ");
            double movieRating = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            // Update movie count
            movieCount.put(rating, movieCount.getOrDefault(rating, 0) + 1);

            // Update total rating for each category
            movieRatingTotal.put(rating, movieRatingTotal.getOrDefault(rating, 0.0) + movieRating);
        }

        // Calculate average rating for each category
        Map<String, Double> averageRating = new HashMap<>();
        for (String rating : movieCount.keySet()) {
            double totalRating = movieRatingTotal.get(rating);
            int count = movieCount.get(rating);
            averageRating.put(rating, totalRating / count);
        }

        // Output results
        System.out.println("\nMovie Rating Analysis:");
        for (String rating : movieCount.keySet()) {
            System.out.println("Category: " + rating);
            System.out.println("Number of movies: " + movieCount.get(rating));
            System.out.println("Average rating: " + averageRating.get(rating));
            System.out.println();
        }

        scanner.close();
    }
}
