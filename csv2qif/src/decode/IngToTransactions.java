package decode;

import java.io.File;

import data.Data;
import data.Transaction;

public class IngToTransactions extends CSVToTransactions {

	public IngToTransactions(Data data, File file) {
		super(data, file);
	}


	@Override
	public Transaction readFromLine(String str, int n) {
		
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
		Transaction t = new Transaction();
		str = str.substring(1, str.length() - 1);
		String[] strings = str.split("(\",\")");
	
		t.setDate(strings[0]);
		t.setName (strings[1]);
		t.setOwnAccount(strings[2]);
		t.setAccount(strings[3]);
		t.setCode(strings[4]);
		
		if (strings[5].contains("A")) {
			t.setDC("-");
		}

		t.setAmount(strings[6]);
		t.setCurrency("euro");		
		t.setDescription(strings[8]);
		
		t.setComment("");
		t.setCategory(getCategory());
		return t;
	}

}
