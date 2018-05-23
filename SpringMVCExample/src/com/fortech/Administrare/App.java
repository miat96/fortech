package com.fortech.Administrare;

import com.fortech.Entities.Camera;
import com.fortech.Entities.Facultate;
import com.fortech.Entities.Student;
import com.fortech.Entities.User;
import com.fortech.Repository.CameraRepo;
import com.fortech.Repository.FacultateRepo;
import com.fortech.Repository.StudentRepo;
import com.fortech.Repository.UserRepo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Camera camera = new Camera();
        camera.setIdCamera(1);
        camera.setNrLocLiber(5);
        camera.setNrLocOcupate(0);
        CameraRepo cameraRepo = new CameraRepo();
        //cameraRepo.save(camera);
        
        Facultate universitate = new Facultate();
        universitate.setIdFacultate(1);
        universitate.setDenumire("UBB");
        universitate.setAdresa("Kogalniceanu");
        FacultateRepo universitateRepo = new FacultateRepo();
        //universitateRepo.save(universitate);
        
        Student student = new Student();
        student.setCnp("12345");
        student.setNume("ana");
        student.setPrenume("maria");
        student.setTelefon("112");
        student.setAdresa("adresa");
        student.setCamera(camera);
        student.setFacultate(universitate);
        StudentRepo studentRepo = new StudentRepo();
        //studentRepo.save(student);
        
        User user = new User();
        user.setUserName("admin");
        user.setPassword("admin");
        UserRepo userRepo = new UserRepo();
        //userRepo.save(user);
        
        Camera camera2 = new Camera();
        camera2.setIdCamera(1);
        camera2.setNrLocLiber(2);
        camera2.setNrLocOcupate(20);
        
        cameraRepo.update(camera2);
        
        studentRepo.delete(student);
        cameraRepo.delete(camera);
        universitateRepo.delete(universitate);
        userRepo.delete(user);
//        
    }
}
