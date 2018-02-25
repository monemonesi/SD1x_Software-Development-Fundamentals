package hmw3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;





public class MovieDatabase {
 
    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;


    public MovieDatabase() {
	movieList = new ArrayList<Movie>();
	actorList = new ArrayList<Actor>();
    }



    public void addMovie(String name, String[] actors) {
	
	Movie movieToAdd = new Movie();
	movieToAdd.setName(name);
	
	boolean thisMovieExist = false;
	for (Movie existingMovie : movieList) {
	    if (name.equals(existingMovie.getName())) {
		thisMovieExist=true;
	    } 
	}
	if (!thisMovieExist) {
	    movieList.add(movieToAdd);
	}

	ArrayList<Actor> actorsInFilm = new ArrayList<Actor>();
	
	for (int i = 0; i < actors.length; i++) {
	    Actor actor = new Actor();
	    actor.setName(actors[i]);
	    actorsInFilm.add(actor);
	}
	
	for (Actor actInThisFilm : actorsInFilm) {
		boolean thisActorExists = false;
		for (int i = 0; i < actorList.size(); i++) {   
		    if(actInThisFilm.getName().equals(actorList.get(i).getName())) {
			thisActorExists=true;    
		    }
		}
		if (!thisActorExists) {
		    actorList.add(actInThisFilm);
		}
	}
    }



    public void addRating(String name, double rating) {
	for (Movie existingMovie : movieList) {
	    if (existingMovie.getName().equals(name)) {
		existingMovie.setRating(rating);
	    }
	}

    }//end addRating

 

    public void updateRating(String name, double newRating) {
	for (Movie existingMovie : movieList) {
	    if (existingMovie.getName().equals(name)) {
		existingMovie.setRating(newRating);
	    }
	}
    }//end updated rating



    public String getBestActor() {
	Collections.sort(actorList);
	return actorList.get(0).getName();
    }
    

    

    /*
     * 
     * String getBestMovie() Returns the name of the movie with the highest rating.
     * 
     * In the case of a tie, return any one of the best movies.
     */

    @SuppressWarnings("unchecked")
    public String getBestMovie() {
	Collections.sort(movieList);
	return movieList.get(0).getName();
    }

    public ArrayList<Movie> getMovieList() {
	return movieList;
    }

    public ArrayList<Actor> getActorList() {
	return actorList;
    }

    public static void main(String[] args) throws IOException {
	// TODO Auto-generated method stub
	MovieDatabase myMdb = new MovieDatabase();
	File moviesFile = new File(
		"C:\\Users\\Monesi Roberto\\eclipse-workspace\\Software Development Fundamentals\\src\\hmw3\\movies.txt");
	Scanner scnr = new Scanner(moviesFile);
	
	File ratingFile = new File(
		"C:\\Users\\Monesi Roberto\\eclipse-workspace\\Software Development Fundamentals\\src\\hmw3\\ratings.txt");
	Scanner scnr2 = new Scanner(ratingFile);
	
	/**
	 * creating a 2D arrayList based on the content of the movie.txt file
	 */
	ArrayList<String[]> dataMovies = new ArrayList<String[]>();
	// int count=0;
	while (scnr.hasNextLine()) {
	    // ArrayList<String> dataLine =new ArrayList<String>() ;
	    // dataLine.add(scnr.nextLine().split(","));
	    String[] dataLine = scnr.nextLine().split(",");
	    dataMovies.add(dataLine);
	    // count++;
	}

	for (int i = 0; i < dataMovies.size(); i++) {
	    // consider all the strings for each line. Avoid the 0 element because is the
	    // actor name
	    for (int j = 1; j < dataMovies.get(i).length; j++) {
		String movieName = new String(dataMovies.get(i)[j]);
		ArrayList<String> tempActorsName = new ArrayList<String>();
		tempActorsName.add(dataMovies.get(i)[0]);

		for (int k = i + 1; k < dataMovies.size(); k++) {
		    for (int k2 = 1; k2 < dataMovies.get(k).length; k2++) {
			if (dataMovies.get(k)[k2].equals(movieName)) {
			    tempActorsName.add(dataMovies.get(k)[0]);
			}
		    }
		}
		// create an array with the name of all the actor filmed in one film
		String[] actorsName = new String[tempActorsName.size()];
		for (int k = 0; k < tempActorsName.size(); k++) {
		    actorsName[k] = tempActorsName.get(k);
		}
		myMdb.addMovie(movieName, actorsName);
		// System.out.println(movieName);
		// System.out.println("with "+Arrays.toString(actorsName));
		// System.out.println("____________________");
	    } // end dataMovie Col
	} // end dataMovie Row
	
	/**
	 * creating a 2 different arrayList based on the content of the rating.txt file
	 * one contains the movie title, the other the rating
	 */
	ArrayList<String> dataLineRating = new ArrayList<String>();
	
	//Create a temp ArrayList with each lin
	while (scnr2.hasNextLine()) {
	    dataLineRating.add(scnr2.nextLine());	
	}
	
	//Put the name of the film in ratedMovie, and the rate in movieRate
	for (int i = 1; i < dataLineRating.size(); i++) {
	    
	    String name = dataLineRating.get(i).split("[\t]")[0];
	    double rating = Double.parseDouble(dataLineRating.get(i).split("[\t]")[1]);
	    System.out.println(name + " " + rating);
	    myMdb.addRating(name, rating);
	}
	
	System.out.println(myMdb.getBestActor());
	System.out.println(myMdb.getBestMovie());
	
	
	

    }

}
