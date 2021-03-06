package decode;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import data.Data;
import data.Transaction;
import data.Transactions;

public abstract class CSVToTransactions {
	protected ArrayList<Transaction> transactions;
	protected Data data;
	private File file;
	//protected Rules rules;
	

	abstract Transaction readFromLine(String inLine, int number);

	CSVToTransactions(Data data, File file){
		this.data = data;
		//setData(data);
		
		//setFile(file);
		//rules = new Rules();
		//loadCSV(file.getAbsolutePath());
		this.transactions = data.getTransactions();
		//System.out.println("tr = "+transactions);
		loadCSV(file.getAbsolutePath());
		//loadCSV(file);
		data.println();
		System.out.println("tr = "+transactions);
	}

	public void loadCSV(String filename){
		System.out.println("load file: "+filename);
		Reader inStream;
		BufferedReader input;
		String inLine;
		int number=0;
		
		try{
			inStream = new FileReader(filename);
			input = new BufferedReader(inStream);
			while((inLine = input.readLine()) != null && !inLine.isEmpty()){
				number++;
				Transaction t;
				t = readFromLine(inLine, number);
				if(t != null){
				//	System.out.println("add to data");
					transactions.add(t);
					//System.out.println("Size array: "+ getData().getTransactions().size());
				}
			}
	//		System.out.println(getData().getTransactions().a)
			//getData().printTransactions();
			System.out.println(number);
		}
		catch(IOException e){
			System.err.println("error");
			e.printStackTrace();
		}		
		//System.out.println("Size array: "+ ().getTransactions().size());
	}
	
	public String getCategory(){
		return null;
	}


	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}
	
	
}
