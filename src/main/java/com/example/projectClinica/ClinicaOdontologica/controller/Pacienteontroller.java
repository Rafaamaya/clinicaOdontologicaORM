package com.example.projectClinica.ClinicaOdontologica.controller;



import com.example.projectClinica.ClinicaOdontologica.entities.Odontologo;
import com.example.projectClinica.ClinicaOdontologica.entities.Paciente;
import com.example.projectClinica.ClinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("paciente")
public class Pacienteontroller {

    @Autowired
    private PacienteService pacienteService;


    @PostMapping("/guardar")
    public ResponseEntity<Paciente>  getGuardarOdontologo(@RequestBody Paciente paciente){
        ResponseEntity<Paciente> response = null;
        if (pacienteService.guardarPaciente(paciente) != null){
            response = ResponseEntity.ok(paciente);
        }else {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(paciente);
        }
        return response;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Paciente>> getListarOdontologo(){
        return ResponseEntity.ok(pacienteService.listarPaciente()) ;
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> getBuscarOdontologo(@PathVariable Long id){
        ResponseEntity response = null;
        Optional<Paciente> paciente = pacienteService.buscarPaciente(id);
        if(paciente == null){
            response = new ResponseEntity("No existe odontologo con ese id" , HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity(paciente ,HttpStatus.OK);
        }
        return response;
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> getEliminarOdontologo(@RequestParam Long id){
        ResponseEntity response = null;
        if(pacienteService.eliminarOdontologo(id) == false){
            response = new ResponseEntity("No existe odontologo con ese id" , HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity("Se borro el odontologo con id: " + id,HttpStatus.OK);
        }
        return response;
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizarødontologo(@RequestBody Paciente paciente){
        ResponseEntity response = null;
        if(pacienteService.actualizar(paciente) == false){
            response = new ResponseEntity("No existe el registro a modificar", HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity("Se modifici de forma correcta", HttpStatus.OK);
        }
        return response;
    }

}
