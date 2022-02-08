package api.curl.toprank.dto;

public class User_TopRankDTO {
	private String nickname;
	private String rank;
	private String mmr;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getMmr() {
		return mmr;
	}
	public void setMmr(String mmr) {
		this.mmr = mmr;
	}
	
}
