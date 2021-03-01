package com.phd.quesans.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phd.quesans.entity.DTO.QuestionDTO;
@Repository
public class AdminQuestionDAOImpl implements AdminQuestionDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public QuestionDTO getQuestion(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(QuestionDTO.class);
		criteria.add(Restrictions.idEq(new Integer(id)));
		return (QuestionDTO) criteria.list().get(0);
	}

	@Override
	public List<QuestionDTO> getQuestionList() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return session.createCriteria(QuestionDTO.class).list();
	}

	@Override
	public int addQuestion(QuestionDTO question) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(question);
			System.out.println("Record Added");
			return 1;
		} catch (Exception e) {
			return 0;
		}
		
	}

	@Override
	public int deleteQuestion(QuestionDTO question) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(question);
			System.out.println("Record Deleted");
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

}
