package service;

import dao.WykladowcaDao;
import dao.iWykladowcaDao;
import model.Wykladowca;

import java.util.List;

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

    public List<Wykladowca> getAll() {
        wykladowcaDao.openSessionWithTransaction();
        List<Wykladowca> profesors = wykladowcaDao.getAll();
        wykladowcaDao.closeSessionWithTransaction();

        return profesors;
    }
}
