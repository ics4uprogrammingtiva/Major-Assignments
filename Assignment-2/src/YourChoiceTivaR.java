import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

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
				
				// Declare Variables
				// Step one
				int daysCatPlays;
				int daysCollectingBoxes;
				int totalDaysOfWork;
				int boxesCollected;
				int currentDay;
				
				
				// Get Input from File
				// Step two

				// The name of the file to open.
		        String InputfileName = "temp.txt";

		        // This will reference one line at a time
		        String line = null;

		        try {
		            // FileReader reads text files in the default encoding.
		            FileReader fileReader = 
		                new FileReader(InputfileName);

		            // Always wrap FileReader in BufferedReader.
		            BufferedReader bufferedReader = 
		                new BufferedReader(fileReader);

		            while((line = bufferedReader.readLine()) != null) {
		                System.out.println(line);
		            }   

		            // Always close files.
		            bufferedReader.close();         
		        }
		        catch(FileNotFoundException ex) {
		            System.out.println(
		                "Unable to open file '" + 
		                InputfileName + "'");                
		        }
		        catch(IOException ex) {
		            System.out.println(
		                "Error reading file '" 
		                + InputfileName + "'");                  
		            // Or we could just do this: 
		            // ex.printStackTrace();
		        }
				
				// Calculations 
				// Step three
				
				// Output to txt file 
				// Step four
				
		        String OutputfileName = "InputWillowWildRide.txt";

		        try {
		            // Assume default encoding.
		            FileWriter fileWriter =
		                new FileWriter(OutputfileName);

		            // Always wrap FileWriter in BufferedWriter.
		            BufferedWriter bufferedWriter =
		                new BufferedWriter(fileWriter);

		            // Note that write() does not automatically
		            // append a newline character.
		            bufferedWriter.write("Hello there,");
		            bufferedWriter.newLine();
		            bufferedWriter.write("We are writing");

		            // Always close files.
		            bufferedWriter.close();
		        }
		        catch(IOException ex) {
		            System.out.println(
		                "Error writing to file '"
		                + OutputfileName + "'");
		            // Or we could just do this:
		            // ex.printStackTrace();
		        }
				

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
		
		
	}

}
