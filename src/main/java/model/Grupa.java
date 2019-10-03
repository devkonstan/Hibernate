package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Grupa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nazwa;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wykladowca_id")
    private Wykladowca wykladowca;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "grupy")
    private List<Student> students = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }


    @Override
    public String toString() {
        return "model.Grupa{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
