<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<% HttpSession hs=request.getSession();%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
 crossorigin="anonymous">
<style>
.back{
	
	background-image:url('') no-repeat center;
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
<title>Register | TaskadE</title>

</head>
<body class="back">
	<div class="container mt-2 pt-5">
		<div class="row">
			<div class="col-12 col-sm-8 col-md-5 m-auto">
				<div class="card">

					<div class="card-body">
						<h4 class="text-center">Register</h4>
                              <div class="alert alert-primary" role="alert"><%=hs.getAttribute("message") %></div>


						<form class="row g-3" method="post" action="register">
							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">FistrName</label> <input
									type="text"  name="fname" class="form-control" id="inputEmail4">
							</div>
							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">LastName</label>
								<input type="text" name="lname" class="form-control" id="inputPassword4">
							</div>
							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Email</label> <input
									type="text"  name="email" class="form-control" id="inputEmail4">
							</div>
							
							<div class="col-md-6">
								<label for="inputPassword" class="form-label" >Password</label> <input
									type="password" name="pwd" class="form-control" id="inputCity">
							</div>
							<div class="col-md-4">
								<label for="inputState" class="form-label">Your role</label> <select
									id="inputState"  name="role" class="form-select">
									<option selected>Choose...</option>
									<option>Java Developer</option>
									<option>Python Developer</option>
									<option>FullStack with MERN</option>
									<option>Tester Selenium</option>
									<option>Tester </option>
									<option>Digital marketing SEO</option>
									<option>Full stack JAVA</option>
									<option>UI/UX design</option>
									<option>Networking</option>
									<option>AI python</option>
									<option>A1/ML python Analyst</option>
									
								</select>
							</div>
							<div class="col-md-6">
								<label for="inputPassword" class="form-label">Mobile</label> <input
									type="text" name="phone" class="form-control" id="inputCity">
							</div>
							<div class="col-12">
								<div class="form-check">
									<input class="form-check-input" type="checkbox" id="gridCheck">
									<label class="form-check-label" for="gridCheck"> Check
										me out </label>
								</div>
							</div>
							<div class="text-center mt-8 ">
								<button type="submit" class="btn btn-primary">Register</button>
								<div id="emailHelp" class="form-text">
									Are you a user?<a href="login.jsp">Login</a>
								</div>
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>







</body>
</html>