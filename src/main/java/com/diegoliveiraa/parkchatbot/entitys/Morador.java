package com.diegoliveiraa.parkchatbot.entitys;

import com.diegoliveiraa.parkchatbot.dtos.morador.MoradorRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity(name = "morador")
@Table(name = "tb_morador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Morador {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "morador_id", nullable = false, updatable = false)
    private UUID id;

    private String nome;
    private String telefone;
    private String residencia;

    @OneToOne(mappedBy = "proprietario")
    private Vaga vaga;

    @OneToMany(mappedBy = "inquilino")
    private List<Aluguel> alugueisComoInquilino;

    @OneToMany(mappedBy = "proprietario")
    private List<Aluguel> alugueisComoProprietario;

    public Morador(MoradorRequestDTO dto) {
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.residencia = dto.residencia();
    }
}