
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for the Model
 * 
 * @author Erica
 */
public class ModelTest {
	
	/**
	 * This field represents a model object
	 */
	private Model m;

	/**
	 * Sets up model constructor
	 */
	@Before
	public void setUp() {
		m = new Model();
	}

	/**
	 * Test getEquation method
	 */
	@Test
	public void testGetEquation() {
		assertNull(m.getEquation());
	}
	
}
