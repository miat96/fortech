package com.fortech.Controller;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fortech.Entities.Facultate;
import com.fortech.Entities.Student;
import com.fortech.Entities.User;
import com.fortech.Repository.StudentRepo;
import com.fortech.Service.IMyService;
import com.fortech.Service.MyException;
import com.fortech.Service.MyService;

@Controller
public class ControllerGeneral {
	
	@Autowired(required = false)
	IMyService myService = new MyService();
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView login(){
		return new ModelAndView("result", "command", new Student());
	}
	
	@RequestMapping(value = "/loadStudenti", method = RequestMethod.POST)
	public String loadStudenti(@ModelAttribute("SpringWeb")Facultate universitate, ModelMap model) {
		model.addAttribute("universitati", myService.loadAllUniversitati());
		model.addAttribute("dataList", myService.loadStudentFormUniversitate(universitate));
		return "facultate";
	}
	

	
	@RequestMapping(value = "/loadStudentFromCamera", method = RequestMethod.POST)
	public String loadStudentFromCamera(@RequestParam String idCamera, Model model) {
		model.addAttribute("dataListStudent", myService.loadStudentFromCamera(Integer.parseInt(idCamera)));
		loadCamere(model);
		return "result";
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@RequestParam String cnp, @RequestParam String nume, @RequestParam String prenume, 
			@RequestParam String telefon,@RequestParam String adresa,@RequestParam String cameraID,
			@RequestParam String universitateID, HttpServletRequest request, Model model) {
		String error = "";
		
		if(cnp.equals("") || nume.equals("") || prenume.equals("") || telefon.equals("") || adresa.equals("") ||
				cameraID.equals("") || universitateID.equals("")) {
			model.addAttribute("error", "Toate campurile trebuie completate.\n");
			loadUniversitati(model);
			return "student";
		}
		if((Pattern.matches("[a-zA-Z]+", cnp) == true) || (Pattern.matches("[a-zA-Z]+", telefon) == true)) {
				error += "Numarul de telefon si cnp-ul nu pot contine litere.\n";
		}
			
		if((Pattern.matches("[0-9]+", nume) == true) || (Pattern.matches("[0-9]+", prenume) == true)) {
				error += "Numele si prenumele nu pot contine cifre.\n";
		}		

		if(!error.equals("")) {		
			model.addAttribute("error", error);
			loadUniversitati(model);
			return "student";
		}
		
		try {
			int cam = Integer.parseInt(cameraID);
			int univ = Integer.parseInt(universitateID);	
			myService.addStudent(cnp, nume, prenume, telefon, adresa, cam, univ);
		}catch (MyException e) {
			model.addAttribute("error", e.getMessage());
		} catch (Exception e) {
			model.addAttribute("error", "Id-ul camerei si a universitatii trebuie sa fie de tip intreg.");
		}
		loadUniversitati(model);
		return "student";	
	}
	
	@RequestMapping(value = "/goStudent", method = RequestMethod.GET)
	public String createStudent(Model model) {
		loadUniversitati(model);
		return "student";		
	}
	
	@RequestMapping(value = "/goFacultate", method = RequestMethod.GET)
	public String goFacultate(Model model) {
		loadUniversitati(model);
		return "facultate";		
	}
	
	@RequestMapping(value = "/goResult", method = RequestMethod.GET)
	public String paginaPrincipala(Model model) {
		loadCamere(model);
		return "result";		
	}
	
	@RequestMapping(value = "/loadUniv", method = RequestMethod.POST)
	public void loadUniversitati(Model model) {
		model.addAttribute("dataListFacultati", myService.loadAllUniversitati());
		model.addAttribute("universitati", myService.loadAllUniversitati());		
	}
	
	@RequestMapping(value = "/loadCam", method = RequestMethod.POST)
	public void loadCamere(Model model) {
		model.addAttribute("dataListCamere", myService.loadAllCamera());
	}
	
	
	@RequestMapping(value = "/addCamera", method = RequestMethod.POST)
	public String addCamera(@RequestParam String idCamera, @RequestParam String nrLocLiber, Model model) {
		if(idCamera.equals("") || nrLocLiber.equals("")) {
			model.addAttribute("errorAddCamera", "Toate campurile trebuie completate.\n");
			loadCamere(model);
			return "result";
		}
		try {
			int idC = Integer.parseInt(idCamera);
			int nrL = Integer.parseInt(nrLocLiber);
			if(idC <= 0 || nrL <= 0) {
				model.addAttribute("errorAddCamera", "Numarul camerei si numarul de locuri trebuie sa fie strict pozitive.\n");
				loadCamere(model);
				return "result";
			}
			myService.addCamera(idC, nrL);
		} catch (MyException e) {
			model.addAttribute("errorAddCamera", e.getMessage());
		} catch (Exception e) {
			model.addAttribute("errorAddCamera", "Numarul camerei si numarul de locuri trebuie sa fe de tip intreg.\n");
		}
		loadCamere(model);
		return "result";
	}
	
	@RequestMapping(value = "/stergereCamera", method = RequestMethod.POST)
	public String stergereCamera(@RequestParam String idCamera, Model model) {
		if(idCamera.equals("")) {
			model.addAttribute("errorStergereCamera", "Completati campul cu numarul camerei pe care doriti sa o stergerti.\n");
			loadCamere(model);
			return "result";
		}
		try {
			int idC = Integer.parseInt(idCamera);
			myService.stergereCamera(idC);
		} catch (MyException e) {
			model.addAttribute("errorStergereCamera", e.getMessage());
		} catch (Exception e) {
			model.addAttribute("errorStergereCamera", "Numarul camerei trebuie sa fie de tip intreg.\n");
		}
		loadCamere(model);
		return "result";
	}
	
	@RequestMapping(value = "/stergereStudent", method = RequestMethod.POST)
	public String stergereStudent(@RequestParam String idStudent, Model model) {
		if(idStudent.equals("")) {
			model.addAttribute("errorStergereStudent","Selectati din tabel studentul pe care doriti sa il stergeti.\n");
		}
		else {
			myService.stergereStudent(idStudent);
		}
		loadCamere(model);
		return "result";
	}
	
	@RequestMapping(value = "/cautareStudentiByNume", method = RequestMethod.POST)
	public String cautareStudentiByNume(@RequestParam String numeCautare, Model model) {
		model.addAttribute("dataListStudent", myService.findStudentByName(numeCautare));
		loadUniversitati(model);
		return "student";
	}

}
