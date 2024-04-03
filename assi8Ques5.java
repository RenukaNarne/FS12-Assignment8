import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RestaurantRatingAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> ratingRangesCount = new HashMap<>();
        Map<String, Double> ratingRangesTotal = new HashMap<>();

        // Input restaurant ratings
        System.out.print("Enter the number of restaurants: ");
        int numRestaurants = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numRestaurants; i++) {
            System.out.print("Enter the name of restaurant " + (i + 1) + ": ");
            String restaurantName = scanner.nextLine();
            System.out.print("Enter the rating of restaurant " + (i + 1) + " (out of 10): ");
            int rating = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Update rating range count
            String ratingRange = getRatingRange(rating);
            ratingRangesCount.put(ratingRange, ratingRangesCount.getOrDefault(ratingRange, 0) + 1);

            // Update total rating for each range
            ratingRangesTotal.put(ratingRange, ratingRangesTotal.getOrDefault(ratingRange, 0.0) + rating);
        }

        // Calculate average rating for each range
        Map<String, Double> averageRating = new HashMap<>();
        for (String range : ratingRangesCount.keySet()) {
            double totalRating = ratingRangesTotal.get(range);
            int count = ratingRangesCount.get(range);
            averageRating.put(range, totalRating / count);
        }

        // Output results
        System.out.println("\nRestaurant Rating Analysis:");
        for (String range : ratingRangesCount.keySet()) {
            System.out.println("Restaurants rated within range " + range + ": " + ratingRangesCount.get(range));
            System.out.println("Average rating: " + averageRating.get(range));
        }

        scanner.close();
    }

    private static String getRatingRange(int rating) {
        if (rating >= 1 && rating <= 5) {
            return "1-5";
        } else if (rating >= 6 && rating <= 10) {
            return "6-10";
        } else {
            return "Unknown";
 
