<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ page import ="com.niran.Beans.*"
             import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<%
HttpSession hs = request.getSession();
if(!"admin@07".equals(hs.getAttribute("email")) || hs.getAttribute("email")==null){
	RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
	rd.forward(request,response);
}
%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
.back {
	background-image: url('') no-repeat center;
	background-size: cover;
	width: 100%;
	height: 100vh;
}

.back::before {
	background-color: rgba(0, 0, 0, 0.6);
	content: "";
	position: absolute;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
}

.navbar-brand {
	font-weight: 500;
	color: #009970;
	font-size: 24px;
	transition: 0.3s color;
}

.login-button {
	background-color: #009970;
	color: #fff;
	font-size: 14px;
	padding: 8px 20px;
	border-radius: 50px;
	text-decoration: none;
	transition: 0.3s background-color;
}

.login-button:hover {
	background-color: #00b383;
}

.navbar-toggler {
	border: none;
	font-size: 1.25rem;
}

.navbar {
	background-color: #fff;
	height: 80px;
	margin: 20px;
	border-radius: 16px;
	padding: 0.5rem;
}

.navbar-toggler:focus, .btn-close:focus {
	box-shadow: none;
	outline: none;
}

.nav-link {
	color: #666777;
	font-weight: 500;
	position: relative;
}

.h-section .container {
	height: 100vh;
	z-index: 1;
	position: relative;
}

.h-section h1 {
	font-size: 1.8em;
}

.h-section h2 {
	font-size: 1.2em;
}

.container1 {
	position: absolute;
	top: 60px;
	left: 120px;
}
</style>
<meta charset="UTF-8">
<title>To-Do | TaskadE</title>
</head>
<body class="back">

	<nav class="navbar navbar-expand-lg fixed-top">
		<div class="container">
			<a class="navbar-brand me-auto" href="#">TaskadE</a>

			<div class="offcanvas offcanvas-end" tabindex="-1"
				id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
				<div class="offcanvas-header">
					<h5 class="offcanvas-title" id="offcanvasNavbarLabel">Offcanvas</h5>
					<button type="button" class="btn-close" data-bs-dismiss="offcanvas"
						aria-label="Close"></button>
				</div>
				<div class="offcanvas-body">
					<ul class="navbar-nav justify-content-center flex-grow-1 pe-3">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="adminHome.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="allTasks">To-Do</a></li>
						<li class="nav-item"><a class="nav-link" href="adminDoing">Doing</a></li>
						<li class="nav-item"><a class="nav-link" href="adminDone">Done</a></li>
						<li class="nav-item"><a class="nav-link" href="users">Users</a></li>
					</ul>
				</div>
			</div>

			<a class="nav-link mx-lg-2" href="#"><%=hs.getAttribute("user")%></a>
			<a href="logout" class="login-button mx-lg-2">Logout</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
				aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
		</div>
	</nav>

    <!-- table starts -->
	<div class="container container1 mt-5 bg-gradient">
		<h2 class="text center text-white p2  text-uppercase">List of
			Tasks</h2>
			<div class="alert alert-primary" role="alert"><%=  hs.getAttribute("alert") %></div>
			
		<table
			class="table table-responsive  border-dark table-hover text-center text-capitalize">
			<tr class="table-dark table-active text-uppercase text-white">
				<th>TaskId</th>
				<th>TaskName</th>
				<th>posted</th>
				<th>description</th>
				<th>edit</th>
			</tr>

			<tr>
			<% List<Task> list=(ArrayList<Task>)hs.getAttribute("record");
              if(list==null){
    	 
    	 %>
  		<td> <%= "no-task"%></td>
  		<td> <%= "no-task"%></td>
  		<td> <%= "no-task"%></td>
  		<td> <%= "no-task"%></td>
  		<td> <a href="#"><button class="btn btn-warning">edit</button></a>
					<a href="#"><button class="btn btn-danger">delete</button></a></td>
  		</tr>
     	 
  <%    }
     else{
    	 
    	 for(Task item:list){
    		 java.util.Date date=new java.util.Date();
    		
    			%>
    			<tr>
    			
    			<td> <%= item.getTaskId()%></td>
    			<td>  <%=item.getTaskName() %></td>
    			<td><%= date%></td>
    			<td><%=item.getTaskDesc() %></td>
    			<td> <a href="#"><button class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#update">edit</button></a>
					<a href="deleteTask?tid=<%= item.getTaskId()%>"><button class="btn btn-danger">delete</button></a></td>
    			</tr>
    			<%    }
     }
	%>
		</table>
		<a href="#"><button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#login">AddTask</button></a>
		
		<form action="allTasks" method="get">
          <input type="submit" value="searchAll"/>
          </form>
		
	</div>
	<!-- Table ends -->
	
	<!-- Popover addTask form -->
	<div class="modal fade" id="login" tabindex="-1"
		aria-labelledby="loginLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="loginLabel">AddTask</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="addTask" method="post">
						<div class="mb-3">
							<label for="uname" class="form-label">TaskId</label> <input
								type="text" name="tid" id="uname" class="form-control"
								required />
						</div>
						<div class="mb-3">
							<label for="pwd" class="form-label">TaskName</label> <input
								type="text" name="tname" id="pwd" class="form-control"
								required />
						</div>
						<div class="mb-3">
							<label for="pwd" class="form-label">TaskDesc</label> <input
								type="text" name="tdesc" id="pwd" class="form-control"
								required />
						</div>
						<div class="d-flex justify-content-between">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="update" tabindex="-1"
		aria-labelledby="loginLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="loginLabel">Update Task</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="editTask" method="post">
						<div class="mb-3">
							<label for="pwd" class="form-label">Task Id (Id should not be changed)</label> <input
								type="text"  name="tid" id="pwd" class="form-control"
								required />
						</div>
						
						<div class="mb-3">
							<label for="pwd" class="form-label">TaskName</label> <input
								type="text"   name="tname" id="pwd" class="form-control"
								required />
						</div>
						<div class="mb-3">
							<label for="pwd" class="form-label">TaskDesc</label> <input
								type="text" name="tdesc" id="pwd" class="form-control"
								required />
						</div>
						<div class="d-flex justify-content-between">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Save changes</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- popover addTask form ends -->
</body>
</html>