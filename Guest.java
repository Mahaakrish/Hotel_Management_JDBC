package pra;
import java.sql.*;
public class Guest {
	static Connection con = null;
	Guest(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pra","mahaakrish","Mahaan@1997");
			System.out.println("Connected...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	void checkIn(int id,String name,int phno,String addr) {
		Recieptionist r =new Recieptionist();
		r.bookRoom(id, name, phno, addr);
	}
	void checkOut(int gid) {
		try {
			Statement st = con.createStatement();
			String qry1 = "select paystat from bill where gid="+gid+";";
			ResultSet rs= st.executeQuery(qry1);
			rs.next();
			String stat = rs.getString(1);
			if(stat=="no")
				payBill(gid);
			String qry2 = "update room set vacant='yes' where id=(select roomid from guest where id="+gid+");";
			st.executeUpdate(qry2);
			String qry3 = "delete from guest where id="+gid+";";
			st.executeUpdate(qry3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static void payBill(int gid) {
		try {
			Statement st = con.createStatement();
			String qry = "update bill set paystat='yes' where gid="+gid+";";
			st.executeUpdate(qry);
			System.out.println("Bill paid...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	void orderFood(int gid,int fid) {
		Chef c = new Chef();
		c.takeOrder(fid, gid);
	}
	void submitFeedback(int gid,String msg) {
		Recieptionist r = new Recieptionist();
		r.acceptFeedback(gid, msg);
	}
	void complain(int gid,String msg) {
		Manager m = new Manager();
		m.recordComplaint(gid, msg);
	}
}
