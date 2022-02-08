package api.curl.stats.url;

import api.curl.connect.Connect_Manager;
import api.curl.key.Static_API_Value;

public class User_StatsURI {
	private Static_API_Value api_value;
	private String rank_url;
	private Connect_Manager connect;
	
	public String stats_uri(int user_number) {
		api_value = new Static_API_Value();
		connect = new Connect_Manager();
		rank_url = api_value.getUrl() + "/user/stats/"+user_number+"/7";
		return connect.connect_toAPI(rank_url);
	}
}
