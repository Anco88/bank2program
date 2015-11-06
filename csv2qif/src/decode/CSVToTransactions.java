package decode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import data.Data;
import data.Transaction;

public abstract class CSVToTransactions {
	private Data data;
	
	/**
	 * @return the data
	 */
	public Data getData() {
		return data;
	}
	

	/**
	 * @param data the data to set
	 */
	public void setData(Data data) {
		this.data = data;
	}
	
	abstract void readFromLine(String inLine, Transaction t, int number);

	CSVToTransactions(Data data){
		setData(data);
	}

	public void loadCSV(String filename){
		Reader inStream;
		BufferedReader input;
		String inLine;
		int number=0;
		
		try{
			inStream = new FileReader(filename);
			input = new BufferedReader(inStream);
			while((inLine = input.readLine()) != null && !inLine.isEmpty()){
				number++;
				Transaction t = new Transaction();
				getData().getTransactions().add(t);
				readFromLine(inLine, t, number);
			}
		}
		catch(IOException e){
			System.err.println("error");
			e.printStackTrace();
		}		
	}
	
	public String getCategory(){
		return null;
	}
}
