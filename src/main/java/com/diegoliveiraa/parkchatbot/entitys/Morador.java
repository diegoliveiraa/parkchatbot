package com.diegoliveiraa.parkchatbot.entitys;

import com.diegoliveiraa.parkchatbot.dtos.MoradorRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity(name = "morador")
@Table(name = "tb-morador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "moradorId")
public class Morador {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID moradorId;

    private String nome;
    private String telefone;
    private String residencia;

    @OneToOne(mappedBy = "proprietario")
    private Vaga vaga;

    @OneToMany(mappedBy = "inquilino")
    private List<Aluguel> vagasAlugadas;

    public Morador(MoradorRequestDTO dto) {
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.residencia = dto.residencia();
    }
}