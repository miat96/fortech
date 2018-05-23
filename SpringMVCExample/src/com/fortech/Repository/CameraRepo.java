package com.fortech.Repository;

import java.util.List;

import org.hibernate.Session;

import com.fortech.DBUtils.HibernateConfig;
import com.fortech.Entities.Camera;
import com.fortech.Entities.User;

public class CameraRepo implements IRepository<Integer, Camera> {

	public void save(Camera entity) {
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

	public void update(Camera entity) {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			try {
				sessionObj.beginTransaction();
				Camera camera = (Camera) sessionObj.get(Camera.class, entity.getIdCamera());
				camera.setNrLocLiber(entity.getNrLocLiber());
				camera.setNrLocOcupate(entity.getNrLocOcupate());
				sessionObj.save(camera);

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

	public void delete(Camera entity) {
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

	public Camera findOne(Integer id) {
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
        try {
            sessionObj.beginTransaction();
            Camera camera = (Camera) sessionObj.get(Camera.class, id);
            return camera;

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

	public List<Camera> findAll() {
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();
            List<Camera> result = sessionObj.createQuery("from com.fortech.Entities.Camera").list();
            return result;
        } finally {
	        if (sessionObj != null) {
	            sessionObj.close();
	        }
        }
	}
	

}
