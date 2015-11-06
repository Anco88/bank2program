package data;
/**
 * 
 */

/**
 * @author anco
 * 
 */

public class Transaction {

	String DC = "";
	String amount;
	String date;
	String currency;
	String name;
	String comment = "";
	String category = "";
	String ownAccount;
	String account;
	String code;
	String description;

	public Transaction() {

	}

	public String toQif() {
		String str = "";
		String memo = "";
		str += "D" + date + "\n";
		str += "T" + DC + amount + "\n";
		str += "P";
		if (!account.isEmpty()) {
			str += account + " ";
		}
		if (!name.isEmpty()) {
			str += name;
			memo += description + " ";
		} else {
			str += description;
		}
		str += "\n";
		memo += comment;
		memo = memo.trim();
		if (!memo.isEmpty()) {
			str += "M" + memo + "\n";
		}
		str += "N" + code + "\n";
		if (!category.isEmpty()) {
			str += "L" + category + "\n";
		}
		str += "^";

		return str;

	}

	public String toCSV() {
		String str = "\"";
		String n = "";
		String memo = "";
		String cat = "";
		String subcat = "";
		if (!account.isEmpty()) {
			n = account + " ";
		}
		if (!name.isEmpty()) {
			n += name;
			memo += description + " ";
		} else {
			n += description;
		}
		if (!category.isEmpty()) {
			String catTemp[] = category.split(":");
			cat = catTemp[0];
			if (catTemp.length > 1) {
				subcat = catTemp[1];
			}
		}

		memo += comment;
		System.out.println(n);
		str += concat("\",\"", date, DC + amount, n, memo, code,
				cat.toLowerCase(), subcat.toLowerCase());
		str += "\"";

		return str;

	}

	

	private String setCat() {
		// TODO Auto-generated method stub
		if (description != null
				&& (description.contains("ALBERT HEIJN")
						|| description.contains("Aldi ")
						|| description.contains("Jumbo ")
						|| description.contains("JUMBO ")
						|| description.contains("Spar ") || description
							.contains("LIDL "))) {
			return "Huishoudelijk:Boodschappen";
		}

		if (description != null && (description.contains("NS "))) {
			return "Huishoudelijk:Reiskosten";
		}

		if (name != null && (name.contains("DE FRIESLAND ZORGVE"))) {
			return "Verzekeringen:Zorg";
		}

		if (description != null
				&& (description.contains("huur Schuitendiep 17C studio"))) {
			return "Rekeningen:Huur";
		}

		if (description != null
				&& (description.contains("voorschot gas water elektra"))) {
			return "Rekeningen:GWE Internet";
		}

		if (comment != null && comment.contains("HUURTOESLAG")) {
			return "Uitkeringen:Huur subsidie";
		}

		if (comment != null && comment.contains("ZORGTOESLAG")) {
			return "Uitkeringen:Zorgtoeslag";
		}

		if (comment != null && comment.contains("Geldautomaat")) {
			return "Opname kas";
		}

		if (description != null && description.contains("Studiefinanciering")) {
			return "Uitkeringen:Studiefinanciering";
		}

		if (name != null && name.contains("Gemeente Groningen")) {
			return "Belastingen:Gemeente";
		}

		if (name != null && name.contains("MONUTA VERZEKERINGEN NV")) {
			return "Verzekeringen:Uitvaart verzekering";
		}

		if (name != null && name.contains("Simyo")) {
			return "Rekeningen:Telefoon";
		}

		if (name != null && name.contains("Kosten")) {
			return "Bank kosten:Service kosten";
		}

		if (name != null && name.contains("Debetrente")) {
			return "Bank kosten:Rente";
		}

		if (name != null
				&& (name.contains("OXFAM NOVIB") || name
						.contains("Stichting Fight cancer"))) {
			return "Goede doelen:Giften";
		}

		if (name != null && (name.contains("RIJKSUNIVERSITEIT GR"))) {
			return "Onderwijs:Lesgeld";
		}

		if (name != null
				&& (name.contains("CLEOPATRA A.S.G.") || name.contains("COVER"))) {
			return "Ontspanning:Studentenvereniging";
		}

		return "";
	}

	public String concat(String separator, String... args) {
		String str = args[0];
		for (int i = 1; i < args.length; i++) {
			str = str + separator + args[i];
		}
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}	
	@Override
	public String toString(){
		String str = "";
		str += concat(",", date, DC + amount, name, comment, category,ownAccount, account, code, description, currency);
		return str;
	}
}
