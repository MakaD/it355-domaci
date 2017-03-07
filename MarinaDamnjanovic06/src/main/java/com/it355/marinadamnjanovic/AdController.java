package com.it355.marinadamnjanovic;

import com.it355.dao.AdDao;
import com.it355.model.Ad;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Marina
 */
@Controller
public class AdController {
    
    @Autowired
    private MessageSource messageSource;
    
    @Autowired
    private AdDao adDao;
    
    @RequestMapping(value = "/addAd", method = RequestMethod.GET)
    public String addAd(ModelMap model) {
        System.out.println("Pozivam message source");
        System.out.println(messageSource.getMessage("title", null, Locale.ENGLISH));
        
        model.addAttribute("command", new Ad());
        
        adDao.addAd();
        adDao.addAdAround("moj naslov je <== ");
        try {
            adDao.addAdThrowException();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "addAd";
        
        //return new ModelAndView("addAd", "command", new Ad());
    }
    
    @RequestMapping(value = "/showAd", method = RequestMethod.POST)
    public String showAd(@ModelAttribute Ad ad, ModelMap model) {
        /*model.addAttribute("title", ad.getTitle());
        model.addAttribute("description", ad.getDescription());
        model.addAttribute("deadline", ad.getDeadline());*/
        
        model.addAttribute("ad", ad);
        
        return "result";
    }
    
}
