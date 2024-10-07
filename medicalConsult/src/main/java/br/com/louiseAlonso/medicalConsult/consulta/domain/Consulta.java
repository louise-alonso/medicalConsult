package br.com.louiseAlonso.medicalConsult.consulta.domain;

import br.com.louiseAlonso.medicalConsult.usuario.domain.Usuario;
import jakarta.persistence.*; // Assuming you're using an older JPA version
// import javax.persistence.*;  // For recent JPA versions
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CONSULTAS")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONSULTA")
    private
    Long idConsulta;

    @Column(name = "DATA_CONSULTA")

    private String dataConsulta; // Now a Date type

    @Column(name = "ESPECIALIDADE")
    private String especialidade;

    @Column(name = "PROFISSIONAL")
    private String profissional;

    @ManyToOne
    @JoinColumn(name = "id_Usuario")
    private Usuario usuario;

    // Other methods (optional)

    public Consulta(Long idConsulta, String dataConsulta, String profissional, String especialidade, Usuario usuario) {
        this.idConsulta = idConsulta;
        this.dataConsulta = dataConsulta;
        this.profissional = profissional;
        this.especialidade = especialidade;
        this.usuario = usuario;


    }

}

