package com.niran.Dao;

import java.util.List;

import com.niran.Beans.Task;
import com.niran.Beans.User;

import jakarta.servlet.http.HttpSession;

public interface TaskadeDao {
	public String userRegisterDao(User user);
	public User userLogiinDao(String email);
	public String addTaskDao(Task task);
	public List<Task> getAlltasksDao();
	public String deleteTaskDao(String tid);
	public String editTaskDao(Task task);

    public String todoDao(Task task,String email);
    public List<Task> tasksDao(String email);
    
    public String doneDao(Task task,String email);
    public List<Task> doneTaskksDao(String email);
    
    public List<Task> adminDoingDao();
    public List<Task> adminDoneDao();
    
    public List<User> users();
    
    public String userDeleteDao(String email);

}
