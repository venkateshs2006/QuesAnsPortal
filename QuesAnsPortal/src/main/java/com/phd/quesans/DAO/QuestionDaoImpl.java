package com.phd.quesans.DAO;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phd.quesans.entity.DTO.QuestionDTO;
import com.phd.quesans.entity.DTO.SearchEngineDTO;
import com.phd.quesans.entity.DTO.SearchKeywordDTO;
@Repository
public class QuestionDaoImpl implements QuestionDao{
	@Autowired
    private SessionFactory sessionFactory;
	@Override
	public List<String> listQuestion(String term) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		//Transaction transaction=session.beginTransaction();
		Criteria criteria = session.createCriteria(QuestionDTO.class);
		criteria.add(Expression.ilike("question", "%"+term+"%"));

		criteria.setProjection(Projections.property("question"));

		criteria.addOrder(Order.asc("question"));

		return criteria.list();		
	}
	@Override
	public QuestionDTO getQuestionPojo(String question) {
		Session session=sessionFactory.getCurrentSession();
	//	Transaction transaction=session.beginTransaction();
		Criteria criteria = session.createCriteria(QuestionDTO.class);
		criteria.add(Expression.ilike("question", "%"+question+"%"));
		return (QuestionDTO) criteria.list().get(0); // Need to check null condition. 

	}
	@Override
	public List<SearchEngineDTO> listSearchEngine() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		//Transaction transaction=session.beginTransaction();	
		//Query query = (Query) session.createQuery("from searchengine");
        List<SearchEngineDTO> list = session.createQuery("from SearchEngineDTO").list();
        System.out.println("######################## LIst of SEarch Engines :::"+list.toString());
       // WeatherModel w = (WeatherModel) list.get(0);
		return list ;//session.get(SearchEngineDTO.class).list();		
	}
	@Override
	public List<SearchKeywordDTO> listKeyword(int quesid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		//Transaction transaction=session.beginTransaction();
		Criteria criteria = session.createCriteria(SearchKeywordDTO.class);
		criteria.add(Expression.eq("quesid", quesid));
		return criteria.list();	
	}
	
}
