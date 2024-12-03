package br.com.louise.medicalconsult.consulta.models;

import br.com.louise.medicalconsult.usuario.models.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;


@Data
@Getter
@Setter
@Entity
@Table(name = "CONSULTAS")
public class Consulta {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONSULTA")
    private Long idConsulta;
    @Column(name = "DATA_CONSULTA")
    private Date dataConsulta;
    @Column(name = "PROFISSIONAL")
    private String Profissional;
    @Column(name = "ESPECIALIDADE")
    private String especialidade;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;
}
