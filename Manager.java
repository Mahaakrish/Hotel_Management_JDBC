package pra;
import java.sql.*;
public class Manager {
	Connection con = null;
	Manager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pra","mahaakrish","Mahaan@1997");
			System.out.println("Connected...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	void addStaff(String id,String name,long phno ,String job){
		try {
			Statement st = con.createStatement();
			String qry = "insert into staff value('"+id+"','"+name+"',"+phno+",'"+job+"');";
			st.execute(qry);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	void removeStaff(String id) {
		try {
			Statement st = con.createStatement();
			String qry = "delete from staff where id='"+id+"';";
			st.executeUpdate(qry);
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	void recordComplaint(int gid,String msg) {
		try {
			Statement st = con.createStatement();
			String qry = "insert into complaint value("+gid+",'"+msg+"');";
			st.execute(qry);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
