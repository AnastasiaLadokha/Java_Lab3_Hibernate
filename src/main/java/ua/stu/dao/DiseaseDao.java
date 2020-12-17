package ua.stu.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.stu.entity.Department;
import ua.stu.entity.Disease;
import ua.stu.utils.HibernateSessionFactoryUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiseaseDao {

    public Disease getDisease(int id){
        Transaction transaction = null;
        Disease disease = new Disease();
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            disease = session.get(Disease.class, id);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return disease;
    }

    public void saveDisease(Disease disease){
        Transaction transaction = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(disease);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteDisease(Disease disease){
        Transaction transaction = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(disease);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateDisease(Disease disease){
        Transaction transaction = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(disease);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public String allDiseases(){
        List<Disease> diseases = (List<Disease>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Disease").list();
        return diseases.toString();
    }
}
