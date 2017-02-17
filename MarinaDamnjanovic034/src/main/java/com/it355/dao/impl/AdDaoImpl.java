package com.it355.dao.impl;

import com.it355.dao.AdDao;

/**
 *
 * @author Marina
 */
public class AdDaoImpl implements AdDao{

    @Override
    public void addAd() {
        System.out.println("Dodajem oglas.");
    }

    @Override
    public String addAdRet() {
        System.out.println("Dodajem oglas i vracam vrednost");
        return "dodato";
    }

    @Override
    public void addAdThrowException() throws Exception {
        System.out.println("Dodajem oglas, ali bacicu gresku");
        throw new Exception("Generic Error");
    }

    @Override
    public void addAdAround(String title) {
        System.out.println("Dodajem oglas sa naslovom: " + title);
    }
    
    
    
}
