/**
 * This abstract represents a bead in an abacus
 * 
 * @author Erica Shepherd
 *
 */
public abstract class Bead {
	/**
	 * This field represents the value of the bead
	 */
	protected int value;
	
	/**
	 * This field represents whether or not the bead is active
	 */
	protected boolean active;
	
	/**
	 * This field represents whether or not the bead will be visible
	 */
	protected boolean visibility;
	
	/**
	 * Constructor for bead with given value
	 * @param value value of bead
	 */
	public Bead(int value) {
		this.value = value;
		this.visibility = true;
		this.active = false;
	}
	
	/**
	 * Returns the value of the bead
	 * @return value of the bead
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Returns visibility of the bead
	 * @return visibility of the bead
	 */
	public boolean isVisible() {
		return visibility;
	}
	
	/**
	 * Returns active state of the bead
	 * @return active state of the bead
	 */
	public boolean isActive() {
		return active;
	}
	
	/**
	 * Sets the visibility of the bead
	 * @param v visibility of bead
	 */
	public void setVisible(boolean v) {
		visibility = v;
	}

	/**
	 * Sets the active state of the bead
	 * @param a active state of the bead
	 */
	public void setActive(boolean a) {
		active = a;
	}
}
