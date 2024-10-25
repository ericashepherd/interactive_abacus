/**
 * This class represents the controller for the abacus program
 * 
 * @author Erica Shepherd
 *
 */
public class Controller {
	/**
	 * This field represents the model
	 */
	final Model in;
	
	/**
	 * This field represents the view
	 */
	final Frame out;
	
	/**
	 * Constructs controller with given model and view
	 * @param in model
	 * @param out view
	 */
	Controller(Model in, Frame out) {
		this.in = in;
		this.out = out;
	}
	
	/**
	 * Runs model's abacus methods that adjust bead 
	 * activeness and visibility based on which bead
	 * was selected from the x and y coordinates of the
	 * mouse click.
	 * 
	 * @param x x-coordinate of mouse click
	 * @param y y-coordinate of mouse click
	 */
	public void mouseEvent(int x, int y) {
		String side = "";
		// assigns rows/column based on click
		int column = checkX(x);
		int row = -1;
		
		// returns if bead was not clicked
		if (column == -1)
			return;
		
		// checks which column was clicked
		if (y > 45 && y < 125) {
			row = checkTopY(y);
			side = "top";
		}
		else if (y > 147 && y < 422) {
			row = checkBottomY(y);
			side = "bottom";
		}
	
		// returns if bead was not clicked
		if (row == -1) 
			return;
		
		// runs abacus methods to adjust visibility/activeness based
		// on which bead was selected
		if (side == "bottom") {
			in.getAbacus().selectBottomBead(column, row);
		}
		else if (side == "top") {
			in.getAbacus().selectTopBead(column, row);
		}
		
		// tells view to repaint
		out.repaint();
	}
	
	/**
	 * Returns the x-coordinate of mouse-click if valid,
	 * returns -1 if not valid
	 * 
	 * @param x x-coordinate of mouse-click
	 * @return x-coordinate of mouse-click if valid,
	 * returns -1 if not valid
	 */
	private int checkX(int x) {
		for (int i=0; i<10; i++) {
			if (x > 663 - 68*i && x < 713 - 68*i) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Returns the y-coordinate of mouse-click if valid,
	 * returns -1 if not valid
	 * 
	 * @param y y-coordinate of mouse-click
	 * @return y-coordinate of mouse-click if valid,
	 * returns -1 if not valid
	 */
	private int checkTopY(int y) {
		for (int i=0; i<2; i++) {
			if (y > 45 + 30*i && y < 70 + 30*i) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Returns the y-coordinate of mouse-click if valid,
	 * returns -1 if not valid
	 * 
	 * @param y y-coordinate of mouse-click
	 * @return y-coordinate of mouse-click if valid,
	 * returns -1 if not valid
	 */
	private int checkBottomY(int y) {
		for (int i=0; i<5; i++) {
			if (y > 147 + 30*i && y < 172 + 30*i) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Returns value calculated by abacus
	 * @return value calculated by abacus
	 */
	public long getValue() {
		return in.getAbacus().getValue();
	}

	/**
	 * Resets abacus and repaints view
	 */
	public void resetEvent() {
		in.getAbacus().reset();
		out.repaint();
	}

	/**
	 * Returns top array of beads from column index
	 * @param index index of column
	 * @return top array of beads from column index
	 */
	public Bead[] getTopBeads(int index) {
		return in.getAbacus().getColumn(index).getTopBeads();
	}
	
	/**
	 * Returns bottom array of beads from column index
	 * @param index index of column
	 * @return bottom array of beads from column index
	 */
	public Bead[] getBottomBeads(int index) {
		return in.getAbacus().getColumn(index).getBottomBeads();
	}
	
	/**
	 * Sets the difficulty level of generated equations
	 * @param level difficulty level
	 */
	public void selectLevel(Difficulty level) {
		in.selectLevel(level);
	}
	
	/**
	 * Returns the equation from the model
	 * @return equation from model
	 */
	public Equation getEquation() {
		return in.getEquation();
	}
	
	/**
	 * Tells model to generate a new equation
	 */
	public void generateEquation() {
		in.generateEquation();
	}
	
	/**
	 * Returns the String stating whether or not the
	 * value of the abacus matches the answer of the
	 * equation
	 * 
	 * @return string stated above
	 */
	public String checkValue() {
		return in.checkValue();
	}
}
