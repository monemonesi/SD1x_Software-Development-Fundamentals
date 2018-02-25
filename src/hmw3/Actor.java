package hmw3;

import java.util.ArrayList;


public class Actor implements Comparable {
    String name;
    private ArrayList<Movie> movies;
    

    public Actor() {
	// name = " ";
	movies = new ArrayList<Movie>();
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public ArrayList<Movie> getMovies() {
	return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
	this.movies = movies;
    }
    
    //helper method
    private Double getAverageRating() {
	float sum = 0;
	for (Movie movie : movies) {
	    sum += movie.getRating();
	}
	
	return sum / (1.0 * movies.size());
    }

    

    @Override
    public int compareTo(Object o) {
	Actor other = (Actor) o;
	return (int)( this.getAverageRating()-other.getAverageRating());
    }
     


     
}
