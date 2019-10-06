package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String miasto;
    private String ulica;
    private String kod;

    public Adres(Integer id, String miasto, String ulica, String kod) {
        this.id = id;
        this.miasto = miasto;
        this.ulica = ulica;
        this.kod = kod;
    }

    public Adres() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "id=" + id +
                ", miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", kod='" + kod + '\'' +
                '}';
    }
}
