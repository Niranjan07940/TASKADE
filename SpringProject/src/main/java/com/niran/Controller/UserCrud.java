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

import com.niran.Service.TaskadeService;

import jakarta.servlet.http.HttpSession;


@Controller
@SessionAttributes({"record","alert","tasks"})
public class UserCrud {
	
	@Autowired
	private TaskadeService taskadeServiceImpl;
	
	@RequestMapping(value="/userTasks",method=RequestMethod.GET)
	public String fetchAllTasks(ModelMap map) {
        String status="";
		
		List<Task> tl=taskadeServiceImpl.getAllTasksService();
		if(tl.isEmpty()) {
			status="userto-do";
			map.addAttribute("alert","no tasks has been added yet");
		}
		else {
			status="userto-do";
			map.addAttribute("record", tl);
			map.addAttribute("alert","tasks fetched successfully");
		}
		return status;

		
	}
	@RequestMapping(value="/doing",method=RequestMethod.GET)
	public String todo(@RequestParam("tid")String tid,@RequestParam("tname")String tname,@RequestParam("tdesc")String tdesc,HttpSession hs) {
		String status="";
		Task task=new Task();
		ModelMap map=new ModelMap();
		task.setTaskId(tid);
		task.setTaskName(tname);
		task.setTaskDesc(tdesc);
		String email=(String)hs.getAttribute("email");
		status=taskadeServiceImpl.todoService(task,email);
		
		
		List<Task> allTasks=taskadeServiceImpl.getTasks(email);
		hs.setAttribute("allTasks", allTasks);

		if(status.equals("success") && allTasks!=null) {
			status="userDoing";
			map.addAttribute("alert", "do the task now");
			
		}
		else {
			status="userDoing";
			map.addAttribute("alert","problem occured");
		}
		return status;	
	}
	
	@RequestMapping(value="/doingit",method=RequestMethod.GET)
	public String doing(HttpSession hs) {
		String status="";
		ModelMap map=new ModelMap();
		String email=(String)hs.getAttribute("email");
		List<Task> allTasks=taskadeServiceImpl.getTasks(email);
		hs.setAttribute("allTasks", allTasks);

		if(allTasks!=null) {
			status="userDoing";
			map.addAttribute("alert","do the task now");
		}
		else {
			status="userDoing";
			map.addAttribute("alert","problem occured");
		}
		return status;
	}
	@RequestMapping(value="/done",method=RequestMethod.GET)
	public String done(@RequestParam("tid")String tid,@RequestParam("tname")String tname,@RequestParam("tdesc")String tdesc,HttpSession hs) {
		String status="";
		String email=(String)hs.getAttribute("email");
		Task task=new Task();
		task.setTaskId(tid);
		task.setTaskName(tname);
		task.setTaskDesc(tdesc);
		status=taskadeServiceImpl.doneService(task,email);
		List<Task> allDone=taskadeServiceImpl.doneTasksService(email);
		hs.setAttribute("allDone", allDone);
		if(status.equals("success") && allDone!=null) {
			status="userDone";	
		}
		else {
			status="userDone";
			
		}
		return status;
	}
	
	@RequestMapping(value="/doneit",method=RequestMethod.GET)
	public String doneall(HttpSession hs) {
		String status="";
		ModelMap map=new ModelMap();
		String email=(String)hs.getAttribute("email");
		List<Task> allDone=taskadeServiceImpl.doneTasksService(email);
		hs.setAttribute("allDone", allDone);

		if(allDone!=null) {
			status="userDone";
			map.addAttribute("alert","do the task now");
		}
		else {
			status="userDone";
			map.addAttribute("alert","problem occured");
		}
		
		return status;
	}
	
	
	
	
	

}
