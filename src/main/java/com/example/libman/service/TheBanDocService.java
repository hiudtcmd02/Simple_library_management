package com.example.libman.service;

import com.example.libman.dao.TheBanDocDAO;
import com.example.libman.entity.TheBanDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class TheBanDocService {
    @Autowired
    private TheBanDocDAO theBanDocDAO;

    public void saveNewReaderCard(TheBanDoc theBanDoc){
        TheBanDoc tbd = new TheBanDoc();
        tbd.setMaThe(theBanDoc.getMaThe());
        tbd.setNgayTaoThe(theBanDoc.getNgayTaoThe());
        tbd.setNgayHetHan(theBanDoc.getNgayHetHan());
        tbd.setBanDocId(theBanDoc.getBanDocId());

        theBanDocDAO.addTheBanDoc(tbd);
    }
}
