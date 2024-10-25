import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for Abacus
 * 
 * @author Erica Shepherd
 *
 */
public class AbacusTest {

	/**
	 * This field represents an abacus object
	 */
	Abacus a;
	
	/**
	 * Constructs abacus object
	 */
	@Before
	public void setUp() {
		a = new Abacus();
	}

	/**
	 * Tests getColumn method
	 */
	@Test
	public void testGetColumn() {
		assertEquals(0, a.getColumn(0).getValue());
	}
	
	/**
	 * Tests selectTopBead method
	 */
	@Test
	public void testSelectTop() {
		a.selectTopBead(0, 1);
		assertEquals(true, a.getColumn(0).getTopBeads()[0].isVisible());
		assertEquals(false, a.getColumn(0).getTopBeads()[1].isVisible());
		assertEquals(false, a.getColumn(0).getTopBeads()[1].isActive());
		
		a.selectTopBead(0, 0);
		assertEquals(false, a.getColumn(0).getTopBeads()[0].isVisible());
		assertEquals(true, a.getColumn(0).getTopBeads()[1].isVisible());
		assertEquals(true, a.getColumn(0).getTopBeads()[1].isActive());
	}
	
	
	/**
	 * Tests selectBottomBead method
	 */
	@Test
	public void testSelectBottom() {
		int i;
		a.selectBottomBead(0, 0);
		assertEquals(false, a.getColumn(0).getBottomBeads()[0].isVisible());
		assertEquals(false, a.getColumn(0).getBottomBeads()[0].isActive());
		
		for (i=1; i<5; i++) {
			assertEquals(true, a.getColumn(0).getBottomBeads()[i].isVisible());
			assertEquals(false, a.getColumn(0).getBottomBeads()[i].isActive());
		}
		
		a.selectBottomBead(0, 1);
		assertEquals(true, a.getColumn(0).getBottomBeads()[0].isVisible());
		assertEquals(true, a.getColumn(0).getBottomBeads()[0].isActive());
		
		assertEquals(false, a.getColumn(0).getBottomBeads()[1].isVisible());
		assertEquals(false, a.getColumn(0).getBottomBeads()[1].isActive());
		
		for (i=2; i<5; i++) {
			assertEquals(true, a.getColumn(0).getBottomBeads()[i].isVisible());
			assertEquals(false, a.getColumn(0).getBottomBeads()[i].isActive());
		}
	}
	
	/**
	 * Tests getValue method
	 */
	@Test
	public void testGetValue() {
		assertEquals(0, a.getValue());
		a.selectBottomBead(0, 1);
		assertEquals(1, a.getValue());
		a.selectTopBead(0, 0);
		assertEquals(6, a.getValue());
	}
	
	/**
	 * Tests reset method
	 */
	@Test
	public void testReset() {
		a.selectBottomBead(0, 1);
		a.selectTopBead(0, 0);
		a.reset();
		assertEquals(0, a.getValue());
	}
}
