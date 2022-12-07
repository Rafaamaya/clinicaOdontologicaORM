package com.example.projectClinica.ClinicaOdontologica.service;

import com.example.projectClinica.ClinicaOdontologica.entities.DTO.OdontologoDTO;
import com.example.projectClinica.ClinicaOdontologica.entities.Odontologo;
import java.util.List;
import java.util.Optional;

public interface IOdontologoService {

    List<Odontologo> listarOdontologo();
    OdontologoDTO buscarOdontologo (Long id);
    Odontologo guardarOdontologo(Odontologo odontologo);
    boolean eliminarOdontologo (Long id);
    boolean actualizar(Odontologo odontologo);
}
