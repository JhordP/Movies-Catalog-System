package dom.com.gm.movies.service;

import dom.com.gm.movies.data.*;
import dom.com.gm.movies.domain.Movie;
import dom.com.gm.movies.exceptions.DataAccesEx;

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

    }
    
    public void searchMovie(String search){

    }

    public void startFile(){

    }
}
