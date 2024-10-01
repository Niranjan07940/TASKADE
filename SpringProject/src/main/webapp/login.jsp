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
<title>Login | TaskadE</title>
</head>
<body class="back">


	<div class="container mt-2 pt-5">
		<div class="row">
			<div class="col-12 col-sm-8 col-md-5 m-auto">
				<div class="card">

					<div class="card-body">
						<h4 class="text-center">Login</h4>
						<h2 class="text-center">Login as user/admin</h2>
						<div class="alert alert-primary" role="alert"><%=hs.getAttribute("message") %></div>
						<form class="mx-auto" action="login" method="post">
							<div class="mb-3 mt-3">
								<label for="exampleInputEmail1" class="form-label">Email
									address/username</label> <input type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="email">

							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" class="form-control"
									id="exampleInputPassword1" name="pwd">
								<div id="emailHelp" class="form-text">Forgot password?</div>
							</div>
							<div class="text-center mt-4">
								<button type="submit" class="btn btn-primary">Login</button>
								<div id="emailHelp" class="form-text">
									Aren't a user?<a href="register.jsp">Register</a>
								</div>`
							</div>
						</form>

					</div>

				</div>

			</div>
		</div>

	</div>




</body>
</html>