package br.com.louise.medicalconsult.consulta.services;

import br.com.louise.medicalconsult.consulta.models.Consulta;
import br.com.louise.medicalconsult.consulta.repositories.ConsultaRepository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ConsultaServiceTest {
    @InjectMocks
    private ConsultaService consultaService;
    @Mock
    private ConsultaRepository consultaRepository;

    @Test
    void cadastrarConsulta() {
        Consulta consulta = new Consulta();
        consulta.setProfissional("Marcelo");
        //configuração do comportamento do do MOCK
        when(consultaRepository.save(any(Consulta.class))).thenReturn(consulta);


        //A execução do metodo a ser testado
        var resultado = consultaService.cadastrarConsulta(consulta);

        //Validação do Teste
        assertNotNull(consulta);
        assertEquals("Marcelo", resultado.getProfissional());

        verify(consultaRepository, times(1)).save(consulta);
    }

    @Test
    void listarConsultas() {
        Consulta consulta1 = new Consulta();
        Consulta consulta2 = new Consulta();
        consulta1.setProfissional("Andressa");
        consulta2.setProfissional("House");

        List<Consulta> consultas = new ArrayList<>();
        consultas.add(consulta1);
        consultas.add(consulta2);
        //configuração do comportamento do do MOCK
        when(consultaRepository.findAll()).thenReturn(consultas);
        //A execução do metodo a ser testado
        var resultado = consultaService.listarConsultas();
        //Validação do Teste

        assertAll(
                () -> assertNotNull(resultado),
                () -> assertEquals(2, resultado.size()),
                () -> assertEquals("Dr.House", resultado.get(0).getProfissional())
        );
    }

    @Test
    void buscarPorId() {
        Consulta consulta = new Consulta();
        consulta.setProfissional("Lindineia");
        //configuração do comportamento do do MOCK
        when(consultaRepository.findById(consulta.getIdConsulta())).thenReturn(Optional.of(consulta));
        //A execução do metodo a ser testado
        var resultado = consultaService.buscarPorId(consulta.getIdConsulta());
        //Validação do Teste
        assertAll(
                () -> assertNotNull(resultado),
                () -> assertEquals("Nicolas", consulta.getProfissional())
        );
    }

    @Test
    void excluirConsulta() {
        Consulta consulta = new Consulta();
        //configuração do comportamento do do MOCK
        when(consultaRepository.findById(consulta.getIdConsulta())).thenReturn(Optional.of(consulta));
        //A execução do metodo a ser testado
        consultaService.excluirConsulta(consulta.getIdConsulta());
        //Validação do Teste
        verify(consultaRepository, times(1)).deleteById(consulta.getIdConsulta());
    }
}