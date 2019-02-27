import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

// Added this to help read text files
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
 * Created by: Tiva Rait
 * Created on: 24-Feb-2019
 * Created for: ICS4U
 * Major Assignment – Assignment #1 String Stuff
 * This program ...
*/

public class StringStuff {
	
	// Global Variables
			// General variables
			String answerString = "";
			String inputString = "";
			char nextChar;
			boolean inputFromFile;
			int originalLength = 0;
			
			// Blowup String Variables
			int newLength = 0;
			
	        

	private JFrame frame;
	private JTextField txtInputFromBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StringStuff window = new StringStuff();
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
	public StringStuff() {
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
		
		JLabel lblTitle = new JLabel("String Stuff");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(10, 11, 414, 25);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblCharOfLongestRun = new JLabel("Characters with the longest run: ");
		lblCharOfLongestRun.setEnabled(false);
		lblCharOfLongestRun.setBounds(231, 208, 193, 14);
		frame.getContentPane().add(lblCharOfLongestRun);
		// Just in case I don't use it
		lblCharOfLongestRun.setVisible(false);
		
		JLabel lblNewLength = new JLabel("New Length: ");
		lblNewLength.setBounds(286, 145, 138, 14);
		frame.getContentPane().add(lblNewLength);
		
		JLabel lblOriginalLength = new JLabel("Original Length: ");
		lblOriginalLength.setBounds(286, 129, 138, 14);
		frame.getContentPane().add(lblOriginalLength);
		
		JLabel lblAnswer = new JLabel("Output: ");
		lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswer.setBounds(231, 47, 193, 14);
		frame.getContentPane().add(lblAnswer);
		
		// I created this above where the rest of its code is because it needs to be referencd
		JRadioButton radInputFromBox = new JRadioButton("Get Input From Text Box");
		
		JRadioButton radInputFromFile = new JRadioButton("Get Input From Text File");
		radInputFromFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// When it is selected set it to be selected
				radInputFromFile.setSelected(true);
				
				// Set other rad button to not be selected 
				radInputFromBox.setSelected(false);
				// Set input from file to be true or false
				inputFromFile = true;
				
				// Hide the text box if it was enabled 
				txtInputFromBox.setEnabled(false);
				txtInputFromBox.setVisible(false);
			}
		});
		radInputFromFile.setBounds(20, 43, 193, 23);
		frame.getContentPane().add(radInputFromFile);
		
		// I referenced this and created it above radInputFromFile
		//JRadioButton radInputFromBox = new JRadioButton("Get Input From Text Box");
		radInputFromBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// When it is selected set it to be selected
				radInputFromBox.setSelected(true);
				
				// Set other rad button to not be selected 
				radInputFromFile.setSelected(false);
				// Set input from file to be true or false
				inputFromFile = false;
				
				// Show the textBox So that user may enter something in it
				txtInputFromBox.setEnabled(true);
				txtInputFromBox.setVisible(true);
			}
		});
		radInputFromBox.setBounds(20, 81, 175, 23);
		frame.getContentPane().add(radInputFromBox);

		
		JLabel lblError = new JLabel("New label");
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(10, 233, 414, 17);
		frame.getContentPane().add(lblError);
		
		txtInputFromBox = new JTextField();
		txtInputFromBox.setBounds(201, 82, 86, 20);
		frame.getContentPane().add(txtInputFromBox);
		txtInputFromBox.setColumns(10);
		txtInputFromBox.setVisible(false);
		
		//!!!!!
		// Hide all of the labels that have to do with the output
		lblAnswer.setVisible(false);
		lblOriginalLength.setVisible(false);
		lblNewLength.setVisible(false);
		lblError.setVisible(false);
		
		// I added this next line so that it could be created...
		// ...here and referenced in blowup String
		JButton btnIntMaxRun = new JButton("Int MaxRun");
		
		JButton btnBlowupString = new JButton("Blowup String");
		btnBlowupString.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// !!!!!
				// Do the Blowup String things
				
				// Local Variables
				int originalLength;
				int newLength;
				boolean lastCharWasNumber = false;
				int lastNumber = 0;
				int numOfTimesShouldPrint;
				
				// Disable Everything
				btnIntMaxRun.setEnabled(false);
				btnBlowupString.setEnabled(false);
				radInputFromBox.setEnabled(false);
				radInputFromFile.setEnabled(false);
				txtInputFromBox.setEnabled(false);
				
				//If then statement to determine where to get input from
				
				if (inputFromFile == true)
				{
					// The name of the file to open.
			        String inputFile = "inputBlowup.txt";
	
			        // This will reference one line at a time
			        String line = null;
	
			        try {
			            // FileReader reads text files in the default encoding.
			            FileReader fileReader = 
			                new FileReader(inputFile);
	
			            // Always wrap FileReader in BufferedReader.
			            BufferedReader bufferedReader = 
			                new BufferedReader(fileReader);
	
			            while((line = bufferedReader.readLine()) != null) {
			                System.out.println(line);
			                inputString = line;
			            }   
	
			            // Always close files.
			            bufferedReader.close(); 
			            
			        }
			        catch(FileNotFoundException ex) {
			            System.out.println(
			                "Unable to open file '" + 
			                inputFile + "'");                
			        }
			        catch(IOException ex) {
			            System.out.println(
			                "Error reading file '" 
			                + inputFile + "'");                  
			        }
				}
				else
				{
					txtInputFromBox.setEnabled(false);
					txtInputFromBox.setVisible(true);
					inputString = txtInputFromBox.getText();
				}
					
					/*// If user didn't enter anything into the text field
					if (txtInputFromBox.getText().isEmpty())
					{
						lblError.setVisible(true);
						lblError.setText("You did not enter anything into the text box please"
								+ " restart program and enter a valid input");
					}
					else
					{
					*/

						char[] chars = inputString.toCharArray();
						
						originalLength = (chars.length);
						System.out.println("This is the length: " + originalLength);
						
						// Loop to get the answer
						for (int i = 0; i < originalLength; i++ )
						{
							// Read the first char in the array 
							nextChar = inputString.charAt(i);
							
							// If the input string has any special characters...
							//... Tell user there was an error
							if (!Character.isLetterOrDigit(nextChar))
							{
								lblError.setVisible(true);
								lblError.setText("Sorry please restart program and enter valid input");
								// And stop the program where it is
								i = originalLength;
								answerString = "Error";
								
								
							}
							
							// TIME FOR THE REALLY COMPLICATED STUFF
							// Was the last character a number
							if (lastCharWasNumber == true)
							{
								
								//Convert the number from last time to an int
								numOfTimesShouldPrint = Character.getNumericValue(lastNumber);
								
								//// !! Loop to print nextChar the needed number of times
								// Use the converted number
								for (int t = 0; t < numOfTimesShouldPrint +1; t++ )
								{
									answerString = (answerString + nextChar);
								}
								
								// Turn off the last char was number thing
								lastCharWasNumber = false;
								
								// Figure out if current char is a number
								if (Character.isDigit(nextChar))
								{
									//Make last number equal to nextChar
									lastNumber = nextChar;
									
									//Set it to be true
									lastCharWasNumber = true;
								}
								
							}
							else 
							{
								if (Character.isDigit(nextChar))
								{
									// Is the number zero because then that wouldn't really effect anything 
									if (nextChar == 0)
									{
										lastCharWasNumber = false;
									}
									else
									{
										lastNumber = nextChar;
										lastCharWasNumber = true;
									}
									
								}
								else
								{
									answerString = (answerString + nextChar);
									lastCharWasNumber = false;
								}
							}
						//}
						
						// Get the new length and set labels to show both old and new length
						newLength = answerString.length();
						
						lblOriginalLength.setText("Original Length: " + originalLength);
						lblNewLength.setText("New Length: " + newLength);
						
						
						// Show all of the labels that need showing
						lblAnswer.setVisible(true);
						lblOriginalLength.setVisible(true);
						lblNewLength.setVisible(true);
						
						// !!!!!!
						// Show the answer and print output
						
						
						// Name of file I am creating
						String outputFile = "outputBlowup.txt";
						
						try 
						{
							// Things to put in the output file
							String bytes = answerString;
							byte[] buffer = bytes.getBytes();
							
							FileOutputStream outputStream = 
								new FileOutputStream(outputFile);
							
							// Put the things I want into the output file
							outputStream.write(buffer);
							
							// Close the file
							outputStream.close();
							
							System.out.println("Wrote " + buffer.length + " bytes");
						}
						catch(IOException ex) {
							System.out.println(
								"Error writing file '"
								+ outputFile + "'");
							
						}
						
						// Make the answer show up as a label
						lblAnswer.setText("Output: " + answerString);
					}
					
						
				}
				
				
				

				
				
		});
		btnBlowupString.setBounds(41, 141, 138, 23);
		frame.getContentPane().add(btnBlowupString);
		
		// I removed this next line so that it could be created...
		//... and referenced in an earlier area
		//JButton btnIntMaxRun = new JButton("Int MaxRun");
		btnIntMaxRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Do Int MaxRun
				
				// Set Variables
				int longestRun = 1;
				int currentRun = 0;
				char runChar;
				
				// Disable Everything
				btnIntMaxRun.setEnabled(false);
				btnBlowupString.setEnabled(false);
				radInputFromBox.setEnabled(false);
				radInputFromFile.setEnabled(false);
				txtInputFromBox.setEnabled(false);
				
				// //If then statement to determine where to get input from
				
				if (inputFromFile == true)
				{
					// The name of the file to open.
			        String inputFile = "inputMaxRun.txt";
	
			        // This will reference one line at a time
			        String line = null;
	
			        try {
			            // FileReader reads text files in the default encoding.
			            FileReader fileReader = 
			                new FileReader(inputFile);
	
			            // Always wrap FileReader in BufferedReader.
			            BufferedReader bufferedReader = 
			                new BufferedReader(fileReader);
	
			            while((line = bufferedReader.readLine()) != null) {
			                System.out.println(line);
			                inputString = line;
			            }   
	
			            // Always close files.
			            bufferedReader.close(); 
			            
			        }
			        catch(FileNotFoundException ex) {
			            System.out.println(
			                "Unable to open file '" + 
			                inputFile + "'");                
			        }
			        catch(IOException ex) {
			            System.out.println(
			                "Error reading file '" 
			                + inputFile + "'");                  
			        }
				}
				else
				{
					txtInputFromBox.setEnabled(false);
					txtInputFromBox.setVisible(true);
					
					// Get the input from the textbox
					inputString = txtInputFromBox.getText();
				}
						char[] chars = inputString.toCharArray();
						
						originalLength = (chars.length);
						
						// Read the first char in the array 
						runChar = inputString.charAt(0);
						
						for (int i = 0; i < originalLength; i++ )
						{
							// Read the first char in the array 
							nextChar = inputString.charAt(i);
							
							// If the input string has any special characters...
							//... or numbers tell the user there was an error
							if (!Character.isLetter(nextChar))
							{
								lblError.setVisible(true);
								lblError.setText("Sorry please restart program and enter valid input");
								// And stop the program where it is
								i = originalLength;
								answerString = "Error";
								
								
							}
							
							//Determine if the current char is the same as the one that came before it
							if (nextChar == runChar)
							{
								currentRun = (currentRun +1);
								
								// If longest run is shorter than current run then make the current run the longest run
								if (longestRun < currentRun)
								{
									longestRun = (longestRun+1);
								}
								
							}
							else
							{
								runChar = nextChar;
								
								currentRun = 1;
							}
						}
						
						// Get answer 
						answerString = Integer.toString(longestRun);
						
						// Show the answer label 
						lblAnswer.setVisible(true);
						
						
						// Print it in output file
						// !!!!!!
						
						
						// Name of file I am creating
						String outputFile = "outputMaxRun.txt";
						
						try 
						{
							// Things to put in the output file
							String bytes = answerString;
							byte[] buffer = bytes.getBytes();
							
							FileOutputStream outputStream = 
								new FileOutputStream(outputFile);
							
							// Put the things I want into the output file
							outputStream.write(buffer);
							
							// Close the file
							outputStream.close();
							
							System.out.println("Wrote " + buffer.length + " bytes");
						}
						catch(IOException ex) {
							System.out.println(
								"Error writing file '"
								+ outputFile + "'");
							
						}
						
						// Show the answer in label
						// Make the answer show up as a label
						lblAnswer.setText("Output: " + answerString);
				}
			
		});
		btnIntMaxRun.setBounds(41, 204, 138, 23);
		frame.getContentPane().add(btnIntMaxRun);
		
		
		
	}
}
