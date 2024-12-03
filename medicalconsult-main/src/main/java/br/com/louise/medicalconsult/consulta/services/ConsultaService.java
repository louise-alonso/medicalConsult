package br.com.louise.medicalconsult.consulta.services;

import br.com.louise.medicalconsult.consulta.models.Consulta;
import br.com.louise.medicalconsult.consulta.repositories.ConsultaRepository;
import br.com.louise.medicalconsult.usuario.repositories.UsuarioRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Consulta cadastrarConsulta(Consulta consulta){
        consulta.setIdConsulta(null);
        return consultaRepository.save(consulta);
    }

    public List<Consulta> listarConsultas(){
        return consultaRepository.findAll();
    }

    public Consulta atualizarConsulta(Consulta consulta){
        if(consulta.getIdConsulta() == null){
            throw new RuntimeException("Consulta sem ID");
        }
        return consultaRepository.save(consulta);
    }
    public Consulta buscarPorId(Long id) {
        return consultaRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Consulta não encontrada:", id)
        );
    }

    public void excluirConsulta(Long id) {
        usuarioRepository.deleteById(id);
    }
}
