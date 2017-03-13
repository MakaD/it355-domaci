package com.it355.marinadamnjanovic.dao;

import com.it355.marinadamnjanovic.model.Company;
import java.util.List;

/**
 *
 * @author Marina
 */
public interface CompanyDao {
    public int getCount();
    public List<Company> getAllCompanies();
    public boolean addCompany(Company company);
}
