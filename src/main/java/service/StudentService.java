package service;

import dao.StudentDao;
import dao.iStudentDao;
import model.Student;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class StudentService {

    private iStudentDao studentDao = new StudentDao();

    public void save(Student student) {
//        student.setNumer_indeksu(getRandomIndex());
        studentDao.openSessionWithTransaction();
        studentDao.persist(student);
        studentDao.closeSessionWithTransaction();
    }

    private String getRandomIndex() {
        Random random = new Random();
        return random.nextInt(899999) + 100000 + "";
    }

    public Optional<Student> getById(int id) {
        studentDao.openSessionWithTransaction();
        Optional<Student> studentOptional = Optional.ofNullable(studentDao.getById(id));
        studentDao.closeSessionWithTransaction();

        return studentOptional;
    }

    public List<Student> getAll() {
        studentDao.openSessionWithTransaction();
        List<Student> students = studentDao.getAll();
        studentDao.closeSessionWithTransaction();

        return students;
    }

    public void delete(int id) {
        studentDao.openSessionWithTransaction();
        Student student = studentDao.getById(id);
        studentDao.delete(student);
        studentDao.closeSessionWithTransaction();
    }

    public void update(Student student) {
        studentDao.openSessionWithTransaction();
        studentDao.update(student);
        studentDao.closeSessionWithTransaction();
    }

    public Optional<Student> getByIndex(String index) {
        studentDao.openSessionWithTransaction();
        Optional<Student> studentOptional = Optional.ofNullable(studentDao.getByIndex(index));
        studentDao.closeSessionWithTransaction();

        return studentOptional;
    }

    public List<Student> getAllByYear(Integer year, String surname) {
        studentDao.openSessionWithTransaction();
        List<Student> students = studentDao.getAllByYear(year, surname);
        studentDao.closeSessionWithTransaction();

        return students;
    }

    public void removeAllByFaculty(String faculty) {
        studentDao.openSessionWithTransaction();
        studentDao.removeAllByFaculty(faculty);
        studentDao.closeSessionWithTransaction();
    }

    public void updateAllplus1yearByProfile(String profile) {
        studentDao.openSessionWithTransaction();
        studentDao.updateAllplus1yearByProfile(profile);
        studentDao.closeSessionWithTransaction();
    }

    public void promoteAllStudents(List<String> indexNumbers) {
        studentDao.openSessionWithTransaction();
        studentDao.promoteAllStudents(indexNumbers);
        studentDao.closeSessionWithTransaction();
    }

    public List<Student> getStudentByCity(String city) {
        studentDao.openSessionWithTransaction();
        List<Student> students = studentDao.getStudentByCity(city);
        studentDao.closeSessionWithTransaction();

        return students;
    }

    public List<Student> getStudentByGroup(String group) {
        studentDao.openSessionWithTransaction();
        List<Student> students = studentDao.getStudentByGroup(group);
        studentDao.closeSessionWithTransaction();

        return students;
    }
}

