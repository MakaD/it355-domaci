package com.it355.marinadamnjanovic.service;

import com.it355.marinadamnjanovic.model.Ad;
import java.util.List;

/**
 *
 * @author Marina
 */
public interface AdService {
    public int getCount();
    public List<Ad> getAllAds();
    public boolean addAd(Ad ad);
}
