package api.curl.stats.json;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import api.curl.stats.dto.User_StatsDTO;
import api.curl.stats.url.User_StatsURI;

public class JsonFromAPI_stats {
	private User_StatsURI uri;
	private User_StatsDTO dto;

	public List<User_StatsDTO> read_json(int user_number){
		JSONObject jsonObject;
		JSONArray userStats_json;
		JSONObject userStats_json_teammode;
		List<User_StatsDTO> list = new ArrayList<User_StatsDTO>();
		dto = new User_StatsDTO();
		uri = new User_StatsURI();
		try {
			JSONParser parser = new JSONParser();
			jsonObject = (JSONObject) parser.parse(uri.stats_uri(user_number));
			userStats_json = (JSONArray) jsonObject.get("userStats");
//			System.out.println(userStats_json.indexOf(userStats_json.get()));
			if (userStats_json.listIterator().hasNext()) {
				userStats_json_teammode = (JSONObject) userStats_json.get(0);
				dto.setRank_solo_mmr(userStats_json_teammode.get("mmr").toString());
				dto.setRank_solo_totalGames(userStats_json_teammode.get("totalGames").toString());
				dto.setRank_solo_totalWins(userStats_json_teammode.get("totalWins").toString());
				dto.setRank_solo_top3(userStats_json_teammode.get("top3").toString());
				dto.setRank_solo_averageRank(userStats_json_teammode.get("averageRank").toString());
				dto.setRank_solo_averageKills(userStats_json_teammode.get("averageKills").toString());
				dto.setRank_solo_averageAssistants(userStats_json_teammode.get("averageAssistants").toString());
			}
			
			if (userStats_json.listIterator().hasNext()) {
				userStats_json_teammode = (JSONObject) userStats_json.get(1);
//				dto.setRank_duo_mmr(userStats_json_teammode.get("mmr").toString());
//				dto.setRank_duo_totalGames(userStats_json_teammode.get("totalGames").toString());
//				dto.setRank_duo_totalWins(userStats_json_teammode.get("totalWins").toString());
//				dto.setRank_duo_top3(userStats_json_teammode.get("top3").toString());
//				dto.setRank_duo_averageRank(userStats_json_teammode.get("averageRank").toString());
//				dto.setRank_duo_averageKills(userStats_json_teammode.get("averageKills").toString());
//				dto.setRank_duo_averageAssistants(userStats_json_teammode.get("averageAssistants").toString());
			}
			
			if (userStats_json.listIterator().hasNext()) {
				userStats_json_teammode = (JSONObject) userStats_json.get(2);
//				dto.setRank_squad_mmr(userStats_json_teammode.get("mmr").toString());
//				dto.setRank_squad_totalGames(userStats_json_teammode.get("totalGames").toString());
//				dto.setRank_squad_totalWins(userStats_json_teammode.get("totalWins").toString());
//				dto.setRank_squad_top3(userStats_json_teammode.get("top3").toString());
//				dto.setRank_squad_averageRank(userStats_json_teammode.get("averageRank").toString());
//				dto.setRank_squad_averageKills(userStats_json_teammode.get("averageKills").toString());
//				dto.setRank_squad_averageAssistants(userStats_json_teammode.get("averageAssistants").toString());
			}
			list.add(dto);
			

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