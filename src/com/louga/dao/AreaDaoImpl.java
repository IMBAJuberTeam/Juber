package com.louga.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.louga.entity.Area;
import com.louga.utils.PageBean;   

@Repository("areaDao")
@Transactional
public class AreaDaoImpl implements AreaDao{ 
	
	@Autowired
    private SessionFactory sessionFactory;  
  
    public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    }

	@Override
	public Area getArea(int id) {   
      String hql = "from Area a where a.id=?";  
      Query query = sessionFactory.getCurrentSession().createQuery(hql);  
      query.setInteger(0, id);  
      return (Area)query.uniqueResult();  
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Area> getAllAreas() {
        String hql = "from Area";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);     
        return query.list();  
	}
	
	/**
	 * �Զ����ȡ���ݼ�
	 * 
	 * @param PageBean pageBean
	 * 		��װ��PageBean�࣬������ʼҳ����󼯺���
	 * @param Criterion...ctrs
	 * 		crts��������
	 */
	@Override
	public PageBean getAreas(PageBean pageBean, Criterion...ctrs) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Area.class);
		//���������ѯ
		for (Criterion criterion : ctrs) {
			c.add(criterion);
		}
		
//		c.setProjection(Projections.rowCount());
//		int totalRecord=Integer.valueOf(c.uniqueResult().toString());
//		c.setProjection(null);

		c.setFirstResult((pageBean.getMaxResult())*(pageBean.getCurrentPage()-1));
		c.setMaxResults(pageBean.getMaxResult());
		pageBean.setList(c.list());
		return pageBean;
	}  
      
 
}  
