package com.juber.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.juber.entity.Area;
import com.juber.manager.AreaManager;
import com.juber.utils.PageBean;

  
@Controller  
@RequestMapping("")  
public class AreaColltroller {  
  
	@Autowired
    private AreaManager areaManager;  
  
    @RequestMapping("/getAllAreas.do")
    public String getAllAreas(HttpServletRequest request){  
          
        request.setAttribute("areaList", areaManager.getAllAreas());  
          
        return "/page/area/areas";  
    }  
      
    @RequestMapping(value="/getChildrens.do", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  getArea(String id,HttpServletRequest request){  
    	List<Area> list = areaManager.getChildrens(Integer.parseInt(id));
        return JSON.toJSONString(list); 
    }
    	
	@RequestMapping(value="/getAreas.do", produces = "application/json; charset=utf-8")
	@SuppressWarnings("unchecked")
	@ResponseBody
    public String getAreas(String pageNum, String dataCount, String condition, 
    		HttpServletRequest request, Model model){  
          
    	PageBean pageBean = new PageBean(pageNum, dataCount, "22", new String[]{});
    	
        List<Area> list = (List<Area>) areaManager.getAreas(pageBean, 
        		Restrictions.like("areaName", "%" + "" + "%")).getList();  

        
        return JSON.toJSONString(list);  
    } 
}  