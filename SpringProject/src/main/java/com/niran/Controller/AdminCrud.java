package com.niran.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.niran.Beans.Task;
import com.niran.Beans.User;
import com.niran.Service.TaskadeService;
import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes({"record","alert"})
public class AdminCrud {
	@Autowired
	private TaskadeService taskadeServiceImpl;
	
	@RequestMapping(value="/addTask",method=RequestMethod.POST)
	public String addTask(@RequestParam("tid")String taskId,@RequestParam("tname")String taskName,@RequestParam("tdesc")String desc,HttpSession hs){
		String status="";
		ModelMap map= new ModelMap();
		Task task=new Task();
		task.setTaskId(taskId);
		task.setTaskName(taskName);
		task.setTaskDesc(desc);
		status=taskadeServiceImpl.addTaskService(task);
		if(status.equals("success")) {
			status="to-do";
//			map.addAttribute("alert","task added successfully");
			hs.setAttribute("alert","task added successfully");
		}
		else {
			status="to-do";
//			map.addAttribute("alert","problem occured while adding the task");
			hs.setAttribute("alert","problem occured while adding task");
		}
		return  status;
	}
	
	@RequestMapping(value="/allTasks",method=RequestMethod.GET)
	public String getAllTasks(ModelMap map,HttpSession hs) {
		String status="";
		
		List<Task> tl=taskadeServiceImpl.getAllTasksService();
		if(tl.isEmpty()) {
			status="to-do";
//			map.addAttribute("alert","no tasks has been added yet");
			hs.setAttribute("alert","no tasks has been added yet");
		}
		else {
			status="to-do";
			map.addAttribute("record", tl);
//			map.addAttribute("alert","tasks fetched successfully");
			hs.setAttribute("alert","fetched successfully");
			
		}
		return status;
	}
	
	@RequestMapping(value="/deleteTask",method=RequestMethod.GET)
	public String deleteTask(@RequestParam("tid")String taskId,ModelMap map) {
		String status="";
		
		status=taskadeServiceImpl.deleteTaskService(taskId);
		if(status.equals("success")) {
			status="to-do";
			map.addAttribute("alert","task deleted Successfully");
		}
		else {
			status="to-do";
			map.addAttribute("alert","problem occured while deleting the task");	
		}
		return status;
	}
	
	@RequestMapping(value="/editTask",method=RequestMethod.POST)
	public String editTasks(@RequestParam("tid")String taskid,@RequestParam("tname")String taskName,@RequestParam("tdesc")String taskDesc) {
		Task task =new Task();
		String status="";
		ModelMap map=new ModelMap();
		task.setTaskId(taskid);
		task.setTaskName(taskName);
		task.setTaskDesc(taskDesc);
		status=taskadeServiceImpl.editTaskSerice(task);
		if(status.equals("success")) {
			status="to-do";
			map.addAttribute("alert","updated Successfully");
		}
		else {
			status="to-do";
			map.addAttribute("alert","problem occured while updating");
		}
		return status;
	}
	
	@RequestMapping(value="/adminDoing",method=RequestMethod.GET)
	public String doing(HttpSession hs) {
		String status="";
		List<Task> tasks=taskadeServiceImpl.adminDoingService();
		if(tasks!=null) {
			status="doing";
			hs.setAttribute("adminDoing", tasks);
		}
		else {
			status="doing";
			hs.setAttribute("alert", "problem occured");
		}
		
		return status;
	}
	
	@RequestMapping(value="/adminDone",method=RequestMethod.GET)
	public String adminDone(HttpSession hs) {
		String status="";
		List<Task> tasks=taskadeServiceImpl.adminDoneService();
		if(tasks!=null) {
			status="done";
			hs.setAttribute("adminDoing", tasks);
		}
		else {
			status="done";
			hs.setAttribute("alert", "problem occured");
		}
		
		return status;
	}
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String users(HttpSession hs) {
		String status="";
		List<User> users=taskadeServiceImpl.users();
		if(users!=null) {
			status="users";
			hs.setAttribute("adminDoing", users);
		}
		else {
			status="users";
			hs.setAttribute("alert", "problem occured");
		}
		
		return status;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String userDelete(@RequestParam("email")String email) {
		String status="";
		status=taskadeServiceImpl.deleteUserService(email);
		if(status.equals("success")) {
			status="users";
		}
		else {
			status="users";
		}
		return status;
	}
	
	

}
