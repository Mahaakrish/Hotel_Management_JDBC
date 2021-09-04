package pra;
import java.sql.*;
public class Recieptionist {
	static Connection con = null;
	public Recieptionist() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pra","mahaakrish","Mahaan@1997");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	static int checkRoomStatus(){
		int rid=0;
		try {
			HouseKeeping h = new HouseKeeping();
			Statement st = con.createStatement();
			String qry = "select id,clean from room where vacant='yes';";
			ResultSet rs= st.executeQuery(qry);
			rs.next();
			rid = rs.getInt(1);
			h.cleanRoom(rid);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rid;
	}
	void bookRoom(int gid,String name,int phno,String addr) {
		int rid=checkRoomStatus();
		if(rid!=0) {
			try {
				System.out.println(rid+" assigned");
				Statement st = con.createStatement();
				String qry1 = "insert into guest value("+gid+",'"+name+"',"+phno+",'"+addr+"',"+rid+");";
				String qry2 = "update room set vacant='no' where id="+rid+";";
				generateBill(gid,rid);
				st.execute(qry1);
				st.executeUpdate(qry2);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Rooms full;");
		}
	}
	static void generateBill(int gid,int rid) {
		try {
			Statement st = con.createStatement();
			String qry1 = "select count(*) from bill;";
			ResultSet rs= st.executeQuery(qry1);
			rs.next();
			int bid = rs.getInt(1)+1;
			String qry2 = "select price from room where id="+rid+";";
			rs= st.executeQuery(qry2);
			rs.next();
			int price = rs.getInt(1);
			String qry3 = "insert into bill value("+bid+","+gid+","+price+",'no');";
			st.execute(qry3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	void acceptFeedback(int gid,String msg) {
		try {
			Statement st = con.createStatement();
			String qry = "insert into feedback value("+gid+",'"+msg+"');";
			st.execute(qry);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
