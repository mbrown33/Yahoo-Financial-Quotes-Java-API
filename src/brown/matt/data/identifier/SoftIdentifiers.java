package brown.matt.data.identifier;

import java.util.Calendar;
import java.util.Date;

/*
 * This class retrieves the symbol for soft commodities.
 * @author Matthew Brown
 */
public class SoftIdentifiers {

	private static String COCOA = "CC@@@.NYB";
	private static String COFFEE = "KC@@@.NYB";
	private static String COTTON = "CT@@@.NYB";
	private static String LUMBER = "LB@@@.CME";
	private static String ORANGE_JUICE = "OJ@@@.NYB";
	private static String SUGAR = "SB@@@.NYB";
	
	/*
	 * energies stores the month code to be used in a particular month.
	 * For example: The Java Date .getMonth() returns 0 for January which
	 * would correspond to 'H' in the array.  H is the month code for March
	 * which would be the futures price to be viewed in January.
	 * 
	 * Month Codes: F=January, G=February, H=March, J=April, K=May, M=June,
	 * N=July, Q=August, U=September, V=October, C=November, Z=December
	 */
	private static char[] cocoa_coffee_cotton = {'H', 'H', 'K', 'K', 'N', 'N', 'U', 'U', 'V', 'Z', 'Z', 'H'};
	private static char[] lumber_oj = {'H', 'H', 'K', 'K', 'N', 'N', 'U', 'U', 'X', 'X', 'F', 'F'};
	private static char[] sugar = {'H', 'H', 'K', 'K', 'N', 'N', 'V', 'V', 'V', 'H', 'H', 'H'};
	
	/*
	 * Get the quote Symbol for Cocoa.
	 * @param none
	 * @return Cocoa quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getCocoa() {
		Date d = new Date();
			
		return COCOA.replace("@@@", cocoa_coffee_cotton[d.getMonth()] + getYearDec(d));
	}
	
	/*
	 * Get the quote Symbol for Coffee.
	 * @param none
	 * @return Coffee quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getCoffee() {
		Date d = new Date();
			
		return COFFEE.replace("@@@", cocoa_coffee_cotton[d.getMonth()] + getYearDec(d));
	}
	
	/*
	 * Get the quote Symbol for Cotton.
	 * @param none
	 * @return Cotton quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getCotton() {
		Date d = new Date();
			
		return COTTON.replace("@@@", cocoa_coffee_cotton[d.getMonth()] + getYearDec(d));
	}
	
	/*
	 * Get the quote Symbol for Lumber.
	 * @param none
	 * @return Lumber quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getLumber() {
		Date d = new Date();
			
		return LUMBER.replace("@@@", lumber_oj[d.getMonth()] + getYearNov(d));
	}
	
	/*
	 * Get the quote Symbol for Orange Juice.
	 * @param none
	 * @return Orange Juice quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getOrangeJuice() {
		Date d = new Date();
			
		return ORANGE_JUICE.replace("@@@", lumber_oj[d.getMonth()] + getYearNov(d));
	}
	
	/*
	 * Get the quote Symbol for Sugar.
	 * @param none
	 * @return Sugar quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getSugar() {
		Date d = new Date();
			
		return SUGAR.replace("@@@", sugar[d.getMonth()] + getYearOct(d));
	}
	
	/*
	 * Get the quote Symbols for all soft commodities.
	 * @param none
	 * @return All soft quote symbols with the correct month and year abbreviations separated by "+"
	 */
	public static String getAllSofts() {
		return getCocoa() + "+" + getCoffee() + "+" + getCotton() + "+" + getLumber() + "+" + getOrangeJuice() + "+" + getSugar();
	}
	
	/*
	 * Get the year symbol for a quote - Increments by one if current month is December
	 * @param the current date
	 * @return symbol for the year
	 */
	@SuppressWarnings("deprecation")
	private static String getYearDec(Date d) {	
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		int yr = calendar.get(Calendar.YEAR);
		
		// Increment the year by one if current month is December.
		if (d.getMonth() == 11) return String.format("%d", yr+1).substring(2,4);
		
		return String.format("%d", yr).substring(2,4);
	}
	
	/*
	 * Get the year symbol for a quote - Increments by one if current month is at least November
	 * @param the current date
	 * @return symbol for the year
	 */
	@SuppressWarnings("deprecation")
	private static String getYearNov(Date d) {	
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		int yr = calendar.get(Calendar.YEAR);
		
		// Increment the year by one if current month is at least November.
		if (d.getMonth() >= 10) return String.format("%d", yr+1).substring(2,4);
		
		return String.format("%d", yr).substring(2,4);
	}
	
	/*
	 * Get the year symbol for a quote - Increments by one if current month is at least October
	 * @param the current date
	 * @return symbol for the year
	 */
	@SuppressWarnings("deprecation")
	private static String getYearOct(Date d) {	
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		int yr = calendar.get(Calendar.YEAR);
		
		// Increment the year by one if current month is at least October.
		if (d.getMonth() >= 9) return String.format("%d", yr+1).substring(2,4);
		
		return String.format("%d", yr).substring(2,4);
	}
}
