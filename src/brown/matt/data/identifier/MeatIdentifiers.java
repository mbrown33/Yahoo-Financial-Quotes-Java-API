package brown.matt.data.identifier;

import java.util.Calendar;
import java.util.Date;

/*
 * This class retrieves the symbol for meat commodities.
 * @author Matthew Brown
 */
public class MeatIdentifiers {
	
	private static String FEEDER_CATTLE = "FC@@@.CME";
	private static String LIVE_CATTLE = "LC@@@.CME";
	private static String LEAN_HOGS = "LH@@@.CME";
	//Pork Bellies Not found
	//private static String PORK_BELLIES = "PB@@@.CME";
	private static String MILK_CLASS_III = "DA@@@.CME";
	
	/*
	 * energies stores the month code to be used in a particular month.
	 * For example: The Java Date .getMonth() returns 0 for January which
	 * would correspond to 'H' in the array.  H is the month code for March
	 * which would be the futures price to be viewed in January.
	 * 
	 * Month Codes: F=January, G=February, H=March, J=April, K=May, M=June,
	 * N=July, Q=August, U=September, V=October, C=November, Z=December
	 */
	private static char[] feeder_cattle = {'H', 'H', 'J', 'K', 'Q', 'Q', 'Q', 'U', 'V', 'X', 'F', 'F'};
	private static char[] live_cattle = {'G', 'H', 'K', 'K', 'Q', 'Q', 'Q', 'U', 'V', 'Z', 'Z', 'G'};
	private static char[] lean_hogs = {'G', 'J', 'J', 'K', 'M', 'N', 'Q', 'V', 'V', 'Z', 'Z', 'G'};
	private static char[] milk_class_iii = {'G', 'H', 'J', 'K', 'M', 'N', 'Q', 'U', 'V', 'C', 'Z', 'F'};
	
	/*
	 * Get the quote Symbol for Feeder Cattle.
	 * @param none
	 * @return Feeder Cattle quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getFeederCattle() {
		Date d = new Date();
			
		return FEEDER_CATTLE.replace("@@@", feeder_cattle[d.getMonth()] + getYearNov(d));
	}
	
	/*
	 * Get the quote Symbol for Live Cattle.
	 * @param none
	 * @return Live Cattle quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getLiveCattle() {
		Date d = new Date();
			
		return LIVE_CATTLE.replace("@@@", live_cattle[d.getMonth()] + getYearDec(d));
	}
	
	/*
	 * Get the quote Symbol for Lean Hogs.
	 * @param none
	 * @return Lean Hogs quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getLeanHogs() {
		Date d = new Date();
			
		return LEAN_HOGS.replace("@@@", lean_hogs[d.getMonth()] + getYearDec(d));
	}
	
	/*
	 * Get the quote Symbol for Milk Class III.
	 * @param none
	 * @return Milk Class III quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getMilkClassIII() {
		Date d = new Date();
			
		return MILK_CLASS_III.replace("@@@", milk_class_iii[d.getMonth()] + getYearDec(d));
	}
	
	/*
	 * Get the quote Symbols for all meat commodities.
	 * @param none
	 * @return All meat quote symbols with the correct month and year abbreviations separated by "+"
	 */
	public static String getAllMeats() {
		return getFeederCattle() + "+" + getLiveCattle() + "+" + getLeanHogs() + "+" + getMilkClassIII();
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
	 * Get the year symbol for a quote - Increments by one if current month is November
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
}
