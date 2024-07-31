public class GameReview {
    // Поля класу для зберігання назви гри, рейтингу та рецензії
    private final String name;
    private final int rating;
    private final String review;

    // Конструктор для ініціалізації об'єкта GameReview
    public GameReview (String name, int rating, String review) {
        this.name = name;
        this.rating = rating;
        this.review = review;
    }
    // Геттер для отримання назви гри
    public String getName() {
        return name;
    }

    // Геттер для отримання рейтингу гри
    public int getRating() {
        return rating;
    }

    // Геттер для отримання рецензії на гру
    public String getReview() {
        return review;
    }

    // Метод для перетворення об'єкта GameReview у рядок формату CSV
    public String toString () {
        return name + ", " + rating +", " + review;
    }

    // Статичний метод для створення об'єкта GameReview з рядка формату CSV
    public static GameReview fromString(String line) {
        String[] parts = line.split(", ");
        return new GameReview(parts[0], Integer.parseInt(parts[1]), parts[2]);
    }
}
