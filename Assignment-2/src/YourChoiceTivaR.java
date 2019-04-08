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
 * Major Assignment – 2 Your Choice
 * This program is three problems in one
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
				
				int Numcases = 10;
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
					Answers[i] = ("Days project was delayed: " + daysDelayed + ", Total days of work: " +
					totalDaysOfWork + ", Num of boxes collected: " + boxesCollected);
					
					
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
				
				//Students mark
				double testMark;
				double assignmentMark;
				double projectMark;
				double quizMark;
				
				
				// Outputs
				int numStudentsPassing;
				double highestClassMark;
				double lowestClassMark;
				double classAverage;
				int numOfHonourStudents;
				
				// Variables to help with solving the problem
				// Number of datasets we have
				int Numcases = 10;
				// Input I get
				int numStudents;
				// For figuring out what is the current line overall
				int currentLine;
				// For figuring out which line is where we get our weights from
				int lineCounter = -1;
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
		        	lineCounter = (lineCounter +1);
		        	String [] firstLine = Input.get(lineCounter).split(" ");
					testWeight = Integer.parseInt(firstLine[0]);
					assignmentWeight = Integer.parseInt(firstLine[1]);
					projectWeight = Integer.parseInt(firstLine[2]);
					quizWeight = Integer.parseInt(firstLine[3]);

					//To get number of students
					// Problem is here!!!!!!!!
					lineCounter = (lineCounter + 1);
					numStudents = Integer.parseInt(Input.get(lineCounter));
					
					// Set all of the outputs back to their original numbers so they don't get mixed up
					numStudentsPassing = 0;
					highestClassMark = 0;
					lowestClassMark = 101;
					classAverage = 0;
					numOfHonourStudents = 0;
					// To cycle through each dataset
					for (currentStudent = 1; currentStudent <= numStudents; currentStudent++)
					{
						individAverage = 0;
						// Continue from here
						lineCounter = (lineCounter + 1);
						
						String [] StudentMarks = Input.get(lineCounter).split(" ");
						testMark = Double.parseDouble(StudentMarks[0]);
						assignmentMark = Double.parseDouble(StudentMarks[1]);
						projectMark = Double.parseDouble(StudentMarks[2]);
						quizMark = Double.parseDouble(StudentMarks[3]);
						System.out.println(" Line counter :" + lineCounter);
						
						// Calculate the individual average
						individAverage = (individAverage + (testMark * (testWeight/100)));
						individAverage = (individAverage + (assignmentMark * (assignmentWeight/100)));
						individAverage = (individAverage + (projectMark * (projectWeight/100)));
						individAverage = (individAverage + (quizMark * (quizWeight/100)));
						
						// To determine the outputs I added
						if (individAverage < lowestClassMark)
						{
							lowestClassMark = individAverage;
						}
						
						if (individAverage > highestClassMark)
						{
							highestClassMark = individAverage;
						}
						
						if (individAverage >= 50)
						{
							numStudentsPassing = (numStudentsPassing + 1);
							
						}
						
						if (individAverage >= 80)
						{
							numOfHonourStudents = (numOfHonourStudents + 1);
						}
						
						classAverage = classAverage + individAverage;
					}
					
					classAverage = (classAverage/numStudents);
					
					Answers[i] = ("Number of Students Passing: " + numStudentsPassing + ", Class Average: " + classAverage +
							", Highest Mark: " + highestClassMark + ", Lowest Mark: " + lowestClassMark +
							", Number of Honour Roll Students: " + numOfHonourStudents);
					
		        }
				
				// Step four
				//Output
		        
		        // Output to txt file 
				
		        String OutputfileName = "OutputPassOrFail.txt";

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
		        }
			}
		});
		btnPassOrFail.setBounds(229, 74, 195, 23);
		frame.getContentPane().add(btnPassOrFail);
		
		JButton btnMartianTime = new JButton("Martian Time");
		btnMartianTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Step One
				// Variables
				double SECONDSEARTHDAY = 86400;
				double SECONDSMARSDAY = 88642.663;
				double RATIOOFEARTHTOMARS = (SECONDSEARTHDAY/SECONDSMARSDAY);
				System.out.println("Ratio of earth to Mars " + RATIOOFEARTHTOMARS);
				
				// Earth variables
				double earthDays = 0;
				double earthHours = 0;
				double earthMinutes = 0;
				double earthSeconds = 0;
				
				double totalEarthSeconds = 0;
				
				// Mars Variables
				int marsDays = 0;
				int marsHours = 0;
				int marsMinutes = 0;
				int marsSeconds = 0;
				
				double updatedDays = 0;
				double updatedHours = 0;
				double updatedMinutes = 0;
				double updatedSeconds = 0;
				
				double totalMarsDays = 0;
				double totalMarsHours = 0;
				double totalMarsMinutes = 0;
				double totalMarsSeconds = 0;
				
				
				// Variables to help me solve the problem
				// To know how many things in the dataset 
				int Numcases = 10;
				// Keep track of current line
				int lineCounter = 0;
				
				// Arrays
				// Array containing the whole dataset
				ArrayList <String> Input = new ArrayList <String>();
				
				// Array for just the answers to output
				String Answers[]= new String [Numcases];
				
				//! Step Two
				//get Input
				
				// The name of the file to open.
		        String InputfileName = "InputMartianTime.txt";

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
		        
				// Step Three 
				// Calculations
		        for(int i = 0; i < Numcases; i++)
		        {
		        	// Put all of the input into its own variable
		        	String [] currentLine = Input.get(lineCounter).split(" ");
		        	earthDays = Double.parseDouble(currentLine[0]);
		        	earthHours = Double.parseDouble(currentLine[1]);
		        	earthMinutes = Double.parseDouble(currentLine[2]);
		        	
		        	// Convert earth times to seconds
		        	earthDays = (earthDays - 1);
		        	System.out.println("Earth days " + updatedDays);
		        	updatedHours = ((earthDays * 24)+ earthHours);
		        	updatedMinutes = ((updatedHours*60)+ earthMinutes);
		        	updatedSeconds = (updatedMinutes*60);
		        	
		        	// Convert it to mars times
		        	totalMarsSeconds = (updatedSeconds * RATIOOFEARTHTOMARS);
		        	System.out.println("Total marsSeconds" +totalMarsSeconds);
		        	totalMarsMinutes = (totalMarsSeconds/60);
		        	System.out.println("totalMarsMinutes " + totalMarsMinutes);
		        	totalMarsHours = Math.floor(totalMarsMinutes/60);
		        	totalMarsDays = Math.floor(totalMarsHours/24);
		        	
		        	// Figure out how much of everything there is
		        	marsDays = (int)(totalMarsDays +1);
		        	
		        	marsHours = (int)(totalMarsHours%24);
		        	marsMinutes = (int) (totalMarsMinutes%60);
		        	
		        	// Put answer into the Answer Array
		        	Answers [i] = ("Day " + marsDays + ", " + marsHours + ":" + marsMinutes);
		        	
		        	lineCounter = lineCounter +1;
		        }
				// Step four
				// Output 
		        
		        // Output to txt file 
				
		        String OutputfileName = "OutputMartianTime.txt";

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
		        }
			}
		});
		btnMartianTime.setBounds(118, 124, 195, 23);
		frame.getContentPane().add(btnMartianTime);
		
		
	}

}
