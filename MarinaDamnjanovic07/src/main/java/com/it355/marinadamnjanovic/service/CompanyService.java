package com.it355.marinadamnjanovic.service;

import com.it355.marinadamnjanovic.model.Company;
import java.util.List;

/**
 *
 * @author Marina
 */
public interface CompanyService {
    public int getCount();
    public List<Company> getAllCompanies();
    public boolean addCompany(Company company);
}
