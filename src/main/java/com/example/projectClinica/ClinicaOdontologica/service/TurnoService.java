package com.example.projectClinica.ClinicaOdontologica.service;

import com.example.projectClinica.ClinicaOdontologica.entities.Turno;
import com.example.projectClinica.ClinicaOdontologica.repository.PacienteRepository;
import com.example.projectClinica.ClinicaOdontologica.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    TurnoRepository turnoRepository;


    @Override
    public List<Turno> listarTurno() {
        return turnoRepository.findAll();
    }

    @Override
    public Turno guardarTuro(Turno turno) {
        turnoRepository.save(turno);
        return turno;
    }

    @Override
    public boolean eliminarOdontologo(Long id) {
        if (turnoRepository.findById(id).isPresent()){
            turnoRepository.deleteById(id);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Optional<Turno> buscarTurno(Long id) {
        return turnoRepository.findById(id);
    }
}
