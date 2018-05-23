package com.fortech.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="camera")
public class Camera {
	
	@Id
	@Column(name="IdCamera", nullable=false)
	private int idCamera;
	
	@Column(name="NrLocLiber")
	private int nrLocLiber;
	
	@Column(name="NrLocOcupate")
	private int nrLocOcupate;
	
	@OneToMany
	@JoinColumn(name="IdCamera",referencedColumnName="IdCamera")
	private List<Student> studentiCamera;

	public int getIdCamera() {
		return idCamera;
	}

	public void setIdCamera(int idCamera) {
		this.idCamera = idCamera;
	}

	public int getNrLocLiber() {
		return nrLocLiber;
	}

	public void setNrLocLiber(int nrLocLiber) {
		this.nrLocLiber = nrLocLiber;
	}

	public int getNrLocOcupate() {
		return nrLocOcupate;
	}

	public void setNrLocOcupate(int nrLocOcupate) {
		this.nrLocOcupate = nrLocOcupate;
	}
	
}
