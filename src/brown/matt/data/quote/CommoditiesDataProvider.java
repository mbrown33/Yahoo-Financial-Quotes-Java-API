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

import brown.matt.data.identifier.EnergyIdentifiers;
import brown.matt.data.identifier.GrainIdentifiers;
import brown.matt.data.identifier.MeatIdentifiers;
import brown.matt.data.identifier.MetalIdentifiers;
import brown.matt.data.identifier.SoftIdentifiers;

public class CommoditiesDataProvider {

	private static final String BASE_URL = "http://download.finance.yahoo.com/d/quotes.csv?s=";
	//Symbol, Name, last trade, date of last trade, time of last trade, open, high , low, day's change, Previous Close
	private static final String TAGS = "&f=snl1d1t1ohgw1p";
	
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
			System.out.println(newData.toString());
			data.add(newData);
		}
		
		return data;
	}
	
//	public static void getData() throws IOException {
//		//String uri = "http://download.finance.yahoo.com/d/quotes.csv?s=SMH14.CBT&f=sl1c1d1";
//		String uri = BASE_URL + EnergyIdentifiers.getAllEnergies() + TAGS;
//		URL url = new URL(uri);
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.setRequestMethod("GET");
//		
//		conn.connect();
//		InputStream in = conn.getInputStream();
//		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//		String text = null;
//		
//		while ((text = reader.readLine()) != null)	System.out.println(text);
//
//		conn.disconnect();
//	}
	
}
