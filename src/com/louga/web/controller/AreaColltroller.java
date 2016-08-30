package com.louga.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.louga.entity.Area;
import com.louga.manager.AreaManager;
import com.louga.utils.PageBean;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;  
  
@Controller  
@RequestMapping("/area")  
public class AreaColltroller {  
  
	@Autowired
    private AreaManager areaManager;  
  
    @RequestMapping("/getAllAreas.do")
    public String getAllAreas(HttpServletRequest request){  
          
        request.setAttribute("areaList", areaManager.getAllAreas());  
          
        return "/main";  
    }  
      
    @RequestMapping(value="/getChildrens.do", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  getArea(String id,HttpServletRequest request){  
    	List<Area> list = areaManager.getChildrens(Integer.parseInt(id));
    	JSONArray jsonArray = new JSONArray();
    	JSONObject jsonObject;
        request.setAttribute("childrenList", list); 
        for (Area area : list) {
        	jsonObject = new JSONObject();
        	jsonObject.put("id", area.getId());
        	jsonObject.put("areaCode", area.getAreaCode());
        	jsonObject.put("areaName", area.getAreaName());
        	
        	jsonArray.add(jsonObject);
		}
        return jsonArray.toString();
    }
    
	@RequestMapping("/getAreas.do")
	@SuppressWarnings("unchecked")
    public ModelAndView getAreas(String pageNum, String dataCount, String condition, 
    		HttpServletRequest request, Model model){  
          
    	PageBean pageBean = new PageBean();
    	//过滤非法页数，空或者小于0的设置为起始页1
    	if(pageNum == null || pageNum.equals("") || Integer.parseInt(pageNum) < 1){
    		pageNum = "1";
    	}
    	if(dataCount== null || dataCount.equals("")){
    		dataCount = "0";
    	}
    	int totalPages = (Integer.parseInt(dataCount)%10 == 0?0:1) + Integer.parseInt(dataCount)/10;
    	if(Integer.parseInt(pageNum) > totalPages){
    		pageNum = totalPages + "";
    	}
    	pageBean.setConditions(condition);
    	pageBean.setCurrentPage(Integer.parseInt(pageNum.equals("0")?"1":pageNum));
    	pageBean.setMaxResult(10);
//        request.setAttribute("areaList", (List<Area>)areaManager.getAreas(pageBean, new Criterion[]{}).getList());  
//        request.setAttribute("page", pageBean);  
        
        model.addAttribute("areaList",  (List<Area>)areaManager.getAreas(pageBean, Restrictions.like("areaName", "%" + condition + "%")).getList());  
        model.addAttribute("page", pageBean);
        model.addAttribute("conditon", condition);
        
        return new ModelAndView("/main");  
    } 
}  