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
	
	public String getSymbol() {
		return symbol;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCurrentPrice() {
		return currentPrice;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getOpen() {
		return open;
	}
	
	public String getHigh() {
		return high;
	}
	
	public String getLow() {
		return low;
	}
	
	public String getChange() {
		return change;
	}
	
	public String getClose() {
		return close;
	}
	
	@Override
	public String toString() {
		return getName() + " Current Price: " + getCurrentPrice() + " Open: " + getOpen() +
				" High: " + getHigh() + " Low: " + getLow() + " Change: " + getChange() +
				" Close: " + getClose() + " Time: " + getTime();
	}
	
}
