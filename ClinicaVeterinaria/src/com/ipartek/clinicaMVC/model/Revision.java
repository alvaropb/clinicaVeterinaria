package com.ipartek.clinicaMVC.model;

import java.util.Date;

public class Revision {
	 /*
     * la fecha de la revisi�n el id del doctor que lo reviso motivo de la revisi�n
     * diagnostico tratamiento
     */
    private Date fechaRevision;
    private int idDoctor;
    private String motivoRevision;
    private String diagnostico;
    private String tratamiento;
    private int idAnimal;
    private int idRevision;

    public Revision() {
	super();
	this.fechaRevision = new Date();
	this.idDoctor = 0;
	this.motivoRevision = "";
	this.diagnostico = "";
	this.tratamiento = "";
	this.idAnimal = 0;
	this.idRevision = 0;
    }

    public Date getFechaRevision() {
	return fechaRevision;
    }

    public void setFechaRevision(Date fechaRevision) {
	this.fechaRevision = fechaRevision;
    }

    public int getIdDoctor() {
	return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
	this.idDoctor = idDoctor;
    }

    public String getMotivoRevision() {
	return motivoRevision;
    }

    public void setMotivoRevision(String motivoRevision) {
	this.motivoRevision = motivoRevision;
    }

    public String getDiagnostico() {
	return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
	this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
	return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
	this.tratamiento = tratamiento;
    }

    public int getIdAnimal() {
	return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
	this.idAnimal = idAnimal;
    }

    public int getIdRevision() {
	return idRevision;
    }

    public void setIdRevision(int idRevision) {
	this.idRevision = idRevision;
    }

    @Override
    public String toString() {
	return "Revision [fechaRevision=" + fechaRevision + ", idDoctor=" + idDoctor + ", motivoRevision="
		+ motivoRevision + ", diagnostico=" + diagnostico + ", tratamiento=" + tratamiento + ", idAnimal="
		+ idAnimal + "]";
    }


}
