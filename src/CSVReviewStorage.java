
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CSVReviewStorage implements ReviewStorage{
    private static final String FILE_NAME = "reviews.csv";

    // Додаємо нову рецензію у файл CSV
    @Override
    public void addReview(GameReview review) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(review.toString());
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Отримуємо рецензію за назвою гри
    @Override
    public Optional<GameReview> getReview(String name) {
        // Отримуємо всі рецензії та шукаємо першу, яка відповідає назві гри
        return gerAllReview().stream()
                .filter(review -> review.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    // Отримуємо список всіх рецензій
    @Override
    public List<GameReview> gerAllReview() {
        List<GameReview> reviews = new ArrayList<>();
        // Відкриваємо файл для читання
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            // Читаємо файл рядок за рядком
            while ((line = reader.readLine()) != null){
                // Перетворюємо рядок у об'єкт GameReview і додаємо його до списку
                reviews.add(GameReview.fromString(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return reviews;
    }
}
