package com.it355.marinadamnjanovic;

import com.it355.model.Ad;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Marina
 */
@Controller
public class AdController {
    
    @Autowired
    private MessageSource messageSource;
    
    @RequestMapping(value = "/showAd", method = RequestMethod.GET)
    public ModelAndView showAd() {
        System.out.println("Pozivam message source");
        System.out.println(messageSource.getMessage("title", null, Locale.ENGLISH));
        
        return new ModelAndView("showAd", "command", new Ad());
    }
    
    @RequestMapping(value = "/addAd", method = RequestMethod.POST)
    public String addAd(@ModelAttribute Ad ad, ModelMap model) {
        model.addAttribute("title", ad.getTitle());
        model.addAttribute("description", ad.getDescription());
        model.addAttribute("deadline", ad.getDeadline());
        
        return "addAd";
    }
    
}
