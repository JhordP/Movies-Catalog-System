package dom.com.gm.movies.data;

import java.util.List;
import dom.com.gm.movies.domain.Movie;
import dom.com.gm.movies.exceptions.*;


public interface IDataAccess { //Contains the movie file executing operations

    boolean exists(String fileName) throws DataAccesEx;

    List<Movie> list(String fileName) throws DataReadEx;

    void write(Movie movie, String fileName, boolean append) throws DataWriteEx;

    String search(String fileName, String search) throws DataReadEx;

    void create(String fileName) throws DataAccesEx;
    void delete(String fileName) throws DataAccesEx;
}
