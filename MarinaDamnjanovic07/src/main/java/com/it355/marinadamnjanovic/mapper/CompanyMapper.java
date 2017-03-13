package com.it355.marinadamnjanovic.mapper;

import com.it355.marinadamnjanovic.model.Ad;
import com.it355.marinadamnjanovic.model.Company;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Marina
 */
public class CompanyMapper implements RowMapper<Company> {
    
    @Override
    public Company mapRow(ResultSet rs, int arg1) throws SQLException {
        Company company=new Company();
        company.setId(rs.getInt("id"));
        company.setName(rs.getString("ime"));
        company.setCity(rs.getString("grad"));
        company.setEmail("email");
        return company;
}
}
