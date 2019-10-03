package service;

import DAO.WykladowcaDao;
import DAO.iWykladowcaDao;
import model.Wykladowca;

public class WykladowcaService {

    private iWykladowcaDao wykladowcaDao = new WykladowcaDao();

    public void save(Wykladowca wykladowca) {
        wykladowcaDao.openSessionWithTransaction();
        wykladowcaDao.persist(wykladowca);
        wykladowcaDao.closeSessionWithTransaction();
    }

    public Wykladowca getById(int id) {
        wykladowcaDao.openSessionWithTransaction();
        Wykladowca wykladowca = wykladowcaDao.getById(id);
        wykladowcaDao.closeSessionWithTransaction();

        return wykladowca;
    }
}
