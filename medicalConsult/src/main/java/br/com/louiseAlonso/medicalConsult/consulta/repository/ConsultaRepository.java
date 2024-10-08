package br.com.louiseAlonso.medicalConsult.consulta.repository;

import br.com.louiseAlonso.medicalConsult.consulta.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
