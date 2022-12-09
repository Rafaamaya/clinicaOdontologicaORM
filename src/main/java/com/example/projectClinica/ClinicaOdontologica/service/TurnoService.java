package com.example.projectClinica.ClinicaOdontologica.service;

import com.example.projectClinica.ClinicaOdontologica.entities.DTO.OdontologoDTO;
import com.example.projectClinica.ClinicaOdontologica.entities.DTO.PacienteDTO;
import com.example.projectClinica.ClinicaOdontologica.entities.DTO.TurnoDTO;
import com.example.projectClinica.ClinicaOdontologica.entities.Odontologo;
import com.example.projectClinica.ClinicaOdontologica.entities.Turno;
import com.example.projectClinica.ClinicaOdontologica.repository.PacienteRepository;
import com.example.projectClinica.ClinicaOdontologica.repository.TurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    TurnoRepository turnoRepository;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    ObjectMapper mapper;


    @Override
    public List<Turno> listarTurno() {
        return turnoRepository.findAll();
    }

    @Override
    public Turno guardarTuro(Turno turno) {
        if ((odontologoService.buscarOdontologo(turno.getOdontologo().getId()) != null) && pacienteService.buscarPaciente(turno.getPaciente().getId()) != null) {
            turnoRepository.save(turno);
            return turno;
        } else {
            return null;
        }
    }

    @Override
    public boolean eliminarOdontologo(Long id) {
        if (turnoRepository.findById(id).isPresent()) {
            turnoRepository.deleteById(id);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public TurnoDTO buscarTurno(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        OdontologoDTO odontologoDTO = null;
        PacienteDTO pacienteDTO = null;
        if (turno.isPresent()) {
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
            odontologoDTO = mapper.convertValue(turno.get().getOdontologo(), OdontologoDTO.class);
            odontologoDTO.setFullName(String.format("%s %s", turno.get().getOdontologo().getNombre(), turno.get().getOdontologo().getApellido()));

            pacienteDTO = mapper.convertValue(turno.get().getPaciente(), PacienteDTO.class);
            pacienteDTO.setFullName(String.format("%s %s", turno.get().getPaciente().getNombre(), turno.get().getPaciente().getApellido()));
            pacienteDTO.setCalleNumero(String.format("%s %s", turno.get().getPaciente().getDomicilio().getCalle(), turno.get().getPaciente().getDomicilio().getNumero()));
            pacienteDTO.setLocalidad(turno.get().getPaciente().getDomicilio().getLocalidad());
            pacienteDTO.setProvincia(turno.get().getPaciente().getDomicilio().getProvincia());

            turnoDTO.setOdontologoDTO(odontologoDTO);
            turnoDTO.setPacienteDTO(pacienteDTO);
        }
        return turnoDTO;
    }
}
