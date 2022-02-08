package api.curl.rank.dto;

public class User_RankDTO {
	private String userNum;
	private String mmr;
	private String nickname;
	private String rank;
	@Override
	public String toString() {
		return "User_RankDTO [userNum=" + userNum + ", mmr=" + mmr + ", nickname=" + nickname + ", rank=" + rank + "]";
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getMmr() {
		return mmr;
	}
	public void setMmr(String mmr) {
		this.mmr = mmr;
	}
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
}
