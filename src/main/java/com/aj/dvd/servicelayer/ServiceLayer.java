package com.aj.dvd.servicelayer;

import com.aj.dvd.dao.DaoFilePersistenceException;
import com.aj.dvd.dto.DVD;

import java.util.Collection;

public interface ServiceLayer {
    public void createDVD(DVD dvd) throws DaoFilePersistenceException, DaoValidationException, DuplicateTitleException;

    public DVD removeDVD(String title) throws DaoFilePersistenceException;

    public void editDVD(DVD dvd) throws DaoFilePersistenceException;

    public Collection<String> listDVDs() throws DaoFilePersistenceException;

    public DVD getDVDFromTitle(String title) throws DaoFilePersistenceException;
    public DVD checkForExistence(String title) throws DaoFilePersistenceException,DaoValidationException;

}


