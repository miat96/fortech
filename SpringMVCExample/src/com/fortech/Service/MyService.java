package com.fortech.Service;

import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.fortech.Entities.Camera;
import com.fortech.Entities.Facultate;
import com.fortech.Entities.Student;
import com.fortech.Entities.User;
import com.fortech.Repository.CameraRepo;
import com.fortech.Repository.FacultateRepo;
import com.fortech.Repository.StudentRepo;
import com.fortech.Repository.UserRepo;


@Service("myService")

public class MyService implements IMyService{
	private UserRepo userRepo = new UserRepo();
	private FacultateRepo facultateRepo = new FacultateRepo();
	private StudentRepo studentRepo = new StudentRepo();
	private CameraRepo cameraRepo = new CameraRepo();

	@Override
	public boolean verificareUser(String username, String password) {
		User userNow = userRepo.findOne(username);
		if((userNow!=null) && (userNow.getPassword().equals(password))) {
			return true;
		}
		return false;
	}

	@Override
	public List<User> loadAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public List<Facultate> loadAllUniversitati() {
		return facultateRepo.findAll();
	}

	@Override
	public List<Student> loadStudentFormUniversitate(Facultate facultate) {
		Facultate newUnivers = facultateRepo.findIdUniversitateByDenumire(facultate.getDenumire());
		return studentRepo.findStudentFromUniversitate(newUnivers.getIdFacultate());
	}

	@Override
	public void addStudent(String cnp, String nume, String prenume, String telefon, String adresa, int cameraID,
			int universitateID) throws MyException {
		
		Camera camera = cameraRepo.findOne(cameraID);
		Facultate facultate = facultateRepo.findOne(universitateID);
		if(camera == null || facultate == null) {
			throw new MyException("Camera sau facultatea nu este valida.\n");
		}
		if (camera.getNrLocLiber() > 0) {
			Student student = new Student();
			student.setCnp(cnp);
			student.setNume(nume);
			student.setPrenume(prenume);
			student.setTelefon(telefon);
			student.setAdresa(adresa);
			student.setCamera(camera);
			student.setFacultate(facultate);
			int locLiber = camera.getNrLocLiber()-1;
			int locOcupat = camera.getNrLocOcupate()+1;
			camera.setNrLocLiber(locLiber);
			camera.setNrLocOcupate(locOcupat);
			if (studentRepo.findOne(cnp) != null) {
				studentRepo.update(student);
			}
			else {
				studentRepo.save(student);
			}
			cameraRepo.update(camera);
		}
		else {
			throw new MyException("Camera nu mai dispune de locuri libere.\n");
		}
		
	}

	@Override
	public List<Student> loadStudentFromCamera(int idCamera) {
		return studentRepo.findStudentFromCamera(idCamera);
	}

	@Override
	public List<Camera> loadAllCamera() {
		return cameraRepo.findAll();
	}

	@Override
	public void addCamera(int idCamera, int nrLocLiber) throws MyException {
		if(cameraRepo.findOne(idCamera) != null) {
			throw new MyException("Exista deja camera cu acest numar.\n");
		}
		Camera camera = new Camera();
		camera.setIdCamera(idCamera);
		camera.setNrLocLiber(nrLocLiber);
		camera.setNrLocOcupate(0);		
		cameraRepo.save(camera);
	}

	@Override
	public void stergereCamera(int idCamera) throws MyException {
		Camera camera = cameraRepo.findOne(idCamera);
		if(camera ==  null) {
			throw new MyException("Nu exista camera pe care doriti sa o stergeti.\n");
		}
		if(loadStudentFromCamera(idCamera).size() != 0) {
			throw new MyException("Camera nu se poate sterge deoarece exista persoane cazate in ea.\n");
		}
		cameraRepo.delete(camera);		
	}

	@Override
	public void stergereStudent(String idStudent) {
		Student student = studentRepo.findOne(idStudent);
		Camera camera = student.getCamera();
		int locLiber = camera.getNrLocLiber()+1;
		int locOcupat = camera.getNrLocOcupate()-1;
		camera.setNrLocLiber(locLiber);
		camera.setNrLocOcupate(locOcupat);
		cameraRepo.update(camera);
		studentRepo.delete(student);		
	}

	@Override
	public List<Student> findStudentByName(String nume) {
		return studentRepo.findStudentByName(nume);	
	}
	
}



