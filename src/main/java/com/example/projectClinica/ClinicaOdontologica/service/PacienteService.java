package com.example.projectClinica.ClinicaOdontologica.service;


import com.example.projectClinica.ClinicaOdontologica.entities.Odontologo;
import com.example.projectClinica.ClinicaOdontologica.entities.Paciente;
import com.example.projectClinica.ClinicaOdontologica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> listarPaciente() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente guardarPaciente(Paciente paciente) {
        if (pacienteRepository.save(paciente) != null) {
            return paciente;
        }
        return null;
    }

    @Override
    public Optional<Paciente> buscarPaciente(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if (paciente.isPresent()){
            return paciente;
        }
        return null;
    }

    @Override
    public boolean eliminarOdontologo(Long id) {
        if (pacienteRepository.findById(id).isPresent()){
            pacienteRepository.deleteById(id);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public boolean actualizar(Paciente paciente) {
        if (pacienteRepository.findById(paciente.getId()).isPresent()){

            pacienteRepository.saveAndFlush(paciente);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
