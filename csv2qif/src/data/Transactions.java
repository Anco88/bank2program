/**
 * 
 */
package data;

import java.util.ArrayList;

/**
 * @author anco
 *
 */
public class Transactions {
	private ArrayList<Transaction> transactions;
	

	/**
	 * @return the transactions
	 */
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}


	/**
	 * @param transactions the transactions to set
	 */
	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}


	/**
	 * 
	 */
	public Transactions() {
		transactions = new ArrayList<Transaction>();
	}
	
	public void println(){
		for(Transaction t : getTransactions()){
			System.out.println(t.toString());
		}
	}

}
