package decode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import data.Data;
import data.Rule;
import data.Transaction;

public class Rules {
	ArrayList<Rule> rules = new ArrayList<Rule>();
	private Data data;
	
	public Rules() {
		readRules();
	}
	
	public ArrayList<Rule> getRules(){
		return rules;
	}
	
	private void readRules() {
		readRules("rules.rules");
		System.out.println(rules.size());
	}
	
	private void readRules(String filename) {
		Reader inStream;
		BufferedReader input;
		String inLine;
		
		try{
			File f = new File(filename);
			
			// check if file is present
			if(!f.exists() || f.isDirectory() ) {
				System.out.println("No rules file found");
				return;
			}
			
			inStream = new FileReader(filename);
			input = new BufferedReader(inStream);
			while((inLine = input.readLine()) != null && !inLine.isEmpty()){
				Rule r = new Rule(inLine);
				rules.add(r);
			}
	//		System.out.println(getData().getTransactions().a)
		}
		catch(IOException e){
			System.err.println("error");
			e.printStackTrace();
		}		
	}

	public Rules(Data data) {
		this();
		this.data = data;
	}
	
	
	public String findCategory(Transaction t){
		String str = t.getName()+t.getAccount()+t.getDescription()+t.getDC()+t.getAccount()+t.getComment()+t.getCode();
		for(Rule r : rules){
			if (str.toLowerCase().contains(r.getTest().toLowerCase())){
				return r.getCategory();
			}
		}
		
		return "";
	}

}
