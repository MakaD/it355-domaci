package com.it355.marinadamnjanovic.controller;

import com.it355.marinadamnjanovic.dao.MDDao;
import com.it355.marinadamnjanovic.entity.Ad;
import com.it355.marinadamnjanovic.entity.Company;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Marina
 */
@Controller
public class MDController {
    
    @Autowired
    MDDao dao;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }
    
    @RequestMapping(value = "/addAd", method =
    RequestMethod.GET)
    public String addAd(Model model) {
        model.addAttribute("ad", new Ad());
        return "addAd";
    }
    
    @RequestMapping(value = "/editAd/{id}", method =
    RequestMethod.GET)
    public String addProduct(@PathVariable("id") int id, Model model) {
        Ad a = dao.getAdById(id);
        model.addAttribute("ad",a);
        return "addAd";
    }
    
    @RequestMapping(value = "/addAd", method =
    RequestMethod.POST)
    public ModelAndView addProduct(@ModelAttribute("ad") Ad p, ModelAndView model) {
        p = dao.addAd(p);
        model.addObject("ads",
        dao.getAllAds());
        model.addObject("successMsg", "Ad successfully added");
        model.addObject("ad",p);
        return model;
    }
    
    @RequestMapping(value = "/seeads", method = RequestMethod.GET)
    public ModelAndView getAds(ModelAndView model) {
        model.addObject("ads",dao.getAllAds());
        model.addObject("ad", new Ad());
        return model;
    }
    @RequestMapping(value = "/deletead/{id}", method =
    RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") int id, HttpServletRequest request) {
        System.out.println("Fetching & Deleting ad with id" + id);
        Ad a = dao.getAdById(id);
        if (a == null) {
            System.out.println("Unable to delete. Ad with id " + id + " not found");
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }
        dao.deleteAd(a);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
    
    @RequestMapping(value = "/addCompany", method =
    RequestMethod.GET)
    public String addCompany(Model model) {
        model.addAttribute("company", new Ad());
        return "addCompany";
    }
    
    @RequestMapping(value = "/editCompany/{id}", method =
    RequestMethod.GET)
    public String addCompany(@PathVariable("id") int id, Model model) {
        Company c = dao.getCompanyById(id);
        model.addAttribute("company",c);
        return "addCompany";
    }
    
    @RequestMapping(value = "/addCompany", method =
    RequestMethod.POST)
    public ModelAndView addCompany(@ModelAttribute("company") Company p, ModelAndView model) {
        p = dao.addCompany(p);
        model.addObject("companies",
        dao.getAllCompanies());
        model.addObject("successMsg", "Company successfully added");
        model.addObject("company",p);
        return model;
    }
    
    @RequestMapping(value = "/seecompanies", method = RequestMethod.GET)
    public ModelAndView getCompanies(ModelAndView model) {
        model.addObject("companies",dao.getAllCompanies());
        model.addObject("company", new Company());
        return model;
    }
    @RequestMapping(value = "/deletecompany/{id}", method =
    RequestMethod.GET)
    public String deleteCompany(@PathVariable("id") int id, HttpServletRequest request) {
        System.out.println("Fetching & Deleting company with id" + id);
        Company a = dao.getCompanyById(id);
        if (a == null) {
            System.out.println("Unable to delete. Company with id " + id + " not found");
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }
        dao.deleteCompany(a);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
    
    
}
