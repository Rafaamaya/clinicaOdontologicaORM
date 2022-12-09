package com.example.projectClinica.ClinicaOdontologica.service;

import com.example.projectClinica.ClinicaOdontologica.entities.DTO.PacienteDTO;
import com.example.projectClinica.ClinicaOdontologica.entities.Odontologo;
import com.example.projectClinica.ClinicaOdontologica.entities.Paciente;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {
    List<Paciente> listarPaciente();
    Paciente guardarPaciente(Paciente paciente);
    PacienteDTO buscarPaciente(Long id);
    boolean eliminarOdontologo (Long id);
    boolean actualizar(Paciente paciente);
}


