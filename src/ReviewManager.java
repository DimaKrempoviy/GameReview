import java.util.Optional;

public class ReviewManager {
    private final ReviewStorage storage;

    public ReviewManager(ReviewStorage storage) {
        this.storage = storage;
    }

    public void addReview(String name, int rating, String review) {
        GameReview gameReview = new GameReview(name, rating, review);
        storage.addReview(gameReview);
    }

    public Optional<GameReview> getReview(String name) {
        return storage.getReview(name);
    }
}
