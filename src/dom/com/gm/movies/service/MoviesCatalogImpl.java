package dom.com.gm.movies.service;

import dom.com.gm.movies.data.*;
import dom.com.gm.movies.domain.Movie;
import dom.com.gm.movies.exceptions.DataAccesEx;
import dom.com.gm.movies.exceptions.DataReadEx;

public class MoviesCatalogImpl implements IMoviesCatalog{
    
    private final IDataAccess data;

    public MoviesCatalogImpl() {
        this.data = new DataAccessImpl();
    }

    public void addMovie(String movieName){
        var movie = new Movie(movieName);
        boolean append;
        try {
            append = data.exists(IMoviesCatalog.FILE_NAME);
            data.write(movie, IMoviesCatalog.FILE_NAME, append);
        } catch (DataAccesEx e) {
            e.printStackTrace();
            System.out.println("Error: Data not found. "+e.getMessage());
        }
    }

    public void movieList(){
        try {
            var movies = this.data.list(IMoviesCatalog.FILE_NAME);
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        } catch (DataReadEx e) {
            System.out.println("Error trying to retrieve the data list: ");
            e.printStackTrace();
        }
    }
    
    public void searchMovie(String search){
        try {
            String searchResult = this.data.search(IMoviesCatalog.FILE_NAME, search);
            System.out.println("Search Results:\n"+searchResult);
        } catch (DataReadEx e) {
            System.out.println("Data search error:");
            e.printStackTrace();
        }
    }

    public void restartFile(){
        try {
            if (this.data.exists(IMoviesCatalog.FILE_NAME)) {
                this.data.delete(IMoviesCatalog.FILE_NAME);
                this.data.create(IMoviesCatalog.FILE_NAME);
            }else {
                data.create(IMoviesCatalog.FILE_NAME);
            }
        } catch (DataAccesEx e) {
            System.out.println("Error re-starting the movie catalog file.");
            e.printStackTrace();
        }
    }
}
