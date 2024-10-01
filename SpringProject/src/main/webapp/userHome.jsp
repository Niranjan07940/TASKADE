<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%HttpSession hs=request.getSession();
if(hs.getAttribute("email")==null){
	RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
	rd.forward(request,response);
}
%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
 crossorigin="anonymous">
<style>
.back{
	
	background-image:url('backgroung.jpg') no-repeat center;
	background-size:cover;
	width:100%;
	height:100vh;

}
.back::before{
	background-color:rgba(0,0,0,0.6);
	content:"";
	position:absolute;
	top:0;
	right:0;
	bottom:0;
	left:0;
	
}
.navbar-brand{
	font-weight:500;
	color:#009970;
	font-size:24px;
	transition:0.3s color;
}
.login-button{
	background-color:#009970;
	color:#fff;
	font-size:14px;
	padding:8px 20px;
	border-radius:50px;
	text-decoration:none;
	transition:0.3s background-color;
}
.login-button:hover{
	background-color:#00b383;
}

.navbar-toggler{
	border:none;
	font-size:1.25rem;
}
.navbar{
	background-color:#fff;
	height:80px;
	margin:20px;
	border-radius:16px;
	padding:0.5rem;
}
.navbar-toggler:focus, .btn-close:focus{
	box-shadow:none;
	outline:none;
}
.nav-link{
	color:#666777;
	font-weight:500;
	position:relative;
}
.h-section .container{
	height:100vh;
	z-index:1;
	position:relative;
}
.h-section h1{
	font-size:1.8em;
}
.h-section h2{
	font-size:1.2em;
}



</style>
<meta charset="UTF-8">
<title>User | TaskadE</title>
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
							aria-current="page" href="userHome.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="userTasks">To-Do</a></li>
						<li class="nav-item"><a class="nav-link" href="doingit">Doing</a></li>
						<li class="nav-item"><a class="nav-link" href="doneit">Done</a></li>
						
						
					</ul>
				</div>
			</div>
			
			<a class="nav-link mx-lg-2" href="#"><%=hs.getAttribute("user") %></a>
			<a href="logout" class="login-button mx-lg-2">Logout</a>
			
			<button class="navbar-toggler" type="button"
				data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
				aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
		</div>
		
	</nav>
	
	<section class="h-section">
	
	<div class=" container d-flex align-items-center justify-content-center fs-1 text-white flex-column ">
	<div class="alert alert-primary" role="alert"><%=  hs.getAttribute("message") %></div>
	<h1>TaskadE</h1>
	<h2>To do: Prepare. Doing: Execute. Done: Celebrate</h2>
	<h3>Welcome User:<%=hs.getAttribute("user") %></h3>
	
			
	
	</div>
	
	
	</section>
	

</body>
</html>