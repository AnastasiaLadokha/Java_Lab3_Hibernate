package ua.stu.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.stu.entity.Card;
import ua.stu.utils.HibernateSessionFactoryUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardDao {

    public Card getCard(int id){
        Transaction transaction = null;
        Card card = new Card();
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            card = session.get(Card.class, id);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return card;
    }

    public void saveCard(Card card){
        Transaction transaction = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(card);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteCard(Card card){
        Transaction transaction = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.delete(card);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateCard(Card card){
        Transaction transaction = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(card);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public String allCards(){
        List cards = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Card").list();
        return cards.toString();
    }
}
