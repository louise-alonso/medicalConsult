package br.com.louiseAlonso.medicalConsult.usuario.repositories;

import br.com.louiseAlonso.medicalConsult.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}