package com.it355.marinadamnjanovic.service.impl;

import com.it355.marinadamnjanovic.dao.AdDao;
import com.it355.marinadamnjanovic.model.Ad;
import com.it355.marinadamnjanovic.service.AdService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Marina
 */
public class AdServiceImpl implements AdService{
    
    @Autowired
    AdDao adDao;

    @Override
    public int getCount() {
        return adDao.getCount();
    }

    @Override
    public List<Ad> getAllAds() {
        return adDao.getAllAds();
    }

    @Override
    public boolean addAd(Ad ad) {
        return adDao.addAd(ad);
    }
    
}
