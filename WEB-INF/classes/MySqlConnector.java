import java.sql.*;

public class MySqlConnector{
	public static Connection getConnection(){
		String url="jdbc:mysql://localhost:3306/leave_management_system";
		String com="com.mysql.jdbc.Driver";
		Connection cn=null;
		try{
			Class.forName(com);
			cn=DriverManager.getConnection(url,"root","");
			return cn;
		}catch(Exception e){
			e.getMessage();
			return cn;
		}
	}
	public static void main(String[] any){
		MySqlConnector.getConnection();
		}
}