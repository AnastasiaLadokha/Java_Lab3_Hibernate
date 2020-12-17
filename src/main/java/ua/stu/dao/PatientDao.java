package ua.stu.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.stu.entity.Doctor;
import ua.stu.entity.Patient;
import ua.stu.utils.HibernateSessionFactoryUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDao {

    public Patient getPatient(int id){
        Transaction transaction = null;
        Patient patient = new Patient();
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            patient = session.get(Patient.class, id);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return patient;
    }

    public void savePatient(Patient patient){
        Transaction transaction = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(patient);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deletePatient(Patient patient){
        Transaction transaction = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(patient);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updatePatient(Patient patient){
        Transaction transaction = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(patient);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public String allPatients(){
        List<Patient> patients = (List<Patient>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Patient").list();
        return patients.toString();
    }
}
