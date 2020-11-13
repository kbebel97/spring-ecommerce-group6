package com.jumplus.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jumplus.ecommerce.dao.UserDAO;
import com.jumplus.ecommerce.model.User;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = "/")
	public ModelAndView Login(ModelAndView model) {
//		User user = userDAO.getUserByEmail("N/A");
//		System.out.println(user);

		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView Register(ModelAndView model) {
		User newuser = new User();
		model.addObject("newUser", newuser);
		return model;
	}
	
	@RequestMapping(value="/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user) {
		userDAO.addUser(user);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/homePage", method = RequestMethod.GET)
	public ModelAndView homePage(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User userByusername = userDAO.getUserByUsername(username);
		User userBypassword = userDAO.getUserByPassword(password);
		ModelAndView model = new ModelAndView();
		model.addObject("user", userByusername );
		model.setViewName("customerhome");
		return model;
		
	}
	
	
	

}
