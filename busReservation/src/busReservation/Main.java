package busReservation;
// import java.util.*;
import java.sql.*;

public class Main {
	public static void main(String[] args) throws SQLException {
		readRecords();
	}
	public static void readRecords() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/busReservation";
		String user = "root";
		String pass = "johny";
		String query = "select * from busDetails;";
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			System.out.println("Id :" + rs.getInt(1));
			System.out.println("Cpacity :" + rs.getInt(2));
			System.out.println("AC :" + rs.getBoolean(3));
			System.out.println("Route :" + rs.getInt(4));
			System.err.println("\n-----------------------------------------------------------------------------------------------------\n");
		}
		con.close();
	}
	
	// insert Record
	
	public static void insertRecords() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/busReservation";
		String user = "root";
		String pass = "johny";
		String query = "insert into busDetails values(16117001,32,true,117);";
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement st = con.createStatement();
		int rows = st.executeUpdate(query);
		System.out.println("No of tables affected :" + rows);		
		con.close();
	}
	
	// Prepared Statement
	
	public static void insertPrep() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/busReservation";
		String user = "root";
		String pass = "johny";
		String query = "insert into busDetails values(?,?,?,?);";
		int busNo = 16118001;
		int capacity = 45;
		boolean ac = true;
		int route = 118;
		Connection con = DriverManager.getConnection(url, user, pass);
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, busNo);
		st.setInt(2, capacity);
		st.setBoolean(3, ac);
		st.setInt(4, route);
		int rows = st.executeUpdate();
		System.out.println("No of tables affected :" + rows);		
		con.close();
	}
	
	// Delete values 
	
	public static void deleteRecord() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/busReservation";
		String user = "root";
		String pass = "johny";
		int busNo = 16115002;
		String query = "delete from busDetails where busNo = " + busNo;
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement st = con.createStatement();
		int rows = st.executeUpdate(query);
		System.out.println("No of tables affected :" + rows);		
		con.close();
	}
	
}