package api.curl.gameid.json;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import api.curl.gameid.dto.User_GameinfoDTO;
import api.curl.gameid.jdbc.User_GameinfoJDBC;
import api.curl.gameid.url.User_GameidURI;
import api.curl.language.json.Language_GameInfoJson;
import api.curl.language.uri.Language_GameInfoURI;

public class User_GameinfoJson {
	private User_GameidURI user_Gameiduri;
	private User_GameinfoDTO user_Gameinfodto;
	private User_GameinfoJDBC user_Gameinfojdbc;

	public List<User_GameinfoDTO> read_json(String gameid) {
		JSONObject userGameinfo_json;
		JSONArray userGameinfo_json_arr = null;
		JSONObject userGameinfo_json_arr_obj;
		JSONObject userGameinfo_json_weapon;
		ArrayList<User_GameinfoDTO> list = new ArrayList<User_GameinfoDTO>();
		user_Gameiduri = new User_GameidURI();
		user_Gameinfojdbc = new User_GameinfoJDBC();
		try {
			JSONParser parser = new JSONParser();
			userGameinfo_json = (JSONObject) parser.parse(user_Gameiduri.gameinfo(gameid));
			userGameinfo_json_arr = (JSONArray) userGameinfo_json.get("userGames");
			for (int i = 0; i < userGameinfo_json_arr.size(); i++) {
				user_Gameinfodto = new User_GameinfoDTO();
				userGameinfo_json_arr_obj = (JSONObject) userGameinfo_json_arr.get(i);
				userGameinfo_json_weapon = (JSONObject) userGameinfo_json_arr_obj.get("equipment");
				user_Gameinfodto.setUserNum(userGameinfo_json_arr_obj.get("userNum").toString());
				user_Gameinfodto.setNickname(userGameinfo_json_arr_obj.get("nickname").toString());
				user_Gameinfodto.setGameid(userGameinfo_json_arr_obj.get("gameId").toString());
				user_Gameinfodto.setMatchingMode(userGameinfo_json_arr_obj.get("matchingMode").toString());
				user_Gameinfodto.setMatchingTeamMode(userGameinfo_json_arr_obj.get("matchingTeamMode").toString());
				user_Gameinfodto.setCharacterNum(userGameinfo_json_arr_obj.get("characterNum").toString());
				user_Gameinfodto.setSkinCode(userGameinfo_json_arr_obj.get("skinCode").toString() );
				user_Gameinfodto.setCharacterLevel(userGameinfo_json_arr_obj.get("characterLevel").toString());
				user_Gameinfodto.setGameRank(userGameinfo_json_arr_obj.get("gameRank").toString());
				user_Gameinfodto.setPlayerKill(userGameinfo_json_arr_obj.get("playerKill").toString());
				user_Gameinfodto.setMonsterKill(userGameinfo_json_arr_obj.get("monsterKill").toString());
				user_Gameinfodto.setPlayerAssistant(userGameinfo_json_arr_obj.get("playerAssistant").toString());
				user_Gameinfodto.setMmrBefore(userGameinfo_json_arr_obj.get("mmrBefore").toString());
				user_Gameinfodto.setMmrGain(userGameinfo_json_arr_obj.get("mmrGain").toString());
				user_Gameinfodto.setGameRank(userGameinfo_json_arr_obj.get("gameRank").toString());
				user_Gameinfodto.setDamageToPlayer(userGameinfo_json_arr_obj.get("damageToPlayer").toString());
				user_Gameinfodto.setDamageToMonster(userGameinfo_json_arr_obj.get("damageToMonster").toString());
				if(userGameinfo_json_weapon.get("0") != null) {
					user_Gameinfodto.setEquipment_0(userGameinfo_json_weapon.get("0").toString());
				} else {
					user_Gameinfodto.setEquipment_0("0");
				}
				if(userGameinfo_json_weapon.get("1") != null) {
					user_Gameinfodto.setEquipment_1(userGameinfo_json_weapon.get("1").toString());
				} else {
					user_Gameinfodto.setEquipment_1("0");
				}
				if(userGameinfo_json_weapon.get("2") != null) {
					user_Gameinfodto.setEquipment_2(userGameinfo_json_weapon.get("2").toString());
				} else {
					user_Gameinfodto.setEquipment_2("0");
				}
				if(userGameinfo_json_weapon.get("3") != null) {
					user_Gameinfodto.setEquipment_3(userGameinfo_json_weapon.get("3").toString());
				} else {
					user_Gameinfodto.setEquipment_3("0");
				}
				if(userGameinfo_json_weapon.get("4") != null) {
					user_Gameinfodto.setEquipment_4(userGameinfo_json_weapon.get("4").toString());
				} else {
					user_Gameinfodto.setEquipment_4("0");
				}
				if(userGameinfo_json_weapon.get("5") != null) {
					user_Gameinfodto.setEquipment_5(userGameinfo_json_weapon.get("5").toString());
				} else {
					user_Gameinfodto.setEquipment_5("0");
				}
				user_Gameinfojdbc.insert_gameinfo_sql(user_Gameinfodto.getGameid(), user_Gameinfodto.getNickname(),
						user_Gameinfodto.getUserNum(), user_Gameinfodto.getGameRank(),
						user_Gameinfodto.getCharacterLevel(), user_Gameinfodto.getMmrBefore(),
						user_Gameinfodto.getMmrGain(), user_Gameinfodto.getDamageToMonster(),
						user_Gameinfodto.getDamageToMonster(), user_Gameinfodto.getPlayerKill(),
						user_Gameinfodto.getPlayerAssistant(), user_Gameinfodto.getMonsterKill(),
						user_Gameinfodto.getCharacterNum(), user_Gameinfodto.getSkinCode(),
						user_Gameinfodto.getEquipment_0(), user_Gameinfodto.getEquipment_1(),
						user_Gameinfodto.getEquipment_2(), user_Gameinfodto.getEquipment_3(),
						user_Gameinfodto.getEquipment_4(),user_Gameinfodto.getEquipment_5());
				System.out.println("닉네임 : " + user_Gameinfodto.getNickname());
				System.out.println("유저번호 : " + user_Gameinfodto.getUserNum());
				System.out.println("게임번호 : " + user_Gameinfodto.getGameid());
				System.out.println("케릭번호 : "+user_Gameinfodto.getCharacterNum());
				System.out.println("스킨번호 : " + user_Gameinfodto.getSkinCode());
				System.out.println("게임등수 : "+user_Gameinfodto.getGameRank());
				System.out.println("K : "+user_Gameinfodto.getPlayerKill());
				System.out.println("A : "+user_Gameinfodto.getPlayerAssistant());
				System.out.println("H : "+user_Gameinfodto.getMonsterKill());
				System.out.println("딜량 : "+user_Gameinfodto.getDamageToPlayer());
				System.out.println("동물 딜량 :"+user_Gameinfodto.getDamageToMonster());
				System.out.println("장착무기 0번 : "+user_Gameinfodto.getEquipment_0());
				System.out.println("장착무기 1번 : "+user_Gameinfodto.getEquipment_1());
				System.out.println("장착무기 2번 : "+user_Gameinfodto.getEquipment_2());
				System.out.println("장착무기 3번 : "+user_Gameinfodto.getEquipment_3());
				System.out.println("장착무기 4번 : "+user_Gameinfodto.getEquipment_4());
				System.out.println("장착무기 5번 : "+user_Gameinfodto.getEquipment_5());
				System.out.println("MMR : "+user_Gameinfodto.getMmrBefore()+"+"+user_Gameinfodto.getMmrGain());
				list.add(user_Gameinfodto);
			}
			System.out.println("---------------------------------------------------------한판");
			user_Gameinfojdbc.autoclose_jdbc();
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}
