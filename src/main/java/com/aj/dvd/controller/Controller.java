package com.aj.dvd.controller;

import com.aj.dvd.dao.AuditDao;
import com.aj.dvd.dao.Dao;
import com.aj.dvd.dao.DaoFilePersistenceException;
import com.aj.dvd.dto.DVD;
import com.aj.dvd.servicelayer.DaoValidationException;
import com.aj.dvd.servicelayer.DuplicateTitleException;
import com.aj.dvd.servicelayer.ServiceLayer;
import com.aj.dvd.ui.View;

import java.util.Collection;

public class Controller {

    private View view;
    private ServiceLayer serviceLayer;

    public Controller(View view, ServiceLayer serviceLayer) {
        this.view = view;
        this.serviceLayer = serviceLayer;
    }

    public void run() {

        boolean whilstRunning = true;
        int userChoice;
        try {
            while (whilstRunning) {
                view.displayMenu();
                userChoice = view.getUserChoice();

                switch (userChoice) {
                    case 1:
                        addDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        editDVD();
                        break;
                    case 4:
                        listDVDs();
                        break;
                    case 5:
                        displayDVD();
                        break;
                    case 6:
                        searchDVD();
                        break;
                    case 7:
                        whilstRunning = false;
                        view.exitingMessage();
                        break;
                    default:
                        System.out.println("default message");
                }
            }
        } catch (DaoFilePersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    public void addDVD() throws DaoFilePersistenceException {
        boolean adding = true;
        do {
            DVD newDVD = view.getNewDVD();
            try {
                serviceLayer.createDVD(newDVD);
                adding = view.addDVDSuccess();
            } catch (DuplicateTitleException | DaoValidationException e) {
                view.displayErrorMessage(e.getMessage());
                adding = false;
            }
        } while (adding);
    }

    public void editDVD() throws DaoFilePersistenceException {
        String title = view.getTitle();
        DVD dvd = null;
        try {
            dvd = serviceLayer.checkForExistence(title);
            DVD editedDVD = view.editDVD(dvd);
            try {
                serviceLayer.editDVD(editedDVD);
            } catch (DaoFilePersistenceException
                    e) {
                view.displayErrorMessage(e.getMessage());
            }
        } catch (DaoValidationException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    public void removeDVD() throws DaoFilePersistenceException {
        boolean removing = true;
        do {
            String title = view.getTitle();
            DVD exDVD = serviceLayer.removeDVD(title);
            removing = view.dvdRemoveMessage(exDVD);
        }
        while (removing);
    }

    public void listDVDs() throws DaoFilePersistenceException {
        Collection<String> dvds = serviceLayer.listDVDs();
        view.listDVDs(dvds);
    }

    public void displayDVD() throws DaoFilePersistenceException {
        String title = view.getTitle();
        DVD dvd = serviceLayer.getDVDFromTitle(title);
        view.displayDVDInfo(dvd);
    }

    public void searchDVD() throws DaoFilePersistenceException {
        String title = view.getTitle();
        DVD dvd = serviceLayer.getDVDFromTitle(title);
        view.dvdSearch(dvd);
    }
}
