import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

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
				
				int Numcases = 10;
				int lineCounter = 0;
				boolean hasBox = false;
				
				ArrayList <String> Input = new ArrayList <String>();
				
				// Important final answer 
				int daysDelayed = 0;
				
				// Get the things put into text file
				String inputString = "Fail";
				
				// Get Input from File
				// Step two
				
				// The name of the file to open.
		        String InputfileName = "InputWillowWildRide.txt";

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
		                Input.add(line);
		                
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
		        
		        // Thanks Allison for helping explain this to me
		        // Cycle through test cases
		        for(int i = 0; i < Numcases; i++) 
		        {
		        	String [] firstLine = Input.get(lineCounter).split(" ");
					daysCatPlays = Integer.parseInt(firstLine[0]);
					daysCollectingBoxes = Integer.parseInt(firstLine[1]);
					
					// Possible place for logical error
					for (currentDay = 1; currentDay <= daysCollectingBoxes; currentDay++)
					{
						//////////////
						// Continue from here
					}
						
					
					
					
					//at very end
					//increment linecounter
					lineCounter= lineCounter + 1 + daysCollectingBoxes; 
		        }
				
				
				// Output to txt file 
				
		        String OutputfileName = "OutputWillowWildRide.txt";

		        try {
		            // Assume default encoding.
		            FileWriter fileWriter =
		                new FileWriter(OutputfileName);

		            // Always wrap FileWriter in BufferedWriter.
		            BufferedWriter bufferedWriter =
		                new BufferedWriter(fileWriter);

		            // Note that write() does not automatically
		            // append a newline character.
		            bufferedWriter.write(inputString);
		            bufferedWriter.newLine();
		            bufferedWriter.write("Working?");

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
