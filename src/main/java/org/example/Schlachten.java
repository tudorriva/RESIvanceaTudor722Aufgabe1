package org.example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class Schlachten {
    @XmlElement(name = "Id")
    int id;
    @XmlElement(name = "Charaktername")
    String charakterName;
    @XmlElement(name = "Stufe")
    Stuffe stufe;
    @XmlElement(name = "Beschreibung")
    String beschreibung;
    @XmlElement(name = "Datum")
    LocalDate Datum;
    @XmlElement(name = "Kraftpunkte")
    double kraftpunkte;

    public Schlachten(int id, String charakterName, String beschreibung, LocalDate datum, double kraftpunkte) {
        this.id = id;
        this.charakterName = charakterName;
        this.beschreibung = beschreibung;
        Datum = datum;
        this.kraftpunkte = kraftpunkte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharakterName() {
        return charakterName;
    }

    public void setCharakterName(String charakterName) {
        this.charakterName = charakterName;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public LocalDate getDatum() {
        return Datum;
    }

    public void setDatum(LocalDate datum) {
        Datum = datum;
    }

    public double getKraftpunkte() {
        return kraftpunkte;
    }

    public void setKraftpunkte(double kraftpunkte) {
        this.kraftpunkte = kraftpunkte;
    }
}
