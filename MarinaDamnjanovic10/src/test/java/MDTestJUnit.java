import com.it355.marinadamnjanovic.dao.MDDao;
import com.it355.marinadamnjanovic.dao.impl.MDDaoImpl;
import com.it355.marinadamnjanovic.entity.Ad;
import com.it355.marinadamnjanovic.entity.Company;
import java.util.Arrays;
import java.util.List;
import java.util.Locale.Category;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Marina
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/marinadamnjanovic-servlet.xml"})
public class MDTestJUnit {
    
    @Autowired
    protected MDDao dao;
    
    @Autowired
    private ApplicationContext context;
    
    @Before
    public void setUp() {
        dao = new MDDaoImpl();
    }
    
    @Test
    public void addCompanyTest() {
        Company com = new Company();
        com.setName("Nova kompanija");
        Company newCom = dao.addCompany(com);
        dao.deleteCompany(newCom);
        Assert.assertNotNull(newCom);
    }
    
    @Test
    public void addAdTest() {
        Ad ad = new Ad();
        ad.setTitle("Novi oglas");
        Ad newAd = dao.addAd(ad);
        dao.deleteAd(newAd);
        Assert.assertNotNull(newAd);
    }
    
    @Test
    public void getCompanyByIdTest() {
        Company cat = new Company();
        cat.setName("Nova kategorija");
        Company newCom = dao.addCompany(cat);
        Company get =
        dao.getCompanyById(newCom.getId());
        dao.deleteCompany(newCom);
        Assert.assertNotNull(get);
    }
    
    @Test
    public void getAdByIdTest() {
        Ad ad = new Ad();
        ad.setTitle("Novi oglas");
        Ad newAd = dao.addAd(ad);
        Ad get =
        dao.getAdById(newAd.getId());
        dao.deleteAd(newAd);
        Assert.assertNotNull(get);
    }
    
    @Test
    public void getAllCompaniesTest() {
        Company first = new Company();
        first.setName("First");
        first.setEmail("first.company@gmail.com");
        first.setCity("Nis");
        Company second = new Company();
        second.setName("Second");
        second.setEmail("second.company@gmail.com");
        second.setCity("Novi Sad");
        
        Company newFirst = dao.addCompany(first);
        Company newSecond = dao.addCompany(second);
        
        Company[] array = {first, second};
        
        Assert.assertArrayEquals(array, new Company[] {newFirst, newSecond});
    }
    
    @Test
    public void getAllAdsTest() {
        Ad first = new Ad();
        first.setTitle("First");
        first.setDescription("First Ad");
        first.setDeadline("First deadline");
        Ad second = new Ad();
        second.setTitle("Second");
        second.setDescription("Second Ad");
        second.setDeadline("Second deadline");
        
        Ad newFirst = dao.addAd(first);
        Ad newSecond = dao.addAd(second);
        
        Ad[] array = {first, second};
        
        Assert.assertArrayEquals(array, new Ad[] {newFirst, newSecond});
    }

    @Test
    public void deleteAdTest() {
        Ad ad = new Ad();
        ad.setTitle("Naslov");
        ad.setDescription("Opis");
        ad.setDeadline("ROk");
        Ad newAd = dao.addAd(ad);
        dao.deleteAd(newAd);
        Ad deletedAd =
        dao.getAdById(newAd.getId());
        Assert.assertNull(deletedAd);
    }
    
}
