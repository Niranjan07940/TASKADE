<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
	pageEncoding="UTF-8"%>
	<%@ page import ="com.niran.Beans.*"
             import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

<% HttpSession hs=request.getSession();
List<Task> list=(ArrayList<Task>)hs.getAttribute("record");
     if(list==null){
    	 
    	 %>
    	 <div class="alert alert-primary" role="alert"><%= "no tasks has been added yet" %></div>
    	<ul>
    	
  		<li> <%= "nothing"+" "+"nothing"+" "+"nothing" %></li>
  		</ul>
     	 
  <%    }
     else{
    	 for(Task item:list){
    			%>
    			<div class="alert alert-primary" role="alert"><%= "tasks fetched successfully" %></div>
    			<ul>
    			<li> <%= item.getTaskId()+" "+item.getTaskName()+" "+item.getTaskDesc() %></li>
    			</ul>
    			<% }
     }
	
	
	%>
	

	
</body>
</html>