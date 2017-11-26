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
		%>
		<% String adminName = (String)session.getAttribute("uName"); %>
		<%= "welcome "+adminName %>
		<hr>
		<br><a href = ''>View Leave Request</a>
		<br><a href = './UserInfo'>User Info</a>
		<br><a href = ''>Admin Info</a>
		<br><a href = ''>Add New Admin</a>
		
	</body>
</html>