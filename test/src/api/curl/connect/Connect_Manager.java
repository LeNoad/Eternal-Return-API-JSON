package api.curl.connect;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import api.curl.key.Static_API_Value;

public class Connect_Manager {
	
	private int responseCode;
	private String result_api_data;
	private String output;
	private Static_API_Value api;
	
	public String connect_toAPI(String urL_api_connect) {
		URL urlObject = null;
		HttpURLConnection con = null;
		StringBuffer response = new StringBuffer();
		try {
			urlObject = new URL(urL_api_connect);
			con = (HttpURLConnection) urlObject.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("accept", "application/json");
			con.setRequestProperty("x-api-key", api.getKey());
			responseCode = con.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

			while ((output = br.readLine()) != null) {
				response.append(output);
				result_api_data = output;
			}
			br.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result_api_data;
	}
}
