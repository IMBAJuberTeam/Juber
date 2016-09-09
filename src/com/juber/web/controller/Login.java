package com.juber.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;  
  
@Controller  
public class Login {  
  
	@RequestMapping("/login.do")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, Model model){  
          String userName = request.getParameter("userName");
          String passWord = request.getParameter("passWord");
          
          if(userName.equals(passWord)){
        	  request.getSession().setAttribute("token", "OK");
        	  request.getSession().setMaxInactiveInterval(600);
//              return new ModelAndView("redirect:/area/getAreas.do?pageNum=1&dataCount=&condition="); 
              return new ModelAndView("redirect:/defaultPage.do"); 
          }
        return new ModelAndView("/index");  
    }
	
	@RequestMapping("/defaultPage.do")
	public ModelAndView toMain(HttpServletRequest request, HttpServletResponse response, Model model){
		return new ModelAndView("/pages/area/default"); 
	}
	
	@RequestMapping("/defaultlogin.do")
	public ModelAndView toLogin(HttpServletRequest request, HttpServletResponse response, Model model){
		return new ModelAndView("/index"); 
	}
	
	@RequestMapping("/logout.do")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, Model model){
		request.getSession().invalidate();
		return new ModelAndView("/index"); 
	}  
   
}  