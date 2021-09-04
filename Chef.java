package pra;
import java.sql.*;
public class Chef {
	Connection con = null;
	Chef(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pra","mahaakrish","Mahaan@1997");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	void takeOrder(int fid,int gid) {
		try {
			System.out.println("Food is being prepared..");
			Statement st = con.createStatement();
			String qry1 = "select price from food where id="+fid+";";
			ResultSet rs= st.executeQuery(qry1);
			rs.next();
			int price = rs.getInt(1);
			String qry = "update bill set fprice=fprice+"+price+" where gid="+gid+";";
			st.executeUpdate(qry);
			System.out.println("Food delivered...");
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}
