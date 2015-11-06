import program.Program;
import Gui.ProgramFrame;

/**
 * 
 */

/**
 * @author anco
 * 
 */
public class main {

	/**
	 * 
	 */
	public main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Qif file = new Qif();
		ProgramFrame f = new ProgramFrame(new Program());
		file.loadSVN("input.txt");
		// file.save("output.qif");
		file.saveCSV("output.csv");

	}

}
