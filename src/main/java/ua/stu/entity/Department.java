package ua.stu.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int count_of_rooms;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Doctor> doctors;

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Department() {

    }

    public Department(int id, String title, int count_of_rooms) {
        this.id = id;
        this.title = title;
        this.count_of_rooms = count_of_rooms;
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

    public int getCount_of_rooms() {
        return count_of_rooms;
    }

    public void setCount_of_rooms(int count_of_rooms) {
        this.count_of_rooms = count_of_rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id &&
                count_of_rooms == that.count_of_rooms &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, count_of_rooms);
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", title='" + title + '\'' +
                ", count_of_rooms=" + count_of_rooms +
                "\n";
    }
}
