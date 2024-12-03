package br.com.louise.medicalconsult.usuario.services;

import br.com.louise.medicalconsult.usuario.models.Usuario;
import br.com.louise.medicalconsult.usuario.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    void cadastrarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("Diego");
        //configuração do comportamento do do MOCK
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);


        //A execução do metodo a ser testado
        var resulto = usuarioService.cadastrarUsuario(usuario);

        //Validação do Teste
        assertNotNull(usuario);
        assertEquals("asd", resulto.getNomeUsuario());

        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    void listarUsuarios() {
        //Criando o objeto usuarios
        Usuario usuario1 = new Usuario();
        usuario1.setNomeUsuario("Diego");
        Usuario usuario2 = new Usuario();
        usuario2.setNomeUsuario("Edgar");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        //configuração do comportamento do do MOCK
        when(usuarioRepository.findAll()).thenReturn(usuarios);

        //A execução do metodo a ser testado
        var resultado = usuarioService.listarUsuarios();

        //Validação do Teste
        assertAll(
                () -> assertNotNull(resultado),
                () -> assertEquals(2, resultado.size()),
                () ->  assertEquals("Diego", resultado.get(0).getNomeUsuario(), "O nome do usuário 1 está incorreto"),
                () -> assertEquals("Edgar", resultado.get(1).getNomeUsuario(), "O nome do usuário 2 está incorreto")
        );
    }
    @Test
    void atualizarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("Jair");
        usuario.setIdUsuario(1L);
        //configuração do comportamento do do MOCK
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);
        //A execução do metodo a ser testado
        var resultado = usuarioService.atualizarUsuario(usuario);
        //Validação do Teste
        assertAll(
                () -> assertNotNull(resultado),
                () -> assertEquals("Jair", resultado.getNomeUsuario())
        );
    }
    @Test
    void buscarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("Phill");
        usuario.setIdUsuario(1L);
        //configuração do comportamento do do MOCK
        when(usuarioRepository.findById(usuario.getIdUsuario())).thenReturn(Optional.of(usuario));
        //A execução do metodo a ser testado
        var resultado = usuarioService.buscarUsuario(usuario.getIdUsuario());
        //Validação do Teste
        assertAll(
                () -> assertNotNull(resultado),
                () -> assertEquals("Phill", resultado.getNomeUsuario())
        );
    }
    @Test
    void excluirUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("Lewis");
        usuario.setIdUsuario(1L);

        //configuração do comportamento do do MOCK
        when(usuarioRepository.findById(usuario.getIdUsuario())).thenReturn(Optional.of(usuario));
        //A execução do metodo a ser testado
        usuarioService.excluirUsuario(usuario.getIdUsuario());

        //Validação do Teste
        verify(usuarioRepository, times(1)).deleteById(usuario.getIdUsuario());
    }
}