import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGraphicalInterface {

	JFrame frame;
	private JTextField inputField;
	private JTextField outputField;
	private JTextField keyField;

	
	/**
	 * Create the application.
	 */
	public MainGraphicalInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		JFileChooser dirSelect = new JFileChooser(); 
		dirSelect.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		inputField = new JTextField();
		inputField.setBounds(12, 80, 298, 19);
		frame.getContentPane().add(inputField);
		inputField.setColumns(10);
		
		JLabel title = new JLabel("TMSENCRYPTS");
		title.setFont(new Font("Dialog", Font.BOLD, 28));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(89, 12, 258, 34);
		frame.getContentPane().add(title);
		
		JLabel lblInput = new JLabel("Input");
		lblInput.setBounds(12, 59, 70, 15);
		frame.getContentPane().add(lblInput);
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setBounds(12, 111, 70, 15);
		frame.getContentPane().add(lblOutput);
		
		outputField = new JTextField();
		outputField.setColumns(10);
		outputField.setBounds(12, 128, 298, 19);
		frame.getContentPane().add(outputField);
		
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TMSencryptS.decrypt(inputField.getText(), outputField.getText(), Long.parseLong(keyField.getText()));
			}
		});
		btnDecrypt.setBounds(321, 226, 117, 25);
		frame.getContentPane().add(btnDecrypt);
		
		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TMSencryptS.encrypt(inputField.getText(), outputField.getText(), Long.parseLong(keyField.getText()));
			}
		});
		btnEncrypt.setBounds(198, 226, 117, 25);
		frame.getContentPane().add(btnEncrypt);
		
		JButton btnSelectInput = new JButton("Select");
		btnSelectInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dirSelect.setEnabled(true);
				dirSelect.setVisible(true);
				dirSelect.showOpenDialog(dirSelect);
				inputField.setText(dirSelect.getSelectedFile().toString());
			}
		});
		btnSelectInput.setBounds(321, 77, 117, 25);
		frame.getContentPane().add(btnSelectInput);
		
		JButton btnSelectOutput = new JButton("Select");
		btnSelectOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dirSelect.setEnabled(true);
				dirSelect.setVisible(true);
				dirSelect.showOpenDialog(dirSelect);
				outputField.setText(dirSelect.getSelectedFile().toString());
			}
		});
		btnSelectOutput.setBounds(322, 125, 117, 25);
		frame.getContentPane().add(btnSelectOutput);
		
		JLabel lblKey = new JLabel("Key (16 digits)");
		lblKey.setBounds(12, 159, 132, 15);
		frame.getContentPane().add(lblKey);
		
		keyField = new JTextField();
		keyField.setFont(new Font("Liberation Sans", Font.PLAIN, 24));
		keyField.setColumns(10);
		keyField.setBounds(12, 178, 426, 36);
		frame.getContentPane().add(keyField);
	}
}
