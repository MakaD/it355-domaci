package com.it355.marinadamnjanovic.dao.impl;

import com.it355.marinadamnjanovic.dao.MDDao;
import com.it355.marinadamnjanovic.entity.Ad;
import com.it355.marinadamnjanovic.entity.Company;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Marina
 */
@Repository("mDDao")
@Service
public class MDDaoImpl implements MDDao{
    
    @SuppressWarnings("unused")
    private final Log logger = LogFactory.getLog(getClass());
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory)
    {
    this.sessionFactory = sessionFactory;
    }
    public Session getSession() {
    return sessionFactory.getCurrentSession();
    }
    
    @Override
    @Transactional
    public int getCompanyCount() {
        Number result = (Number)
        getSession().createSQLQuery("select count(*) from companies").uniqueResult();
        return Integer.parseInt(result.toString());
    }
    
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Company> getAllCompanies() {
        List<Company> results = (List<Company>)
        getSession().createCriteria(Company.class).list();
        return results;
    }

    @Transactional
    @Override
    public Company addCompany(Company company) {
        return (Company)getSession().merge(company);
    }

    @Transactional
    @Override
    public Company getCompanyById(int id) {
        Company c = (Company)
        getSession().createCriteria(Company.class).add(Restrictions.eq("id", id)).uniqueResult();
        return c;
    }

    @Transactional
    @Override
    public void deleteCompany(Company company) {
        getSession().delete(company);
    }

    @Transactional
    @Override
    public int getAdCount() {
        Number result = (Number)
        getSession().createSQLQuery("select count(*) from ads").uniqueResult();
        return Integer.parseInt(result.toString());
    }

    @Transactional
    @Override
    public List<Ad> getAllAds() {
        List<Ad> results = (List<Ad>)
        getSession().createCriteria(Ad.class).list();
        return results;
    }

    @Transactional
    @Override
    public Ad getAdById(int id) {
        Ad a = (Ad)
        getSession().createCriteria(Ad.class).add(Restrictions.eq("id", id)).uniqueResult();
        return a;
    }

    @Transactional
    @Override
    public Ad addAd(Ad ad) {
        return (Ad)getSession().merge(ad);
    }

    @Transactional
    @Override
    public void deleteAd(Ad ad) {
        getSession().delete(ad);
    }
    
}
