package api.curl.gameid.url;

import java.util.ArrayList;
import java.util.List;

import api.curl.connect.Connect_Manager;
import api.curl.curl.usernum.dto.User_UsernumDTO;
import api.curl.curl.usernum.json.JsonFromAPI_usernum;
import api.curl.curl.usernum.url.User_UsernumURI;
import api.curl.gameid.dto.User_GameidDTO;
import api.curl.gameid.dto.User_GameinfoDTO;
import api.curl.gameid.json.User_GameidJson;
import api.curl.gameid.json.User_GameidNextJson;
import api.curl.gameid.json.User_GameinfoJson;
import api.curl.key.Static_API_Value;
import api.curl.stats.json.JsonFromAPI_stats;

public class User_GameidURI {
	private Static_API_Value api_value;
	private String gameid_uri;
	private Connect_Manager connect;
	private User_UsernumURI usernumURI;

	public String gameid(String nickname) {
		JsonFromAPI_usernum usernum_json = new JsonFromAPI_usernum();
		JsonFromAPI_stats json = new JsonFromAPI_stats();
		List<User_UsernumDTO> usernum_list = usernum_json.read_json(nickname);
		User_UsernumDTO usernum_dto = usernum_list.get(0);
		api_value = new Static_API_Value();
		connect = new Connect_Manager();
		gameid_uri = api_value.getUrl() + "/user/games/" + usernum_dto.getUserNum();
		return connect.connect_toAPI(gameid_uri);
	}

	public String next(String gameid, String nickname) {
		JsonFromAPI_usernum usernum_json = new JsonFromAPI_usernum();
		JsonFromAPI_stats json = new JsonFromAPI_stats();
		List<User_UsernumDTO> usernum_list = usernum_json.read_json(nickname);
		User_UsernumDTO usernum_dto = usernum_list.get(0);
		api_value = new Static_API_Value();
		connect = new Connect_Manager();
		gameid_uri = api_value.getUrl() + "/user/games/" + usernum_dto.getUserNum() + "?next=" + gameid;
		return connect.connect_toAPI(gameid_uri);
	}

	public String gameinfo(String gameid) {
		api_value = new Static_API_Value();
		connect = new Connect_Manager();
		gameid_uri = api_value.getUrl() + "/games/" + gameid;
		return connect.connect_toAPI(gameid_uri);
	}


//		  User_GameidURI gameidURI = new User_GameidURI();
//		  System.out.println(gameidURI.gameinfo("15227308"));
//		  User_GameinfoJson info = new User_GameinfoJson(); info.read_json("15227308");

}
