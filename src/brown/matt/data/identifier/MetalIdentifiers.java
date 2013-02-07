package brown.matt.data.identifier;

import java.util.Calendar;
import java.util.Date;

/*
 * This class retrieves the symbol for meat commodities.
 * @author Matthew Brown
 */
public class MetalIdentifiers {

	private static String GOLD = "GC@@@.CMX";
	private static String COPPER = "HG@@@.CMX";
	private static String PLATINUM = "PL@@@.NYM";
	private static String SILVER = "SI@@@.CMX";
	
	/*
	 * energies stores the month code to be used in a particular month.
	 * For example: The Java Date .getMonth() returns 0 for January which
	 * would correspond to 'G' in the array.  G is the month code for February
	 * which would be the futures price to be viewed in January.
	 * 
	 * Month Codes: F=January, G=February, H=March, J=April, K=May, M=June,
	 * N=July, Q=August, U=September, V=October, C=November, Z=December
	 */
	private static char[] gold = {'G', 'J', 'J', 'M', 'M', 'Q', 'Q', 'V', 'V', 'Z', 'Z', 'G'};
	private static char[] copper_silver = {'H', 'H', 'J', 'K', 'N', 'N', 'U', 'U', 'Z', 'Z', 'Z', 'H'};
	private static char[] platinum = {'J', 'J', 'J', 'N', 'N', 'N', 'V', 'V', 'V', 'F', 'F', 'F'};
	
	/*
	 * Get the quote Symbol for Gold.
	 * @param none
	 * @return Gold quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getGold() {
		Date d = new Date();
			
		return GOLD.replace("@@@", gold[d.getMonth()] + getYearDec(d));
	}
	
	/*
	 * Get the quote Symbol for Copper.
	 * @param none
	 * @return Copper quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getCopper() {
		Date d = new Date();
			
		return COPPER.replace("@@@", copper_silver[d.getMonth()] + getYearDec(d));
	}
	
	/*
	 * Get the quote Symbol for Silver.
	 * @param none
	 * @return Silver quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getSilver() {
		Date d = new Date();
			
		return SILVER.replace("@@@", copper_silver[d.getMonth()] + getYearDec(d));
	}
	
	/*
	 * Get the quote Symbol for Platinum.
	 * @param none
	 * @return Platinum quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getPlatinum() {
		Date d = new Date();
			
		return PLATINUM.replace("@@@", platinum[d.getMonth()] + getYearOct(d));
	}
	
	/*
	 * Get the quote Symbols for all metals commodities.
	 * @param none
	 * @return All metals quote symbols with the correct month and year abbreviations separated by "+"
	 */
	public static String getAllMetals() {
		return getGold() + "+" + getCopper() + "+" + getSilver() + "+" + getPlatinum();
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
	 * Get the year symbol for a quote - Increments by one if current month is October
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
