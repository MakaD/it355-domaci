package com.it355.marinadamnjanovic.dao.impl;

import com.it355.marinadamnjanovic.dao.CompanyDao;
import com.it355.marinadamnjanovic.mapper.CompanyMapper;
import com.it355.marinadamnjanovic.model.Ad;
import com.it355.marinadamnjanovic.model.Company;
import java.util.List;
import javax.activation.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Marina
 */
public class CompanyDaoImpl implements CompanyDao{
    
    private JdbcTemplate jdbcTemplate;
    @SuppressWarnings("unused")
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate((javax.sql.DataSource) dataSource);
    }

    @Override
    public int getCount() {
        String sql = "SELECT COUNT(*) FROM COMPANIES";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<Company> getAllCompanies() {
        String sql= "SELECT * FROM COMPANIES";
        List<Company> companies= jdbcTemplate.query(sql, new CompanyMapper());
        return companies;
    }

    @Override
    public boolean addCompany(Company company) {
        String sql = "INSERT INTO COMPANIES " + "(ID, NAME, CITY, EMAIL) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, new Object[] {company.getId(), company.getName(), company.getCity(), company.getEmail()});
        return true;
    }
    
}
