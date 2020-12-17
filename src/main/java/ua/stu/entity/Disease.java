package ua.stu.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "disease")
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String treatment;
    private String prevention;

    @OneToMany(mappedBy = "disease", cascade = CascadeType.ALL)
    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Disease(){

    }

    public Disease(int id, String title, String treatment, String prevention) {
        this.id = id;
        this.title = title;
        this.treatment = treatment;
        this.prevention = prevention;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getPrevention() {
        return prevention;
    }

    public void setPrevention(String prevention) {
        this.prevention = prevention;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disease disease = (Disease) o;
        return id == disease.id &&
                Objects.equals(title, disease.title) &&
                Objects.equals(treatment, disease.treatment) &&
                Objects.equals(prevention, disease.prevention);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, treatment, prevention);
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", title='" + title + '\'' +
                ", treatment='" + treatment + '\'' +
                ", prevention='" + prevention + '\'' +
                "\n";
    }
}
