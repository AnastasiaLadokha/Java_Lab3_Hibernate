package ua.stu.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, insertable = false, updatable = false)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date receipt_date;

    @Temporal(TemporalType.DATE)
    private Date discharge_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Doctor doctor;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disease_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Disease disease;

    public Card(int id, Date receipt_date, Date discharge_date, Doctor doctor, Patient patient, Disease disease) {
        this.id = id;
        this.receipt_date = receipt_date;
        this.discharge_date = discharge_date;
        this.doctor = doctor;
        this.patient = patient;
        this.disease = disease;
    }

    public Card() {

    }

    @Override
    public String toString() {
        return "id=" + id +
                ", receipt_date=" + receipt_date +
                ", discharge_date=" + discharge_date;
                /*", doctor_id=" + doctor.getId() +
                ", patient_id=" + patient.getId() +
                ", disease_id=" + disease.getId() + "\n";*/
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return id == card.id &&
                doctor == card.doctor &&
                patient == card.patient &&
                disease == card.disease &&
                Objects.equals(receipt_date, card.receipt_date) &&
                Objects.equals(discharge_date, card.discharge_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, receipt_date, discharge_date, doctor, patient, disease);
    }

    public int getId() {
        return id;
    }

    public Date getReceipt_date() {
        return receipt_date;
    }

    public void setReceipt_date(Date receipt_date) {
        this.receipt_date = receipt_date;
    }

    public Date getDischarge_date() {
        return discharge_date;
    }

    public void setDischarge_date(Date discharge_date) {
        this.discharge_date = discharge_date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient_id) {
        this.patient = patient_id;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease_id) {
        this.disease = disease_id;
    }
}
