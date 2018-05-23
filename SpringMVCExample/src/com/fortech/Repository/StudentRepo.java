package com.fortech.Repository;

import java.util.List;

import org.hibernate.Session;

import com.fortech.DBUtils.HibernateConfig;
import com.fortech.Entities.Camera;
import com.fortech.Entities.Student;
import com.fortech.Entities.User;

public class StudentRepo implements IRepository<String, Student> {

	public void save(Student entity) {
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

	public void update(Student entity) {
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
        try {
            sessionObj.beginTransaction();
            Student student = (Student) sessionObj.get(Student.class, entity.getCnp());
            student.setNume(entity.getNume());
            student.setPrenume(entity.getPrenume());
            student.setTelefon(entity.getTelefon());
            student.setAdresa(entity.getAdresa());
            student.setCamera(entity.getCamera());
            student.setFacultate(entity.getFacultate());
            sessionObj.save(student);

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

	public void delete(Student entity) {
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

	public Student findOne(String id) {
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
        try {
            sessionObj.beginTransaction();
            Student student = (Student) sessionObj.get(Student.class, id);
            return student;

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

	public List<Student> findAll() {
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
            sessionObj.beginTransaction();
            List<Student> result = sessionObj.createQuery("from com.fortech.Entities.Student").list();
            return result;
        } finally {
			if (sessionObj != null) {
                sessionObj.close();
            }
		}
	}

	
	public List<Student> findStudentFromUniversitate(int idFacultate){
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try{
            sessionObj.beginTransaction();
            List<Student> result = sessionObj.createQuery("from com.fortech.Entities.Student WHERE IdFacultate = " + idFacultate).list();
            return result;
        } finally {
			if (sessionObj != null) {
                sessionObj.close();
            }
		}
		
	}
	
	public List<Student> findStudentFromCamera(int idCamera){
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try{
            sessionObj.beginTransaction();
            List<Student> result = sessionObj.createQuery("from com.fortech.Entities.Student WHERE IdCamera = " + idCamera).list();
            return result;
        } finally {
			if (sessionObj != null) {
                sessionObj.close();
            }
		}
		
	}
	
	public List<Student> findStudentByName(String nume){
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try{
            sessionObj.beginTransaction();
            List<Student> result = sessionObj.createQuery("from com.fortech.Entities.Student WHERE Nume LIKE '%" + nume + "%'").list();
            List<Student> resul2 = sessionObj.createQuery("from com.fortech.Entities.Student WHERE Prenume LIKE '%" + nume + "%'").list();
            result.addAll(resul2);
            return result;
        } finally {
			if (sessionObj != null) {
                sessionObj.close();
            }
		}
		
	}
	
}
