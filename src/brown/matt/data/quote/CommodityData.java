package brown.matt.data.quote;

public class CommodityData {

	private String symbol;
	private String name;
	private String currentPrice;
	private String date;
	private String time;
	private String open;
	private String high;
	private String low;
	private String change;
	private String close;
	
	/*
	 * CommodityData Constructor - used to store market data
	 * @param Strings: Symbol, Name, Current Price, Date, Time, Open, High, Low, Day's Change, Previous Day's Close
	 */
	public CommodityData(String sym, String nam, String current, String dat, String tim, String op, String hi, 
			String lo, String chan, String cl) {
		symbol = sym;
		name = nam;
		currentPrice = current;
		date = dat;
		time = tim;
		open = op;
		high = hi;
		low = lo;
		change = chan;
		close = cl;
	}
	
	/*
	 * Get Symbol
	 * @param none
	 * @returns String symbol
	 */
	public String getSymbol() {
		return symbol;
	}
	
	/*
	 * Get Name
	 * @param none
	 * @returns String name
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Get Current Price
	 * @param none
	 * @returns String Current Price
	 */
	public String getCurrentPrice() {
		return currentPrice;
	}
	
	/*
	 * Get Date
	 * @param none
	 * @returns String date
	 */
	public String getDate() {
		return date;
	}
	
	/*
	 * Get Time
	 * @param none
	 * @returns String time
	 */
	public String getTime() {
		return time;
	}
	
	/*
	 * Get Open
	 * @param none
	 * @returns String open
	 */
	public String getOpen() {
		return open;
	}
	
	/*
	 * Get Day's High
	 * @param none
	 * @returns String high
	 */
	public String getHigh() {
		return high;
	}
	
	/*
	 * Get Day's Low
	 * @param none
	 * @returns String low
	 */
	public String getLow() {
		return low;
	}
	
	/*
	 * Get Day's Change
	 * @param none
	 * @returns String change
	 */
	public String getChange() {
		return change;
	}
	
	/*
	 * Get Previous Day's close
	 * @param none
	 * @returns String close
	 */
	public String getClose() {
		return close;
	}
	
	/*
	 * Overrides toString() to display basic information
	 * @param none
	 * @returns String object information
	 */
	@Override
	public String toString() {
		return getName() + " Current Price: " + getCurrentPrice() + " Open: " + getOpen() +
				" High: " + getHigh() + " Low: " + getLow() + " Change: " + getChange() +
				" Close: " + getClose() + " Time: " + getTime();
	}
	
}
