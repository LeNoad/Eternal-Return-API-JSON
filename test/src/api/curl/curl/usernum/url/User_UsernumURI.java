package api.curl.curl.usernum.url;

import api.curl.connect.Connect_Manager;
import api.curl.key.Static_API_Value;

public class User_UsernumURI {
	private Static_API_Value api_value;
	private String rank_url;
	private Connect_Manager connect;

	public String usernum_uri(String nickname) {
		api_value = new Static_API_Value();
		connect = new Connect_Manager();
		rank_url = api_value.getUrl() + "/user/nickname?query=" + nickname;
		return connect.connect_toAPI(rank_url);
	}
}
