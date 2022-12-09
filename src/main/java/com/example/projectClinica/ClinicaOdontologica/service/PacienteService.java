package com.example.projectClinica.ClinicaOdontologica.service;


import com.example.projectClinica.ClinicaOdontologica.entities.DTO.OdontologoDTO;
import com.example.projectClinica.ClinicaOdontologica.entities.DTO.PacienteDTO;
import com.example.projectClinica.ClinicaOdontologica.entities.Odontologo;
import com.example.projectClinica.ClinicaOdontologica.entities.Paciente;
import com.example.projectClinica.ClinicaOdontologica.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    ObjectMapper mapper;

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
    public PacienteDTO buscarPaciente(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if (paciente.isPresent()){
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
            pacienteDTO.setFullName(String.format("%s %s",paciente.get().getNombre(),paciente.get().getApellido()));
            pacienteDTO.setCalleNumero(String.format("%s %s",paciente.get().getDomicilio().getCalle(),paciente.get().getDomicilio().getNumero()));
            pacienteDTO.setLocalidad(paciente.get().getDomicilio().getLocalidad());
            pacienteDTO.setProvincia(paciente.get().getDomicilio().getProvincia());
        }
        return pacienteDTO;
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
