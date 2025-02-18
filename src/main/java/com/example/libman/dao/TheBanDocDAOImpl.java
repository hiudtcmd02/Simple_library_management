package com.example.libman.dao;

import com.example.libman.entity.TheBanDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TheBanDocDAOImpl implements TheBanDocDAO{
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public TheBanDocDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addTheBanDoc(TheBanDoc theBanDoc) {
        String sql = "INSERT INTO thebandoc (maThe, ngayTaoThe, ngayHetHan, BanDocid) VALUES ( ?, ?, ?, ?)";
        jdbcTemplate.update(sql, theBanDoc.getMaThe(), theBanDoc.getNgayTaoThe(), theBanDoc.getNgayHetHan(), theBanDoc.getBanDocId());
    }
}
