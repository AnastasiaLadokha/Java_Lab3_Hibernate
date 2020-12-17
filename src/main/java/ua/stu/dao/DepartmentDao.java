package ua.stu.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.stu.entity.Card;
import ua.stu.entity.Department;
import ua.stu.utils.HibernateSessionFactoryUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {

    public Department getDepartment(int id){
        Transaction transaction = null;
        Department department = new Department();
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            department = session.get(Department.class, id);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return department;
    }

    public void saveDepartment(Department department){
        Transaction transaction = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteDepartment(Department department){
        Transaction transaction = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(department);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateDepartment(Department department){
        Transaction transaction = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(department);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public String allDepartments(){
        List<Department> departments = (List<Department>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Department").list();
        return departments.toString();
    }
}
