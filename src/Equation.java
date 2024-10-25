import java.util.Random;

/**
 * This equation represents a randomly generated
 * algebraic equation
 * 
 * @author Erica Shepherd
 *
 */
public abstract class Equation {
	/**
	 * This field represents the answer to the equation
	 */
	protected int answer;
	
	/**
	 * This field represents the first variable in the equation
	 */
	protected int v1;
	
	/**
	 * This field represents the second variable in the equation
	 */
	protected int v2;
	
	/**
	 * Constructor for equation with given difficulty level
	 * @param level difficulty level
	 */
	public Equation(Difficulty level) {
		Random rand = new Random();
		switch(level) {
			// generates easy equations
			case easy:
				v1 = 10 * (rand.nextInt(9) + 1);
				v2 = rand.nextInt(9) + 1;
				break;
			// generates medium equations
			case medium:
				v1 = rand.nextInt(200) + 100;
				v2 = rand.nextInt(200) + 100;
				break;
			// generates hard equations
			case hard:
				v1 = rand.nextInt(99999) + 999;
				v2 = rand.nextInt(99999) + 999;
				break;
			// defaults to zero
			default:
				v1 = 0;
				v2 = 0;
		}
	}
	
	/**
	 * Returns the answer to the equation
	 * @return answer to the equation
	 */
	public int getAnswer() {
		return answer;
	}
}
