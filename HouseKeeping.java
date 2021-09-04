package pra;
import java.sql.*;
public class HouseKeeping {
	Connection con = null;
	public HouseKeeping() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pra","mahaakrish","Mahaan@1997");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	void cleanRoom(int roomid) {
		try {
			Statement st = con.createStatement();
			String qry = "update room set clean='yes' where id="+roomid+";";
			st.executeUpdate(qry);
			System.out.println("Room cleaned...");
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}
