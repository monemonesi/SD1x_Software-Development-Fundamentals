package hmw3;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovieDatabaseTest {
    MovieDatabase mdb, mdb2, mdb3, mdb4, mdb5, mdb6;
    Movie m1;
    Actor a1, a2;
    

    @BeforeEach
    void setUp() throws Exception {
	mdb = new MovieDatabase();
	mdb2 = new MovieDatabase();
	mdb3 = new MovieDatabase();
	mdb4 = new MovieDatabase();
	mdb5 = new MovieDatabase();
	m1 = new Movie();
	a1 = new Actor();
	a2 = new Actor();
    }
    /*
    @Test
    void testMovieDatabase() {
	fail("Not yet implemented");
    }*/

    @Test
    void testAddMovie() {
	mdb2.addMovie("Rocky", new String[] { "Clay Maddox", "Sylvester Stallone" });
	assertEquals(mdb2.getActorList().size(), 2);
	assertEquals(mdb2.getMovieList().size(), 1);
	mdb2.addMovie("Rocky", new String[] { "Clay Maddox", "Sylvester Stallone" });
	
	assertEquals(mdb2.getActorList().size(), 2);
	assertEquals(mdb2.getMovieList().size(), 1);
	mdb2.addMovie("Matrix", new String[] { "Neo", "Trinity" });
	assertEquals(mdb2.getActorList().size(), 4);
	assertEquals(mdb2.getMovieList().size(), 2);
	System.out.println(mdb2.getActorList().size());
	/*
	for (int i = 0; i < mdb2.getActorList().size(); i++) {
	    System.out.println(mdb2.getActorList().get(i).getName());
	}
	*/

	
    }
    
    @Test
    void testAddRating() {
	mdb3.addMovie("Rocky", new String[] { "Clay Maddox", "Sylvester Stallone" });
	mdb3.addMovie("Matrix", new String[] { "Neo", "Trinity" });
	mdb3.addRating("Rocky", 70);
	assertEquals(mdb3.getMovieList().get(0).getRating(), 70);
	//System.out.print(mdb2.getMovieList().get(0)+ " " + mdb2.getMovieList().get(0).getRating());
	mdb3.addRating("Test", 100);
	assertEquals(mdb3.getMovieList().get(0).getRating(), 70);
	mdb3.addRating("Matrix", 50);
	//assertEquals(mdb3.getMovieList().get(1).getRating(), 50);
    }
    
    @Test
    void testUpdateRating() {
	mdb4.addMovie("Rocky", new String[] { "Clay Maddox", "Sylvester Stallone" });
	mdb4.addMovie("Matrix", new String[] { "Neo", "Trinity" });
	mdb4.addRating("Rocky", 70);
	mdb4.updateRating("Rocky", 85);
	assertEquals(mdb4.getMovieList().get(0).getRating(), 85);

    }
    

    @Test
    void testGetBestActor() {
	mdb5.addMovie("Rocky", new String[] { "Clay Maddox", "Sylvester Stallone" });
	mdb5.addMovie("Matrix", new String[] { "Neo", "Trinity" });
	mdb5.addMovie("Rambo", new String[] { "Sylvester Stallone", "SomoneElse" });
	mdb5.addRating("Rocky", 90);
	mdb5.addRating("Matrix", 85);
	mdb5.addRating("Rambo", 85);
	assertEquals(mdb5.getBestActor(), "Clay Maddox");
	
    }

    
    
    @Test
    public void Test() {
	mdb.addMovie("Rocky", new String[] { "Clay Maddox", "Sylvester Stallone" });
	assertEquals(mdb.getActorList().size(), 2);
	assertEquals(mdb.getMovieList().size(), 1);

	mdb.addMovie("Rambo", new String[] { "A", "Sylvester Stallone" });
	assertEquals(mdb.getActorList().size(), 3);
	assertEquals(mdb.getMovieList().size(), 2);

    }

}
