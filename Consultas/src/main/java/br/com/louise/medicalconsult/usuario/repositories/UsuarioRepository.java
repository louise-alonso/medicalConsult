package br.com.louise.medicalconsult.usuario.repositories;

import br.com.louise.medicalconsult.usuario.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

