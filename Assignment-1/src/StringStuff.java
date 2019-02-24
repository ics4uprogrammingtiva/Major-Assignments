import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class StringStuff {

	private JFrame frame;

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
		
		JRadioButton radInputFromFile = new JRadioButton("Get Input From Text File");
		radInputFromFile.setBounds(20, 43, 153, 23);
		frame.getContentPane().add(radInputFromFile);
		
		JRadioButton radInputFromBox = new JRadioButton("Get Input From Text Box");
		radInputFromBox.setBounds(20, 81, 153, 23);
		frame.getContentPane().add(radInputFromBox);
		
		JButton btnBlowupString = new JButton("Blowup String");
		btnBlowupString.setBounds(41, 141, 103, 23);
		frame.getContentPane().add(btnBlowupString);
		
		JButton btnIntMaxRun = new JButton("Int MaxRun");
		btnIntMaxRun.setBounds(41, 204, 103, 23);
		frame.getContentPane().add(btnIntMaxRun);
		
		JLabel lblAnswer = new JLabel("Output: ");
		lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswer.setBounds(271, 47, 153, 14);
		frame.getContentPane().add(lblAnswer);
		
		JLabel lblOriginalLength = new JLabel("Original Length: ");
		lblOriginalLength.setBounds(286, 129, 138, 14);
		frame.getContentPane().add(lblOriginalLength);
		
		JLabel lblNewLength = new JLabel("New Length: ");
		lblNewLength.setBounds(286, 153, 138, 14);
		frame.getContentPane().add(lblNewLength);
		
		JLabel lblCharOfLongestRun = new JLabel("Characters with the longest run: ");
		lblCharOfLongestRun.setEnabled(false);
		lblCharOfLongestRun.setBounds(231, 208, 193, 14);
		frame.getContentPane().add(lblCharOfLongestRun);
	}
}
