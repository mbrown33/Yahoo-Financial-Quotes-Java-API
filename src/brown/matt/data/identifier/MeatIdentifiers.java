package brown.matt.data.identifier;

import java.util.Date;

public class MeatIdentifiers extends Identifiers {
	
	private static String CME = "Chicago Mercantile Exchange";
	
	private static String FEEDER_CATTLE = "FC@@@.CME";
	private static String LIVE_CATTLE = "LC@@@.CME";
	private static String LEAN_HOGS = "LH@@@.CME";
	//Pork Bellies Not found
	//private static String PORK_BELLIES = "PB@@@.CME";
	private static String MILK_CLASS_III = "DA@@@.CME";
	
	private static char[] feeder_cattle = {'H', 'H', 'J', 'K', 'Q', 'Q', 'Q', 'U', 'V', 'X', 'F', 'F'};
	private static char[] live_cattle = {'G', 'H', 'K', 'K', 'Q', 'Q', 'Q', 'U', 'V', 'Z', 'Z', 'G'};
	private static char[] lean_hogs = {'G', 'J', 'J', 'K', 'M', 'N', 'Q', 'V', 'V', 'Z', 'Z', 'G'};
	private static char[] milk_class_iii = {'G', 'H', 'J', 'K', 'M', 'N', 'Q', 'U', 'V', 'C', 'Z', 'F'};
	
	@SuppressWarnings("deprecation")
	public static String getFeederCattle() {
		Date d = new Date();
			
		return FEEDER_CATTLE.replace("@@@", feeder_cattle[d.getMonth()] + getYear(d));
	}
	
	@SuppressWarnings("deprecation")
	public static String getLiveCattle() {
		Date d = new Date();
			
		return LIVE_CATTLE.replace("@@@", live_cattle[d.getMonth()] + getYear(d));
	}
	
	@SuppressWarnings("deprecation")
	public static String getLeanHogs() {
		Date d = new Date();
			
		return LEAN_HOGS.replace("@@@", lean_hogs[d.getMonth()] + getYear(d));
	}
	
	@SuppressWarnings("deprecation")
	public static String getMilkClassIII() {
		Date d = new Date();
			
		return MILK_CLASS_III.replace("@@@", milk_class_iii[d.getMonth()] + getYear(d));
	}
	
	public static String getAllMeats() {
		return getFeederCattle() + "+" + getLiveCattle() + "+" + getLeanHogs() + "+" + getMilkClassIII();
	}
}
