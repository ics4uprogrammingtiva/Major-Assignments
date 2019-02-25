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
			boolean inputFromFile = false;
			
			// Blowup String Variables
			int originalLength = 0;
			int newLength = 0;
			
			// IntMaxRun Variables
	        

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
		
		JRadioButton radInputFromFile = new JRadioButton("Get Input From Text File");
		radInputFromFile.setBounds(20, 43, 153, 23);
		frame.getContentPane().add(radInputFromFile);
		
		JRadioButton radInputFromBox = new JRadioButton("Get Input From Text Box");
		radInputFromBox.setBounds(20, 81, 153, 23);
		frame.getContentPane().add(radInputFromBox);
		
		JLabel lblError = new JLabel("New label");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(10, 236, 414, 14);
		frame.getContentPane().add(lblError);
		
		txtInputFromBox = new JTextField();
		txtInputFromBox.setBounds(179, 82, 86, 20);
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
				
				// Variables
				String originalLength = "";
				boolean lastCharWasNumber = false;
				int lastNumber = 0;
				int index = 0;
				char nextChar = 'a';
				
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
			        String inputFile = "input.txt";
	
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
			            }   
	
			            // Always close files.
			            bufferedReader.close(); 
			            inputString = line;
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
					txtInputFromBox.setVisible(true);
					txtInputFromBox.setEnabled(true);
					
					// Use a try catch in case the box is empty
					
					String inputString = txtInputFromBox.getText();
						
				}
				
				
				// If the input string has any special characters...
				//... Tell user there was an error
				
				// Loop to get the answer
				
				
				
				
				// Show all of the labels that need showing
				lblAnswer.setVisible(true);
				lblOriginalLength.setVisible(true);
				lblNewLength.setVisible(true);
			}
		});
		btnBlowupString.setBounds(41, 141, 103, 23);
		frame.getContentPane().add(btnBlowupString);
		
		// I removed this next line so that it could be created...
		//... and referenced in an earlier area
		//JButton btnIntMaxRun = new JButton("Int MaxRun");
		btnIntMaxRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnIntMaxRun.setBounds(41, 204, 103, 23);
		frame.getContentPane().add(btnIntMaxRun);
		
		// !!!!!!
		// Show the answer and print output
		
		
		// Name of file I am creating
		String outputFile = "output.txt";
		
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
