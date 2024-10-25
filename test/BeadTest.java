import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for Beads
 * 
 * @author Erica Shepherd
 *
 */
public class BeadTest {
	/**
	 * This field represents an Earth bead
	 */
	Bead e;
	
	/**
	 * This field represents a Heaven Bead
	 */
	Bead h;
	
	/**
	 * Constructs bead objects
	 */
	@Before
	public void setUp() {
		e = new EarthBead();
		h = new HeavenBead();
	}

	/**
	 * Tests getValue method
	 */
	@Test
	public void testGetValue() {
		assertEquals(1, e.getValue(), 0.1);
		assertEquals(5, h.getValue(), 0.1);
	}
	
	/**
	 * Tests isVisible method
	 */
	@Test
	public void testIsVisible() {
		assertEquals(true, e.isVisible());
		assertEquals(true, h.isVisible());
	}
	
	/**
	 * Tests isActive method
	 */
	@Test
	public void testIsActive() {
		assertEquals(false, e.isActive());
		assertEquals(false, h.isActive());
	}
	
	/**
	 * Tests setVisible method
	 */
	@Test
	public void testSetVisible() {
		e.setVisible(false);
		h.setVisible(false);
		assertEquals(false, e.isVisible());
		assertEquals(false, h.isVisible());
	}
	
	/**
	 * Tests setActive method
	 */
	@Test
	public void testSetActive() {
		e.setActive(true);
		h.setActive(true);
		assertEquals(true, e.isActive());
		assertEquals(true, h.isActive());
	}

}
