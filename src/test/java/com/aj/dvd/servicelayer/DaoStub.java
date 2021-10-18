package com.aj.dvd.servicelayer;

import com.aj.dvd.dao.Dao;
import com.aj.dvd.dao.DaoFilePersistenceException;
import com.aj.dvd.dto.DVD;

import java.util.ArrayList;
import java.util.Collection;

public class DaoStub implements Dao {


    DVD onlyDVD;

    public DaoStub() {
         this.onlyDVD = new DVD("Mary Poppins",
                "1967",
                "U",
                "Unknown",
                "Disney",
                "Classic");
    }

    public DaoStub(DVD testDVD) {
        this.onlyDVD = testDVD;
    }

    @Override
    public DVD addDVD(DVD dvd) throws DaoFilePersistenceException {
        if (dvd.getTitle().equals(onlyDVD.getTitle())) {
            return onlyDVD;
        }
        else {
            return null;
        }
    }

    @Override
    public DVD removeDVD(String title) throws DaoFilePersistenceException {
        return null;
    }

    @Override
    public Collection<String> listDVDs() throws DaoFilePersistenceException {
        return null;
    }

    @Override
    public DVD getDVDFromTitle(String title) throws DaoFilePersistenceException {
        if (title.equals(onlyDVD.getTitle())) {
            return onlyDVD;
        } else
            return null;
    }
}
