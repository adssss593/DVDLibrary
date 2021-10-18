package com.aj.dvd.servicelayer;

import com.aj.dvd.dao.AuditDao;
import com.aj.dvd.dao.Dao;
import com.aj.dvd.dao.DaoFilePersistenceException;
import com.aj.dvd.dto.DVD;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceLayerImplTest {

    DVD differentDVD = new DVD("Wizard of oz",
            "1940",
            "U",
            "Director",
            "Disney",
            "technicolour"
            );
    ServiceLayer testServiceLayer;

    public ServiceLayerImplTest () {
        Dao daoStub = new DaoStub();
        AuditDao auditDaoStub = new DaoAuditStub();
        testServiceLayer = new ServiceLayerImpl(daoStub,auditDaoStub);
    }

    @Test
    void testValidDVD() {
        try {
            testServiceLayer.createDVD(differentDVD);
        } catch (DuplicateTitleException |
                DaoValidationException |
                DaoFilePersistenceException e) {
            fail("Adding this dvd should not throw this error");
        }
    }

    @Test
    void testDuplicatedDVD() {
        DVD onlyDVD = new DVD("Mary Poppins",
                "1967",
                "U",
                "Unknown",
                "Disney",
                "Classic");
        try {
            testServiceLayer.createDVD(onlyDVD);
            fail("Should not work because dvd exists");
        } catch (DaoValidationException |
                DaoFilePersistenceException e) {
            fail("Wrong exception thrown");
        } catch (DuplicateTitleException e) {
            return;
        }
    }

    @Test
    void testInvalidData() {
        differentDVD.setTitle("");
        try {
            testServiceLayer.createDVD(differentDVD);
            fail("Should not be allowed to create DVD");
        } catch (DuplicateTitleException | DaoFilePersistenceException e) {
            fail("wrong error thrown");
        } catch (DaoValidationException e) {
            return;
        }
    }

    @Test
    void testForExistence () {
        try {
            testServiceLayer.checkForExistence("Gladiator");
            fail("Film does not exist in list");
        } catch (DaoFilePersistenceException e) {
            fail("Wrong error thrown");
        }catch (DaoValidationException e) {
            return;
        }
    }
}