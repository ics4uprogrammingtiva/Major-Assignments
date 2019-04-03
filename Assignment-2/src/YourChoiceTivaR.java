import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * Created by: Tiva Rait
 * Created on: 03-April-2019
 * Created for: ICS4U
 * Major Assignment – 2
 * This program ...
*/
public class YourChoiceTivaR {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YourChoiceTivaR window = new YourChoiceTivaR();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public YourChoiceTivaR() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInstructions = new JLabel("Select which problem you would like the program to do.");
		lblInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructions.setBounds(10, 11, 414, 14);
		frame.getContentPane().add(lblInstructions);
		
		JButton btnWillowWildRide = new JButton("Willow's Wild Ride");
		btnWillowWildRide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnWillowWildRide.setBounds(10, 74, 195, 23);
		frame.getContentPane().add(btnWillowWildRide);
		
		JButton btnPassOrFail = new JButton("Pass or Fail");
		btnPassOrFail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPassOrFail.setBounds(229, 74, 195, 23);
		frame.getContentPane().add(btnPassOrFail);
		
		JButton btnMartianTime = new JButton("Martian Time");
		btnMartianTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMartianTime.setBounds(118, 124, 195, 23);
		frame.getContentPane().add(btnMartianTime);
		
		// Procedure
		//
	}

}
