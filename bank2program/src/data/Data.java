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
	ArrayList<Transaction> transactions;
	private Rules rules;
	private String bank;
	/**
	 * 
	 */
	public Data() {
		transactions = new ArrayList<Transaction>();
		rules = new Rules();
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
	 * @return the rules
	 */
	public Rules getRules() {
		return rules;
	}

	/**
	 * @param rules the rules to set
	 */
	public void setRules(Rules rules) {
		this.rules = rules;
	}

	/**
	 * @return the bank
	 */
	public String getBank() {
		return bank;
	}

	/**
	 * @param bank the bank to set
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}

}
