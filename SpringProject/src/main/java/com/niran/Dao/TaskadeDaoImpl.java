package com.niran.Dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.niran.Beans.Task;
import com.niran.Beans.User;



import java.util.*;
@Repository
public class TaskadeDaoImpl implements TaskadeDao {
	
    @Autowired
	private JdbcTemplate jdbcTemplate;
	public String userRegisterDao(User user) {
		String status="";
		try {
			Object arr[]= {user.getFname(),user.getLname(),user.getEmail(),user.getPwd(),user.getRole(),user.getMobile()};
			int x=jdbcTemplate.update("insert into registration values(?,?,?,?,?,?)",arr);
			if(x==1) {
				status="success";
			}
			else {
				status="failure";
			}
		}
		catch(Exception e) {
			status="failure";
			e.printStackTrace();
			}
		
		return status;
	}
	@Override
	public User userLogiinDao(String email) {
		
			
		List<User> l=jdbcTemplate.query("select *from Registration where email='"+email+"'",(rs,rowNum)->{
				User user = new User();
				user.setFname(rs.getString(1));
				user.setLname(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPwd(rs.getString(4));
				user.setRole(rs.getString(5));
				user.setMobile(rs.getString(6));
				return user;
			});
		return l.isEmpty()?null:l.get(0);
		
	}
	@Override
	public String addTaskDao(Task task) {
		String status="";
		try {
			Object arr[]= {task.getTaskId(),task.getTaskName(),task.getTaskDesc()};
			int x=jdbcTemplate.update("insert into addTask values(?,?,?)",arr);
			if(x==1) {
				status="success";
			}
			else {
				status="failure";
			}
			
		}
		catch(Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public List<Task> getAlltasksDao() {
		List<Task> tasks=jdbcTemplate.query("select *from addTask", (rs,rowNum)->{
			Task t=new Task();
			t.setTaskId(rs.getString(1));
			t.setTaskName(rs.getString(2));
			t.setTaskDesc(rs.getString(3));
			return t;
			
		});
		return tasks;
	}
	
	public String deleteTaskDao(String tid) {
		String status="";
		try {
			int x=jdbcTemplate.update("delete from addTask where taskId='"+tid+"'");
			if(x==1) {
				status="success";
				}
			else {
				status="failure";
			}
			}
		catch(Exception e) {
			status="falure";
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public String editTaskDao(Task task) {
		String status="";
		try {
			Object arr[]= {task.getTaskName(),task.getTaskDesc(),task.getTaskId()};
			int x=jdbcTemplate.update("update addTask set taskName=?,taskDesc=? where taskId=?",arr);
			if(x==1) {
				status="success";
			}
			else {
				status="failure";
				
			}
		}
		catch(Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public String todoDao(Task task,String email) {
		String status="";
		
		Object []arr= {task.getTaskId(),task.getTaskName(),task.getTaskDesc(),email};
		try {
			int x=jdbcTemplate.update("delete from addTask where taskId='"+task.getTaskId()+"'");
			int y=jdbcTemplate.update("insert into doing values(?,?,?,?)",arr);
			if(x==1 && y==1) {
				status="success";
			}
			else {
				status="failure";
			}
			
		}
		catch(Exception e) {
			status="failure";
			e.printStackTrace();
			
		}
		return status;
	}
	public List<Task> tasksDao(String email){
		
		List<Task> tasks=jdbcTemplate.query("select *from doing where email='"+email+"'",(rs,rowNum)->{
			Task task=new Task();
			task.setTaskId(rs.getString(1));
			task.setTaskName(rs.getString(2));
			task.setTaskDesc(rs.getString(3));
			
			return task;
		});
		
		return tasks;
	}
	@Override
	public String doneDao(Task task,String email) {
        String status="";
		
		Object []arr= {task.getTaskId(),task.getTaskName(),task.getTaskDesc(),email};
		try {
			int x=jdbcTemplate.update("delete from doing where taskId='"+task.getTaskId()+"'");
			int y=jdbcTemplate.update("insert into done values(?,?,?,?)",arr);
			if(x==1 && y==1) {
				status="success";
			}
			else {
				status="failure";
			}
			
		}
		catch(Exception e) {
			status="failure";
			e.printStackTrace();
			
		}
		
		return status;
	}
	@Override
	public List<Task> doneTaskksDao(String email) {
		List<Task> tasks=jdbcTemplate.query("select *from done where email='"+email+"'",(rs,rowNum)->{
			Task task=new Task();
			task.setTaskId(rs.getString(1));
			task.setTaskName(rs.getString(2));
			task.setTaskDesc(rs.getString(3));
			
			return task;
		});
		
		return tasks;
		
		
	}
	@Override
	public List<Task> adminDoingDao() {
		
		List<Task> tasks=jdbcTemplate.query("select *from doing", (rs,rowNum)->{
			Task task=new Task();
			task.setTaskId(rs.getString(1));
			task.setTaskName(rs.getString(2));
			task.setTaskDesc(rs.getString(3));
			task.setEmail(rs.getString(4));
			return task;
			
		});
		return tasks;
	}
	@Override
	public List<Task> adminDoneDao() {
		List<Task> tasks=jdbcTemplate.query("select *from done", (rs,rowNum)->{
			Task task=new Task();
			task.setTaskId(rs.getString(1));
			task.setTaskName(rs.getString(2));
			task.setTaskDesc(rs.getString(3));
			task.setEmail(rs.getString(4));
			return task;
			
		});
		return tasks;
		
		
	}
	@Override
	public List<User> users() {
		List<User> users=jdbcTemplate.query("select *from registration", (rs,rowNum)->{
			User user=new User();
			user.setFname(rs.getString(1));
			user.setRole(rs.getString(5));
			user.setEmail(rs.getString(3));
			user.setMobile(rs.getString(6));
			return user;
		});
		
		return users;
	}
	@Override
	public String userDeleteDao(String email) {
		String status="";
		try {
			int x=jdbcTemplate.update("delete from registration where Email='"+email+"'");
			if(x==1) {
				status="success";
				
			}
			else {
				status="failure";
			}
			
		}
		catch(Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}
	
	
	

}
