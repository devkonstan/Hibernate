import java.util.List;
import java.util.Random;

public class StudentService {

    private iStudentDAO studentDAO = new StudentDAO();

    public void save(Student student) {
        student.setNumer_indeksu(getRandomIndex());
        studentDAO.openSessionWithTransaction();
        studentDAO.persist(student);
        studentDAO.closeSessionWithTransaction();
    }

    private String getRandomIndex() {
        Random random = new Random();
        return random.nextInt(899999) + 100000 + "";
    }

    public Student getById(int id) {
        studentDAO.openSessionWithTransaction();
        Student student = studentDAO.getById(id);
        studentDAO.closeSessionWithTransaction();

        return student;
    }

    public List<Student> getAll() {
        studentDAO.openSessionWithTransaction();
        List<Student> students = studentDAO.getAll();
        studentDAO.closeSessionWithTransaction();
        return students;
    }

    public void delete(int id) {
        studentDAO.openSessionWithTransaction();
        Student student = studentDAO.getById(id);
        studentDAO.delete(student);
        studentDAO.closeSessionWithTransaction();
    }

    public void update(Student student) {
        studentDAO.openSessionWithTransaction();
        studentDAO.update(student);
        studentDAO.closeSessionWithTransaction();
    }

    public Student getByIndex(String index) {
        studentDAO.openSessionWithTransaction();
        Student student = studentDAO.getByIndex(index);
        studentDAO.closeSessionWithTransaction();

        return student;
    }

    public List<Student> getAllByYear(Integer year, String surname) {
        studentDAO.openSessionWithTransaction();
        List<Student> students = studentDAO.getAllByYear(year, surname);
        studentDAO.closeSessionWithTransaction();

        return students;
    }

    public void removeAllByFaculty(String faculty) {
        studentDAO.openSessionWithTransaction();
        studentDAO.removeAllByFaculty(faculty);
        studentDAO.closeSessionWithTransaction();
    }

    public void updateAllplus1yearByProfile(String profile) {
        studentDAO.openSessionWithTransaction();
        studentDAO.updateAllplus1yearByProfile(profile);
        studentDAO.closeSessionWithTransaction();
    }

    public void promoteAllStudents(List<String> indexNumbers) {
        studentDAO.openSessionWithTransaction();
        studentDAO.promoteAllStudents(indexNumbers);
        studentDAO.closeSessionWithTransaction();
    }

    public List<Student> getStudentByCity(String city) {
        studentDAO.openSessionWithTransaction();
        List<Student> students = studentDAO.getStudentByCity(city);
        studentDAO.closeSessionWithTransaction();

        return students;
    }

    public List<Student> getStudentByGroup(String group) {
        studentDAO.openSessionWithTransaction();
        List<Student> students = studentDAO.getStudentByGroup(group);
        studentDAO.closeSessionWithTransaction();

        return students;
    }
}

