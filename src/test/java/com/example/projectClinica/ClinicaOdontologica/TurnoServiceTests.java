package com.example.projectClinica.ClinicaOdontologica;

import com.example.projectClinica.ClinicaOdontologica.entities.Domicilio;
import com.example.projectClinica.ClinicaOdontologica.entities.Odontologo;
import com.example.projectClinica.ClinicaOdontologica.entities.Paciente;
import com.example.projectClinica.ClinicaOdontologica.entities.Turno;
import com.example.projectClinica.ClinicaOdontologica.service.OdontologoService;
import com.example.projectClinica.ClinicaOdontologica.service.PacienteService;
import com.example.projectClinica.ClinicaOdontologica.service.TurnoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TurnoServiceTests {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;

    public void cargarData() {
        Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.guardarPaciente(new Paciente("Santiago", "Paz", "Paz@gmail.com", "88888888", domicilio));
        odontologoService.guardarOdontologo(new Odontologo("Santiago", "Paz", "3455647"));
    }

    @Test
    public void cargarTurnoTest() {
        if (odontologoService.buscarOdontologo(1l) == null || pacienteService.buscarPaciente(1L) == null)
            cargarData();
        Paciente paciente = new Paciente();
        Odontologo odontologo = new Odontologo();
        paciente.setId(1l);
        odontologo.setId(1l);
        turnoService.guardarTuro(new Turno(odontologo, paciente));
        Assert.assertNotNull(turnoService.buscarTurno(1l));
    }
   @Test
    public void buscarTurnoTest(){
        Assert.assertNotNull(turnoService.buscarTurno(1L));
    }
/*    @Test
    public void actualizarTurnoTest(){
        System.out.println(turnoService.buscarTurno(1L).equals(turnoService.buscarTurno(1L)));
        Assert.assertTrue(true);
    }*/


}
