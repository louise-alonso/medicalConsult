package br.com.louise.medicalconsult.consulta.controllers;

import br.com.louise.medicalconsult.consulta.models.Consulta;
import br.com.louise.medicalconsult.consulta.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<Consulta> cadastrarConsulta(@RequestBody Consulta consulta) {
        Consulta novaConsulta = consultaService.cadastrarConsulta(consulta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(novaConsulta.getIdConsulta()).toUri();
        return ResponseEntity.created(uri).body(novaConsulta);
    }
    //    @PostMapping
    //    public ResponseEntity<Consulta> cadastrarUsuario(@RequestBody Consulta consulta) {
    //        Consulta novaConsulta = consultaService.cadastrarConsulta(consulta);
    //        return ResponseEntity.status(HttpStatus.CREATED).body(novaConsulta);
    //    }

    @GetMapping
    public ResponseEntity<List<Consulta>> listarConsultas() {
        List<Consulta> consultas = consultaService.listarConsultas();
        return ResponseEntity.status(HttpStatus.OK).body(consultas);
    }

    @PutMapping
    public ResponseEntity<Consulta> atualizarConsulta(@RequestBody Consulta consulta) {
        Consulta consultaAlt = consultaService.atualizarConsulta(consulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaAlt);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscarPorId(@PathVariable Long id) {
        Consulta consulta = consultaService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(consulta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirConsulta(@PathVariable Long id) {
        consultaService.excluirConsulta(id);
        return ResponseEntity.ok("Consulta excluido com sucesso!");
    }
}
