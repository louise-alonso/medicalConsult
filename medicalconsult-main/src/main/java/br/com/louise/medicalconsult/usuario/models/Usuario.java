package br.com.louise.medicalconsult.usuario.models;

import br.com.louise.medicalconsult.consulta.models.Consulta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    @Column(name = "NOME_USUARIO")
    private String nomeUsuario;
    @Column(name = "EMAIL_USUARIO")
    private String email;
    @Column(name = "CPF_USUARIO")
    private String cpf;
    @Column(name = "TELEFONE_USUARIO")
    private String telefone;
    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;
    @Column(name = "PERMISSAO")
    @Enumerated(EnumType.STRING)
    private Permissao permissao;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Consulta> consultas;
}


