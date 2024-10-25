import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * This class represents a Graphical User Interface with
 * an interactive abacus and equation generation.
 * 
 * @author Erica Shepherd
 *
 */
public class GUI {

	/**
	 * Constructor runs the createGUI method
	 */
	public GUI() {
		createGUI();
	}
	
	/**
	 * Creates the GUI with a controller and model
	 */
	public void createGUI() {
		
		// Creates window
		JFrame win = new JFrame();
		win.setTitle("Interactive Abacus");
		win.setSize(800, 500);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.getContentPane().setLayout(null);
		
		// Creates JPanel frame for abacus with JPanel arrays on top for beads
		JPanel frame = new Frame();
		frame.setBounds(10, 110, 764, 340);
		win.getContentPane().add(frame);
		frame.setLayout(null);
		
		// Creates a controller and assigns the model and frame
		Controller c = new Controller(new Model(), (Frame) frame);
		// Links the controller to the frame/view
		((Frame) frame).setController(c);
		
		// Adds a label that displays the value of the abacus
		JLabel lblValue = new JLabel("Value: " + c.getValue());
		lblValue.setVerticalAlignment(SwingConstants.TOP);
		lblValue.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		lblValue.setBounds(20, 87, 311, 23);
		win.getContentPane().add(lblValue);
		
		// creates an overlapped panel to display the equations with an etched border
		JPanel equationPanel = new JPanel();
		equationPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		equationPanel.setBounds(209, 32, 393, 57);
		win.getContentPane().add(equationPanel);
		equationPanel.setLayout(null);
		// holds the equations text
		JLabel lblEquation = new JLabel("Click GENERATE to make a new equation.");
		lblEquation.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquation.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		lblEquation.setBounds(10, 11, 373, 35);
		equationPanel.add(lblEquation);
		
		
		// Buttons for user interaction
		
		// Reset button to reset the abacus
		JButton btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Monospaced", Font.PLAIN, 20));
		btnReset.setBounds(631, 66, 128, 33);
		win.getContentPane().add(btnReset);
		
		// Check button to check whether or not the abacus answer is correct
		JButton btnCheckAnswer = new JButton("CHECK");
		btnCheckAnswer.setFont(new Font("Monospaced", Font.PLAIN, 20));
		btnCheckAnswer.setBounds(631, 21, 128, 34);
		win.getContentPane().add(btnCheckAnswer);
		
		// Generate button for generating a new equation
		JButton btnGenerate = new JButton("GENERATE");
		btnGenerate.setFont(new Font("Monospaced", Font.PLAIN, 20));
		btnGenerate.setBounds(20, 42, 158, 34);
		win.getContentPane().add(btnGenerate);
		
		// Easy button for easy level equations
		JRadioButton rdbtnEasy = new JRadioButton("Easy");
			rdbtnEasy.setSelected(true);
		rdbtnEasy.setFont(new Font("Book Antiqua", Font.PLAIN, 10));
		rdbtnEasy.setBounds(20, 12, 49, 23);
		win.getContentPane().add(rdbtnEasy);
		
		// Medium button for medium level equations
		JRadioButton rdbtnMedium = new JRadioButton("Medium");
		rdbtnMedium.setFont(new Font("Book Antiqua", Font.PLAIN, 10));
		rdbtnMedium.setBounds(71, 12, 63, 23);
		win.getContentPane().add(rdbtnMedium);
		
		// Hard button for hard level equations
		JRadioButton rdbtnHard = new JRadioButton("Hard");
		rdbtnHard.setFont(new Font("Book Antiqua", Font.PLAIN, 10));
		rdbtnHard.setBounds(136, 12, 49, 23);
		win.getContentPane().add(rdbtnHard);
		
		// Text label that notifies user whether or not their answer is correct or not
		JLabel lblCorrect = new JLabel("Correct!");
		lblCorrect.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorrect.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		lblCorrect.setBounds(507, 13, 75, 20);
		win.getContentPane().add(lblCorrect);
			lblCorrect.setVisible(false);
			

		// Action listeners
		
		// Checks for click on abacus and adjusts values/abacus drawing accordingly
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// updates abacus if bead is clicked on
				c.mouseEvent(e.getX(), e.getY());
				
				// updates value text
				lblValue.setText(String.format("Value: %d", c.getValue()));
			}
		});
		
		// Checks if user clicks on the easy button and sets the equation level accordingly
		rdbtnEasy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnEasy.setSelected(true);
				rdbtnMedium.setSelected(false);
				rdbtnHard.setSelected(false);
				c.selectLevel(Difficulty.easy);
			}
		});
		
		// Checks if user clicks on the medium button and sets the equation level accordingly
		rdbtnMedium.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnEasy.setSelected(false);
				rdbtnMedium.setSelected(true);
				rdbtnHard.setSelected(false);
				c.selectLevel(Difficulty.medium);
			}
		});
		
		// Checks if user clicks on the hard button and sets the equation level accordingly
		rdbtnHard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnEasy.setSelected(false);
				rdbtnMedium.setSelected(false);
				rdbtnHard.setSelected(true);
				c.selectLevel(Difficulty.hard);
			}
		});
		
		// Generates an equation if user clicks on generate button
		btnGenerate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// generates an equation
				c.generateEquation();
				lblCorrect.setVisible(false);
				// updates text with equation
				lblEquation.setText(c.getEquation().toString());
			}
		});
		
		// Notifies user if the answer is correct or not
		btnCheckAnswer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// checks values and assigns string to text label
				String s = c.checkValue();
				switch(s) {
					case "Correct!":
						lblCorrect.setForeground(new Color(0, 128, 0));
						break;
					case "Incorrect":
						lblCorrect.setForeground(new Color(165, 42, 42));
						break;
					default:
						break;
				}
				lblCorrect.setText(s);
				lblCorrect.setVisible(true);
			}
		});
		
		// Resets the abacus if user clicks on reset button
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c.resetEvent();
				lblValue.setText(String.format("Value: %d", c.getValue()));
			}
		});
		
		// makes window visible
		win.setVisible(true);
	}
	
	// creates an instance of the GUI and runs it
	 public static void main(String[] args) {
		 GUI abacus = new GUI();
	 }
}
