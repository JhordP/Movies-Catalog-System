package dom.com.gm.movies.data;

import java.io.*;
import java.util.*;

import dom.com.gm.movies.domain.Movie;
import dom.com.gm.movies.exceptions.*;

public class DataAccessImpl implements IDataAccess{

    @Override
    public boolean exists(String fileName) throws DataAccesEx {
        var file = new File(fileName);
        return file.exists();
    }

    @Override
    public List<Movie> list(String fileName) throws DataReadEx {
        var file = new File(fileName);
        List<Movie> movies = new ArrayList<>();
        try {
            var input = new BufferedReader(new FileReader(file));
            String nameLine = null;
            nameLine = input.readLine();
            
            while (nameLine != null) {
                Movie movie = new Movie(nameLine);
                movies.add(movie);
                nameLine = input.readLine();
            }
            input.close(); //Closes the BufferedReader
            return movies; //Returns the List of Movies.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new DataReadEx("Data read exception: "+ e.getMessage());

        } catch (IOException e) {
            e.printStackTrace();
            throw new DataReadEx("Data read exception: "+ e.getMessage());
        }
    }

    @Override
    public void write(Movie movie, String fileName, boolean append) throws DataWriteEx {
        var file = new File(fileName);
        try {
            var output = new PrintWriter(new FileWriter(file, append));
            output.println(movie.toString()); //Since this is NOT System.out.println you shall use .toString method
            output.close();

            if (!append) {
                System.out.println("Data added: "+movie);
            } else {
                System.out.println("Data overrided: "+movie);
            }
        } catch (IOException e) {          
            e.printStackTrace();
            throw new DataWriteEx("Data write exception: "+e.getMessage());
        }
        
    }

    @Override
    public String search(String fileName, String search) throws DataReadEx {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void create(String fileName) throws DataAccesEx {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(String fileName) throws DataAccesEx {
        // TODO Auto-generated method stub
        
    }

}
