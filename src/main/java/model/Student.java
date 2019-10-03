package model;

import model.Adres;
import model.Grupa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "imie") //nie trzeba tego dodawac, bo sam wygeneruje
    private String imie;
    private String nazwisko;
    private String numer_indeksu;
    private String wydzial;
    private Integer rok;
    private String profil;

    //wielu studentow moze mieszkac pod jednym adresem
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "adres_id")
    private Adres adres;

    //wielu studentow ma jednego wykladowce
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wykladowca_id")
    private Wykladowca wykladowca;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) //fetch domyslnie jest lazy
    @JoinTable(name = "student_grupa", joinColumns = {
            @JoinColumn(name = "student_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "grupa_id")})
    private List<Grupa> grupy = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNumer_indeksu() {
        return numer_indeksu;
    }

    public void setNumer_indeksu(String numer_indeksu) {
        this.numer_indeksu = numer_indeksu;
    }

    public String getWydzial() {
        return wydzial;
    }

    public void setWydzial(String wydzial) {
        this.wydzial = wydzial;
    }

    public Integer getRok() {
        return rok;
    }

    public void setRok(Integer rok) {
        this.rok = rok;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Wykladowca getWykladowca() {
        return wykladowca;
    }

    public void setWykladowca(Wykladowca wykladowca) {
        this.wykladowca = wykladowca;
    }

    public List<Grupa> getGrupy() {
        return grupy;
    }

    public void setGrupy(List<Grupa> grupy) {
        this.grupy = grupy;
    }

    @Override
    public String toString() {
        return "model.Student{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", numer_indeksu='" + numer_indeksu + '\'' +
                ", wydzial='" + wydzial + '\'' +
                ", rok=" + rok +
                ", profil='" + profil + '\'' +
                ", adres=" + adres +
                ", wykladowca=" + wykladowca +
                ", grupy=" + grupy +
                '}';
    }
}

