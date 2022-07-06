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

            if (append) {
                System.out.println("Data added: "+movie);
            } else {
                System.out.println("Data generated: "+movie);
            }
        } catch (IOException e) {          
            e.printStackTrace();
            throw new DataWriteEx("Data write exception: "+e.getMessage());
        }
        
    }

    @Override
    public String search(String fileName, String search) throws DataReadEx {
        var file = new File(fileName);
        StringBuilder searchResult = new StringBuilder();
        try {
            var input = new BufferedReader(new FileReader(file));
            String line = null;
            line = input.readLine();
            var index = 1;
            while (line != null) {
                if (search != null && line.contains(search)) {
                    searchResult.append("Movie: "+line +" Index: "+index+"\n");
                }
                line = input.readLine();
                index++;
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new DataReadEx("Data read exception: "+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataReadEx("Data read exception: "+e.getMessage());
        }
        
        if (searchResult.isEmpty()) {
            return "Data not found.";    
        }
        else{
            return searchResult.toString();
        }
    }

    @Override
    public void create(String fileName) throws DataAccesEx {
        var file = new File(fileName);
        try {
            var output = new PrintWriter(new FileWriter(file));
            output.close();
            System.out.println("File created successfully");
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataAccesEx("Error creating the file. "+e.getMessage());
        }
    }

    @Override
    public void delete(String fileName) throws DataAccesEx {
        var file = new File(fileName);
        if (file.exists()){ file.delete(); System.out.println("File deleted."); }
        
    }

}
