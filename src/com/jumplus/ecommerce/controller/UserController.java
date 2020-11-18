package com.jumplus.ecommerce.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jumplus.ecommerce.dao.cartItemDAO;
import com.jumplus.ecommerce.dao.ItemDAO;
import com.jumplus.ecommerce.dao.UserDAO;
import com.jumplus.ecommerce.model.Item;
import com.jumplus.ecommerce.model.User;
import com.jumplus.ecommerce.model.cartItem;
import com.jumplus.ecommerce.model.purchasedItem;
import com.jumplus.ecommerce.dao.purchasedItemDAO;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired 
	private cartItemDAO cartItemDAO;
	
	@Autowired
	private ItemDAO itemDAO;
	
	@Autowired
	private purchasedItemDAO purchasedItemDAO;
		
//--------------------------------------- Pages ---------------------------------------//
	
	@RequestMapping(value = "/")
	public ModelAndView Login(ModelAndView model) {
		model.setViewName("index");
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView Register(ModelAndView model) {
		User newuser = new User();
		model.addObject("newUser", newuser);
		model.setViewName("register");
		return new ModelAndView("register");
	}
	
	@RequestMapping(value="/usercatalog", method = RequestMethod.GET)
	public ModelAndView homePage(@ModelAttribute User user) {
		User userBypasswordAndemail = userDAO.getUserByPasswordandEmail(user.getPassword(), user.getEmail());
		if(userBypasswordAndemail != null) {
			List<cartItem> cartItems = cartItemDAO.getcartItems(userBypasswordAndemail.getUserId());
			List<Item> Items = itemDAO.getAllItems();
			ModelAndView model = new ModelAndView();
			model.addObject("user", userBypasswordAndemail);
			model.addObject("cartItems", cartItems);
			model.addObject("items", Items);
			model.setViewName("customerhome");
			return model;
		} else return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/cartPage", method = RequestMethod.GET)
	public ModelAndView cartPage(HttpServletRequest request) {
		User user = userDAO.getUserById(Integer.parseInt(request.getParameter("userId")));
		List<cartItem> cartItems = cartItemDAO.getcartItems(Integer.parseInt(request.getParameter("userId")));
		ModelAndView model = new ModelAndView();
		model.addObject("cartItems", cartItems);
		model.addObject("user", user);
		model.setViewName("shoppingcart");
		return model;	
	}
	
	@RequestMapping(value="/userPage", method = RequestMethod.GET)
	public ModelAndView userPage(HttpServletRequest request) {
		User user = userDAO.getUserById(Integer.parseInt(request.getParameter("userId")));
		ModelAndView model = new ModelAndView();
		model.addObject("user", user);
		return model;
	}
	
	@RequestMapping(value="/customerdetails", method = RequestMethod.GET)
	public ModelAndView customerdetails(HttpServletRequest request) {
		User user = userDAO.getUserById(Integer.parseInt(request.getParameter("userId")));
		ModelAndView model = new ModelAndView();
		model.addObject("user", user);
		model.setViewName("customerdetails");
		return model;
	}
	
	@RequestMapping(value="/confirmorder", method = RequestMethod.POST)
	public ModelAndView confirmOrder(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.setViewName("invoice");
		return model;
	}
//--------------------------------------- Methods and Redirects ---------------------------------------//
	
	@RequestMapping(value="/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user) {
		userDAO.addUser(user);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/addtoCart", method = RequestMethod.GET)
	public ModelAndView addtoCart(HttpServletRequest request) {
//		System.out.println("item Id: " + request.getParameter("itemId"));
//		System.out.println("user ID: " + request.getParameter("userId"));
		Item item = itemDAO.getItem(Integer.parseInt(request.getParameter("itemId")));
		cartItem ci = new cartItem();
		ci.setItemId(item.getItemId());
		ci.setName(item.getName());
		ci.setCode(item.getCode());
		ci.setPrice(item.getPrice());
		ci.setQuantity(1);
		ci.setUserId(Integer.parseInt(request.getParameter("userId")));
		cartItemDAO.addcartItem(ci);
		List<Item> items = itemDAO.getAllItems();
		ModelAndView model = new ModelAndView();
		User user = userDAO.getUserById(Integer.parseInt(request.getParameter("userId")));
		model.addObject("user", user);
		model.addObject("items", items);
		model.setViewName("customerhome");
		return model;
	}
	
	@RequestMapping(value="/deletefromCart", method = RequestMethod.DELETE)
	public ModelAndView deletefromCart(HttpServletRequest request) {
		cartItemDAO.deletecartItem(Integer.parseInt(request.getParameter("itemId")), Integer.parseInt(request.getParameter("userId")));
		return new ModelAndView("redirect:/shoppingcart");
	}
	
	@RequestMapping(value="/purchaseItem", method = RequestMethod.POST)
	public ModelAndView purchaseItem(HttpServletRequest request) {
		cartItem cartItem = cartItemDAO.getcartItem(Integer.parseInt(request.getParameter("userId")), Integer.parseInt(request.getParameter("cartitemId")) );
		cartItemDAO.deletecartItem(Integer.parseInt(request.getParameter("cartitemId")), Integer.parseInt(request.getParameter("userId")));
		purchasedItem pi = new purchasedItem();
		pi.setItemId(cartItem.getItemId());
		pi.setName(cartItem.getName());
		pi.setCode(cartItem.getCode());
		pi.setPrice(cartItem.getPrice());
		pi.setQuantity(1);
		pi.setUserId(Integer.parseInt(request.getParameter("userId")));
		pi.setPurchaseDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		purchasedItemDAO.addpurchasedItem(pi);
		return new ModelAndView("redirect:/shoppingcart");
	}
	
	@RequestMapping(value="/makeReturn", method = RequestMethod.DELETE)
	public ModelAndView makeReturn(HttpServletRequest request) {
		purchasedItemDAO.deletepurchasedItem(Integer.parseInt(request.getParameter("purchaseditemId")), Integer.parseInt(request.getParameter("userId")));
		return new ModelAndView("redirect:/purchasedProducts");	
	}
	
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpServletRequest request) {
		return new ModelAndView("redirect:/");	
	}
}
	


