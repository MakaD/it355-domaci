package com.it355.marinadamnjanovic.dao;

import com.it355.marinadamnjanovic.model.Ad;
import java.util.List;

/**
 *
 * @author Marina
 */
public interface AdDao {
    public int getCount();
    public List<Ad> getAllAds();
    public Ad getById(int id);
    public boolean addAd(Ad ad);
    public boolean deleteAd(int id);
}
