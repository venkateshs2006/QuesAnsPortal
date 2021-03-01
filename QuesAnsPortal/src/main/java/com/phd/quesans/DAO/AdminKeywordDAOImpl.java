package com.phd.quesans.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.phd.quesans.entity.DTO.SearchKeywordDTO;
@Repository
public class AdminKeywordDAOImpl implements AdminKeywordDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SearchKeywordDTO getSearchKeyword(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(SearchKeywordDTO.class);
		criteria.add(Restrictions.idEq(new Integer(id)));
		return (SearchKeywordDTO) criteria.list().get(0);
	}

	@Override
	public List<SearchKeywordDTO> getSearchKeywordList() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		return session.createCriteria(SearchKeywordDTO.class).list();
	}

	@Override
	public int addSearchKeyword(SearchKeywordDTO searchKeyword) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(searchKeyword);
			System.out.println("Record Added");
			return 1;
		} catch (Exception e) {
			return 0;
		}
		
	}

	@Override
	public int deleteSearchKeyword(SearchKeywordDTO searchKeyword) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(searchKeyword);
			System.out.println("Record Deleted");
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

}
