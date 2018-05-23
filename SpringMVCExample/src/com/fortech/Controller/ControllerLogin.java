package com.fortech.Controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fortech.Entities.User;
import com.fortech.Service.IMyService;
import com.fortech.Service.MyService;


@Controller
@Resource(name = "myService")
public class ControllerLogin {
	
	@Autowired(required = false)
	IMyService myService = new MyService();
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(){
		return new ModelAndView("login", "command", new User());
	}
	
	@RequestMapping(value = "/findUser", method = RequestMethod.POST)
	public String findUser(@ModelAttribute("SpringWeb")User user, 
		ModelMap model) {
		if(myService.verificareUser(user.getUserName(), user.getPassword()) == true) {
			loadUniversitati(model);
			loadCamere(model);
			return "result";
		}
		else {
			model.addAttribute("loginError", "Datele introduse nu sunt corecte!");
			return "login";	
		}
	   }
	
	@RequestMapping(value = "/loadUser", method = RequestMethod.POST)
	public void loadUser(ModelMap model) {
		model.addAttribute("dataList", myService.loadAllUsers());
	}
	
	@RequestMapping(value = "/loadUniversitati", method = RequestMethod.POST)
	public void loadUniversitati(ModelMap model) {
		model.addAttribute("universitati", myService.loadAllUniversitati());
		
	}
	
	@RequestMapping(value = "/loadCamere", method = RequestMethod.POST)
	public void loadCamere(ModelMap model) {
		model.addAttribute("dataListCamere", myService.loadAllCamera());
	}

}
