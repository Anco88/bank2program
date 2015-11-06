/**
 * 
 */
package data;

import java.util.ArrayList;

import decode.Rules;

/**
 * @author anco
 *
 */
public class Data {
	private Transactions transactions;
	private Rules rules;
	/**
	 * @return the transactions
	 */
	public ArrayList<Transaction> getTransactions(){
		return transactions.getTransactions();
	}
	/**
	 * @param transactions the transactions to set
	 */
	public void setTransactions(Transactions transactions) {
		this.transactions = transactions;
	}
	
	/**
	 * 
	 */
	public Data() {
		transactions = new Transactions();
		rules = new Rules();
	}

}
