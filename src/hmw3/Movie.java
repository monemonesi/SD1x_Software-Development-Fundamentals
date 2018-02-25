package hmw3;

import java.util.ArrayList;


public class Movie implements Comparable{

    private String name;
    private ArrayList<Actor> actors;
    private double rating;
    /*
    public Movie(String name, ArrayList<Actor> actors, double rating) {
	this.name = name;
	this.actors = actors;
	this.rating = rating;
    }*/

    public Movie() {
	// name = " ";
	actors = new ArrayList<Actor>();
    }
    

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public ArrayList<Actor> getActors() {
	return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
	this.actors = actors;
    }

    public double getRating() {
	return rating;
    }

    public void setRating(double rating) {
	this.rating = rating;
    }


    @Override
    public int compareTo(Object o) {
	Movie otherM = (Movie) o;
	
	return (int)(this.getRating()-otherM.getRating());
    }

}
