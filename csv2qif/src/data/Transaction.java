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

	public void readFromLine(String str) {
		str = str.substring(1, str.length() - 1);
		String[] strings = str.split("(\",\")");
		ownAccount = strings[0];
		currency = strings[1];

		if (strings[3].contains("D")) {
			DC = "-";
		}

		amount = strings[4];

		account = strings[5];
		name = strings[6];
		date = strings[7];
		code = strings[8];

		if (strings.length > 10) {
			description = strings[10];
		}
		for (int i = 11; i < strings.length; i++) {
			comment += " " + strings[i];
		}
		comment = comment.trim();
		category = setCat();

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

}
