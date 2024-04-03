import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookReviewAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> ratingRangesCount = new HashMap<>();
        Map<String, Integer> reviewSentimentsCount = new HashMap<>();

        // Input book review details
        System.out.print("Enter the number of books reviewed: ");
        int numBooks = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        for (int i = 0; i < numBooks; i++) {
            System.out.print("Enter the title of book " + (i + 1) + ": ");
            String bookTitle = scanner.nextLine();
            System.out.print("Enter the rating of book " + (i + 1) + " (out of 10): ");
            int rating = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Update rating range count
            String ratingRange = getRatingRange(rating);
            ratingRangesCount.put(ratingRange, ratingRangesCount.getOrDefault(ratingRange, 0) + 1);

            // Update review sentiment count
            String reviewSentiment = getReviewSentiment(rating);
            reviewSentimentsCount.put(reviewSentiment, reviewSentimentsCount.getOrDefault(reviewSentiment, 0) + 1);
        }

        // Output results
        System.out.println("\nBook Review Analysis:");
        for (String range : ratingRangesCount.keySet()) {
            System.out.println("Books rated within range " + range + ": " + ratingRangesCount.get(range));
        }
        System.out.println("\nReview Sentiment Analysis:");
        for (String sentiment : reviewSentimentsCount.keySet()) {
            System.out.println("Books with " + sentiment + " reviews: " + reviewSentimentsCount.get(sentiment));
        }

        scanner.close();
    }

    private static String getRatingRange(int rating) {
        if (rating >= 1 && rating <= 5) {
            return "1-5 stars";
        } else if (rating >= 6 && rating <= 10) {
            return "6-10 stars";
        } else {
            return "Unknown";
        }
    }

    private static String getReviewSentiment(int rating) {
        if (rating >= 1 && rating <= 3) {
            return "negative";
        } else if (rating == 4 || rating == 5) {
            return "neutral";
        } else {
            return "positive";
        }
    }
}
