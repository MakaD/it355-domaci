package com.it355.marinadamnjanovic.dao.impl;

import com.it355.marinadamnjanovic.dao.AdDao;
import com.it355.marinadamnjanovic.mapper.AdMapper;
import com.it355.marinadamnjanovic.model.Ad;
import java.sql.Types;
import java.util.List;
import javax.activation.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Marina
 */
public class AdDaoImpl implements AdDao{
    
    private JdbcTemplate jdbcTemplate;
    @SuppressWarnings("unused")
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate((javax.sql.DataSource) dataSource);
    }

    @Override
    public int getCount() {
        String sql = "SELECT COUNT(*) FROM ADS";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<Ad> getAllAds() {
        String sql= "SELECT * FROM ADS";
        List<Ad> ads= jdbcTemplate.query(sql, new AdMapper());
        return ads;
    }

    @Override
    public boolean addAd(Ad ad) {
        String sql = "INSERT INTO ADS " + "(ID, TITLE, DESCRIPTION, DEADLINE) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, new Object[] {ad.getId(), ad.getTitle(), ad.getDescription(), ad.getDeadline()});
        return true;
    }
    
    @Override
    public Ad getById(int id){
        String sql= "SELECT * FROM ADS WHERE ID = ?";
        Ad ad= jdbcTemplate.queryForObject(sql, new Object[] { id }, new AdMapper());
        return ad;
    }
    
    @Override
    public boolean deleteAd(int id){
        String sql= "DELETE FROM ADS WHERE ID = ?";
        jdbcTemplate.update(sql, new Object[] { id }, new int[] {Types.BIGINT});
        return true;
    }
    
}
