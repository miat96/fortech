package com.fortech.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@Column(name="CNP", nullable=false)
	private String cnp;
	
	@Column(name="Nume", nullable=false)
	private String nume;
	
	@Column(name="Prenume", nullable=false)
	private String prenume;
	
	@Column(name="Telefon", nullable=false)
	private String telefon;
	
	@Column(name="Adresa")
	private String adresa;
	
	@ManyToOne
	@JoinColumn(name="IdCamera", referencedColumnName="IdCamera", nullable=false)
	private Camera camera;
	
	@ManyToOne
	@JoinColumn(name="IdFacultate", referencedColumnName="IdFacultate", nullable=false)
	private Facultate facultate;

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public Facultate getFacultate() {
		return facultate;
	}

	public void setFacultate(Facultate facultate) {
		this.facultate = facultate;
	}
	

}
