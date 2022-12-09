package com.example.projectClinica.ClinicaOdontologica.entities.DTO;

import com.example.projectClinica.ClinicaOdontologica.entities.Odontologo;
import com.example.projectClinica.ClinicaOdontologica.entities.Paciente;

public class TurnoDTO {
    private Long id;
    private OdontologoDTO odontologoDTO;
    private PacienteDTO pacienteDTO;


    public TurnoDTO() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public OdontologoDTO getOdontologoDTO() {
        return odontologoDTO;
    }
    public void setOdontologoDTO(OdontologoDTO odontologoDTO) {
        this.odontologoDTO = odontologoDTO;
    }

    public PacienteDTO getPacienteDTO() {
        return pacienteDTO;
    }
    public void setPacienteDTO(PacienteDTO pacienteDTO) {
        this.pacienteDTO = pacienteDTO;
    }
}
