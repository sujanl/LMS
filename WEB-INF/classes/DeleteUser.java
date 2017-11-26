import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DeleteUser extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String value = request.getParameter("id");
		String query = "delete from user where UserName='"+value+"'"	;
		try{
			Connection cn = MySqlConnector.getConnection();
			Statement stat = cn.createStatement();
			stat.executeUpdate(query);
			RequestDispatcher rd = request.getRequestDispatcher("/UserInfo");
			rd.include(request, response);
		}catch(Exception e){
			out.println(e.getMessage());
		}
	}
}