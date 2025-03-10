import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	private GradeBook g1;
	private GradeBook g2;

	@BeforeEach
	void setUp() throws Exception {
		
		 g1 = new GradeBook(5);
		 g2 = new GradeBook(5);
		 g1.addScore(80.0);
		 g1.addScore(90.0);
		 
		 g2.addScore(55.0);
		 g2.addScore(87.0);
		 g2.addScore(54.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	@Test
	void testAddScore() {
		g1.addScore(100.0);
		g2.addScore(100.0);
		
		assertTrue(g1.toString().equals("80.0 90.0 100.0 "));
	    assertTrue(g2.toString().equals("55.0 87.0 54.0 100.0 "));
	    
	    // Verify the score size
	    assertEquals(3, g1.getScoresSize());  // g1 should have 3 scores now
	    assertEquals(4, g2.getScoresSize());
	}

	@Test
	void testSum() {
		assertEquals(170.0, g1.sum(), 0.001); // Expected sum = 80 + 90
        assertEquals(196.0, g2.sum(), 0.001); // Expected sum = 55 + 87 + 54
	}

	@Test
	void testMinimum() {
		assertEquals(80.0, g1.minimum(), 0.001); // Smallest score in g1 is 80
        assertEquals(54.0, g2.minimum(), 0.001); // Smallest score in g2 is 54
	}

	@Test
	void testFinalScore() {
		assertEquals(90.0, g1.finalScore(), 0.001); // Sum is 170, drop 80 → 90
        assertEquals(142.0, g2.finalScore(), 0.001); // Sum is 196, drop 54 → 142
	}

	@Test
	void testGetScoresSize() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
