import java.util.List;

public interface iWykladowcaDAO extends iSession{

    void persist(Wykladowca wykladowca);
    Wykladowca getById(int id);
    List<Wykladowca> getAll();
    void delete(Wykladowca wykladowca);
    void update(Wykladowca wykladowca);
}
