package app;
import java.util.Scanner;

import dom.com.gm.movies.service.*;

public class MovieApp {
    static Scanner input;
    static int option;
    static String fileName;
    static IMoviesCatalog movieCatalog;

    public static void main(String[] args) {
        option = -1;
        MovieApp.input = new Scanner(System.in);
        MovieApp.movieCatalog = new MoviesCatalogImpl();

        while(option != 0) {
            System.out.println("Select an option using the keyboard numbers.\n"+
            "1) Initiate Movie Catalog\n"+
            "2) Add Movie\n"+
            "3) List Movie\n"+
            "4) Search Movie\n"+
            "0) Exit");
            option = Integer.parseInt(input.nextLine());

            if (option >= 0 && option <= 4) {
                switch (option) {
                    case 1:
                        MovieApp.movieCatalog.restartFile();
                        break;

                    case 2:
                        System.out.println("Type the movie name.");
                        var movieName = MovieApp.input.nextLine();
                        MovieApp.movieCatalog.addMovie(movieName);
                        break;
                    
                    case 3:
                        MovieApp.movieCatalog.movieList();
                        break;

                    case 4:
                        System.out.println("Type your search criteria.");
                        var search = MovieApp.input.nextLine();
                        MovieApp.movieCatalog.searchMovie(search);
                        break;
                        
                    case 0: 
                        System.out.println("Closing the app...\nApp closed.");
                        break;

                    default: System.out.println("Option not found.");
                        break;
                }
            } else {
                System.out.println("Number typed not valid. Try again...");
            }
        }

    }
}
