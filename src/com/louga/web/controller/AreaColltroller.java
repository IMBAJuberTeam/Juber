package com.louga.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.louga.entity.Area;
import com.louga.manager.AreaManager;
import com.louga.utils.PageBean;  
  
@Controller  
@RequestMapping("/area")  
public class AreaColltroller {  
  
	@Autowired
    private AreaManager areaManager;  
  
    @RequestMapping("/getAllAreas.do")
    public String getAllAreas(HttpServletRequest request){  
          
        request.setAttribute("areaList", areaManager.getAllAreas());  
          
        return "/index";  
    }  
      
    @RequestMapping("/getArea.do")
    @ResponseBody
    public String getArea(String id,HttpServletRequest request){  
          
        request.setAttribute("area", areaManager.getArea(Integer.parseInt(id)));  
      
        return "/index";  
    }
    
	@RequestMapping("/getAreas.do")
	@SuppressWarnings("unchecked")
    public ModelAndView getAreas(String pageNum, HttpServletRequest request, Model model){  
          
    	PageBean pageBean = new PageBean();
    	if(pageNum == null || pageNum.equals("")){
    		pageNum = "1";
    	}
    	pageBean.setCurrentPage(Integer.parseInt(pageNum));
    	pageBean.setMaxResult(10);
//        request.setAttribute("areaList", (List<Area>)areaManager.getAreas(pageBean, new Criterion[]{}).getList());  
//        request.setAttribute("page", pageBean);  
        
        model.addAttribute("areaList",  (List<Area>)areaManager.getAreas(pageBean, new Criterion[]{}).getList());  
        model.addAttribute("page", pageBean);
        
        return new ModelAndView("/index");  
    } 
}  