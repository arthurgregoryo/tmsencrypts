import javax.swing.JOptionPane;

public class TMSToolS {

	public static boolean validKeyCommandLineInterface(long key) {
		if (key > 999999999999999l) {
			if (Long.toString(key).contains("0")) {
				System.out.println("The key must contain only digits greater than 0.");
				return false;
			} else
				return true;
		} else
			System.out.println("The key must contain 16 digits.");
			return false;
	}
	
	public static boolean validKeyGraphical(long key) {
		if (key > 999999999999999l) {
			if (Long.toString(key).contains("0")) {
				JOptionPane.showMessageDialog(null, "The key must contain only digits greater than 0.", "Invalid Key", JOptionPane.ERROR_MESSAGE);
				return false;
			} else
				return true;
		} else
			JOptionPane.showMessageDialog(null, "The key must contain 16 digits.", "Invalid Key", JOptionPane.ERROR_MESSAGE);
			return false;
	}
	
}
