import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class UserLogin extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = (String)request.getParameter("username");
		String password = (String)request.getParameter("password");
		String userQuery = "SELECT * from user where UserName='"+userName+"' and Password = '"+password+"'";
		String adminQuery = "SELECT * from admin where UserName='"+userName+"'and Password = '"+password+"'";
		try{
			HttpSession session = request.getSession();
			Connection cn = MySqlConnector.getConnection();
			Statement stat1 = cn.createStatement();
			Statement stat2 = cn.createStatement();
			ResultSet rsUser, rsAdmin;
			RequestDispatcher rd;
			rsUser = stat1.executeQuery(userQuery);
			rsAdmin = stat2.executeQuery(adminQuery);	

			/*
			//checks if the normal user has logged in
			while(rsUser.next()){
				if(userName.equals(rsUser.getString("UserName")) && password.equals(rsUser.getString("Password"))){
					session.setAttribute("uName",userName);
					rd = request.getRequestDispatcher("./Home.jsp");
					//request.setAttribute("uName",userName);
					//rd.include(request, response);
					response.sendRedirect("./Home.jsp");
				}
				else{
					out.println("<h3>Login UnSuccessfull. Either Username or Password is invalid. <a href = "+"./Index.html>Please try again</a>.</h3>");
				}
			}
		

			//checks if the admin has logged in
			while(rsAdmin.next()){
				if(userName.equals(rsAdmin.getString("UserName")) && password.equals(rsAdmin.getString("Password"))){
					session.setAttribute("uName",userName);
					rd = request.getRequestDispatcher("./AdminHome.jsp");
					//request.setAttribute("uName",userName);
					//rd.include(request, response);
					response.sendRedirect("./AdminHome.jsp");
				}
				else{
					out.println("<h3>Login UnSuccessfull. Either Username or Password is invalid. <a href = "+"./Index.html>Please try again</a>.</h3>");
				}
			}
			*/
			if(rsUser.next()){
				rd = request.getRequestDispatcher("./Home.jsp");
				request.setAttribute("uName",userName);
				rd.include(request , response);
			}
			else if(rsAdmin.next()){
				rd = request.getRequestDispatcher("./AdminHome.jsp");
				request.setAttribute("uName",userName);
				rd.include(request , response);
			}
			else{
				out.println("<h3>Login UnSuccessfull. Either Username or Password is invalid. <a href = "+"./Index.html>Please try again</a>.</h3>");		
			}	
		} catch(Exception e){
			out.println("Internal Error!!"+e.getMessage());
			out.println("<br><a href = "+"./Index.html"+">Click here to Login again<a>");
		}
	}
}