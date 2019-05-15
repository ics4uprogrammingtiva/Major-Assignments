import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.List;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * Created by: Tiva Rait
 * Created on: 15-May-2019
 * Created for: ICS4U
 * Major Assignment #3 Search or Walk
 * This program ...
*/

public class SearchOrWalkTivaR {

	private JFrame frame;
	private JTextField txtBubbleSortUserNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchOrWalkTivaR window = new SearchOrWalkTivaR();
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
	public SearchOrWalkTivaR() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 927, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInstructions = new JLabel("Select one of the elements of this program:");
		lblInstructions.setBounds(10, 11, 414, 14);
		frame.getContentPane().add(lblInstructions);
		
		JButton btnRandomWalk = new JButton("Random Walk");
		btnRandomWalk.setBounds(10, 36, 289, 23);
		frame.getContentPane().add(btnRandomWalk);
		
		JButton btnBinarySearch = new JButton("Binary Search");
		btnBinarySearch.setBounds(306, 36, 289, 23);
		frame.getContentPane().add(btnBinarySearch);
		
		List lstUnsortedNumbers = new List();
		lstUnsortedNumbers.setBounds(621, 132, 110, 183);
		frame.getContentPane().add(lstUnsortedNumbers);
		
		JLabel lblBubbleSUnsortedList = new JLabel("Unsorted Numbers:");
		lblBubbleSUnsortedList.setBounds(621, 112, 110, 14);
		frame.getContentPane().add(lblBubbleSUnsortedList);
		
		List lstSortedNumbers = new List();
		lstSortedNumbers.setBounds(791, 132, 110, 183);
		frame.getContentPane().add(lstSortedNumbers);
		
		JLabel lblBubbleSSortedNumbers = new JLabel("Sorted Numbers:");
		lblBubbleSSortedNumbers.setBounds(791, 112, 110, 14);
		frame.getContentPane().add(lblBubbleSSortedNumbers);
		
		txtBubbleSortUserNumber = new JTextField();
		txtBubbleSortUserNumber.setBounds(815, 65, 86, 20);
		frame.getContentPane().add(txtBubbleSortUserNumber);
		txtBubbleSortUserNumber.setColumns(10);
		
		JLabel lblBubbleSortUserNumber = new JLabel("Number to search for?");
		lblBubbleSortUserNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblBubbleSortUserNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBubbleSortUserNumber.setBounds(612, 65, 193, 14);
		frame.getContentPane().add(lblBubbleSortUserNumber);
		
		JLabel lblBubbleSortAnswer = new JLabel("New label");
		lblBubbleSortAnswer.setBounds(621, 324, 280, 14);
		frame.getContentPane().add(lblBubbleSortAnswer);
		
		JButton btnBubbleSort = new JButton("Bubble Sort");
		btnBubbleSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Define variables
				int MAXVALUE = 99;
				int MINVALUE = 1;
				int RANGE = ((MAXVALUE - MINVALUE)+1);
				int numberOfValues = 10;
				
				// May take this out later 
				int userNumber;
				
				// The textBox
				userNumber = Integer.parseInt(txtBubbleSortUserNumber.getText());
				
				// Generate list for the array
				int [] unSortedNumbers = new int[numberOfValues];
				
				// Loop to get randomly generated list made
				for (int randomGenerationIndex = 0; randomGenerationIndex < numberOfValues; randomGenerationIndex++ )
				{
					int randomNumber = 0;
					
					randomNumber = (int)((Math.random()* RANGE)+ MINVALUE);
					
					lstSortedNumbers.add(Integer.toString(randomNumber));
				}
				
			}
		});
		btnBubbleSort.setBounds(612, 36, 289, 23);
		frame.getContentPane().add(btnBubbleSort);
	}
}
