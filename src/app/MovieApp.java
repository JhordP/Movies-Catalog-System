package app;
import java.util.Scanner;

import dom.com.gm.movies.service.*;

public class MovieApp {
    static Scanner input;
    static int option;
    static String fileName;
    static MoviesCatalogImpl movieCatalog;

    public static void main(String[] args) {

        MovieApp.input = new Scanner(System.in);
    }
}
