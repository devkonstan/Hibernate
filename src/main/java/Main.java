import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Student student = new Student();
        student.setImie("Szymon");
        student.setNazwisko("Nowak");
        //student.setNumer_indeksu("883794");
        student.setRok(3);
        student.setProfil("Matematyka");
        student.setWydzial("Mat-Fiz");

        studentService.save(student);

        Student student2 = new Student();
        student2.setImie("Blazej");
        student2.setNazwisko("Nowak");
        student2.setNumer_indeksu("987654");
        student2.setRok(3);
        student2.setProfil("Matematyka");
        student2.setWydzial("IT");

        studentService.save(student2);
        System.out.println("******");
        System.out.println(studentService.getById(1));
        System.out.println("******");

        //studentService.delete(1);
        System.out.println(studentService.getAll());
//        System.out.println(studentService.getByIndex("883794"));

        System.out.println(studentService.getAllByYear(3, "Nowak"));

        studentService.removeAllByFaculty("IT");
        System.out.println(studentService.getAll());

        studentService.updateAllplus1yearByProfile("Matematyka");
        System.out.println(studentService.getAll());

        studentService.promoteAllStudents(Arrays.asList("10"));
        System.out.println(studentService.getAll());

        Adres adres = new Adres();
        adres.setMiasto("Warszawa");
        adres.setKod("11-111");
        adres.setUlica("Żubrów");

        student.setAdres(adres);
        studentService.save(student);

        Wykladowca wykladowca = new Wykladowca();
        wykladowca.setWydzial("WF");
        wykladowca.setImie("Jan");
        wykladowca.setNazwisko("Kowalczyk");

        student.setWykladowca(wykladowca);
        studentService.save(student);

        Grupa grupa = new Grupa();
        grupa.setNazwa("biblijna");

        student.setGrupy(Arrays.asList(grupa));
        studentService.save(student);

        System.out.println("*****");

        System.out.println("by city: " + studentService.getStudentByCity("Szczecin"));

        System.out.println("by group" + studentService.getStudentByGroup("biblijna"));


//        Student fromDB = studentService.getById(3);
//        fromDB.setNazwisko("Psikuta");
//        studentService.update(fromDB);
//        System.out.println(studentService.getAll());

//        WykladowcaService wykladowcaService = new WykladowcaService();
//        Wykladowca wykladowca = new Wykladowca();
//        wykladowca.setImie("Jan");
//        wykladowca.setNazwisko("Kowalski");
//        wykladowca.setWydzial("Humanistyczny");

//        wykladowcaService.save(wykladowca);
//        System.out.println(wykladowcaService.getById(1));
//        wykladowcaService.getAll();
    }
}
