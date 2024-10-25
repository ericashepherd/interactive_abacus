import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for Equations
 * 
 * @author Erica Shepherd
 *
 */
public class EquationTest {

	/**
	 * This field represents an equation
	 */
	private Equation e;

	/**
	 * Tests Constructor for easy difficulty levels
	 */
	@Test
	public void testEasy() {
		int i;
		for (i=0; i<100; i++) {
			e = new Addition(Difficulty.easy);
			
			if (e.v1 > 100 || e.v1 < 10) {
				fail("v1 out of range");
			}
			if (e.v2 > 10 || e.v2 < 1) {
				fail("v2 out of range");
			}
		}
	}
	
	/**
	 * Tests Constructor for easy difficulty levels
	 */
	@Test
	public void testMedium() {
		int i;
		for (i=0; i<100; i++) {
			e = new Addition(Difficulty.medium);
			
			if (e.v1 > 300 || e.v1 < 100) {
				fail("v1 out of range");
			}
			if (e.v2 > 300 || e.v2 < 100) {
				fail("v2 out of range");
			}
		}
	}
	
	/**
	 * Tests Constructor for hard difficulty levels
	 */
	@Test
	public void testHard() {
		int i;
		for (i=0; i<100; i++) {
			e = new Addition(Difficulty.hard);
			
			if (e.v1 > 100998 || e.v1 < 999) {
				fail("v1 out of range");
			}
			if (e.v2 > 100998 || e.v2 < 999) {
				fail("v2 out of range");
			}
		}
	}
	
	/**
	 * Tests getAnswer method
	 */
	@Test
	public void getAnswer() {
		e = new Addition(Difficulty.easy);
		assertEquals(e.v1 + e.v2, e.getAnswer(), 0.01);
	}

}
