package brown.matt.data.identifier;

import java.util.Calendar;
import java.util.Date;

/*
 * This class retrieves the symbol for energy commodities.
 * @author Matthew Brown
 */
public class EnergyIdentifiers {

	private static String CRUDE_OIL = "CL@@@.NYM";
	private static String HEATING_OIL = "HO@@@.NYM";
	private static String NATURAL_GAS = "NG@@@.NYM";
	private static String RBOB_GAS = "RB@@@.NYM";
	
	/*
	 * energies stores the month code to be used in a particular month.
	 * For example: The Java Date .getMonth() returns 0 for January which
	 * would correspond to 'G' in the array.  G is the month code for February
	 * which would be the futures price to be viewed in January.
	 * 
	 * Month Codes: F=January, G=February, H=March, J=April, K=May, M=June,
	 * N=July, Q=August, U=September, V=October, C=November, Z=December
	 */
	private static char[] energies = {'G', 'H', 'J', 'K', 'M', 'N', 'Q', 'U', 'V', 'C', 'Z', 'F'};
	
	/*
	 * Get the quote Symbol for Crude Oil.
	 * @param none
	 * @return Crude Oil quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getCrudeOil() {
		Date d = new Date();

		return CRUDE_OIL.replace("@@@", energies[d.getMonth()] + getYear(d));
	}
	
	/*
	 * Get the quote Symbol for Heating Oil.
	 * @param none
	 * @return Heating Oil quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getHeatingOil() {
		Date d = new Date();

		return HEATING_OIL.replace("@@@", energies[d.getMonth()] + getYear(d));
	}
	
	/*
	 * Get the quote Symbol for Natural Gas.
	 * @param none
	 * @return Natural Gas quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getNaturalGas() {
		Date d = new Date();
	
		return NATURAL_GAS.replace("@@@", energies[d.getMonth()] + getYear(d));
	}
	
	/*
	 * Get the quote Symbol for RBOB Gas.
	 * @param none
	 * @return RBOB Gas quote symbol with the correct month and year abbreviations
	 */
	@SuppressWarnings("deprecation")
	public static String getRBOBGas() {
		Date d = new Date();
	
		return RBOB_GAS.replace("@@@", energies[d.getMonth()] + getYear(d));
	}
	
	/*
	 * Get the quote Symbols for all energy commodities.
	 * @param none
	 * @return All energies quote symbols with the correct month and year abbreviations separated by "+"
	 */
	public static String getAllEnergies() {
		return getCrudeOil() + "+" + getHeatingOil() + "+" + getNaturalGas() + "+" + getRBOBGas();
	}
	
	/*
	 * Get the year symbol for a quote - Increments by one if current month is December
	 * @param the current date
	 * @return symbol for the year
	 */
	@SuppressWarnings("deprecation")
	private static String getYear(Date d) {	
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		int yr = calendar.get(Calendar.YEAR);
		
		// Increment the year by one if current month is December.
		if (d.getMonth() == 11) return String.format("%d", yr+1).substring(2,4);
		
		return String.format("%d", yr).substring(2,4);
	}
}
