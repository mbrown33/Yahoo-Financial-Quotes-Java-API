package brown.matt.data.identifier;

import java.util.Date;

public class EnergyIdentifiers extends Identifiers {

	private static String NYM = "New York Mercantile Exchange";
	
	private static String CRUDE_OIL = "CL@@@.NYM";
	private static String HEATING_OIL = "HO@@@.NYM";
	private static String NATURAL_GAS = "NG@@@.NYM";
	private static String RBOB_GAS = "RB@@@.NYM";
	
	private static char[] energies = {'G', 'H', 'J', 'K', 'M', 'N', 'Q', 'U', 'V', 'C', 'Z', 'F'};
	
	@SuppressWarnings("deprecation")
	public static String getCrudeOil() {
		Date d = new Date();
			
		return CRUDE_OIL.replace("@@@", energies[d.getMonth()] + getYear(d));
	}
	
	@SuppressWarnings("deprecation")
	public static String getHeatingOil() {
		Date d = new Date();
			
		return HEATING_OIL.replace("@@@", energies[d.getMonth()] + getYear(d));
	}
	
	@SuppressWarnings("deprecation")
	public static String getNaturalGas() {
		Date d = new Date();
			
		return NATURAL_GAS.replace("@@@", energies[d.getMonth()] + getYear(d));
	}
	
	@SuppressWarnings("deprecation")
	public static String getRBOBGas() {
		Date d = new Date();
			
		return RBOB_GAS.replace("@@@", energies[d.getMonth()] + getYear(d));
	}
	
	public static String getAllEnergies() {
		return getCrudeOil() + "+" + getHeatingOil() + "+" + getNaturalGas() + "+" + getRBOBGas();
	}
}
