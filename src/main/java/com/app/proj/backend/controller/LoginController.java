package com.app.proj.backend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.proj.backend.entity.Payment;
import com.app.proj.backend.entity.User;
import com.app.proj.backend.service.PaymentService;
import com.app.proj.backend.service.UserService;

/**
 * @author HsuWaiWaiTun
 *
 */
@Controller
public class LoginController {
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	UserService userService;
	
	@Autowired
	PaymentService paymentService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String hello(){
		log.info("In Home Controller");
		return "login";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView welcome(){
		log.info("In Home Controller");
		ModelAndView modelView = new ModelAndView();
		List<Payment> paymentList = paymentService.findAllPayment();
		modelView.setViewName("index");
		modelView.addObject("paymentList", paymentList);
		return modelView;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String password, Model model){
		log.info("In Login Controller: Username " + username);
		User user = userService.login(username, password);
		ModelAndView modelView = new ModelAndView();
		if(user != null){
			log.info(user.toString());
			modelView.setViewName("index");
			return modelView;
		}
		modelView.setViewName("login");
		modelView.addObject("error", "Login Failed, Try Again.");
		return modelView;
	}

	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model){
		log.info("In logout controller");
		
		return "login";
	}
}
