public class WykladowcaService {

    private iWykladowcaDAO wykladowcaDAO = new WykladowcaDAO();

    public void save(Wykladowca wykladowca) {
        wykladowcaDAO.openSessionWithTransaction();
        wykladowcaDAO.persist(wykladowca);
        wykladowcaDAO.closeSessionWithTransaction();
    }

    public Wykladowca getById(int id) {
        wykladowcaDAO.openSessionWithTransaction();
        Wykladowca wykladowca = wykladowcaDAO.getById(id);
        wykladowcaDAO.closeSessionWithTransaction();

        return wykladowca;
    }
}
