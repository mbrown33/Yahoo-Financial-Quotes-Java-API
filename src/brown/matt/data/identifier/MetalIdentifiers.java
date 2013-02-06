package brown.matt.data.identifier;

import java.util.Date;

public class MetalIdentifiers extends Identifiers {

	private static String NYM = "New York Mercantile Exchange";
	
	private static String GOLD = "GC@@@.CMX";
	private static String COPPER = "HG@@@.CMX";
	private static String PLATINUM = "PL@@@.NYM";
	private static String SILVER = "SI@@@.CMX";
	
	private static char[] gold = {'G', 'J', 'J', 'M', 'M', 'Q', 'Q', 'V', 'V', 'Z', 'Z', 'G'};
	private static char[] copper_silver = {'H', 'H', 'J', 'K', 'N', 'N', 'U', 'U', 'Z', 'Z', 'Z', 'H'};
	private static char[] platinum = {'J', 'J', 'J', 'N', 'N', 'N', 'V', 'V', 'V', 'F', 'F', 'F'};
	
	@SuppressWarnings("deprecation")
	public static String getGold() {
		Date d = new Date();
			
		return GOLD.replace("@@@", gold[d.getMonth()] + getYear(d));
	}
	
	@SuppressWarnings("deprecation")
	public static String getCopper() {
		Date d = new Date();
			
		return COPPER.replace("@@@", copper_silver[d.getMonth()] + getYear(d));
	}
	
	@SuppressWarnings("deprecation")
	public static String getSilver() {
		Date d = new Date();
			
		return SILVER.replace("@@@", copper_silver[d.getMonth()] + getYear(d));
	}
	
	@SuppressWarnings("deprecation")
	public static String getPlatinum() {
		Date d = new Date();
			
		return PLATINUM.replace("@@@", platinum[d.getMonth()] + getYear(d));
	}
	
	public static String getAllMetals() {
		return getGold() + "+" + getCopper() + "+" + getSilver() + "+" + getPlatinum();
	}
}
