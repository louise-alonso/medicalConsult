package br.com.louiseAlonso.medicalConsult.consulta.repositories;

import br.com.louiseAlonso.medicalConsult.consulta.domain.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}