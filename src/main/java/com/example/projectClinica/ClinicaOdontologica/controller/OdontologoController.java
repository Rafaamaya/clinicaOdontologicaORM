package com.example.projectClinica.ClinicaOdontologica.controller;

import com.example.projectClinica.ClinicaOdontologica.entities.DTO.OdontologoDTO;
import com.example.projectClinica.ClinicaOdontologica.entities.Odontologo;
import com.example.projectClinica.ClinicaOdontologica.entities.Paciente;
import com.example.projectClinica.ClinicaOdontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;


    @GetMapping("/listar")
    public ResponseEntity<List<Odontologo>>  getListarOdontologo(){
        return ResponseEntity.ok(odontologoService.listarOdontologo()) ;
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> getBuscarOdontologo(@PathVariable Long id){
        ResponseEntity response = null;
        OdontologoDTO odontologoDTO = odontologoService.buscarOdontologo(id);
        if(odontologoDTO == null){
            response = new ResponseEntity("No existe odontologo con ese id" , HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity(odontologoDTO ,HttpStatus.OK);
        }
        return response;
    }

    @PostMapping("/guardar")
    public ResponseEntity<Odontologo>  getGuardarOdontologo(@RequestBody Odontologo odontologo){
        ResponseEntity<Odontologo> response = null;
        if (odontologoService.guardarOdontologo(odontologo) != null){
            response = ResponseEntity.ok(odontologo);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(odontologo);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> getEliminarOdontologo(@RequestParam Long id){
        ResponseEntity response = null;
        if(odontologoService.eliminarOdontologo(id) == false){
            response = new ResponseEntity("No existe odontologo con ese id" , HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity("Se borro el odontologo con id: " + id,HttpStatus.OK);
        }
        return response;
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizarødontologo(@RequestBody Odontologo odontologo){
        ResponseEntity response = null;
        if(odontologoService.actualizar(odontologo) == false){
            response = new ResponseEntity("No existe el registro a modificar", HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity("Se modifici de forma correcta", HttpStatus.OK);
        }
        return response;
    }
}
