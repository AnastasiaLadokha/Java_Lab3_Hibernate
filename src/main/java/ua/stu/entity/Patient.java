package ua.stu.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;
    private String address;
    private String phone_number;

    @Temporal(TemporalType.DATE)
    private Date date_of_birth;
    private String status;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Patient(){

    }

    public Patient(int id, String first_name, String last_name, String address, String phone_number, Date date_of_birth, String status) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.phone_number = phone_number;
        this.date_of_birth = date_of_birth;
        this.status = status;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id &&
                Objects.equals(first_name, patient.first_name) &&
                Objects.equals(last_name, patient.last_name) &&
                Objects.equals(address, patient.address) &&
                Objects.equals(phone_number, patient.phone_number) &&
                Objects.equals(date_of_birth, patient.date_of_birth) &&
                Objects.equals(status, patient.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, address, phone_number, date_of_birth, status);
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", status='" + status + '\'' +
                "\n";
    }
}
