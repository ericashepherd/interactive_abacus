import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for Columns
 * 
 * @author Erica Shepherd
 *
 */
public class ColumnTest {

	/**
	 * This field represents a column of beads
	 */
	private Column c;
	
	/**
	 * Constructs the column object
	 */
	@Before
	public void setUp() {
		c = new Column();
	}

	/**
	 * Tests getTopBeads method
	 */
	@Test
	public void testGetTopBeads() {
		assertEquals(2, c.getTopBeads().length);
	}
	
	/**
	 * Tests getBottomBeads method
	 */
	@Test
	public void testGetBottomBeads() {
		assertEquals(5, c.getBottomBeads().length);
	}
	
	/**
	 * Tests selectTopBead method
	 */
	@Test
	public void testSelectTop() {
		c.selectTopBead(1);
		assertEquals(true, c.getTopBeads()[0].isVisible());
		assertEquals(false, c.getTopBeads()[1].isVisible());
		assertEquals(false, c.getTopBeads()[1].isActive());
		
		c.selectTopBead(0);
		assertEquals(false, c.getTopBeads()[0].isVisible());
		assertEquals(true, c.getTopBeads()[1].isVisible());
		assertEquals(true, c.getTopBeads()[1].isActive());
	}
	
	/**
	 * Tests selectBottomBead method
	 */
	@Test
	public void testSelectBottom() {
		int i;
		c.selectBottomBead(0);
		assertEquals(false, c.getBottomBeads()[0].isVisible());
		assertEquals(false, c.getBottomBeads()[0].isActive());
		
		for (i=1; i<5; i++) {
			assertEquals(true, c.getBottomBeads()[i].isVisible());
			assertEquals(false, c.getBottomBeads()[i].isActive());
		}
		
		c.selectBottomBead(1);
		assertEquals(true, c.getBottomBeads()[0].isVisible());
		assertEquals(true, c.getBottomBeads()[0].isActive());
		
		assertEquals(false, c.getBottomBeads()[1].isVisible());
		assertEquals(false, c.getBottomBeads()[1].isActive());
		
		for (i=2; i<5; i++) {
			assertEquals(true, c.getBottomBeads()[i].isVisible());
			assertEquals(false, c.getBottomBeads()[i].isActive());
		}
	}

	/**
	 * Tests getValue method
	 */
	@Test
	public void testGetValue() {
		assertEquals(0, c.getValue());
		c.selectBottomBead(1);
		assertEquals(1, c.getValue());
		c.selectTopBead(0);
		assertEquals(6, c.getValue());
	}
	
	/**
	 * Tests resetBottom method
	 */
	@Test
	public void testResetB() {
		c.selectBottomBead(1);
		c.resetBottom();
		assertEquals(0, c.getValue());
	}
	
	/**
	 * Tests resetTop method
	 */
	@Test
	public void testResetT() {
		c.selectTopBead(0);
		c.resetTop();
		assertEquals(0, c.getValue());
	}
	
}
