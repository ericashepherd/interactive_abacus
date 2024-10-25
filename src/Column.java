/**
 * This class represents a column of beads within an abacus
 * 
 * @author Erica Shepherd
 *
 */
public class Column {
	/**
	 * This field represents the number of beads in the top array
	 */
	private int beadsT;
	
	/**
	 * This field represents the number of beads in the bottom array
	 */
	private int beadsB;
	
	/**
	 * This field represents an array of beads at the top of the column
	 */
	private Bead[] beadListT;
	
	/**
	 * This field represents an array of beads at the bottom of the column
	 */
	private Bead[] beadListB;
	
	/**
	 * Column constructor which creates a default
	 */
	public Column() {
		beadsB = 5;
		beadsT = 2;
		beadListB = new Bead[beadsB];
		beadListT = new Bead[beadsT];
		for (int i=0; i<beadsB; i++) {
			beadListB[i] = new EarthBead();
		}
		beadListB[0].setVisible(false);
		for (int i=0; i<beadsT; i++) {
			beadListT[i] = new HeavenBead();
		}
		beadListT[1].setVisible(false);
	}
	
	/**
	 * Returns the top array of beads
	 * @return top array of beads
	 */
	public Bead[] getTopBeads() {
		return beadListT;
	}
	
	/**
	 * Returns the bottom array of beads
	 * @return bottom array of beads
	 */
	public Bead[] getBottomBeads() {
		return beadListB;
	}
	
	/**
	 * Adjusts top bead array visibility and activeness based on
	 * which bead was selected.
	 * 
	 * @param index index of bead
	 */
	public void selectTopBead(int index) {
		Bead bead1 = beadListT[0];
		Bead bead2 = beadListT[1];
		
		if (beadListT[index].isVisible() != true) {
			return;
		}
	
		bead1.setVisible(! bead1.isVisible());
		bead2.setVisible(! bead2.isVisible());
		bead2.setActive(! bead2.isActive());
	}
	
	/**
	 * Adjusts bottom bead array visibility and activeness based on
	 * which bead was selected.
	 * 
	 * @param index index of bead
	 */
	public void selectBottomBead(int index) {
		Bead bead = beadListB[index];
		
		// unable to react to invisible beads
		if (bead.isVisible() != true) {
			return;
		}
		
		// sets bead activeness and visibility
		if (bead.isActive() != true) {
			for (int i=0; i<index; i++) {
				beadListB[i].setActive(true);
				beadListB[i].setVisible(true);
			}
			bead.setActive(false);
			bead.setVisible(false);
		}
		// reverses bead activeness and visibility if already active
		else {
			for (int i=index; i<beadsB; i++) {
				beadListB[i].setActive(false);
				beadListB[i].setVisible(true);
			}
			bead.setActive(false);
			bead.setVisible(false);
		}
	}
	
	/**
	 * Returns the total value of the bead arrays
	 * @return total value of the bead arrays
	 */
	public long getValue() {
		long sum = 0;
		
		// adds top beads
		for (Bead b : beadListT) {
			if (b.isActive())
				sum += b.getValue();
		}
		// adds bottom beads
		for (Bead b : beadListB) {
			if (b.isActive())
				sum += b.getValue();
		}
		
		return sum;
	}
	
	/**
	 * Resets bottom bead activeness and visibility to initial default positions
	 */
	public void resetBottom() {
		for (Bead b : beadListB) {
			b.setActive(false);
			b.setVisible(true);
		}
		beadListB[0].setVisible(false);
	}
	
	/**
	 * Resets top bead activeness and visibility to initial default positions
	 */
	public void resetTop() {
		for (Bead b : beadListT) {
			b.setActive(false);
			b.setVisible(true);
		}
		beadListT[1].setVisible(false);
	}
}
