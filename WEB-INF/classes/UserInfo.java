import java.util.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserInfo extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String query = "select * from user";
		try{
			Connection cn = MySqlConnector.getConnection();
			Statement stat = cn.createStatement();
			ResultSet rs = stat.executeQuery(query);
			List<UserDto> userArr = new ArrayList<UserDto>();
			while(rs.next()){
				UserDto user = new UserDto();
				user.setFullName(rs.getString("Full_Name"));
				user.setCourse(rs.getString("Course"));
				user.setContact(rs.getString("Contact"));
				user.setEmail(rs.getString("Email"));
				user.setUserName(rs.getString("UserName"));
				user.setPassword(rs.getString("Password"));
				userArr.add(user);
			}
			request.setAttribute("ur",userArr);
			RequestDispatcher rd = request.getRequestDispatcher("./UserInfo.jsp");
			rd.include(request,response);
		}catch(Exception e){
			out.println("Error: "+ e.getMessage());
		}
	}
}