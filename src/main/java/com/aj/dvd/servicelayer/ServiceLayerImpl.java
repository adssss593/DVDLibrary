package com.aj.dvd.servicelayer;

import com.aj.dvd.dao.AuditDao;
import com.aj.dvd.dao.Dao;
import com.aj.dvd.dao.DaoFilePersistenceException;
import com.aj.dvd.dao.DaoFileImpl;
import com.aj.dvd.dto.DVD;

import java.util.Collection;
import java.util.Set;

public class ServiceLayerImpl implements ServiceLayer{

    private Dao dao;
    private AuditDao auditDao;

    public ServiceLayerImpl(Dao dao, AuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void createDVD(DVD dvd) throws DaoFilePersistenceException, DaoValidationException, DuplicateTitleException {
        validateDVD(dvd);
        checkForNonExistence(dvd);
        dao.addDVD(dvd);
        auditDao.auditEntry(dvd.getTitle() + "added.");
    }

    @Override
    public DVD removeDVD(String title) throws DaoFilePersistenceException{
        DVD exDVD = dao.removeDVD(title);
        auditDao.auditEntry(exDVD.getTitle() + " removed.");
        return exDVD;
    }

    @Override
    public void editDVD (DVD dvd) throws DaoFilePersistenceException{
        dao.addDVD(dvd);
        auditDao.auditEntry(dvd.getTitle() + " edited.");
    }

    @Override
    public Collection<String> listDVDs () throws DaoFilePersistenceException {
        return dao.listDVDs();
    }

    @Override
    public DVD getDVDFromTitle(String title) throws DaoFilePersistenceException {
        return dao.getDVDFromTitle(title);
    }

    public void validateDVD(DVD dvd) throws DaoValidationException {
        if (dvd.getTitle()==null
                || dvd.getTitle().strip().length() == 0) {
            throw new DaoValidationException("ERROR:  Film must have a title!!");
        }
    }

    @Override
    public DVD checkForExistence(String title) throws DaoFilePersistenceException,DaoValidationException {
        DVD possibleDVD = dao.getDVDFromTitle(title);
        if (possibleDVD == null) {
            throw new DaoValidationException("ERROR: film does not exist");
        }
        return possibleDVD;
    }

    public void checkForNonExistence(DVD dvd) throws DaoFilePersistenceException, DuplicateTitleException{
        if (dao.getDVDFromTitle(dvd.getTitle()) != null) {
            throw new DuplicateTitleException("ERROR: Film already exists!!");
        }
    }


}
