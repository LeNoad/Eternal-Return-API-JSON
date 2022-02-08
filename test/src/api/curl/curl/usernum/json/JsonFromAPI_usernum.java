package api.curl.curl.usernum.json;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import api.curl.curl.usernum.dto.User_UsernumDTO;
import api.curl.curl.usernum.url.User_UsernumURI;


public class JsonFromAPI_usernum {
	private User_UsernumURI uri;
	private User_UsernumDTO dto;
	public List<User_UsernumDTO> read_json(String nickname) {
		JSONObject jsonObject;
		List<User_UsernumDTO> list = new ArrayList<User_UsernumDTO>();
		uri = new User_UsernumURI();
		dto = new User_UsernumDTO();
		try {
			JSONParser parser = new JSONParser();
			jsonObject = (JSONObject) parser.parse(uri.usernum_uri(nickname));
			JSONObject user_json = (JSONObject) jsonObject.get("user");
			dto.setNickname(user_json.get("nickname").toString());
			dto.setUserNum(user_json.get("userNum").toString());
			list.add(dto);
		} catch (ParseException e) {
			// TODO: handle exception
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		return list;
		
	}
}
