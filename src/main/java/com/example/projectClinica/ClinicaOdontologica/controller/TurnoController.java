package com.example.projectClinica.ClinicaOdontologica.controller;


import com.example.projectClinica.ClinicaOdontologica.entities.DTO.TurnoDTO;
import com.example.projectClinica.ClinicaOdontologica.entities.Odontologo;
import com.example.projectClinica.ClinicaOdontologica.entities.Paciente;
import com.example.projectClinica.ClinicaOdontologica.entities.Turno;
import com.example.projectClinica.ClinicaOdontologica.service.OdontologoService;
import com.example.projectClinica.ClinicaOdontologica.service.TurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("turno")
public class TurnoController {
    private static final Logger logger = Logger.getLogger(Pacienteontroller.class);


    @Autowired
    private TurnoService turnoService;

    @PostMapping("/guardar")
    public ResponseEntity<String> getGuardarOdontologo(@RequestBody Turno turno){
        ResponseEntity<String> response = null;
        if (turnoService.guardarTuro(turno) != null){
            logger.info("Se guardo un turno de forma correcta");
            response = ResponseEntity.ok("Se guardo un turno de forma correcta");
        }else {
            logger.info("No se pudo guardar de forma correcta " + turno);
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Su turno no puede ser guardado");
        }
        return response;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Turno>>  getListarOdontologo(){
        return ResponseEntity.ok(turnoService.listarTurno()) ;
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> getEliminarOdontologo(@RequestParam Long id){
        ResponseEntity response = null;
        if(turnoService.eliminarOdontologo(id) == false){
            response = new ResponseEntity("No existe odontologo con ese id" , HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity("Se borro el odontologo con id: " + id,HttpStatus.OK);
        }
        return response;
    }

    @GetMapping("/buscar/{id}")
    public TurnoDTO getBuscarOdontologo(@PathVariable Long id){
        return turnoService.buscarTurno(id);
    }
}
