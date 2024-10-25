import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * This class represents a JPanel frame with the abacus drawn inside
 * and holds arrays of JPanels on top to draw the columns of beads.
 * 
 * @author Erica Shepherd
 *
 */
public class Frame extends JPanel {
	/**
	 * This field represents the bottom array of bead columns.
	 */
	JPanel[] bottomArray;
	
	/**
	 * This field represents the top array of bead columns.
	 */
	JPanel[] topArray;
	
	/**
	 * Constructor for Frame
	 */
	public Frame() {
		super();
	}
	
	/**
	 * Assigns ColumnViews to arrays with given Controller
	 * @param c Controller
	 */
	public void setController(Controller c) {
		// both arrays have 10 columns
		bottomArray = new JPanel[10];
		topArray = new JPanel[10];
		
		for (int i=0; i<10; i++) {
			// sets the bottom arrays
			bottomArray[i] = new ColumnView(c, i);
			bottomArray[i].setBounds(663 - 68*i, 147, 59, 150);
			bottomArray[i].setLayout(null);
			this.add(bottomArray[i]);
			
			// sets the top arrays
			topArray[i] = new ColumnView(c, i, true);
			topArray[i].setBounds(663 - 68*i, 45, 59, 125);
			topArray[i].setLayout(null);
			this.add(topArray[i]);
		}

	}
	
	/**
	 * Paints the frame into the window
	 * @param g paint brush used to draw objects
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// frame of abacus
		g.setColor(Color.gray);
		((Graphics2D) g).setStroke(new BasicStroke(5));
		for (int i=0; i<10; i++) {
			g.drawLine(688 - 68*i, 20, 688 - 68*i, 320);
		}
		g.setColor(Color.black);
		((Graphics2D) g).setStroke(new BasicStroke(30));
		g.drawRect(20,  20,  724,  300);
		((Graphics2D) g).setStroke(new BasicStroke(20));
		g.drawLine(20, 120, 724, 120);
		
		// white dots for easier reading
		g.setColor(Color.white);
		for (int i=0; i<4; i++) {
			g.fillOval(72 + 68*i*3, 116, 8, 8);
		}
	}

}
