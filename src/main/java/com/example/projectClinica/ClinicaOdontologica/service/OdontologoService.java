package com.example.projectClinica.ClinicaOdontologica.service;


import com.example.projectClinica.ClinicaOdontologica.entities.DTO.OdontologoDTO;
import com.example.projectClinica.ClinicaOdontologica.entities.Odontologo;
import com.example.projectClinica.ClinicaOdontologica.repository.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {

    @Autowired
    OdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public List<Odontologo> listarOdontologo() {
        return odontologoRepository.findAll();
    }

    @Override
    public OdontologoDTO buscarOdontologo(Long id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if (odontologo.isPresent()) {
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
            odontologoDTO.setFullName(String.format("%s %s",odontologo.get().getNombre(),odontologo.get().getApellido()));
        }

        return odontologoDTO;
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
        if (odontologoRepository.findById(id).isPresent()) {
            odontologoRepository.deleteById(id);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public boolean actualizar(Odontologo odontologo) {
        if (odontologoRepository.findById(odontologo.getId()).isPresent()) {
            odontologoRepository.saveAndFlush(odontologo);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
