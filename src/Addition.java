/**
 * This class represents an addition equation
 * 
 * @author Erica Shepherd
 *
 */
public class Addition extends Equation {

	/**
	 * Constructor with given difficulty level
	 * @param level difficulty level
	 */
	public Addition(Difficulty level) {
		super(level);
		answer = v1 + v2;
	}
	
	/**
	 * Returns a formatted string with the addition equation
	 * @return formatted string with the addition equation
	 */
	public String toString() {
		return v1 + " + " + v2 + " = ";
	}
	
}
