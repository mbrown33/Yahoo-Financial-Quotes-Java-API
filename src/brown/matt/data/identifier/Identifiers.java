package brown.matt.data.identifier;

import java.util.Calendar;
import java.util.Date;

public class Identifiers {

	protected static String getYear(Date d) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		return String.format("%d", calendar.get(Calendar.YEAR)).substring(2,4);
	}
	
}
