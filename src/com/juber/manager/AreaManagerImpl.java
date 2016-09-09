package com.juber.manager;  
  
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juber.dao.AreaDao;
import com.juber.entity.Area;
import com.juber.utils.PageBean;

@Service("areaManager")
public class AreaManagerImpl implements AreaManager {  
	
	@Autowired
    private AreaDao areaDao; 
      
    public void setAreaDao(AreaDao areaDao) {
 		this.areaDao = areaDao;
 	}

	@Override
	public Area getArea(int id) {
		return areaDao.getArea(id);
	}

	@Override
	public List<Area> getAllAreas() {
		return areaDao.getAllAreas();
	}

	@Override
	public PageBean getAreas(PageBean pageBean, Criterion...ctrs) {
		return areaDao.getAreas(pageBean, ctrs);
	}

	@Override
	public List<Area> getChildrens(int id) {
		return areaDao.getChildrens(id);
	}
    
}  