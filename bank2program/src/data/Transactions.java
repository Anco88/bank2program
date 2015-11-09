package data;

import java.util.ArrayList;

public class Transactions {
	ArrayList<Transaction> transactions;
	public Transactions() {
		transactions = new ArrayList<Transaction>();
	}

	public void add(Transaction t){
		transactions.add(t);
		System.out.println("Transaction added, size arry: " + transactions.size());
	}
	
	
	public void println(){
		for(Transaction t : transactions){
			System.out.println(t.toString());
		}
	}
}
