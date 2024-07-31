import java.util.Optional;

public class ReviewManager {
    // Поле для зберігання об'єкта ReviewStorage
    private final ReviewStorage storage;

    // Конструктор для ініціалізації об'єкта ReviewManager
    public ReviewManager(ReviewStorage storage) {
        this.storage = storage;
    }

    // Метод для додавання нової рецензії
    public void addReview(String name, int rating, String review) {
        // Створюємо новий об'єкт GameReview
        GameReview gameReview = new GameReview(name, rating, review);
        // Додаємо рецензію до сховища
        storage.addReview(gameReview);
    }

    // Метод для отримання рецензії за назвою гри
    public Optional<GameReview> getReview(String name) {
        // Повертаємо рецензію зі сховища
        return storage.getReview(name);
    }
}
