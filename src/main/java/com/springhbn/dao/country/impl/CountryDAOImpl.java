package com.springhbn.dao.country.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.springhbn.dao.AbstractGenericDao;
import com.springhbn.dao.country.CountryDao;
import com.springhbn.model.Country;

public class CountryDAOImpl extends AbstractGenericDao<Country> implements CountryDao{

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Country> findByPopulation(long population, int caseForSearch) {
		Criteria criteria = getSession().createCriteria(Country.class);
		if(caseForSearch == 0){
			criteria.add(Restrictions.lt("population", population));
		}
		if(caseForSearch == 1){
			criteria.add(Restrictions.le("population", population));
		}
		if(caseForSearch == 2){
			criteria.add(Restrictions.eq("population", population));
		}
		if(caseForSearch == 3){
			criteria.add(Restrictions.ge("population", population));
		}
		if(caseForSearch == 4){
			criteria.add(Restrictions.gt("population", population));
		}
		criteria.addOrder(Order.asc("population"));
		return criteria.list();
	}

//	@Autowired
//	 private SessionFactory sessionFactory;
//	 
//	 public void setSessionFactory(SessionFactory sf) {
//	  this.sessionFactory = sf;
//	 }
//	 
//	 public List getAllCountries() {
//	  Session session = this.sessionFactory.getCurrentSession();
//	  List countryList = session.createQuery("from Country").list();
//	  return countryList;
//	 }
//	 
//	 public Country getCountry(int id) {
//	  Session session = this.sessionFactory.getCurrentSession();
//	  Country country = (Country) session.load(Country.class, new Integer(id));
//	  return country;
//	 }
//	 
//	 public Country addCountry(Country country) {
//	  Session session = this.sessionFactory.getCurrentSession();
//	  session.persist(country);
//	  return country;
//	 }
//	 
//	 public void updateCountry(Country country) {
//	  Session session = this.sessionFactory.getCurrentSession();
//	  session.update(country);
//	 }
//	 
//	 public void deleteCountry(int id) {
//	  Session session = this.sessionFactory.getCurrentSession();
//	  Country p = (Country) session.load(Country.class, new Integer(id));
//	  if (null != p) {
//	   session.delete(p);
//	  }
//	 }
}
