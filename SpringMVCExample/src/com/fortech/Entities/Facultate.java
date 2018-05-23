package com.fortech.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="facultate")
public class Facultate {
	
	@Id
	@Column(name="IdFacultate", nullable=false)
	private int idFacultate;
	
	@Column(name="Denumire", nullable=false)
	private String denumire;
	
	@Column(name="Adresa")
	private String adresa;
	
	@OneToMany
	@JoinColumn(name="IdFacultate",referencedColumnName="IdFacultate")
	private List<Student> studentiFacultate;

	

	public int getIdFacultate() {
		return idFacultate;
	}

	public void setIdFacultate(int idFacultate) {
		this.idFacultate = idFacultate;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	

}
