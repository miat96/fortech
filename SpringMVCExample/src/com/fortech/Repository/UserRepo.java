package com.fortech.Repository;

import java.util.List;

import org.hibernate.Session;

import com.fortech.DBUtils.HibernateConfig;
import com.fortech.Entities.User;

public class UserRepo implements IRepository<String, User> {

	public void save(User entity) {
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();
			sessionObj.save(entity);
			sessionObj.getTransaction().commit();
		}
		catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
		
	}

	public void update(User entity) {
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
        try {
            sessionObj.beginTransaction();
            User utilizator = (User) sessionObj.get(User.class, entity.getUserName());
            utilizator.setUserName(entity.getUserName());
            utilizator.setPassword(entity.getPassword());
            sessionObj.save(utilizator);

            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
		
	}

	public void delete(User entity) {
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();
			sessionObj.delete(entity);
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
		
	}

	public User findOne(String id) {
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
        try {
            sessionObj.beginTransaction();
            User angajat = (User) sessionObj.get(User.class, id);
            return angajat;

        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return null;
	}

	public List<User> findAll() {
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
            sessionObj.beginTransaction();
            List<User> result = sessionObj.createQuery("from com.fortech.Entities.User").list();
            return result;
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
	}



}
