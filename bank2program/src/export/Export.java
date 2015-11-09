/**
 * 
 */
package export;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

import data.Data;

/**
 * @author anco
 *
 */
public abstract class Export {

	protected Data data;

	/**
	 * 
	 */
	public Export() {
		// TODO Auto-generated constructor stub
	}
	
	public Export(Data data, File file) {
		this.data = data;
		int overwrite = 0;
		Path path = Paths.get(file.getAbsolutePath());
		if( !Files.notExists(path)){
			Object[] options = {"Ok",
                    "Cancel"};
			overwrite = JOptionPane.showOptionDialog(null,
				    "Do you want to overwrite the file?",
				    "About to overwrite existing file", JOptionPane.OK_CANCEL_OPTION,
				    JOptionPane.WARNING_MESSAGE, null, options, options[1]);
			System.out.println("kueze: "+overwrite );
		}
		if(overwrite == 0){
			save(file.getAbsolutePath());
		}
	}
	
	abstract void save(String str);

}
