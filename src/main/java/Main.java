import model.Adres;
import model.Grupa;
import model.Student;
import model.Wykladowca;
import service.StudentService;

import java.util.Arrays;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Student student1 = new Student();
        student1.setImie("Szymon");
        student1.setNazwisko("Nowak");
        student1.setNumer_indeksu("883794");
        student1.setRok(3);
        student1.setProfil("Matematyka");
        student1.setWydzial("Mat-Fiz");

        studentService.save(student1);

        Student student2 = new Student();
        student2.setImie("Blazej");
        student2.setNazwisko("Kowalski");
        student2.setNumer_indeksu("987654");
        student2.setRok(3);
        student2.setProfil("Polski");
        student2.setWydzial("IT");

        studentService.save(student2);

        System.out.println(studentService.getById(1));
        System.out.println("******");

//        studentService.delete(1);
        System.out.println(studentService.getByIndex("883794"));
        System.out.println("******");

        System.out.println(studentService.getAll());
        System.out.println("******");

        System.out.println(studentService.getAllByYear(3, "Nowak"));
        System.out.println("******");

//        studentService.removeAllByFaculty("IT");
        System.out.println(studentService.getAll());
        System.out.println("******");

        studentService.updateAllplus1yearByProfile("Matematyka");
        System.out.println(studentService.getAll());
        System.out.println("******");

        studentService.promoteAllStudents(Arrays.asList("10"));
            System.out.println(studentService.getAll());

        Adres adres = new Adres();
        adres.setMiasto("Warszawa");
        adres.setKod("11-111");
        adres.setUlica("Żubrów");

        student1.setAdres(adres);
        studentService.save(student1);

        Wykladowca wykladowca = new Wykladowca();
        wykladowca.setWydzial("WF");
        wykladowca.setImie("Jan");
        wykladowca.setNazwisko("Kowalczyk");

        student1.setWykladowca(wykladowca);
        studentService.save(student1);

        Grupa grupa = new Grupa();
        grupa.setNazwa("biblijna");

        student1.setGrupy(Arrays.asList(grupa));
        studentService.save(student1);
        System.out.println("*****");

        System.out.println("by city: " + studentService.getStudentByCity("Warszawa"));

        System.out.println("by group" + studentService.getStudentByGroup("biblijna"));



        student2.setNazwisko("Psikuta");
        studentService.update(student2);
        System.out.println(studentService.getAll());


        wykladowca.setImie("Jan");
        wykladowca.setNazwisko("Kubicki");
        wykladowca.setWydzial("Humanistyczny");


        service.WykladowcaService wykladowcaService = new service.WykladowcaService();
        Wykladowca profesor = new Wykladowca();
        wykladowcaService.save(profesor);
        System.out.println(wykladowcaService.getById(1));
        wykladowcaService.getAll();
    }
}
