package com.aj.dvd;

import com.aj.dvd.controller.Controller;
import com.aj.dvd.dao.AuditDao;
import com.aj.dvd.dao.AuditDaoImpl;
import com.aj.dvd.dao.Dao;
import com.aj.dvd.dao.DaoFileImpl;
import com.aj.dvd.servicelayer.ServiceLayer;
import com.aj.dvd.servicelayer.ServiceLayerImpl;
import com.aj.dvd.ui.UserIO;
import com.aj.dvd.ui.UserIOConsoleImpl;
import com.aj.dvd.ui.View;

public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        View view = new View(io);
        Dao dao = new DaoFileImpl();
        AuditDao auditDao = new AuditDaoImpl();
        ServiceLayer serviceLayer = new ServiceLayerImpl(dao,auditDao);
        Controller controller = new Controller(view,serviceLayer);
        controller.run();

    }

}
