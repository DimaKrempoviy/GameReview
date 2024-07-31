
import java.util.Optional;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Створюємо об'єкт Scanner для читання вводу з консолі
        Scanner scaner = new Scanner(System.in);
        // Створюємо об'єкт CSVReviewStorage для зберігання рецензій у файлі CSV
        ReviewStorage storage = new CSVReviewStorage();
        // Створюємо об'єкт ReviewManager для управління рецензіями
        ReviewManager manager = new ReviewManager(storage);

        while (true){
            // Виводимо меню вибору дії
            System.out.println("Select an option: ");
            System.out.println("1. Add a review");
            System.out.println("2. View the review");
            System.out.println("3. Go out");

            // Зчитуємо вибір користувача
            int choice = scaner.nextInt();
            scaner.nextLine();// Очищаємо буфер після зчитування числа


            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the game");
                    String name = scaner.nextLine();
                    System.out.println("Game rating (1-10)");
                    int rating = scaner.nextInt();
                    scaner.nextLine(); // Очищаємо буфер після зчитування числа
                    System.out.println("Your review of the game");
                    String review = scaner.nextLine();

                    // Додаємо рецензію через ReviewManager
                    manager.addReview(name,rating,review);
                    System.out.println("Review added !" );
                    break;
                case 2:
                    // Перегляд рецензії за назвою гри
                    System.out.println("Enter a game name to view a review: ");
                    String searchName = scaner.nextLine();

                    // Отримуємо рецензію через ReviewManager
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
                    // Вихід з програми
                    System.out.println("Goodbye!");
                default:
                    // Обробка невірного вибору
                    System.out.println("Incorrect selection, try again. ");
            }
        }
    }
}