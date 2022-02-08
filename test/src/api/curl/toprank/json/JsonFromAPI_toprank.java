package api.curl.toprank.json;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import api.curl.toprank.dto.User_TopRankDTO;
import api.curl.toprank.uri.User_TopRankURI;

public class JsonFromAPI_toprank {
	private User_TopRankURI uri;
	private User_TopRankDTO dto;

	public List<User_TopRankDTO> read_json() {
		JSONObject jsonObject;
		JSONArray userTopRank_json = null;
		JSONObject userTopRank_arr;
		ArrayList<User_TopRankDTO> list = new ArrayList<User_TopRankDTO>();
		
		uri = new User_TopRankURI();
		try {
			JSONParser parser = new JSONParser();
			for (int i = 0; i < 3; i++) {
				switch(i) { 
				case 0:
					jsonObject = (JSONObject) parser.parse(uri.top_rank_curl_solo());
					userTopRank_json = (JSONArray) jsonObject.get("topRanks");
					break;
					
				case 1:
					jsonObject = (JSONObject) parser.parse(uri.top_rank_curl_duo());
					userTopRank_json = (JSONArray) jsonObject.get("topRanks");
					break;
					
				case 2:
					jsonObject = (JSONObject) parser.parse(uri.top_rank_curl_squad());
					userTopRank_json = (JSONArray) jsonObject.get("topRanks");
					break;
					
				}
				for (int j = 0; j < 5; j++) {
					dto = new User_TopRankDTO();
					userTopRank_arr = (JSONObject) userTopRank_json.get(j);
					dto.setNickname(userTopRank_arr.get("nickname").toString());
					dto.setMmr(userTopRank_arr.get("mmr").toString());
					dto.setRank(userTopRank_arr.get("rank").toString());
					list.add(dto);
				}
			}
		} catch (ParseException e) {
			// TODO: handle exception
		}
		
		return list;
	}
}
