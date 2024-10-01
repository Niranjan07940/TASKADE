package com.niran.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.niran.Beans.User;
import com.niran.Service.TaskadeService;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes({"message","user"})
public class RegisterLogin {
	@Autowired
	private TaskadeService taskadeServiceImpl;
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String userRegister(@RequestParam("fname")String fname,@RequestParam("lname")String lname,@RequestParam("email")String email,@RequestParam("pwd")String pwd,@RequestParam("role")String role,@RequestParam("phone")String mobile,ModelMap mp){
		String status="";
		User user=new User();
		user.setFname(fname);
		user.setLname(lname);
		user.setEmail(email);
		user.setPwd(pwd);
		user.setRole(role);
		user.setMobile(mobile);
		status=taskadeServiceImpl.userService(user);
		if(status.equals("success")) {
			status="login";
			mp.addAttribute("message","registered successfully");
		}
		else {
			status="register";
			mp.addAttribute("message","user existed already with this account");
		}
		return status;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("email")String email,@RequestParam("pwd")String pwd,ModelMap map,HttpSession hs) {
		String status="";
		User user=taskadeServiceImpl.userLoginService(email);
		if(user==null) {
			status="register";
			map.addAttribute("message","user does not exist! Register");
		}
		else {
			if(user.getEmail().equals("admin@07") && user.getPwd().equals("root")) {
				
				status="adminHome";
				map.addAttribute("message", "logged-in successfully as Admin");
				map.addAttribute("user", user.getFname());
				hs.setAttribute("email", user.getEmail());
				
				
			}
			else {
				status="userHome";
				map.addAttribute("message", "logged-in successfully as user");
				map.addAttribute("user", user.getFname());
				hs.setAttribute("email", user.getEmail());
				
			}
			
		}
		return status;
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession hs) {
		String status="";
		hs.invalidate();
		status="login";
		
		return status;
	}
	
	
	
		
}

