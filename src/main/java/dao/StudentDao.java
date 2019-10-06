package dao;

import model.Student;
import service.Session;

import java.util.List;

public class StudentDao extends Session implements iStudentDao {

    @Override
    public void persist(Student student) {
        entityManager.merge(student);
    }

    public Student getById(int id) {

        return entityManager.find(Student.class, id);
    }

    public List<Student> getAll() {

        return entityManager.createQuery("FROM Student").getResultList();
    }

    public void delete(Student student) {
        entityManager.remove(student);
    }

    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    public Student getByIndex(String indexNumber) {
        String getByIndexSQL = "SELECT s from Student s WHERE s.numer_indeksu =:indexNumber";

        return entityManager.createQuery(getByIndexSQL, Student.class)
                .setParameter("indexNumber", indexNumber)
                .getSingleResult();
    }

    @Override
    public List<Student> getAllByYear(Integer year, String surname) {
        return entityManager.createQuery("SELECT s FROM Student s WHERE s.rok=:year AND s.nazwisko=:surname", Student.class)
                .setParameter("year", year)
                .setParameter("surname", surname)
                .getResultList();
    }

    @Override
    public void removeAllByFaculty(String faculty) {
        entityManager.createQuery("DELETE FROM Student s WHERE s.wydzial=:faculty")
                .setParameter("faculty", faculty)
                .executeUpdate();
    }

    @Override
    public void updateAllplus1yearByProfile(String profile) {
        entityManager.createQuery("UPDATE Student s SET s.rok=rok+1 WHERE s.profil=:profile")
                .setParameter("profile", profile)
                .executeUpdate();
    }

    @Override
    public void promoteAllStudents(List<String> indexNumbers) {

        for (String index : indexNumbers) {
            entityManager.createQuery("UPDATE Student s SET s.rok=rok+1 WHERE s.numer_indeksu=:numer")
                    .setParameter("numer", index)
                    .executeUpdate();
        }

    }

    @Override
    public List<Student> getStudentByCity(String city) {
        return entityManager.createQuery("SELECT s FROM Student s WHERE s.adres.miasto=:miasto", Student.class)
                .setParameter("miasto", city)
                .getResultList();
    }

    @Override
    public List<Student> getStudentByGroup(String group) {
        return entityManager.createQuery("SELECT s FROM Student s JOIN s.grupy g WHERE g.nazwa=:grupa", Student.class)
                .setParameter("grupa", group)
                .getResultList();
    }
}

