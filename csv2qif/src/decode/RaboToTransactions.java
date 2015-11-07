/**
 * 
 */
package decode;

import java.io.File;

import data.Data;
import data.Transaction;

/**
 * @author anco
 *
 */
public class RaboToTransactions extends CSVToTransactions{

	public RaboToTransactions(Data data, File file) {
		super(data, file);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Transaction readFromLine(String str, int n) {
		Transaction t = new Transaction();
		String description = "";
		String comment = "";
		str = str.substring(1, str.length() - 1);
		String[] strings = str.split("(\",\")");
		t.setOwnAccount(strings[0]);
		t.setCurrency(strings[1]);

		if (strings[3].contains("D")) {
			t.setDC("-");
		}

		t.setAmount(strings[4]);

		t.setAccount(strings[5]);
		t.setName (strings[6]);
		t.setDate(strings[7]);
		t.setCode(strings[8]);

		if (strings.length > 10) {
			description = strings[10];
		}
		
		t.setDescription(description);
		
		for (int i = 11; i < strings.length; i++) {
			comment += " " + strings[i];
		}
		comment = comment.trim();
		t.setComment(comment);
		t.setCategory(rules.findCategory(t));
		return t;
	}

}
