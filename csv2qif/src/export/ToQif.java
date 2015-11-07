/**
 * 
 */
package export;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

import data.Data;
import data.Transaction;

/**
 * @author anco
 *
 */
public class ToQif extends Export{

	private Data data;

	/**
	 * 
	 */
	public ToQif() {
		// TODO Auto-generated constructor stub
	}
	
	public ToQif(Data data, File file) {
		super(data, file);
	}
	
	public void save(String filename) {
		BufferedWriter w = null;
		try {
			w = new BufferedWriter(new FileWriter(filename));
			w.write("!Type:Bank\n");
			for (Transaction t : data.getTransactions()) {
				w.write(toQif(t));
				w.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (w != null) {
			try {
				w.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String toQif(Transaction t) {
		String str = "";
		String memo = "";
		str += "D" + t.getDate() + "\n";
		str += "T" + t.getDC() + t.getAmount() + "\n";
		str += "P";
		if (!t.getAccount().isEmpty()) {
			str += t.getAccount() + " ";
		}
		if (!t.getName().isEmpty()) {
			str += t.getName();
			memo += t.getDescription() + " ";
		} else {
			str += t.getDescription();
		}
		str += "\n";
		memo += t.getComment();
		memo = memo.trim();
		if (!memo.isEmpty()) {
			str += "M" + memo + "\n";
		}
		str += "N" + t.getCode() + "\n";
		if (t.getCategory()!= null && !t.getCategory().isEmpty()) {
			str += "L" + t.getCategory() + "\n";
		}
		str += "^";

		return str;

	}

}
