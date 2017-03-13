package com.it355.marinadamnjanovic.controller;

import com.it355.marinadamnjanovic.dao.AdDao;
import com.it355.marinadamnjanovic.dao.CompanyDao;
import com.it355.marinadamnjanovic.model.Ad;
import com.it355.marinadamnjanovic.model.Company;
import com.it355.marinadamnjanovic.service.AdService;
import com.it355.marinadamnjanovic.service.CompanyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Marina
 */
public class HelloController {
    @Autowired
    AdDao adDao;
    
    @Autowired
    CompanyDao companyDao;
    
    @Autowired
    AdService adService;
    
    @Autowired
    CompanyService companyService;
    
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView defaultPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("message", "Ovo je strana kojoj svi mogu da pristupe!");
        model.setViewName("hello");
        return model;
    }
    
    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("message", "Ovo je strana za admine!");
        model.setViewName("admin");
        return model;
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
    @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
        model.addObject("error", "Losi login podaci!");
        }
        if (logout != null) {
        model.addObject("msg", "Izlogovani ste.");
        }
        model.setViewName("login");
        return model;
    }
    
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {
    ModelAndView model = new ModelAndView();
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (!(auth instanceof AnonymousAuthenticationToken)) {
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        System.out.println(userDetail);
        model.addObject("username", userDetail.getUsername());
    }
    model.setViewName("403");
    return model;
    }
    
    @RequestMapping(value="/ads", method=RequestMethod.GET)
    public ModelAndView ads(ModelAndView modelAndView) {
        List<Ad> ads= adService.getAllAds();
        modelAndView.addObject("ads", ads);
        modelAndView.setViewName("ads");
        return modelAndView;
    }
    
    @RequestMapping(value="/companies", method=RequestMethod.GET)
    public ModelAndView companies(ModelAndView modelAndView) {
        List<Company> companies= companyDao.getAllCompanies();
        for (Company company : companies) {
            System.err.println(company.toString());
        }
        modelAndView.addObject("companies", companies);
        modelAndView.setViewName("companies");
        return modelAndView;
    }
    
    @RequestMapping(value = "/addad", method = RequestMethod.GET)
        public String addStudent(Model model) {
        model.addAttribute("ad", new Ad());
        return "addad";
    }
    
    @RequestMapping(value= "/addad", method = RequestMethod.POST)
    public ModelAndView addHomeForm(@ModelAttribute("ad")
    Ad p, ModelAndView model) {
        model.addObject("object", p);
        p.setId(adDao.getCount()+1);
        adService.addAd(p);
        return model;
    }
    
    @RequestMapping(value = "/addcompany", method = RequestMethod.GET)
    public String addSubject(Model model) {
        model.addAttribute("company", new Company());
        return "addcompany";
    }
    
    @RequestMapping(value= "/addcompany", method = RequestMethod.POST)
    public ModelAndView addSubject(@ModelAttribute("company")
    Company p, ModelAndView model) {
        model.addObject("object", p);
        p.setId(companyDao.getCount()+1);
        companyService.addCompany(p);
        return model;
    }
}
