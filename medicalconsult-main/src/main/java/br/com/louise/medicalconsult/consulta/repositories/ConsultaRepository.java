package br.com.louise.medicalconsult.consulta.repositories;

import br.com.louise.medicalconsult.consulta.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}

