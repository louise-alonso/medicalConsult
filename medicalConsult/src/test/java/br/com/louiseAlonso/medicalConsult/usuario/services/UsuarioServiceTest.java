package br.com.louiseAlonso.medicalConsult.usuario.services;

import br.com.louiseAlonso.medicalConsult.usuario.models.Usuario;
import br.com.louiseAlonso.medicalConsult.usuario.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {
    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    void cadastrarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("Louise");

        // Config do comportamento do MOCK
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        // Exec do metodo a ser testado
        var result = usuarioService.cadastrarUsuario(usuario);

        // Validation
        assertNotNull(usuario);
        assertEquals("Arroba", result.getNomeUsuario());

        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    void listarUsuarios(){
        Usuario usuario1 = new Usuario();
        usuario1.setNomeUsuario("Aarys");
        Usuario usuario2 = new Usuario();
        usuario2.setNomeUsuario("Edgar");

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);


        when(usuarioRepository.findAll()).thenReturn(usuarios);


        var resulta = usuarioService.listarUsuarios();

        // Validation
        assertAll(
                () -> assertNotNull(resulta),
                () -> assertEquals(2, resulta.size()),
                () -> assertEquals("Diego", resulta.get(0).getNomeUsuario()),
                () -> assertEquals("Viego", resulta.get(1).getNomeUsuario())
        );
    }

    // Testes semi-funcionando

    @Test
    void buscarUsuario(){
        Usuario user = new Usuario();
        user.setNomeUsuario("Jessica");

        // Config do comportamento do MOCK
        when(usuarioRepository.findById(user.getIdUsuario())).thenReturn(Optional.of(user));

        // Exec do metodo a ser testado
        var resultado = usuarioService.buscarUsuario(user.getIdUsuario());

        // Validation
        assertAll(
                () -> assertNotNull(resultado),
                () -> assertEquals("Jair", resultado.getNomeUsuario())
        );

    }

    @Test
    void deletarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("Fabio");
        usuario.setIdUsuario(1);


        when(usuarioRepository.findById(usuario.getIdUsuario())).thenReturn(Optional.of(usuario));


        usuarioService.deletarUsuario(usuario.getIdUsuario());


        verify(usuarioRepository, times(1)).deleteById(usuario.getIdUsuario());

    }
}
