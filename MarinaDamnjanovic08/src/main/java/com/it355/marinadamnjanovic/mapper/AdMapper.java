package com.it355.marinadamnjanovic.mapper;

import com.it355.marinadamnjanovic.model.Ad;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Marina
 */
public class AdMapper implements RowMapper<Ad> {
    
    @Override
    public Ad mapRow(ResultSet rs, int arg1) throws SQLException {
        Ad ad=new Ad();
        ad.setId(rs.getInt("id"));
        ad.setTitle(rs.getString("naslov"));
        ad.setDescription(rs.getString("opis"));
        ad.setDeadline("rok");
        return ad;
}
}
