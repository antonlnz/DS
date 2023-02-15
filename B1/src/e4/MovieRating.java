package e4;
public enum MovieRating {
    NOT_RATED(-1), AWFUL(0), BAD(2), MEDIOCRE(4),
    GOOD(6), EXCELLENT(8), MASTERPIECE(10);
    public int numericRating;

    public int getNumericRating() {
        return numericRating;
    }

    public boolean isBetterThan(MovieRating movieRating) {
        return this.getNumericRating() > movieRating.getNumericRating();
    }

    MovieRating(int numericRating) {
        this.numericRating = numericRating;
    }
}