package com.aj.dvd.dao;

import com.aj.dvd.dto.DVD;

import java.util.Collection;

public interface Dao {
    public void addDVD(DVD dvd)throws DaoFilePersistenceException;
    public DVD removeDVD(String title) throws DaoFilePersistenceException;
    public Collection<String> listDVDs()throws DaoFilePersistenceException;
    public DVD getDVDFromTitle (String title)throws DaoFilePersistenceException;
}
