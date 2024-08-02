
import java.util.Optional;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scaner = new Scanner(System.in);
        ReviewStorage storage = new CSVReviewStorage();
        ReviewManager manager = new ReviewManager(storage);

        while (true){
            System.out.println("Select an option: ");
            System.out.println("1. Add a review");
            System.out.println("2. View the review");
            System.out.println("3. Go out");

            int choice = scaner.nextInt();
            scaner.nextLine();


            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the game");
                    String name = scaner.nextLine();

                    int rating;
                    do {
                        System.out.println("Game rating (1-10)");
                        rating = scaner.nextInt();
                        scaner.nextLine();
                    } while (rating < 1 || rating > 10);

                    System.out.println("Your review of the game");
                    String review = scaner.nextLine();


                    manager.addReview(name,rating,review);
                    System.out.println("Review added !" );
                    break;
                case 2:
                    System.out.println("Enter a game name to view a review: ");
                    String searchName = scaner.nextLine();

                    Optional<GameReview> foundReview = manager.getReview(searchName);
                    if (foundReview.isPresent()) {
                        GameReview reviewObj = foundReview.get();
                        System.out.println("Game name: " + reviewObj.getName());
                        System.out.println("Rating:  " + reviewObj.getRating());
                        System.out.println("Review: " + reviewObj.getReview());
                    } else {
                        System.out.println("No reviews found.");
                    }

                    break;
                case 3:
                    System.out.println("Goodbye!");
                default:
                    System.out.println("Incorrect selection, try again. ");
            }
        }
    }
}