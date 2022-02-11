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
