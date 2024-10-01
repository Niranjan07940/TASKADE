package com.niran.Service;



import java.util.List;
import com.niran.Beans.Task;
import com.niran.Beans.User;

public interface TaskadeService {
	public String userService(User user);
	public User userLoginService(String email);
	public String addTaskService(Task task);
	public List<Task> getAllTasksService();
	public String deleteTaskService(String tid);
	public String editTaskSerice(Task task);
	
	public String todoService(Task task,String email);
	public List<Task> getTasks(String email);
	
	public String doneService(Task task,String email);
	public List<Task> doneTasksService(String email);
	
	public List<Task> adminDoingService();
	public List<Task> adminDoneService();
	
	public List<User> users();
	
	public String deleteUserService(String email);

	
}
