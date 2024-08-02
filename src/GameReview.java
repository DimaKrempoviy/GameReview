public class GameReview {

    private final String name;
    private final int rating;
    private final String review;


    public GameReview (String name, int rating, String review) {
        this.name = name;
        this.rating = rating;
        this.review = review;
    }

    public String getName() {
        return name;
    }


    public int getRating() {
        return rating;
    }


    public String getReview() {
        return review;
    }


    public String toString () {
        return name + ", " + rating +", " + review;
    }


    public static GameReview fromString(String line) {
        String[] parts = line.split(", ");
        return new GameReview(parts[0], Integer.parseInt(parts[1]), parts[2]);
    }
}
