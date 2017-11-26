<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>User Information</title>
	</head>

	<body>
		<table>
			<tr>
				<td>FullName</td>
				<td>Course</td>
				<td>Contact</td>
				<td>Email</td>
				<td>UserName</td>
				<td>Password</td>
			</tr>
			<c:forEach items = "${ur}" var = "gg">
				<tr>
					<td>${gg.fullName}</td>
					<td>${gg.course}</td>
					<td>${gg.contact}</td>
					<td>${gg.email}</td>
					<td>${gg.userName}</td>
					<td>${gg.password}</td>
					<td><a href="./DeleteUser?id=${gg.userName}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>	
	</body>
</html>