package api.curl.language.uri;

import api.curl.connect.Connect_Manager;
import api.curl.key.Static_API_Value;
import api.curl.language.json.Language_GameInfoJson;

public class Language_GameInfoURI {
	private Static_API_Value api_value;
	private Connect_Manager connect;
	private String metadata_uri;
	public String Character_search() {
		api_value = new Static_API_Value();
		connect = new Connect_Manager();
		metadata_uri = api_value.getUrl() + "/data/Character";
		return connect.connect_toAPI(metadata_uri);
	}
	public String ItemArmor_Search() {
		api_value = new Static_API_Value();
		connect = new Connect_Manager();
		metadata_uri = api_value.getUrl() + "/data/ItemArmor";
		return connect.connect_toAPI(metadata_uri);
	}
	public String ItemWeapon_Search() {
		api_value = new Static_API_Value();
		connect = new Connect_Manager();
		metadata_uri = api_value.getUrl() + "/data/ItemWeapon";
		return connect.connect_toAPI(metadata_uri);
	}
}
