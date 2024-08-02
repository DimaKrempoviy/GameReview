import java.util.List;
import java.util.Optional;

public interface ReviewStorage {
    void addReview(GameReview review);
    Optional<GameReview> getReview(String name);
    List<GameReview> gerAllReview();
}
