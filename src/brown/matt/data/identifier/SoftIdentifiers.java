package brown.matt.data.identifier;

import java.util.Date;

public class SoftIdentifiers extends Identifiers {

	private static String NYB = "New York Board of Trade";
	
	private static String COCOA = "CC@@@.NYB";
	private static String COFFEE = "KC@@@.NYB";
	private static String COTTON = "CT@@@.NYB";
	private static String LUMBER = "LB@@@.CME";
	private static String ORANGE_JUICE = "OJ@@@.NYB";
	private static String SUGAR = "SB@@@.NYB";
	
	private static char[] cocoa_coffee_cotton = {'H', 'H', 'K', 'K', 'N', 'N', 'U', 'U', 'V', 'Z', 'Z', 'H'};
	private static char[] lumber_oj = {'H', 'H', 'K', 'K', 'N', 'N', 'U', 'U', 'X', 'X', 'F', 'F'};
	private static char[] sugar = {'H', 'H', 'K', 'K', 'N', 'N', 'V', 'V', 'V', 'H', 'H', 'H'};
	
	@SuppressWarnings("deprecation")
	public static String getCocoa() {
		Date d = new Date();
			
		return COCOA.replace("@@@", cocoa_coffee_cotton[d.getMonth()] + getYear(d));
	}
	
	@SuppressWarnings("deprecation")
	public static String getCoffee() {
		Date d = new Date();
			
		return COFFEE.replace("@@@", cocoa_coffee_cotton[d.getMonth()] + getYear(d));
	}
	
	@SuppressWarnings("deprecation")
	public static String getCotton() {
		Date d = new Date();
			
		return COTTON.replace("@@@", cocoa_coffee_cotton[d.getMonth()] + getYear(d));
	}
	
	@SuppressWarnings("deprecation")
	public static String getLumber() {
		Date d = new Date();
			
		return LUMBER.replace("@@@", lumber_oj[d.getMonth()] + getYear(d));
	}
	
	@SuppressWarnings("deprecation")
	public static String getOrangeJuice() {
		Date d = new Date();
			
		return ORANGE_JUICE.replace("@@@", lumber_oj[d.getMonth()] + getYear(d));
	}
	
	@SuppressWarnings("deprecation")
	public static String getSugar() {
		Date d = new Date();
			
		return SUGAR.replace("@@@", sugar[d.getMonth()] + getYear(d));
	}
	
	public static String getAllSofts() {
		return getCocoa() + "+" + getCoffee() + "+" + getCotton() + "+" + getLumber() + "+" + getOrangeJuice() + "+" + getSugar();
	}
}
