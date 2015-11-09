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
public class ToCSVHomebank extends Export {

	/**
	 * 
	 */
	public ToCSVHomebank() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param data
	 * @param file
	 */
	public ToCSVHomebank(Data data, File file) {
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
		//	w.write("date;paymode;info;payee;wording;amount;category;tags");
			//w.newLine();
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
		/*
		 *  date 	format must be DD-MM-YY
			paymode 	from 0=none to 10=FI fee
			info 	a string
			payee 	a payee name
			memo 	a string
			amount 	a number with a '.' or ',' as decimal separator, ex: -24.12 or 36,75
			category 	a full category name (category, or category:subcategory)
			tags 	tags separated by space
			tag is mandatory since v4.5
			
			//pay mode
			 * 0 = None
1 = Credit Card
2 = Check
3 = Cash
4 = Transfer
5 = Internal Transfer
6 = Debit Card
7 = Standing Order
8 = Electronic Payment
9 = Deposit
10 = FI Fee
		 * 
		 */
		// TODO change order
		String str = "";
		String n = "";
		String memo = "";
	
		

		memo += t.getComment();
		System.out.println(n);
		str += concat(";", toHomeBankDate(t.getDate()), "0", t.getComment() , 
				t.getName_description(), "",t.getDC()+t.getAmount(), t.getCategory(), t.getCode());
		str += "";

		return str;

	}

	private String toHomeBankDate(String date) {
		String year = date.substring(2, 4);
		String month = date.substring(4, 6);
		String day = date.substring(6, 8);
		
		return day + "-" + month + "-" + year; 
	}


}
