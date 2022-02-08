package api.curl.language.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import api.curl.language.uri.Language_GameInfoURI;

public class Language_GameInfoJson {
	private Language_GameInfoURI language_gameinfouri;
	
	public String readWeapon_code(String hash) {
		JSONObject dataGamecode_json;
		JSONArray  dataGamecode_json_arr = null;
		JSONObject dataGamecode_json_arr_obj;
		try {
			language_gameinfouri = new Language_GameInfoURI();
			JSONParser parser = new JSONParser();
			dataGamecode_json = (JSONObject) parser.parse(language_gameinfouri.ItemWeapon_Search());
			dataGamecode_json_arr = (JSONArray) dataGamecode_json.get("data");
			for (int i = 0; i < dataGamecode_json_arr.size(); i++) {
				dataGamecode_json_arr_obj = (JSONObject)dataGamecode_json_arr.get(i);
				if(dataGamecode_json_arr_obj.get("code").toString().equals(hash)) {
					return dataGamecode_json_arr_obj.get("name").toString();
				}
			}
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String readArmor_code(String hash) {
		JSONObject dataGamecode_json;
		JSONArray  dataGamecode_json_arr = null;
		JSONObject dataGamecode_json_arr_obj;
		try {
			language_gameinfouri = new Language_GameInfoURI();
			JSONParser parser = new JSONParser();
			dataGamecode_json = (JSONObject) parser.parse(language_gameinfouri.ItemArmor_Search());
			dataGamecode_json_arr = (JSONArray) dataGamecode_json.get("data");
			for (int i = 0; i < dataGamecode_json_arr.size(); i++) {
				dataGamecode_json_arr_obj = (JSONObject)dataGamecode_json_arr.get(i);
				if(dataGamecode_json_arr_obj.get("code").toString().equals(hash)) {
					return dataGamecode_json_arr_obj.get("name").toString();
				}
			}
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String readCharacter_code(String hash) {
		JSONObject dataGamecode_json;
		JSONArray  dataGamecode_json_arr = null;
		JSONObject dataGamecode_json_arr_obj;
		try {
			language_gameinfouri = new Language_GameInfoURI();
			JSONParser parser = new JSONParser();
			dataGamecode_json = (JSONObject) parser.parse(language_gameinfouri.Character_search());
			dataGamecode_json_arr = (JSONArray) dataGamecode_json.get("data");
			for (int i = 0; i < dataGamecode_json_arr.size(); i++) {
				dataGamecode_json_arr_obj = (JSONObject)dataGamecode_json_arr.get(i);
				if(dataGamecode_json_arr_obj.get("code").toString().equals(hash)) {
					return dataGamecode_json_arr_obj.get("name").toString();
				}
			}
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
