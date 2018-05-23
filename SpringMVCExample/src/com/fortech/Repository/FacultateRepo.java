package com.fortech.Repository;

import java.util.List;

import org.hibernate.Session;

import com.fortech.DBUtils.HibernateConfig;
import com.fortech.Entities.Facultate;
import com.fortech.Entities.User;

public class FacultateRepo implements IRepository<Integer, Facultate> {

	public void save(Facultate entity) {
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

	public void update(Facultate entity) {
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
        try {
            sessionObj.beginTransaction();
            Facultate universitate = (Facultate) sessionObj.get(Facultate.class, entity.getIdFacultate());
            universitate.setDenumire(entity.getDenumire());
            universitate.setAdresa(entity.getAdresa());
            sessionObj.save(universitate);

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

	public void delete(Facultate entity) {
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

	public Facultate findOne(Integer id) {
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
        try {
            sessionObj.beginTransaction();
            Facultate universitate = (Facultate) sessionObj.get(Facultate.class, id);
            return universitate;

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

	public List<Facultate> findAll() {
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();
            List<Facultate> result = sessionObj.createQuery("from com.fortech.Entities.Facultate").list();
            return result;
        } finally {
	        if (sessionObj != null) {
	            sessionObj.close();
	        }
        }
	}
	
	public Facultate findIdUniversitateByDenumire(String denumire) {
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try{
			sessionObj.beginTransaction();
            List<Facultate> result = sessionObj.createQuery("from com.fortech.Entities.Facultate WHERE Denumire='" + denumire+"'").list();
            return result.get(0);
        } finally {
	        if (sessionObj != null) {
	            sessionObj.close();
	        }
        }
	}

}
