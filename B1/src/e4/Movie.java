package e4;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Movie {
    String title;
    ArrayList<MovieRating> list = new ArrayList<>();

    /**
     * Creates a new movie with the list of ratings empty .
     * @param title Movie title .
     */
    public Movie(String title) {
        this.title = title;
    }
    /**
     * Returns the movie title
     * @return the movie title .
     */
    public String getTitle() {
        return this.title;
    }
    /**
     * Inserts a new movieRating .
     * It is allowed to insert NOT_RATED .
     * @param movieRating MovieRating to be inserted .
     */
    public void insertRating ( MovieRating movieRating ) {
            this.list.add(list.size(), movieRating); //Añade en la ultima posicion de la lista la nueva valoracion
    }
    /**
     * Check if this movie has any rating .
     * @return true if and only if there is a valuation other than NOT_RATED .
     */
    private boolean isRated () {
        if(!list.isEmpty()){
            for (int i = 0; i < list.size(); i++){
                if(list.get(i) != MovieRating.NOT_RATED)
                    return true;
            }
        }
        return false;
    }
    /**
     * Gets the highest rating for this movie .
     * @return maximum rating ; or NOT_RATED if there are no ratings .
     */
    public MovieRating maximumRating () {
        MovieRating max = MovieRating.NOT_RATED;
        if(isRated())
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).isBetterThan(max)){
                    max = list.get(i);
                }
            }
        return max;
        }
    /**
     * Calculate the numerical average rating of this movie .
     * NOT_RATED values are not considered .
     * @return Numerical average rating of this movie .
     * @throws java . util . NoSuchElementException if there are no valid ratings .
     */
    public double averageRating () {
        int count = 0;
        int countNotRated = 0;
        if(!isRated())
            throw new NoSuchElementException();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i)==MovieRating.NOT_RATED)
                countNotRated = countNotRated +1;
            else
                count = count + list.get(i).getNumericRating();
        }
        return ((double) count / (list.size() - countNotRated));
    }
}

