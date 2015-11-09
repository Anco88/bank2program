package decode;

import java.io.File;

import data.Data;
import data.Transaction;

public class IngToTransactions extends CSVToTransactions {

	public IngToTransactions(Data data, File file) {
		super(data, file);
	}

	
	@Override
	public Transaction readFromLine(String str, int n){
		String DC  = "";
		String amount, date, currency, name_description;
		String comment="";
		String category, ownAccount, account, code;
		/* 
		 *1 "Datum",
		2"Naam / Omschrijving",
		3"Rekening",
		4"Tegenrekening",
		5"Code",
		6"Af Bij",
		7"Bedrag (EUR)",
		8"MutatieSoort",
		9"Mededelingen"
		*/
		// skip first line
	
		if(n==1){
			return null;
		}

		str = str.substring(1, str.length() - 1);
		String[] strings = str.split("(\",\")");
	
		date = strings[0];
		name_description = strings[1];
		ownAccount = strings[2];
		account = strings[3];
		code = strings[7];
		
		if (strings[5].contains("A")) {
			DC = "-";
		}

		amount = strings[6];
		currency = "euro";		
		comment  = strings[8];
		
		category = "";
		return new Transaction(DC, amount, date, currency, name_description, comment, 
				category, ownAccount, account, code);
	}

}
