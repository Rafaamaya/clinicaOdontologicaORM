package com.example.projectClinica.ClinicaOdontologica.repository;

import com.example.projectClinica.ClinicaOdontologica.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}
