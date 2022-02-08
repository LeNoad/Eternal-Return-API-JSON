package api.curl.test;

import java.util.List;

import api.curl.curl.usernum.dto.User_UsernumDTO;
import api.curl.curl.usernum.json.JsonFromAPI_usernum;
import api.curl.curl.usernum.url.User_UsernumURI;
import api.curl.gameid.dto.User_GameidDTO;
import api.curl.gameid.json.User_GameidJson;
import api.curl.gameid.json.User_GameidNextJson;
import api.curl.stats.dto.User_StatsDTO;
import api.curl.stats.json.JsonFromAPI_stats;
import api.curl.toprank.dto.User_TopRankDTO;
import api.curl.toprank.json.JsonFromAPI_toprank;

public class Test_Main {
	public static void main(String[] args) {
		User_GameidJson gameid_json = new User_GameidJson();
		User_GameidNextJson gameidnext_json = new User_GameidNextJson();
		// 닉네임 입력 하면 3개월치 전적의 상세검색
		List<User_GameidDTO> list = gameid_json.read_json("Hardbread");
		int lastindex = list.size() - 1;
		String lastGameid = list.get(lastindex).getGameId();
		do {
			// 닉네임 입력 하면 3개월치 전적의 상세검색
			List<User_GameidDTO> nextlist = gameidnext_json.readnext_json(lastGameid, "Hardbread");
			lastindex = nextlist.size() - 1;
			if (lastindex == -1) {
				break;
			} else {
				lastGameid = nextlist.get(lastindex).getGameId();
			}

		} while (true);
	}
}
//		JsonFromAPI_toprank json = new JsonFromAPI_toprank();
//		
//		List<User_TopRankDTO> list = json.read_json();
//		
//		for (int i = 0; i < 15; i++) {
//			User_TopRankDTO dto = list.get(i);
//			System.out.println(dto.getMmr());
//			System.out.println(dto.getNickname());
//			System.out.println(dto.getRank());
//		}
//		JsonFromAPI json = new JsonFromAPI();
//		List<User_RankDTO> list = json.read_json(798740);
//		User_RankDTO dto = list.get(0);
//		System.out.println(dto.getMmr());
//		System.out.println(dto.getNickname());
//		System.out.println(dto.getRank());
//		System.out.println(dto.getUserNum());

//		JsonFromAPI_toprank json = new JsonFromAPI_toprank();
//		List<User_TopRankDTO> list = json.read_json();

//		for (int i = 0; i < 300; i++) {
//			User_TopRankDTO dto = list.get(i);
//			System.out.println(dto.getMmr());
//			System.out.println(dto.getNickname());
//			System.out.println(dto.getRank());
//		}
//		JsonFromAPI_usernum usernum_json = new JsonFromAPI_usernum();
//		JsonFromAPI_stats json = new JsonFromAPI_stats();
//		
//		List<User_UsernumDTO> usernum_list = usernum_json.read_json("lenoad");
//		User_UsernumDTO usernum_dto = usernum_list.get(0);
//		List<User_StatsDTO> list = json.read_json(Integer.parseInt(usernum_dto.getUserNum()));
//		
//		System.out.println("------------------------INFO-------------------------");
//		System.out.println(usernum_dto.getNickname());
//		System.out.println(usernum_dto.getUserNum());
//		System.out.println("------------------------SOLO-------------------------");
//		User_StatsDTO dto = list.get(0);
//		System.out.println(dto.getRank_solo_mmr());
//		System.out.println(dto.getRank_solo_top3());
//		System.out.println(dto.getRank_solo_totalGames());
//		System.out.println(dto.getRank_solo_totalWins());
//		System.out.println(dto.getRank_solo_averageAssistants());
//		System.out.println(dto.getRank_solo_averageKills());
//		System.out.println(dto.getRank_solo_averageRank());
//		System.out.println("------------------------DUO--------------------------");
//		System.out.println(dto.getRank_duo_mmr());
//		System.out.println(dto.getRank_duo_top3());
//		System.out.println(dto.getRank_duo_totalGames());
//		System.out.println(dto.getRank_duo_totalWins());
//		System.out.println(dto.getRank_duo_averageAssistants());
//		System.out.println(dto.getRank_duo_averageKills());
//		System.out.println(dto.getRank_duo_averageRank());
//		System.out.println("-----------------------SQUAD-------------------------");
//		System.out.println(dto.getRank_squad_mmr());
//		System.out.println(dto.getRank_squad_top3());
//		System.out.println(dto.getRank_squad_totalGames());
//		System.out.println(dto.getRank_squad_totalWins());
//		System.out.println(dto.getRank_squad_averageAssistants());
//		System.out.println(dto.getRank_squad_averageKills());
//		System.out.println(dto.getRank_squad_averageRank());
