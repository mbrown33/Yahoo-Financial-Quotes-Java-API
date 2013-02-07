package brown.matt.data.identifier;

import java.util.Calendar;
import java.util.Date;

/*
 * This class retrieves the symbol for grain commodities.
 * @author Matthew Brown
 */
public class GrainIdentifiers {
	
	private static String CORN = "C@@@.CBT";
	private static String OATS = "O@@@.CBT";
	private static String SOYBEANS = "S@@@.CBT";
	private static String SOYBEAN_MEAL = "SM@@@.CBT";
	private static String SOYBEAN_OIL = "B@@@.CBT";
	private static String WHEAT = "W@@@.CBT";
	
	/*
	 * energies stores the month code to be used in a particular month.
	 * For example: The Java Date .getMonth() method returns 0 for January which
	 * would correspond to 'H' in the array.  H is the month code for March
	 * which would be the futures price to be viewed in January.
	 * 
	 * Month Codes: F=January, G=February, H=March, J=April, K=May, M=June,
	 * N=July, Q=August, U=September, V=October, C=November, Z=December
	 */
	private static char[] corn = {'H', 'H', 'K', 'K', 'N', 'N', 'U', 'U', 'X', 'X', 'Z', 'F'};
	private static char[] oats_wheat = {'H', 'H', 'K', 'K', 'N', 'N', 'U', 'U', 'Z', 'Z', 'Z', 'H'};
	private static char[] soybeans = {'H', 'H', 'K', 'K', 'N', 'N', 'Q', 'U', 'X', 'X', 'F', 'F'};
	private static char[] soybean_meal_oil = {'H', 'H', 'K', 'K', 'N', 'N', 'Q', 'U', 'V', 'X', 'F', 'F'};
	
	/*
	 * Get the quote Symbol for Corn.
	 * @param none
	 * @return Corn quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getCorn() {
		Date d = new Date();
			
		return CORN.replace("@@@", corn[d.getMonth()] + getYearDec(d));
	}
	
	/*
	 * Get the quote Symbol for Oats.
	 * @param none
	 * @return Oats quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getOats() {
		Date d = new Date();
			
		return OATS.replace("@@@", oats_wheat[d.getMonth()] + getYearDec(d));
	}
	
	/*
	 * Get the quote Symbol for Soybeans.
	 * @param none
	 * @return Soybeans quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getSoybeans() {
		Date d = new Date();
			
		return SOYBEANS.replace("@@@", soybeans[d.getMonth()] + getYearNov(d));
	}
	
	/*
	 * Get the quote Symbol for Soybean Meal.
	 * @param none
	 * @return Corn quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getSoybeanMeal() {
		Date d = new Date();
			
		return SOYBEAN_MEAL.replace("@@@", soybean_meal_oil[d.getMonth()] + getYearNov(d));
	}
	/*
	 * Get the quote Symbol for Soybean Oil.
	 * @param none
	 * @return Soybean Oil quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getSoybeanOil() {
		Date d = new Date();
			
		return SOYBEAN_OIL.replace("@@@", soybean_meal_oil[d.getMonth()] + getYearNov(d));
	}
	
	/*
	 * Get the quote Symbol for Wheat.
	 * @param none
	 * @return Wheat quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getWheat() {
		Date d = new Date();
			
		return WHEAT.replace("@@@", oats_wheat[d.getMonth()] + getYearDec(d));
	}
	
	/*
	 * Get the quote Symbols for all grain commodities.
	 * @param none
	 * @return All grain quote symbols with the correct month and year abbreviations separated by "+"
	 */
	public static String getAllGrains() {
		return getCorn() + "+" + getOats() + "+" + getSoybeans() + "+" + getSoybeanMeal() + "+" + getSoybeanMeal() + "+" + getWheat();
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
