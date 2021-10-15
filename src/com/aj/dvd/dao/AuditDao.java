package com.aj.dvd.dao;

public interface AuditDao {
    public void auditEntry(String entry) throws DaoFilePersistenceException;
}
