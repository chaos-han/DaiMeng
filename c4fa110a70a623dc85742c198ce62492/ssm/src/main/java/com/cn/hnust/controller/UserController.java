package com.cn.hnust.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	
//	@RequestMapping("/userInfo")
//	public String userInfo(HttpServletRequest request,Model model){
//		int userId = Integer.parseInt(request.getParameter("id"));
//		User user = this.userService.getUserById(userId);
//		model.addAttribute("user", user);
//		return "userInfo";
//	}
	@RequestMapping("/userInfo")
	public String userInfo(@RequestParam int id, Model model){
//		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(id);
		model.addAttribute("user", user);
		return "userInfo";
	}

	@RequestMapping(path="/userInfoPath/{id}")
	public String userInfoPath(@PathVariable int id,Model model){
		User user = this.userService.getUserById(id);
		model.addAttribute("user",user);
		return "userInfo";
	}

	@ResponseBody
	@RequestMapping(path="/userInfoJson/{id}")
	public User userInfoJson(@PathVariable int id){
		User user = this.userService.getUserById(id);
		return user;
	}
}