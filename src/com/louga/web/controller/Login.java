package com.louga.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;  
  
@Controller  
public class Login {  
  
	@RequestMapping("/login.do")
    public ModelAndView getAreas(HttpServletRequest request, Model model){  
          String userName = request.getParameter("userName");
          String passWord = request.getParameter("passWord");
          
          
          if(userName.equals(passWord)){
//        	  return new ModelAndView("redirect:/toList");
              return new ModelAndView("redirect:/area/getAreas.do?pageNum=1&dataCount=&condition="); 
          }      
        return new ModelAndView("/index");  
    } 
}  