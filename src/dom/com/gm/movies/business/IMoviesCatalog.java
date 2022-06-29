package dom.com.gm.movies.business;

public interface IMoviesCatalog { //Contains the Movie Catalog required operations

    public void addMovie(String movieName, String fileName);
    public void movieList(String fileName);
    public void searchMovie(String fileName, String search);
    public void startFile(String fileName);
}
