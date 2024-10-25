import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * This class represents the view of an abacus column.
 * 
 * @author Erica Shepherd
 *
 */
public class ColumnView extends JPanel {

	/**
	 * This field represents the list of beads assigned by the controller.
	 */
	Bead[] beadList;
	
	/**
	 * Constructor for bottom beads with the given index
	 * @param c Controller
	 * @param index index of beads
	 */
	public ColumnView(Controller c, int index) {
		super();
		this.beadList = c.getBottomBeads(index);
	}
	
	/**
	 * Constructor for top beads with the given index
	 * @param c Controller
	 * @param index index of beads
	 * @param b boolean
	 */
	public ColumnView(Controller c, int index, Boolean b) {
		super();
		this.beadList = c.getTopBeads(index);
	}
	
	/**
	 * Paints the beads into the window
	 * @param g paint brush used to draw objects
	 */
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		for (int i=0; i<beadList.length; i++) {
			if (beadList[i].isVisible() == true) {
				g.fillOval(0, 0+30*i, 50, 25);
			}
		}
	}

}
