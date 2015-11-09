package data;

public class Transaction {

	private String DC = "";
	private String amount;
	private String date;
	private String currency;
	private String name_description;
	private String comment = "";
	private String category = "";
	private String ownAccount;
	private String account;
	private String code;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param dC
	 * @param amount
	 * @param date
	 * @param currency
	 * @param name_description
	 * @param comment
	 * @param category
	 * @param ownAccount
	 * @param account
	 * @param code
	 */
	public Transaction(String dC, String amount, String date, String currency,
			String name_description, String comment, String category,
			String ownAccount, String account, String code) {
		super();
		DC = dC;
		this.amount = amount;
		this.date = date;
		this.currency = currency;
		this.name_description = name_description;
		this.comment = comment;
		this.category = category;
		this.ownAccount = ownAccount;
		this.account = account;
		this.code = code;
	}
	
	public String concat(String separator, String... args) {
		String str = args[0];
		for (int i = 1; i < args.length; i++) {
			str = str + separator + args[i];
		}
		return str;
	}
	
	@Override
	public String toString(){
		String str = "";
		str += concat(",", date, DC + amount, name_description, comment, 
				category,ownAccount, account, code, currency);
		return str;
	}


	/**
	 * @return the dC
	 */
	public String getDC() {
		return DC;
	}

	/**
	 * @param dC the dC to set
	 */
	public void setDC(String dC) {
		DC = dC;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the name_description
	 */
	public String getName_description() {
		return name_description;
	}

	/**
	 * @param name_description the name_description to set
	 */
	public void setName_description(String name_description) {
		this.name_description = name_description;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the ownAccount
	 */
	public String getOwnAccount() {
		return ownAccount;
	}

	/**
	 * @param ownAccount the ownAccount to set
	 */
	public void setOwnAccount(String ownAccount) {
		this.ownAccount = ownAccount;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
