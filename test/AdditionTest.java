import static org.junit.Assert.*;
import org.junit.Test;

/**
 * JUnit test for addition equations
 * 
 * @author Erica Shepherd
 *
 */
public class AdditionTest {

	/**
	 * This field represents an equation
	 */
	private Equation m;

	/**
	 * Tests Constructor and answer calculation
	 */
	@Test
	public void testAnswer() {
		m = new Addition(Difficulty.easy);
		assertEquals(m.v1 + m.v2, m.getAnswer(), 0.01);
	}
	
	/**
	 * Tests toString method
	 */
	@Test
	public void testToString() {
		m = new Addition(Difficulty.easy);
		assertEquals(m.v1 + " + " + m.v2 + " = ", m.toString());
	}

}
