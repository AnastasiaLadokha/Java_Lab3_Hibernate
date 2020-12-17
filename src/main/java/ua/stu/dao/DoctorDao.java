package ua.stu.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.stu.entity.Disease;
import ua.stu.entity.Doctor;
import ua.stu.utils.HibernateSessionFactoryUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDao {

    public Doctor getDoctor(int id){
        Transaction transaction = null;
        Doctor doctor = new Doctor();
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            doctor = session.get(Doctor.class, id);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return doctor;
    }

    public void saveDoctor(Doctor doctor){
        Transaction transaction = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(doctor);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteDoctor(Doctor doctor){
        Transaction transaction = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(doctor);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateDoctor(Doctor doctor){
        Transaction transaction = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(doctor);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public String allDoctors(){
        List<Doctor> doctors = (List<Doctor>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Doctor").list();
        return doctors.toString();
    }
}
