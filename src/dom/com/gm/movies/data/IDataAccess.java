package dom.com.gm.movies.data;
import java.util.List;
import dom.com.gm.movies.domain.Movie;

public interface IDataAccess { //Contains the movie file executing operations

    public boolean exists(String fileName);
    public List<Movie> list(String name);
    public void write(Movie movie, String fileName, boolean attach);
    public String search(String fileName, String search);
    public void create(String fileName);
    public void delete(String fileName);
}
