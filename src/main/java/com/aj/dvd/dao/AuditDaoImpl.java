package com.aj.dvd.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class AuditDaoImpl implements AuditDao{

    public static final String AUDIT_FILE = "audit.txt";

    @Override
    public void auditEntry(String entry) throws DaoFilePersistenceException {
        PrintWriter myWriter;
        try {
            myWriter = new PrintWriter(new FileWriter(AUDIT_FILE,true));
        } catch (IOException e) {
            throw new DaoFilePersistenceException("Could not find file",e);
        }
        LocalDateTime dateTimeStamp = LocalDateTime.now();
        myWriter.println(dateTimeStamp + " : " + entry);
        myWriter.flush();
    }
}
