<%@ page import = "java.sql.*" %>
<%@ page import = "java.io.*" %>
<%@ page import = "javax.servlet.*"%>
<%@ page import = "javax.servlet.http.*" %>

<html>
	<head>
		<title>Home</title>
	</head>

	<body>
		<%
			if(session.getAttribute("uName") == null){
				response.sendRedirect("Index.html");
			}
			String userName = (String)session.getAttribute("uName");
			String con = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/leave_management_system";
			String query = "select * from user where UserName = '"+userName+"'";
			ResultSet rs;
			Statement stat;
			try{
				Connection cn;
				Class.forName(con);
				cn = DriverManager.getConnection(url,"root","");
				stat = cn.createStatement();
				rs = stat.executeQuery(query);
				while(rs.next()){
					String fullName = rs.getString("Full_Name");
					String course = rs.getString("Course");
					String contact = rs.getString("Contact");
					String email = rs.getString("Email");
				}				
			}catch(Exception e){
				out.println("Error:"+e.getMessage());
			}
		%>
		<%= "welcome "+userName %>
		

		<br>
		<form name = "logout" action = "./UserLogout">
    			<input type = "submit" value = "Logout">
    	 </form>
		<hr>
		<ul>
			<li><a href="./Home.jsp">Home</a></li>
			<li><a href="./Activity Feed.jsp">Activity Feed</a></li>
			<li><a href="./Profile.jsp">Profile</a></li>
		</ul>
	</body>
</html>