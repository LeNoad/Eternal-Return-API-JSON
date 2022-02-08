package api.curl.gameid.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class User_GameinfoJDBC {
	private Connection conn = null;
	private Statement stmt_usergameinfo;
	private ResultSet rss_usergameinfo;
	
	private static final String db_id = "";
	private static final String db_password = "";
	private static final String db_path = "";
	
	public User_GameinfoJDBC() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("[MariaDB Find Class Success]");
			conn = DriverManager.getConnection(db_path,db_id,db_password);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void autoclose_jdbc() {
		try {
			if (rss_usergameinfo != null) {
				rss_usergameinfo.close();
			}
			if (stmt_usergameinfo != null) {
				stmt_usergameinfo.close();
			}
			if (conn != null) {
				conn.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("[MariaDB Connect Close]");
		}
	}
	public void insert_gameinfo_sql(String gameId, String nickname, String userNum, String gameRank, String characterLevel,
			String mmrBefore,String mmrGain, String damageToPlayer, String damageToMonster, String playerKill,
			String playerAssistant, String monsterKill, String characterNum, String skinCode, String equipment_0,
			String equipment_1, String equipment_2, String equipment_3, String equipment_4, String equipment_5) {
		String insert_gameinfo_sql = "insert into gameinfo_data"
				+ "(gameId, nickname, userNum, gameRank, characterLevel, mmrBefore, mmrGain,"
				+ "damageToPlayer, damageToMonster, playerKill, playerAssistant, monsterKill,"
				+ "characterNum, skinCode, equipment_0, equipment_1, equipment_2, equipment_3,"
				+ "equipment_4, equipment_5) Values ('"+gameId+"', '"+nickname+"', '"+userNum+"', '"+gameRank+"', '"+characterLevel+"', '"+
				mmrBefore+"', '"+mmrGain+"', '"+damageToPlayer+"', '"+damageToMonster+"', '"+playerKill+"', '"+
				playerAssistant+"', '"+monsterKill+"', '"+characterNum+"', '"+skinCode+"', '"+equipment_0+"', '"+
				equipment_1+"', '"+equipment_2+"', '"+equipment_3+"', '"+equipment_4+"', '"+equipment_5+"');";
			try {
				stmt_usergameinfo = conn.createStatement();
				rss_usergameinfo = stmt_usergameinfo.executeQuery(insert_gameinfo_sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
