package dom.com.gm.movies.service;

public interface IMoviesCatalog { //Contains the Movie Catalog required operations

    String FILE_NAME = "movies.txt";
    void addMovie(String movieName/* , String fileName*/);
    void movieList(/*String fileName*/);
    void searchMovie(/*String fileName,*/ String search);
    void startFile(/*String fileName*/);
}
