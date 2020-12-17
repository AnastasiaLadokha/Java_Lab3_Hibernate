package ua.stu.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;
    private String position;

    @Temporal(TemporalType.DATE)
    private Date date_of_birth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @OneToMany(mappedBy = "doctor")
    private List<Card> cards;

    public Doctor(int id, String first_name, String last_name, String position, Department department, Date date_of_birth) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
        this.department = department;
        this.date_of_birth = date_of_birth;
    }

    public Doctor(){

    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", position='" + position + '\'' +
                ", department_id=" + department.getId() +
                ", date_of_birth=" + date_of_birth +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id &&
                department == doctor.department &&
                Objects.equals(first_name, doctor.first_name) &&
                Objects.equals(last_name, doctor.last_name) &&
                Objects.equals(position, doctor.position) &&
                Objects.equals(date_of_birth, doctor.date_of_birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, position, department, date_of_birth);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department_id) {
        this.department = department_id;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}
