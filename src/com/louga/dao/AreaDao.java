package com.louga.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.louga.entity.Area;
import com.louga.utils.PageBean;  

public interface AreaDao {
  
    public Area getArea(int id);  
      
    public List<Area> getAllAreas();
    
    public PageBean getAreas(PageBean pageBean, Criterion...ctrs);
        
}  