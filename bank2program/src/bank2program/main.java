/**
 * 
 */
package bank2program;

import java.io.File;

import Gui.ProgramFrame;

import data.Data;
import decode.DetectBank;
import decode.RaboToTransactions;
import export.ToCSV;
import export.ToCSVHomebank;
import export.ToQif;

/**
 * @author anco
 *
 */
public class main {
	static Data data;
	/**
	 * 
	 */
	public main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();
		
	}

	private static void run() {
		data = new Data();
		System.out.println(data);
		String file = "/home/anco/Downloads/transactions(4).txt";
		String output = "/home/anco/Downloads/test.txt";
		File f = new File(file);
		File out = new File(output);
		System.out.println("running");
		new ProgramFrame(data);
		 
		//String bank = DetectBank.getBank(file);
		//if(bank == "RABO"){
		//	new RaboToTransactions(data, f);
	////	}
		//new ToQif(data, out);
		
	}

}
