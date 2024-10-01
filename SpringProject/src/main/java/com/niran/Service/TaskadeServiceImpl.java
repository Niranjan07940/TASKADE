package com.niran.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niran.Beans.Task;
import com.niran.Beans.User;
import com.niran.Dao.TaskadeDao;



@Service
public class TaskadeServiceImpl implements TaskadeService{
    @Autowired
	private TaskadeDao taskadedaoImpl;
    
	public String userService(User user) {
		String status=taskadedaoImpl.userRegisterDao(user);
		return status;
	}
	
	public User userLoginService(String email) {
		User user=taskadedaoImpl.userLogiinDao(email);
		return user;
	}
	
	public String addTaskService(Task task) {
		String status=taskadedaoImpl.addTaskDao(task);
		return status;
	}

	@Override
	public List<Task> getAllTasksService() {
		List<Task> ts=taskadedaoImpl.getAlltasksDao();
		return ts;
	}

	@Override
	public String deleteTaskService(String tid) {
		String status="";
		status=taskadedaoImpl.deleteTaskDao(tid);
		return status;
	}

	@Override
	public String editTaskSerice(Task task) {
		String status="";
		status=taskadedaoImpl.editTaskDao(task);
		return status;
	}

	@Override
	public String todoService(Task task,String email) {
		String status=taskadedaoImpl.todoDao(task,email);
		return status;
	}

	@Override
	public List<Task> getTasks(String email) {
		List<Task> tasks=taskadedaoImpl.tasksDao(email);
		return tasks;
	}

	@Override
	public String doneService(Task task,String email) {
		String status=taskadedaoImpl.doneDao(task,email);
		
		return status;
	}

	@Override
	public List<Task> doneTasksService(String email) {
		List<Task> allDone=taskadedaoImpl.doneTaskksDao(email);
		return allDone;
	}

	@Override
	public List<Task> adminDoingService() {
		List<Task> tasks=taskadedaoImpl.adminDoingDao();
		
		return tasks;
	}

	@Override
	public List<Task> adminDoneService() {
		List<Task> tasks=taskadedaoImpl.adminDoneDao();
		
		return tasks;
	}

	@Override
	public List<User> users() {
		List<User> users=taskadedaoImpl.users();
		return users;
	}

	@Override
	public String deleteUserService(String email) {
		String status=taskadedaoImpl.userDeleteDao(email);
		return status;
	}

	

	

}
