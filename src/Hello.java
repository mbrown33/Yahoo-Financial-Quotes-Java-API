import java.io.IOException;
import java.util.List;

import brown.matt.data.quote.CommoditiesDataProvider;
import brown.matt.data.quote.CommodityData;

public class Hello {
	public static void main(String[] args) throws IOException {
		List<CommodityData> data = CommoditiesDataProvider.getEnergyData();
		
		for (CommodityData d : data) {
			System.out.println(d.toString());
		}
	}
}
