import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import data.Transaction;

/**
 * 
 */

/**
 * @author anco
 * 
 */
public class Qif {
	ArrayList<Transaction> transactions;

	/**
	 * 
	 */
	public Qif() {
		transactions = new ArrayList<Transaction>();
	}

	/**
	 * @param args
	 */
	public void loadSVN(String filename) {
		Reader inStream;
		BufferedReader input;
		String inLine;

		int numberOfTransactions = 0;

		try {
			inStream = new FileReader(filename);
			input = new BufferedReader(inStream);
			while ((inLine = input.readLine()) != null && !inLine.isEmpty()) {
				numberOfTransactions++;
				System.out.println(numberOfTransactions);
				Transaction t = new Transaction();
				transactions.add(t);
				//t.readFromLine(inLine);
			}
		} catch (IOException e) {
			System.err.println("error");
			e.printStackTrace();
		}
	}

	public void saveCSV(String filename) {
		BufferedWriter w = null;
		try {
			w = new BufferedWriter(new FileWriter(filename));
			w.write("\" date \",\" amount \",\" name \",\" memo \",\" code \",\" category\",\" subcat \"");
			w.newLine();
			for (Transaction t : transactions) {
				w.write(t.toCSV());
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

	public void save(String filename) {
		BufferedWriter w = null;
		try {
			w = new BufferedWriter(new FileWriter(filename));
			w.write("!Type:Bank\n");
			for (Transaction t : transactions) {
				w.write(t.toQif());
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

}
