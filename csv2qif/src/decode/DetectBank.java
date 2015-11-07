/**
 * 
 */
package decode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import data.Transaction;

/**
 * @author anco
 *
 */
public class DetectBank {

	/**
	 * 
	 */
	public DetectBank() {
		// TODO Auto-generated constructor stub
	}

	public static void getBank() {
		// TODO Auto-generated method stub
		
	}
	
	public static String getBank(String filename) {
		System.out.println("load file: "+filename);
		Reader inStream;
		BufferedReader input;
		//String inLine;
		String bank = null;
		
		try{
			inStream = new FileReader(filename);
			input = new BufferedReader(inStream);
			//while((inLine = input.readLine()) != null && !inLine.isEmpty()){
			//}
			if(input.readLine().contains("\"Datum\",\"Naam / Omschrijving\",\"Rekening\",\"Tegenrekening\",\"Code\",\"Af Bij\",\"Bedrag (EUR)\",\"MutatieSoort\",\"Mededelingen\"")){
				bank = "ING";
			}
			else{
				bank = "RABO";
			}
			inStream.close();
		}
		catch(IOException e){
			System.err.println("error");
			e.printStackTrace();
		}		

		return bank;
		
	}

}
