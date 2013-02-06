package brown.matt.data.quote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import brown.matt.data.identifier.CommodityIdentifiers;
import brown.matt.data.identifier.EnergyIdentifiers;
import brown.matt.data.identifier.GrainIdentifiers;
import brown.matt.data.identifier.MeatIdentifiers;
import brown.matt.data.identifier.MetalIdentifiers;
import brown.matt.data.identifier.SoftIdentifiers;

public class CommoditiesDataProvider {

	private static final String BASE_URL = "http://download.finance.yahoo.com/d/quotes.csv?s=";
	//Symbol, Name, last trade, date of last trade, time of last trade, open, high , low, day's change, Previous Close
	private static final String TAGS = "&f=snl1d1t1ohgw1p";
	
	public static List<CommodityData> getSelectData(List<String> selections) throws IOException {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		
		for (String select: selections) {
			switch (select) {
				case CommodityIdentifiers.COCOA:
					if (!first) sb.append("+");
					else first = false;
					sb.append(SoftIdentifiers.getCocoa());	
					break;
				case CommodityIdentifiers.COFFEE:
					if (!first) sb.append("+");
					else first = false;
					sb.append(SoftIdentifiers.getCoffee());	
					break;
				case CommodityIdentifiers.COPPER:
					if (!first) sb.append("+");
					else first = false;
					sb.append(MetalIdentifiers.getCopper());	
					break;	
				case CommodityIdentifiers.CORN:
					if (!first) sb.append("+");
					else first = false;
					sb.append(GrainIdentifiers.getCorn());	
					break;	
				case CommodityIdentifiers.COTTON:
					if (!first) sb.append("+");
					else first = false;
					sb.append(SoftIdentifiers.getCotton());	
					break;	
				case CommodityIdentifiers.CRUDE_OIL:
					if (!first) sb.append("+");
					else first = false;
					sb.append(EnergyIdentifiers.getCrudeOil());	
					break;
				case CommodityIdentifiers.FEEDER_CATTLE:
					if (!first) sb.append("+");
					else first = false;
					sb.append(MeatIdentifiers.getFeederCattle());	
					break;	
				case CommodityIdentifiers.GOLD:
					if (!first) sb.append("+");
					else first = false;
					sb.append(MetalIdentifiers.getGold());	
					break;	
				case CommodityIdentifiers.HEATING_OIL:
					if (!first) sb.append("+");
					else first = false;
					sb.append(EnergyIdentifiers.getHeatingOil());	
					break;		
				case CommodityIdentifiers.LEAN_HOGS:
					if (!first) sb.append("+");
					else first = false;
					sb.append(MeatIdentifiers.getLeanHogs());	
					break;
				case CommodityIdentifiers.LIVE_CATTLE:
					if (!first) sb.append("+");
					else first = false;
					sb.append(MeatIdentifiers.getLiveCattle());	
					break;
				case CommodityIdentifiers.LUMBER:
					if (!first) sb.append("+");
					else first = false;
					sb.append(SoftIdentifiers.getLumber());	
					break;	
				case CommodityIdentifiers.MILK_CLASS_III:
					if (!first) sb.append("+");
					else first = false;
					sb.append(MeatIdentifiers.getMilkClassIII());	
					break;	
				case CommodityIdentifiers.NATURAL_GAS:
					if (!first) sb.append("+");
					else first = false;
					sb.append(EnergyIdentifiers.getNaturalGas());	
					break;	
				case CommodityIdentifiers.OATS:
					if (!first) sb.append("+");
					else first = false;
					sb.append(GrainIdentifiers.getOats());	
					break;	
				case CommodityIdentifiers.ORANGE_JUICE:
					if (!first) sb.append("+");
					else first = false;
					sb.append(SoftIdentifiers.getOrangeJuice());	
					break;	
				case CommodityIdentifiers.PLATINUM:
					if (!first) sb.append("+");
					else first = false;
					sb.append(MetalIdentifiers.getPlatinum());	
					break;	
				case CommodityIdentifiers.RBOB_GAS:
					if (!first) sb.append("+");
					else first = false;
					sb.append(EnergyIdentifiers.getRBOBGas());	
					break;	
				case CommodityIdentifiers.SILVER:
					if (!first) sb.append("+");
					else first = false;
					sb.append(MetalIdentifiers.getSilver());	
					break;	
				case CommodityIdentifiers.SOYBEAN_MEAL:
					if (!first) sb.append("+");
					else first = false;
					sb.append(GrainIdentifiers.getSoybeanMeal());	
					break;	
				case CommodityIdentifiers.SOYBEAN_OIL:
					if (!first) sb.append("+");
					else first = false;
					sb.append(GrainIdentifiers.getSoybeanOil());	
					break;	
				case CommodityIdentifiers.SOYBEANS:
					if (!first) sb.append("+");
					else first = false;
					sb.append(GrainIdentifiers.getSoybeans());	
					break;	
				case CommodityIdentifiers.SUGAR:
					if (!first) sb.append("+");
					else first = false;
					sb.append(SoftIdentifiers.getSugar());	
					break;	
				case CommodityIdentifiers.WHEAT:
					if (!first) sb.append("+");
					else first = false;
					sb.append(GrainIdentifiers.getWheat());	
					break;
				default:
					break;
			}
		}
		
		if (!sb.toString().equals("") && sb != null) {
			String add = BASE_URL + sb.toString() + TAGS;
			return parseData(add);
		}
		
		return null;
	}
	
	public static List<CommodityData> getEnergyData() throws IOException {

		String add = BASE_URL + EnergyIdentifiers.getAllEnergies() + TAGS;
		
		return parseData(add);
	}
	
	public static List<CommodityData> getGrainData() throws IOException {

		String add = BASE_URL + GrainIdentifiers.getAllGrains() + TAGS;
		
		return parseData(add);
	}
	
	public static List<CommodityData> getMeatData() throws IOException {

		String add = BASE_URL + MeatIdentifiers.getAllMeats() + TAGS;
		
		return parseData(add);
	}
	
	public static List<CommodityData> getMetalData() throws IOException {

		String add = BASE_URL + MetalIdentifiers.getAllMetals() + TAGS;
		
		return parseData(add);
	}
	
	public static List<CommodityData> getSoftData() throws IOException {

		String add = BASE_URL + SoftIdentifiers.getAllSofts() + TAGS;
		
		return parseData(add);
	}
	
	private static List<CommodityData> parseData(String add) throws IOException {
		List<CommodityData> data = new ArrayList<CommodityData>();

		URL url = new URL(add);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		
		conn.connect();
		InputStream in = conn.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String text = null;
		
		while ((text = reader.readLine()) != null)	{
			text = text.replace("\"", "");
			StringTokenizer st = new StringTokenizer(text, ",");

			CommodityData newData = new CommodityData(st.nextToken(), st.nextToken(), st.nextToken(),
					st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(),	st.nextToken(), 
					st.nextToken(), st.nextToken());

			data.add(newData);
		}
		
		return data;
	}
	
}
