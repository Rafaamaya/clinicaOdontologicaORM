package com.example.projectClinica.ClinicaOdontologica.service;


import com.example.projectClinica.ClinicaOdontologica.entities.Odontologo;
import com.example.projectClinica.ClinicaOdontologica.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {

    @Autowired
    OdontologoRepository odontologoRepository;


    @Override
    public List<Odontologo> listarOdontologo() {
        return odontologoRepository.findAll();
    }

    @Override
    public Optional<Odontologo> buscarOdontologo(Long id) {
        return odontologoRepository.findById(id);
    }

    @Override
    public Odontologo guardarOdontologo(Odontologo odontologo) {
        if (odontologoRepository.save(odontologo) != null) {
             return odontologo;
        }
        return null;
    }

    @Override
    public boolean eliminarOdontologo(Long id) {
        if (odontologoRepository.findById(id).isPresent()){
            odontologoRepository.deleteById(id);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public boolean actualizar(Odontologo odontologo) {
        if (odontologoRepository.findById(odontologo.getId()).isPresent()){
            odontologoRepository.saveAndFlush(odontologo);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
