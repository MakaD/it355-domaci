package com.it355.dao;

/**
 *
 * @author Marina
 */
public interface AdDao {
    
    public void addAd();
    public String addAdRet();
    public void addAdThrowException() throws Exception;
    public void addAdAround(String title);
    
}
