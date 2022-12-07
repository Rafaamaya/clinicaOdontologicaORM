package com.example.projectClinica.ClinicaOdontologica.entities.DTO;

public class OdontologoDTO {

    private String fullName;
    private String matricula;



    public OdontologoDTO() {
    }


    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
