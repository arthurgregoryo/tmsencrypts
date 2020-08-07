import java.awt.EventQueue;

/*
 * Author: Arthur Gregoryo (gregoryo/arthurgregoryo)
 * Version: 0.1
 * Not recommended for commercial use.
 * 
 */

public class MainCommandOnly {

	public static void main(String[] args) {
		if (args.length == 0)
			mainGraphicalInterfaceCall();
		else {
			mainCommandOnly(args);
		}
	}
	
	public static void mainCommandOnly(String[] args) {
		/*
		 * args[0] first argument args[1] key args[2] input args[3] output
		 */
		
		switch (args[0]) {
		case "--encrypt":
			if(TMSToolS.validKeyCommandLineInterface(Long.parseLong(args[1])))
				TMSencryptS.encrypt(args[2], args[3], Long.parseLong(args[1]));
			break;
		case "--decrypt":
			if(TMSToolS.validKeyCommandLineInterface(Long.parseLong(args[1])))
				TMSencryptS.decrypt(args[2], args[3], Long.parseLong(args[1]));
			break;
		case "--help":
			System.out.println("command type key /input /output" + "\n\n" + "Your keys can have 16 digits." + "\n\n"
					+ "Help:" + "\n" + "--encrypt: encrypts your file to the desired output from an inserted key."
					+ "\n" + "--decrypt: decrypts your file to the desired output from an inserted key." + "\n");
			break;
		}
	}

	public static void mainGraphicalInterfaceCall() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGraphicalInterface window = new MainGraphicalInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
