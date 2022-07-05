package dom.com.gm.movies.domain;

public class Movie { //Represents Movie objects used in the movies catalog app.

    private String name;

    public Movie() {} //Empty constructor
    public Movie(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
//Challenge Given by: Global Mentoring Java University Course.
//Coded by: Jhordany Polanco on VS Code