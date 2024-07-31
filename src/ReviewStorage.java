import java.util.List;
import java.util.Optional;

public interface ReviewStorage {
    // Метод для додавання нової рецензії
    void addReview(GameReview review);
    // Метод для отримання рецензії за назвою гри
    Optional<GameReview> getReview(String name);
    // Метод для отримання списку всіх рецензій
    List<GameReview> gerAllReview();
}
