package api.curl.toprank.uri;

import api.curl.connect.Connect_Manager;
import api.curl.key.Static_API_Value;

public class User_TopRankURI {
	private Static_API_Value api_value;
	private Connect_Manager connect;
	
	public String top_rank_curl_solo() {
		api_value = new Static_API_Value();
		connect = new Connect_Manager();
		String top_rank_url_solo = api_value.getUrl() +  "/rank/top/7/1";
		return connect.connect_toAPI(top_rank_url_solo);
	}
	public String top_rank_curl_duo() {
		api_value = new Static_API_Value();
		connect = new Connect_Manager();
		String top_rank_url_duo = api_value.getUrl() +  "/rank/top/7/2";
		return connect.connect_toAPI(top_rank_url_duo);
	}
	public String top_rank_curl_squad() {
		api_value = new Static_API_Value();
		connect = new Connect_Manager();
		String top_rank_url_squad = api_value.getUrl() +  "/rank/top/7/3";
		return connect.connect_toAPI(top_rank_url_squad);
	}
	
}
