package com.it355.marinadamnjanovic.controller;

import com.it355.marinadamnjanovic.dao.AdDao;
import com.it355.marinadamnjanovic.dao.CompanyDao;
import com.it355.marinadamnjanovic.model.Ad;
import com.it355.marinadamnjanovic.model.Company;
import com.it355.marinadamnjanovic.service.AdService;
import com.it355.marinadamnjanovic.service.CompanyService;
import java.awt.PageAttributes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
/**
 *
 * @author Marina
 */
@RestController
public class MyRestController {
    
    @Autowired
    AdDao adDao;
    
    @Autowired
    CompanyDao companyDao;
    
    @Autowired
    AdService adService;
    
    @Autowired
    CompanyService companyService;
    
    @RequestMapping(value = "/ads", method =
    RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ad>> getAllAds() {
        System.out.println("Fetching ads");
        List<Ad> ads = adDao.getAllAds();
        if (ads.size() == 0) {
            System.out.println("Ads list empty");
            return new ResponseEntity<List<Ad>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Ad>>(ads, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/ad/{id}", method =
    RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
    public ResponseEntity<Ad> getAd(@PathVariable("id") int id) {
        System.out.println("Fetching ad with id " + id);
        Ad ad = adDao.getById(id);
        if (ad == null) {
        System.out.println("Ad with " + id + " not found");
        return new ResponseEntity<Ad>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Ad>(ad, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/ad/", method = RequestMethod.POST)
    public ResponseEntity<Void> addAd(@RequestBody Ad ad) {
        System.out.println("Adding new ad " + ad.toString());
        adService.addAd(ad);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/ad/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Ad> deleteAd(@PathVariable("id") int id) {
    System.out.println("Deleting ad with id " + id);
    Ad ad = adDao.getById(id);
    int adId = ad.getId();
    if (ad == null) {
        System.out.println("Unable to delete. Ad with id " + id + " not found");
        return new ResponseEntity<Ad>(HttpStatus.NOT_FOUND);
    }
    adService.deleteAd(adId);
    return new ResponseEntity<Ad>(HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/companies", method =
    RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Company>> getAllCompanies() {
        System.out.println("Fetching companies");
        List<Company> companies = companyDao.getAllCompanies();
        if (companies.size() == 0) {
            System.out.println("Companies list empty");
            return new ResponseEntity<List<Company>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Company>>(companies, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/company/{id}", method =
    RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
    public ResponseEntity<Company> getComapy(@PathVariable("id") int id) {
        System.out.println("Fetching company with id " + id);
        Company company = companyDao.getById(id);
        if (company == null) {
        System.out.println("Company with " + id + " not found");
        return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Company>(company, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/company/", method = RequestMethod.POST)
    public ResponseEntity<Void> addCompany(@RequestBody Company company) {
        System.out.println("Adding new company " + company.toString());
        companyService.addCompany(company);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Company> deleteCompany(@PathVariable("id") int id) {
    System.out.println("Deleting company with id " + id);
    Company company = companyDao.getById(id);
    int companyId = company.getId();
    if (company == null) {
        System.out.println("Unable to delete. Company with id " + id + " not found");
        return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
    }
    companyService.deleteCompany(companyId);
    return new ResponseEntity<Company>(HttpStatus.OK);
    }

}
