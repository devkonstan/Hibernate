import java.util.List;

public class WykladowcaDAO extends Session implements iWykladowcaDAO {

    @Override
    public void persist(Wykladowca wykladowca) {
        entityManager.merge(wykladowca);
    }

    public Wykladowca getById(int id) {
        return entityManager.find(Wykladowca.class, id);
    }

    public List<Wykladowca> getAll() {
        return entityManager.createQuery("FROM Wykladowca").getResultList();
    }

    public void delete(Wykladowca wykladowca) {
        entityManager.remove(wykladowca);
    }

    public void update(Wykladowca wykladowca) {
        entityManager.merge(wykladowca);
    }
}
