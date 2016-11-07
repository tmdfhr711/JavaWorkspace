import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class PlacesService{
	private static final String LOG_TAG = "GooglePlace";
	
	private static final String PLACES_API_BASE_URL = "https://maps.googleapis.com/maps/api/place";
	
	private static final String TYPE_TEXTSEARCH = "/textsearch";
	private static final String TYPE_DETAILS = "/details";
	private static final String TYPE_SEARCH = "/search";
	private static final String TYPES = "food";
	private static final String OUT_JSON = "/json";
	
	private static final String API_KEY = "AIzaSyBmVsaWKM5MOUDMDeMcKFhc3c9IC-Pdh-w";
	
	
	public static void textSearch(String input){
		ArrayList<Place> resultList = null;
		
		HttpURLConnection conn = null;
		InputStreamReader in = null;
		StringBuilder jsonResults = new StringBuilder();
		try {
			StringBuilder sb = new StringBuilder(PLACES_API_BASE_URL);
			sb.append(TYPE_TEXTSEARCH);
			sb.append(OUT_JSON);
			sb.append("?location=0,0");
			sb.append("&radius=50000");
			sb.append("&types" + TYPES);
			sb.append("&input=" + URLEncoder.encode(input,"utf-8"));
			sb.append("&language=ko");
			sb.append("&key=" + API_KEY);
			sb.append("&next_page_token=10");
			
			URL url = new URL(sb.toString());
			conn = (HttpURLConnection) url.openConnection();
			in = new InputStreamReader(conn.getInputStream());
			
			int read;
			char[] buff = new char[1024];
			while((read = in.read(buff)) != -1){
				jsonResults.append(buff,0,read);
			}
			
		} catch (MalformedURLException e) {
			System.out.println(LOG_TAG + " : " + "Error processing Places API URL\n" + e);
            //return resultList;
        } catch (IOException e) {
        	System.out.println(LOG_TAG + " : " + "Error connecting to Places API\n" + e);
            //return resultList;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
		System.out.println(jsonResults.toString());
		JSONParser parser = new JSONParser();
		JSONObject resultObject = null;
		try {
			resultObject = (JSONObject)parser.parse(jsonResults.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray jsonArray = (JSONArray) resultObject.get("results");
		for(int i = 0; i < jsonArray.size(); i++){
			JSONObject data = (JSONObject) jsonArray.get(i);
			try {
				System.out.println(data.get("place_id").toString());
				System.out.println(URLEncoder.encode(data.get("name").toString(), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(jsonArray.size());
		
		
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlacesService ps = new PlacesService();
		ps.textSearch("서울시 갈비");
	}

}
