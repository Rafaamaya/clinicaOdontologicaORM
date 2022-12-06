package com.example.projectClinica.ClinicaOdontologica.service;

import com.example.projectClinica.ClinicaOdontologica.entities.Odontologo;
import com.example.projectClinica.ClinicaOdontologica.entities.Paciente;
import com.example.projectClinica.ClinicaOdontologica.entities.Turno;

import java.util.List;
import java.util.Optional;

public interface ITurnoService {
    List<Turno> listarTurno();
    Turno guardarTuro(Turno turno);
    boolean eliminarOdontologo (Long id);
    Optional<Turno> buscarTurno (Long id);
}
