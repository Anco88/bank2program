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
		System.out.println("RABO contructor");
		// TODO Auto-generated constructor stub
	}


	@Override
	Transaction readFromLine(String str, int number) {
		String DC  = "";
		String amount;
		String date;
		String currency;
		String name_description;
		String comment="";
		String category;
		String ownAccount;
		String account;
		String code;
		
		str = str.substring(1, str.length() - 1);
		String[] strings = str.split("(\",\")");
		
		ownAccount = strings[0];
		currency = strings[1];
		
		if (strings[3].contains("D")) {
			DC = "-";
		}
		
		
		
		amount = strings[4];

		account = strings[5];
	    name_description = strings[6];
		date = strings[7];
		code =  getCode(strings[8]);
		if(strings.length > 10){
			if (name_description.isEmpty()) {
				name_description = strings[10];
			} else{
				comment = strings[10]+ " ";
			}
		}
		for (int i = 11; i < strings.length; i++) {
			comment += strings[i];
		}
		comment = comment.trim();
		Transaction t = new Transaction(DC, amount, date, currency, name_description, comment, 
				"", ownAccount, account, code);
		
		t.setCategory(data.getRules().findCategory(t));
		
		return t;
	}
	
	private String getCode(String code){
		/* ac 	acceptgiro
		ba 	betaalautomaat
		bg 	bankgiro opdracht
		cb 	crediteurenbetaling
		ck 	Chipknip
		db 	diverse boekingen
		ei 	euro-incasso
		ga 	geldautomaat Euro
		gb 	geldautomaat VV
		id 	iDEAL
		kh 	kashandeling
		ma 	machtiging
		nb 	NotaBox
		sb 	salaris betaling
		sp 	spoedopdracht
		tb 	eigen rekening
		tg 	telegiro
		CR 	tegoed
		D 	tekort
		*/
		switch(code){
		case "ba" : return "betaalautomaat";
		case "bg" : return "bankgiro opdracht";
		case "cb" : return "crediteurenbetaling";
		case "ck" : return "chipknip";
		case "db" : return "diverse boekingen";
		case "ei" : return "euro incasso";
		case "ga" : return "geldautomaat Euro";
		case "gb" : return "geldautomaat VV";
		case "id" : return "iDeal";
		case "kh" : return "kasbehandeling";
		case "ma" : return "machtiging";
		case "nb" : return "notabox";
		case "sb" : return "salaris betaling";
		case "sp" : return "spoedopdracht";
		case "tb" : return "eigen rekening";
		case "tg" : return "telegiro";
		case "CR" : return "tegoed";
		case "D"  : return "tekort";
		}
		
		return "";
	}

}
