package com.it355.marinadamnjanovic.service.impl;

import com.it355.marinadamnjanovic.dao.AdDao;
import com.it355.marinadamnjanovic.dao.CompanyDao;
import com.it355.marinadamnjanovic.model.Company;
import com.it355.marinadamnjanovic.service.CompanyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Marina
 */
public class CompanyServiceImpl implements CompanyService{
    
    @Autowired
    CompanyDao companyDao;

    @Override
    public int getCount() {
        return companyDao.getCount();
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyDao.getAllCompanies();
    }

    @Override
    public boolean addCompany(Company company) {
        return companyDao.addCompany(company);
    }
    
}
