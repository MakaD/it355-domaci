package com.it355.marinadamnjanovic.dao;

import com.it355.marinadamnjanovic.entity.Ad;
import com.it355.marinadamnjanovic.entity.Company;
import java.util.List;

/**
 *
 * @author Marina
 */
public interface MDDao {
    public int getCompanyCount();
    public List<Company> getAllCompanies();
    public Company addCompany(Company company);
    public Company getCompanyById(int id);
    public void deleteCompany(Company company);
    public int getAdCount();
    public List<Ad> getAllAds();
    public Ad getAdById(int id);
    public Ad addAd(Ad ad);
    public void deleteAd(Ad ad);
}
