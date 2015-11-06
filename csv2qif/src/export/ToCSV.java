/**
 * 
 */
package export;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import data.Data;
import data.Transaction;

/**
 * @author anco
 *
 */
public class ToCSV extends Export {

	/**
	 * 
	 */
	public ToCSV() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param data
	 * @param file
	 */
	public ToCSV(Data data, File file) {
		super(data, file);
	}

	/* (non-Javadoc)
	 * @see export.Export#save(java.lang.String)
	 */
	@Override
	void save(String filename) {
		BufferedWriter w = null;
		try {
			w = new BufferedWriter(new FileWriter(filename));
			//w.write("!Type:Bank\n");
			w.write("\" date \",\" amount \",\" name \",\" memo \",\" code \",\" category\",\" subcat \"");
			
			for (Transaction t : super.data.getTransactions()) {
				w.write(toCSV(t));
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

	public String concat(String separator, String... args) {
		String str = args[0];
		for (int i = 1; i < args.length; i++) {
			str = str + separator + args[i];
		}
		return str;
	}
	
	private String toCSV(Transaction t) {
		String str = "\"";
		String n = "";
		String memo = "";
		String cat = "";
		String subcat = "";
		if (!t.getAccount().isEmpty()) {
			n = t.getAccount() + " ";
		}
		if (!t.getName().isEmpty()) {
			n += t.getName();
			memo += t.getDescription() + " ";
		} else {
			n += t.getDescription();
		}
		if (t.getCategory() != null && !t.getCategory().isEmpty()) {
			String catTemp[] = t.getCategory().split(":");
			cat = catTemp[0];
			if (catTemp.length > 1) {
				subcat = catTemp[1];
			}
		}

		memo += t.getComment();
		System.out.println(n);
		str += concat("\",\"", t.getDate(), t.getDC() + t.getAmount(), n, memo, t.getCode(),
				cat.toLowerCase(), subcat.toLowerCase());
		str += "\"";

		return str;

	}


}
