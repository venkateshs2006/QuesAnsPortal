package com.phd.quesans.DAOService;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phd.quesans.hibernate.pojo.QuestionPojo;
import com.phd.quesans.pojo.Question;
@Repository
public class QuestionDaoImpl implements QuestionDao{
	@Autowired
    private SessionFactory sessionFactory;
	@Override
	public List<String> listQuestion(String term) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(QuestionPojo.class);
System.out.println(term);
		criteria.add(Expression.ilike("question", "%"+term+"%"));

		criteria.setProjection(Projections.property("question"));

		criteria.addOrder(Order.asc("question"));

		return criteria.list();		
	}
	
}
