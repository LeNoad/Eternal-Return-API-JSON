package api.curl.rank.json;


import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import api.curl.rank.dto.User_RankDTO;
import api.curl.rank.url.User_RankURI;

public class JsonFromAPI {
	private User_RankURI uri;
	private User_RankDTO dto;
	public List<User_RankDTO> read_json(int user_number) {
		JSONObject jsonObject;
		List<User_RankDTO> list = new ArrayList<User_RankDTO>();
		dto = new User_RankDTO();
		uri = new User_RankURI();
		try {
			JSONParser parser = new JSONParser();
			jsonObject = (JSONObject)parser.parse(uri.rank_uri(user_number));
			JSONObject userRank_json = (JSONObject) jsonObject.get("userRank");
			dto.setMmr(userRank_json.get("mmr").toString());
			dto.setNickname(userRank_json.get("nickname").toString());
			dto.setRank(userRank_json.get("rank").toString());
			dto.setUserNum(userRank_json.get("userNum").toString());
			list.add(dto);
//			System.out.println(jsonObj.toJSONString());
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}
