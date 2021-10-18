package com.aj.dvd.servicelayer;

import com.aj.dvd.dao.AuditDao;
import com.aj.dvd.dao.DaoFilePersistenceException;

public class DaoAuditStub implements AuditDao {

    @Override
    public void auditEntry(String entry) throws DaoFilePersistenceException {

    }
}
