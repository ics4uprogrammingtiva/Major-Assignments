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
 * This program is three programs in one
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
				
				// To figure out which is the current line we are on
				int currentLine = 0;
				
				// Did she get a box or not?
				char cameHomeWith;
				
				int Numcases = 3;
				int lineCounter = 0;
				boolean hasBox = false;
				
				ArrayList <String> Input = new ArrayList <String>();
				
				// Put all the answers for each dataset into an array
				String Answers[]= new String [Numcases];
				
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
		        	// To tell what line
		        	currentLine = currentLine +1;

		        	String [] firstLine = Input.get(lineCounter).split(" ");
					daysCatPlays = Integer.parseInt(firstLine[0]);
					daysCollectingBoxes = Integer.parseInt(firstLine[1]);
					
					// To reset things from previous datasets
					totalDaysOfWork = 0;
					boxesCollected = 0;
					currentDay = 0;
					hasBox = false;
					
					// Possible place for logical error
					for (currentDay = 1; currentDay <= daysCollectingBoxes; currentDay++)
					{
						
						//////////////
						// Continue from here
						cameHomeWith = Input.get(currentLine).charAt(0);
						System.out.println("cameHomeWith " + cameHomeWith);
						
						// Do the complicated problem solving things
						if (cameHomeWith == 'B') 
						{
							if (hasBox == true)
							{
								daysDelayed = (daysDelayed -1);
								
								daysDelayed = (daysDelayed+ daysCatPlays);
							}
							else
							{
								daysDelayed = (daysDelayed + daysCatPlays);
								daysDelayed = (daysDelayed - 1);
							}
							boxesCollected = (boxesCollected + 1);
							hasBox = true;
							
						}
						else
						{
							if (hasBox == true)
							{
								daysDelayed = (daysDelayed - 1);
								if (daysDelayed <= 0)
								{
									daysDelayed = 0;
									hasBox = false;
									
								}
							}
							
							if (hasBox == false)
							{
								
								if (daysDelayed <= 0)
								{
									daysDelayed = 0;
									hasBox = false;
									
								}
							}
							
						}
						
						// To keep track of which line is the current day
						currentLine = (currentLine +1);
						
						totalDaysOfWork = (totalDaysOfWork + 1);
						// Testing purposes
						System.out.println("daysDelayed " + daysDelayed);
						// Testing purposes
						System.out.println("totaldaysOfWork " + totalDaysOfWork);
						System.out.println("boxes Collected " + boxesCollected);
					}
					
					
					totalDaysOfWork = (totalDaysOfWork + daysDelayed);
					
					
					// To set them  to the proper date due to array differences
					//daysDelayed = (daysDelayed -1);
					//totalDaysOfWork = (totalDaysOfWork - 1);
					
					if (daysDelayed <= 0)
					{
						daysDelayed = 0;
					}
					
					// Put answers into an array
					Answers[i] = (daysDelayed + " " + totalDaysOfWork + " " + boxesCollected);
					
					
					//at very end
					//increment linecounter
					lineCounter = lineCounter + 1 + daysCollectingBoxes; 
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
		            for (int printAnswerTimes = 0; printAnswerTimes <= Numcases - 1; printAnswerTimes++)
		            {
		            	bufferedWriter.newLine();
			            bufferedWriter.write(Answers[printAnswerTimes]);
		            }
		            

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
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		JButton btnPassOrFail = new JButton("Pass or Fail");
		btnPassOrFail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Step one 
				// Set up Variables
				// Weights
				double testWeight;
				double assignmentWeight;
				double projectWeight;
				double quizWeight;
				
				
				// Outputs
				int numStudentsPassing;
				double highestClassMark;
				double lowestClassMark;
				double classAverage;
				int numOfHonourStudents;
				
				// Variables to help with solving the problem
				// Number of datasets we have
				int Numcases = 1;
				// Input I get
				int numStudents;
				// For figuring out what is the current line overall
				int currentLine;
				// For figuring out which line is where we get our weights from
				int lineCounter = 0;
				//For figuring out which student we are currently evaluating
				int currentStudent;
				// To figure out what the students average is 
				double individAverage;
				
				// Array containing the whole dataset
				ArrayList <String> Input = new ArrayList <String>();
				
				// Array for just the answers to output
				String Answers[]= new String [Numcases];
				
				////// Step two 
				// Get Input
				
				// The name of the file to open.
		        String InputfileName = "InputPassOrFail.txt";

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
				
				// Step three 
				//Calculations
		        // Start looping though data sets
		        for(int i = 0; i < Numcases; i++)
		        {
		        	String [] firstLine = Input.get(lineCounter).split(" ");
					testWeight = Integer.parseInt(firstLine[0]);
					assignmentWeight = Integer.parseInt(firstLine[1]);
					projectWeight = Integer.parseInt(firstLine[2]);
					quizWeight = Integer.parseInt(firstLine[3]);
					
					//To get number of students
					lineCounter = (lineCounter + 1);
					numStudents = Integer.parseInt(Input.get(lineCounter));
					
					// Set all of the outputs back to their original numbers so they don't get mixed up
					for (currentStudent = 1; currentStudent <= numStudents; currentStudent++)
					{
						individAverage = 0;
						// Continue from here
						
						String [] firstLine = Input.get(lineCounter).split(" ");
						
					}
					
		        }
				
				// Step four
				//Output
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
