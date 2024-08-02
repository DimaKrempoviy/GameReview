
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CSVReviewStorage implements ReviewStorage{
    private static final String FILE_NAME = "reviews.csv";

    @Override
    public void addReview(GameReview review) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(review.toString());
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<GameReview> getReview(String name) {
        return gerAllReview().stream()
                .filter(review -> review.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public List<GameReview> gerAllReview() {
        List<GameReview> reviews = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null){

                reviews.add(GameReview.fromString(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return reviews;
    }
}
