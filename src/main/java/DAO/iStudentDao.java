package DAO;

import model.Student;
import model.iSession;

import java.util.List;

public interface iStudentDao extends iSession {

    void persist(Student student);

    Student getById(int id);

    List<Student> getAll();

    void delete(Student student);

    void update(Student student);

    Student getByIndex(String indexNumber);

    List<Student> getAllByYear(Integer year, String surname);

    void removeAllByFaculty(String faculty);

    void updateAllplus1yearByProfile(String profile);

    void promoteAllStudents(List<String> indexNumbers);

    List<Student> getStudentByCity(String city);

    List<Student> getStudentByGroup(String group);
}
