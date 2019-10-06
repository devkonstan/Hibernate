package dao;

import model.Wykladowca;
import service.iSession;

import java.util.List;

public interface iWykladowcaDao extends iSession {

    void persist(Wykladowca wykladowca);

    Wykladowca getById(int id);

    List<Wykladowca> getAll();

    void delete(Wykladowca wykladowca);

    void update(Wykladowca wykladowca);
}
