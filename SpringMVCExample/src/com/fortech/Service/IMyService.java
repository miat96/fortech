package com.fortech.Service;

import java.util.List;

import com.fortech.Entities.Camera;
import com.fortech.Entities.Facultate;
import com.fortech.Entities.Student;
import com.fortech.Entities.User;

public interface IMyService {
	
	public boolean verificareUser(String username, String password);
	
	public List<User> loadAllUsers();
	
	public List<Facultate> loadAllUniversitati();
	
	public List<Student> loadStudentFormUniversitate(Facultate facultate);
	
	public void addStudent(String cnp, String nume, String prenume, String telefon, String adresa,
			int cameraID, int universitateID) throws MyException;
	
	public List<Student> loadStudentFromCamera(int idCamera);
	
	public List<Camera> loadAllCamera();
	
	public void addCamera(int idCamera, int nrLocLiber) throws MyException;
	
	public void stergereCamera(int idCamera) throws MyException;
	
	public void stergereStudent(String idStudent);
	
	public List<Student> findStudentByName(String nume);
	
}
