package decode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import data.Data;
import data.Transaction;

public abstract class CSVToTransactions {
	private Data data;
	private File file;
	protected Rules rules;
	
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
	
	abstract Transaction readFromLine(String inLine, int number);

	CSVToTransactions(Data data, File file){
		setData(data);
		setFile(file);
		rules = new Rules();
		loadCSV(file.getAbsolutePath());
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
				Transaction t = readFromLine(inLine, number);
				if(t != null){
					getData().getTransactions().add(t);
				}
			}
	//		System.out.println(getData().getTransactions().a)
			getData().printTransactions();
			System.out.println(number);
		}
		catch(IOException e){
			System.err.println("error");
			e.printStackTrace();
		}		
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
