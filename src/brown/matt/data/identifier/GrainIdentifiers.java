package brown.matt.data.identifier;

import java.util.Date;

public class GrainIdentifiers extends Identifiers {
	
	private static String CBOT = "Chicago Board of Trade";
	
	private static String CORN = "C@@@.CBT";
	private static String OATS = "O@@@.CBT";
	private static String SOYBEANS = "S@@@.CBT";
	private static String SOYBEAN_MEAL = "SM@@@.CBT";
	private static String SOYBEAN_OIL = "B@@@.CBT";
	private static String WHEAT = "W@@@.CBT";
	
	private static char[] corn = {'H', 'H', 'K', 'K', 'N', 'N', 'U', 'U', 'X', 'X', 'Z', 'F'};
	private static char[] oats_wheat = {'H', 'H', 'K', 'K', 'N', 'N', 'U', 'U', 'Z', 'Z', 'Z', 'H'};
	private static char[] soybeans = {'H', 'H', 'K', 'K', 'N', 'N', 'Q', 'U', 'X', 'X', 'F', 'F'};
	private static char[] soybean_meal_oil = {'H', 'H', 'K', 'K', 'N', 'N', 'Q', 'U', 'V', 'X', 'F', 'F'};
	
	@SuppressWarnings("deprecation")
	public static String getCorn() {
		Date d = new Date();
			
		return CORN.replace("@@@", corn[d.getMonth()] + getYear(d));
	}
	
	@SuppressWarnings("deprecation")
	public static String getOats() {
		Date d = new Date();
			
		return OATS.replace("@@@", oats_wheat[d.getMonth()] + getYear(d));
	}
	
	@SuppressWarnings("deprecation")
	public static String getSoybeans() {
		Date d = new Date();
			
		return SOYBEANS.replace("@@@", soybeans[d.getMonth()] + getYear(d));
	}
	
	@SuppressWarnings("deprecation")
	public static String getSoybeanMeal() {
		Date d = new Date();
			
		return SOYBEAN_MEAL.replace("@@@", soybean_meal_oil[d.getMonth()] + getYear(d));
	}
	
	@SuppressWarnings("deprecation")
	public static String getSoybeanOil() {
		Date d = new Date();
			
		return SOYBEAN_OIL.replace("@@@", soybean_meal_oil[d.getMonth()] + getYear(d));
	}
	
	@SuppressWarnings("deprecation")
	public static String getWheat() {
		Date d = new Date();
			
		return WHEAT.replace("@@@", oats_wheat[d.getMonth()] + getYear(d));
	}
	
	public static String getAllGrains() {
		return getCorn() + "+" + getOats() + "+" + getSoybeans() + "+" + getSoybeanMeal() + "+" + getSoybeanMeal() + "+" + getWheat();
	}
	
}
