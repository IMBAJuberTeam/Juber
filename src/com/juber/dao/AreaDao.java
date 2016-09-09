package com.juber.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.juber.entity.Area;
import com.juber.utils.PageBean;  

public interface AreaDao {
  
    public Area getArea(int id);  
      
    public List<Area> getChildrens(int id);
    
    public List<Area> getAllAreas();
    
    public PageBean getAreas(PageBean pageBean, Criterion...ctrs);
        
}  