/**
 * This class represents an abacus model.
 * 
 * @author Erica Shepherd
 *
 */
public class Abacus {
	/**
	 * This field represents an array of columns of beads
	 */
	Column[] columns;
	
	/**
	 * Default constructor which creates 10 columns
	 */
	public Abacus() {
		int i;
		columns = new Column[10];
		for (i=0; i<10; i++) {
			columns[i] = new Column();
		}
	}
	
	/**
	 * Returns the column of beads at given index
	 * @param index index
	 * @return column of beads at given index
	 */
	public Column getColumn(int index) {
		return columns[index];
	}
	
	/**
	 * Adjusts column bead array visibilities and activeness based on
	 * which top bead was selected.
	 * 
	 * @param column column of beads
	 * @param index index of bead
	 */
	public void selectTopBead(int column, int index) {
		columns[column].selectTopBead(index);
	}
	
	/**
	 * Adjusts column bead array visibilities and activeness based on
	 * which bottom bead was selected.
	 * 
	 * @param column column of beads
	 * @param index index of bead
	 */
	public void selectBottomBead(int column, int index) {
		columns[column].selectBottomBead(index);
	}
	
	/**
	 * Returns the total value of the column arrays
	 * @return total value of the column arrays
	 */
	public long getValue() {
		int i;
		long sum = 0;
		
		for (i=0; i<columns.length; i++) {
			sum += columns[i].getValue() * Math.pow(10, i);
		}
		return sum;
	}
	
	/**
	 * Resets all columns to initial visibilities and activeness
	 */
	public void reset() {
		for (Column c : columns) {
			c.resetBottom();
			c.resetTop();
		}
	}
	
	
}
