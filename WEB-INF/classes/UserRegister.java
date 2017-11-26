import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class UserRegister extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String fullName = (String)request.getParameter("fullName");
		String course = (String)request.getParameter("course");
		String contact = (String)request.getParameter("contact");
		String email = (String)request.getParameter("email");
		String userName = (String)request.getParameter("userName");
		String password = (String)request.getParameter("password");
		String query = "insert into user(Full_Name, Course, Contact, Email,UserName, Password) values('"+fullName+"','"+course+"','"+contact+"','"+email+"','"+userName+"','"+password+"')";
		try{
			Connection cn = MySqlConnector.getConnection();
			Statement stat = cn.createStatement();
			stat.executeUpdate(query);
			out.println("<h3>Register Completed. Thank You!!</h3><br>");
			out.println("<h2><a href='./Index.html'>Click Here to Login</a></h2>");
		}catch(Exception e){
			out.println("<h2>Sorry!!Register Unsuccessfull.</h3><br>Error:"+e.getMessage());
		}
	}
}