package com.example.projectClinica.ClinicaOdontologica.entities.DTO;

public class PacienteDTO {


    private Long id;
    private String fullName;
    private String email;
    private String dni;
    private String calleNumero;
    private String localidad;
    private String provincia;



    public PacienteDTO() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCalleNumero() {
        return calleNumero;
    }
    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }

    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
