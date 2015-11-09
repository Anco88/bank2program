/**
 * 
 */
package data;

/**
 * @author anco
 *
 */
public class Rule {
	private String option;
	private String test;
	private String category;
	/**
	 * 
	 */
	public Rule() {
		// TODO Auto-generated constructor stub
	}

	public Rule(String str) {
		String strings[] = str.split(">>");
		setTest(strings[0]);
		if(strings.length<2){
			setOption("badRule");
		}
		setCategory(strings[1]);
		if(strings.length>=3){
			setOption(strings[2]);
		}
		
		
	}

	/**
	 * @return the option
	 */
	public String getOption() {
		return option;
	}

	/**
	 * @param option the option to set
	 */
	public void setOption(String option) {
		this.option = option;
	}

	/**
	 * @return the test
	 */
	public String getTest() {
		return test;
	}

	/**
	 * @param test the test to set
	 */
	public void setTest(String test) {
		this.test = test;
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

}
