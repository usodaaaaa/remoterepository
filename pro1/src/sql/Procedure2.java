package sql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Procedure2 {

	public Boolean createlist(java.util.Date ptime,int movie,String roomid) {
		try(Connection conn= DriverManager.getConnection(url,username,password);
				PreparedStatement pre=conn.prepareStatement(sqlinsertplaylist);) {
			
			pre.setDate(1,new java.sql.Date(ptime.getTime()));
			pre.setInt(2, movie);
			pre.setString(3, roomid);
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Boolean createmovie(java.util.Date ptime,int movie,String roomid)   {
		
		this.createlist(ptime, movie, roomid);
//		
		Boolean result=false;
		Sqlm_roomVO rVO=this.selectm_room(roomid);		
		if(rVO.getRoomid().equals(roomid)){
//			
			String storeprocedru="{call creatseats(?,?,?)}";
			
			try (Connection conn= DriverManager.getConnection(url,username,password);
					CallableStatement callst=conn.prepareCall(storeprocedru)){
	
				callst.setDate(1, new java.sql.Date(ptime.getTime()));
				callst.setInt(2,movie);
				callst.setString(3, roomid);
				result=callst.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
		}
		return result;
	}
	private static String url="jdbc:sqlserver://localhost:1433;databaseName=movie";        
	private String username="sa";
	private String password="passw0rd";
	private static final String sql="select*from m_room where roomid=?";
	private static final String sqlcreatseat="insert into seats (ptime,movie,seat_num,sold,custid) values(?,?,?,?,?)";
	private static final String sqlinsertplaylist="insert into playlist (ptime,movie,roomid) values(?,?,?)";
	
	
	
	public Sqlm_roomVO selectm_room(String roomid) {
		Sqlm_roomVO result=null;
		try (Connection conn=DriverManager.getConnection(url,username,password);
				PreparedStatement pre= conn.prepareStatement(sql)){
			
			pre.setString(1, roomid);
			ResultSet re=pre.executeQuery();
			result=new Sqlm_roomVO();
			if(re.next()){
				result.setRoomid(re.getString("roomid"));
				result.setSeat_row(re.getInt("seat_row"));
				result.setSeat_col(re.getInt("seat_col"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) throws SQLException {
		Procedure2 mova =	new Procedure2();
		java.util.Date c=new java.util.Date();
		mova.createmovie(new java.sql.Date(c.getTime()), 2,"A�U");
	}
}
