package com.aj.dvd.dao;

import com.aj.dvd.dto.DVD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class DaoFileImplTest {

    Dao testDao;
    DVD dvd = new DVD("No time to die",
            "2021",
            "18",
            "Cary Joji Fukunaga",
            "paramount",
            "James bond");

    DVD dvd2 = new DVD("Sin tiempo para morir",
            "2021",
            "18",
            "Cary Joji Fukunaga",
            "paramount",
            "James bond");

    @BeforeEach
    void setUp() throws Exception{
        String testFile = "testDVDs.txt";
        new FileWriter(testFile);
        testDao = new DaoFileImpl(testFile);
    }

    @Test
    void addGetDVD() throws Exception{
        testDao.addDVD(dvd);
        DVD retrievedDVD = testDao.getDVDFromTitle("No time to die");
        assertEquals(dvd,retrievedDVD);
    }



    @Test
    void removeDVD() throws Exception{
        testDao.addDVD(dvd);
        testDao.addDVD(dvd2);

        testDao.removeDVD(dvd.getTitle());
        assertFalse(testDao.listDVDs() == null);
        assertTrue(testDao.listDVDs().size() == 1);
        DVD removedDVD = testDao.getDVDFromTitle(dvd.getTitle());
        assertTrue(removedDVD == null);

        testDao.removeDVD(dvd2.getTitle());
        assertFalse(testDao.listDVDs() == null);
        assertTrue(testDao.listDVDs().size() == 0);
        DVD secondRemovedDVD = testDao.getDVDFromTitle(dvd2.getTitle());
        assertTrue(secondRemovedDVD == null);


    }

    @Test
    void listDVDs() throws Exception{
        testDao.addDVD(dvd);
        testDao.addDVD(dvd2);
        Collection<String> titles = testDao.listDVDs();
        assertTrue(titles.size() == 2);
        assertNotNull(titles);
        assertTrue(titles.contains("No time to die"));
        assertTrue(titles.contains("Sin tiempo para morir"));
    }

    @Test
    void getDVDFromTitle() throws Exception{
        testDao.addDVD(dvd);
        String dvdTitle = dvd.getTitle();
        DVD retrievedDVD = testDao.getDVDFromTitle("No time to die");
        assertEquals(retrievedDVD,dvd);
    }
}