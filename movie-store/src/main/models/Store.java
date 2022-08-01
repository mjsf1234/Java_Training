package src.main.models;

import java.util.ArrayList;

public class Store {
    ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovie(int index) {
        return new Movie(this.movies.get(index));
    }

    public void setMovie(int index, Movie movie) {
        this.movies.set(index, new Movie(movie));
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.movies.size(); i++) {
            temp += this.movies.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }

    public void addMovies(Movie movie) {
        this.movies.add(new Movie(movie));
    }

    public void sellMovies(String movieName) {
        /* functional approach */

        this.movies.removeIf((movie) -> {
            return movie.getName().equals(movieName);
        });

        /*
         * Loop approach to remove the movies
         * for (int i = 0; i < movies.size(); i++) {
         * 
         * if (movies.get(i).getName().equals(movieName)) {
         * movies.remove(i);
         * }
         * 
         * }
         */

    }

    public boolean contain(Movie movie) {
        return this.movies.contains(movie);
    }

}
