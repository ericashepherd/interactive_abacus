/**
 * This class represents the entire model of the abacus program 
 * with an abacus and equation generations.
 * 
 * @author Erica Shepherd
 *
 */
public class Model {
	/**
	 * This field represents an abacus object
	 */
	private Abacus abacus;
	
	/**
	 * This field represents the difficulty level of generated
	 * equations
	 */
	private Difficulty level;
	
	/**
	 * This field represents the equation generated
	 */
	private Equation equation;
	
	/**
	 * Constructor that creates a new abacus and sets the
	 * default level to easy
	 */
	public Model(){
		abacus = new Abacus();
		equation = null;
		level = Difficulty.easy;
	}
	
	/**
	 * Returns the abacus object
	 * @return abacus object
	 */
	public Abacus getAbacus() {
		return abacus;
	}
	
	/**
	 * Returns equation object
	 * @return equation object
	 */
	public Equation getEquation() {
		return equation;
	}
	
	/**
	 * Sets the difficulty level for the equations
	 * @param level equation difficulty level
	 */
	public void selectLevel(Difficulty level) {
		this.level = level;
	}

	/**
	 * Generates a new equation and assigns it to the
	 * equation field
	 */
	public void generateEquation() {
		equation = new Addition(level);
	}

	/**
	 * Returns a string stating whether or not the abacus value
	 * is equal to the equation's answer
	 * 
	 * @return string stated above
	 */
	public String checkValue() {
		if (equation != null) {
			if (abacus.getValue() == equation.getAnswer()) {
				return "Correct!";
			}
			else {
				return "Incorrect";
			}
		}
		return "Invalid";
	}
	
}
